package forum.service.post;

import forum.model.Post;
import forum.repository.PostMemoryRepository;
import forum.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PostService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/16/2020
 */
@Service
public class PostUserService implements PostService {
    /**
     * field a repo.
     */
    private final PostRepository posts;

    /**
     * Constructor.
     *
     * @param aPosts post
     */
    public PostUserService(final PostMemoryRepository aPosts) {
        this.posts = aPosts;
    }

    @Override
    public final Post add(final Post post, final String userName) {
        return this.posts.save(post, userName);
    }

    @Override
    public final Post update(final Post post, final String userName) {
        return this.posts.save(post, userName);
    }

    @Override
    public final boolean delete(final Integer id, final String userName) {
        return this.posts.delete(id, userName);
    }

    @Override
    public final Post get(final Integer id, final String userName) {
        return this.posts.get(id, userName);
    }

    @Override
    public final List<Post> getAll(final String userName) {
        return this.posts.getAll(userName);
    }
}
