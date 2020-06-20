package forum.service.message;

import forum.model.Message;
import forum.model.Post;
import forum.repository.CustomMessageCrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PostMessageService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/21/2020
 */
@Service
public class PostMessageService implements MessageService {
    /**
     * field a repo.
     */
    private final CustomMessageCrudRepository message;

    /**
     * Constructor.
     *
     * @param aMessages message
     */
    public PostMessageService(final CustomMessageCrudRepository aMessages) {
        this.message = aMessages;
    }

    @Override
    public final Message add(final Message message) {
        return this.message.saveMsg(message);
    }

    @Override
    public final Message update(final Message message) {
        return this.message.saveMsg(message);
    }

    @Override
    public final boolean delete(final Integer id) {
        return this.message.deleteMsg(id);
    }

    @Override
    public final Message getById(final Integer id) {
        return this.message.findById((long) id).orElse(null);
    }

    @Override
    public final List<Message> getAll(final Post post) {
        return this.message.findByPost(post);
    }

    @Override
    public final List<Message> getAll(final String userName, final Post post) {
        return this.message.findByUserNameAndPost(userName, post);
    }

    @Override
    public final Message findByPostAndMsgId(final Post post, final Integer id) {
        return this.message.findByPostAndMsgId(post, id);
    }
}
