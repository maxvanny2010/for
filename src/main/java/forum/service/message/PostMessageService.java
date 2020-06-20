package forum.service.message;

import forum.model.Message;
import forum.repository.MessageMemoryRepository;
import forum.repository.MessageRepository;
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
    private final MessageRepository message;

    /**
     * Constructor.
     *
     * @param aMessages message
     */
    public PostMessageService(final MessageMemoryRepository aMessages) {
        this.message = aMessages;
    }

    @Override
    public final Message add(final Message message, final Integer idPost) {
        return this.message.save(message, idPost);
    }

    @Override
    public final Message update(final Message message, final Integer idPost) {
        return this.message.save(message, idPost);
    }

    @Override
    public final boolean delete(final Integer id, final Integer idPost) {
        return this.message.delete(id, idPost);
    }

    @Override
    public final Message get(final Integer id, final Integer idPost) {
        return this.message.get(id, idPost);
    }

    @Override
    public final List<Message> getAll(final Integer idPost) {
        return this.message.getAll(idPost);
    }
}
