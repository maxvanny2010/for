package forum.repository;

import forum.model.Message;
import forum.model.Post;

import java.util.List;

/**
 * CustomizedMessage.
 *
 * @param <T> type
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/26/2020
 */
public interface CustomizedMessage<T> {

    List<T> findByPost(Post post);

    List<T> findByUserNameAndPost(String userName, Post post);

    T findByPostAndMsgId(Post post, Integer idMsg);

    boolean deleteMsg(Integer id);

    Message saveMsg(Message message);
}
