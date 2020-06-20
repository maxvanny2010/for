package forum.repository;

import forum.model.Post;

import java.util.List;

/**
 * CustomizedPost.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/26/2020
 */
public interface CustomizedPost<T> {
    List<Post> findByUserName(String userName);

    Post findByUserNameAndId(String userName, Integer id);

    Post savePost(Post post);

    boolean delete(Integer id);
}
