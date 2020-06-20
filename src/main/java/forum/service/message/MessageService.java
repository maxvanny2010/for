package forum.service.message;

import forum.model.Message;

import java.util.List;

/**
 * MessageService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/21/2020
 */
public interface MessageService {
    /**
     * Method to add.
     *
     * @param message a message
     * @param idPost  a id of post
     * @return a new message
     */
    Message add(Message message, Integer idPost);

    /**
     * Method to get.
     *
     * @param id     a id
     * @param idPost a id of post
     * @return message
     */
    Message get(Integer id, Integer idPost);

    /**
     * Method to delete.
     *
     * @param id     a id
     * @param idPost a id of post
     * @return result
     */
    boolean delete(Integer id, Integer idPost);

    /**
     * Method to update.
     *
     * @param message a message
     * @param idPost  a id of post
     * @return a new message
     */
    Message update(Message message, Integer idPost);


    /**
     * Method to get.
     *
     * @param idPost a id of post
     * @return all messages
     */

    List<Message> getAll(Integer idPost);
}
