package forum.repository;

import forum.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * UserRepository.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/25/2020
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findUserByUsername(final String username);
}

