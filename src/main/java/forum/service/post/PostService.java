package forum.service.post;

import forum.model.Post;

import java.util.List;

/**
 * PostServiceAbs.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/17/2020
 */
public interface PostService {


    /**
     * Method to add post.
     *
     * @param post     a post
     * @param userName a name of user
     * @return new post or null
     */
    Post add(Post post, String userName);

    /**
     * Method to get.
     *
     * @param id       id by post
     * @param userName name by user
     * @return post or null
     */
    Post get(Integer id, String userName);

    /**
     * Method to update.
     *
     * @param userName name of user
     * @param post     a post for update
     * @return update post or null
     */
    Post update(Post post, String userName);

    /**
     * Method to delete post.
     *
     * @param id       id of post
     * @param userName name of user
     * @return result
     */
    boolean delete(Integer id, String userName);

    /**
     * Method to get all post by user.
     *
     * @param userName name of user
     * @return list of post by user
     */
    List<Post> getAll(String userName);
}
