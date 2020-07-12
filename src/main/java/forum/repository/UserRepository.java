package forum.repository;

import forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/25/2020
 */
public interface UserRepository extends JpaRepository<User, Long> {
    //   @Query("SELECT u FROM User u WHERE u.username=?1")
    User findByUsername(final String username);
}

