package forum.service.post;

import forum.model.Post;
import forum.repository.CustomPostCrudRepository;
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
    private final CustomPostCrudRepository posts;

    /**
     * Constructor.
     *
     * @param aPosts post
     */
    public PostUserService(final CustomPostCrudRepository aPosts) {
        this.posts = aPosts;
    }

    @Override
    public final Post add(final Post post) {
        return this.posts.savePost(post);
    }

    @Override
    public final Post update(final Post post) {
        return this.posts.savePost(post);
    }

    @Override
    public final boolean delete(final Integer id) {
        return this.posts.delete(id);
    }

    @Override
    public final Post findByNameAndId(final String userName, final Integer id) {
        return this.posts.findByUserNameAndId(userName, id);
    }

    @Override
    public final List<Post> getAll(final String userName) {
        return this.posts.findByUserName(userName);
    }
}
