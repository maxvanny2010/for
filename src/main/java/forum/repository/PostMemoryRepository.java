package forum.repository;

import forum.model.Post;
import forum.util.PostUtil;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * PostRepository.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/16/2020
 */
@Repository
public class PostMemoryRepository implements PostRepository {
    /**
     * field a repository.
     */
    private final Map<String, Map<Integer, Post>> repo
            = new ConcurrentHashMap<>();
    /**
     * field a id.
     */
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        PostUtil.getPosts("user", "A")
                .forEach(post -> this.save(post, "user"));
        PostUtil.getPosts("any", "B")
                .forEach(post -> this.save(post, "any"));
    }

    @Override
    public final Post save(final Post post, final String userName) {
        Map<Integer, Post> posts = this.repo.get(userName);
        final boolean isPosts = Objects.isNull(posts);
        if (post.isNew()) {
            post.setId(this.counter.getAndIncrement());
            if (Objects.isNull(post.getCreated())) {
                post.setCreated(LocalDateTime.of(LocalDate.now(), LocalTime.NOON));
            }
            post.setAuthor(userName);
            if (isPosts) {
                posts = new HashMap<>();
                posts.put(post.getId(), post);
                this.repo.put(userName, posts);
            } else {
                posts.put(post.getId(), post);
            }
            return post;
        }
        //block update
        if (isPosts) {
            return null;
        }
        return posts.computeIfPresent(post.getId(), (k, v) -> post);
    }

    @Override
    public final Post get(final int id, final String userName) {
        final Map<Integer, Post> posts = this.repo.get(userName);
        if (Objects.isNull(posts)) {
            return null;
        }
        return posts.get(id);

    }

    @Override
    public final boolean delete(final int id, final String userName) {
        final Post post = this.get(id, userName);
        if (Objects.isNull(post)) {
            return false;
        }
        final Post remove = this.repo.get(userName).remove(id);
        if (this.repo.get(userName).size() == 0) {
            this.repo.remove(userName);
        }
        return Objects.nonNull(remove);
    }

    @Override
    public final List<Post> getAll(final String userName) {
        final Map<Integer, Post> posts = this.repo.get(userName);
        if (Objects.isNull(posts)) {
            return new ArrayList<>();
        }
        return posts.values()
                .stream()
                .sorted(Comparator.comparing(Post::getCreated).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public final List<Post> getAll() {
        final Collection<Map<Integer, Post>> values = this.repo.values();
        if (values.isEmpty()) {
            return new ArrayList<>();
        }
        return values
                .stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(Post::getCreated).reversed())
                .collect(Collectors.toList());

    }
}
