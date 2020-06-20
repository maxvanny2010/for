package forum.repository;

import forum.model.User;

import java.util.List;

/**
 * UserRepository.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/17/2020
 */
public interface UserRepository {
    /**
     * Method to save.
     *
     * @param user a user
     * @return a new user
     */
    User save(User user);

    /**
     * Method to get.
     *
     * @param id a id
     * @return user
     */
    User get(int id);

    /**
     * Method to delete.
     *
     * @param id a id
     * @return result
     */
    boolean delete(int id);

    /**
     * Method to get.
     *
     * @return all users
     */
    List<User> getAll();

    /**
     * Method to get.
     *
     * @param name a name of user
     * @return user
     */
    User getByName(String name);
}
