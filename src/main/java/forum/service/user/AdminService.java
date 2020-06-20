package forum.service.user;

import forum.model.User;
import forum.repository.UserMemoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AdminService.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/17/2020
 */
@Service
public class AdminService extends UserServiceAbs {
    /**
     * Constructor.
     *
     * @param aUsers users repo
     */
    public AdminService(final UserMemoryRepository aUsers) {
        super(aUsers);
    }

    @Override
    public final User add(final User user) {
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
    public final List<User> getAll() {
        return super.getAll();
    }

    @Override
    public final User getByName(final String name) {
        return super.getByName(name);
    }
}
