package forum.util;

import forum.model.Role;
import forum.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * UserUtil.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/17/2020
 */
public final class UserUtil {
    /**
     * Constructor.
     */
    private UserUtil() {
    }

    /**
     * Method to get.
     *
     * @return templates of post
     */
    public static List<User> getUsers() {
        return Arrays.asList(
                new User(null, "admin", "secret", Role.ROLE_ADMIN),
                new User(null, "user", "secret", Role.ROLE_USER),
                new User(null, "B", "secret", Role.ROLE_USER),
                new User(null, "C", "secret", Role.ROLE_USER),
                new User(null, "D", "secret", Role.ROLE_USER));
    }
}
