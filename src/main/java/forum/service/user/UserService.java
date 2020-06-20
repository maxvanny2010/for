package forum.service.user;

import forum.model.User;
import forum.repository.UserMemoryRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * UserService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/17/2020
 */
@Service
public class UserService extends UserServiceAbs {
    /**
     * Constructor.
     *
     * @param aUsers users repo
     */
    public UserService(final UserMemoryRepository aUsers) {
        super(aUsers);
    }

    @Override
    public final User add(final User user) {
        Objects.requireNonNull(user, "must not be null");
        return super.add(user);
    }

    @Override
    public final User update(final User user) {
        return super.update(user);
    }

    @Override
    public final boolean delete(final Integer id) {
        return super.delete(id);
    }

    @Override
    public final User getByName(final String name) {
        return super.getByName(name);
    }
}
