package forum.repository;

import forum.model.Message;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomMessageCrudRepository.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/26/2020
 */
@Repository
public interface CustomMessageCrudRepository
        extends CrudRepository<Message, Long>, CustomizedMessage<Message> {
}
