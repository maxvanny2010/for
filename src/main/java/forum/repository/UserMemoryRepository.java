package forum.repository;

import forum.model.User;
import forum.util.UserUtil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * UserMemoryRepository.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/17/2020
 */
@Repository
public class UserMemoryRepository implements UserRepository {
    /**
     * field a repo for users.
     */
    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    /**
     * field a counter id.
     */
    private final AtomicInteger counter = new AtomicInteger();

    {
        UserUtil.getUsers().forEach(this::save);
    }

    @Override
    public final User save(final User user) {
        if (user.isNew()) {
            user.setId(counter.getAndIncrement());
            this.users.put(user.getId(), user);
            return user;
        }
        return users.computeIfPresent(user.getId(), (k, v) -> user);
    }

    @Override
    public final User get(final int id) {
        return this.users.get(id);
    }

    @Override
    public final boolean delete(final int id) {
        return Objects.nonNull(this.users.remove(id));
    }

    @Override
    public final List<User> getAll() {
        final List<User> userList = new ArrayList<>(this.users.values());
        if (userList.size() == 0) {
            return new ArrayList<>();
        }
        userList.sort(Comparator.comparing(User::getUsername));
        return userList;
    }

    @Override
    public final User getByName(final String name) {
        return this.users.values()
                .stream()
                .filter(user -> Objects.equals(user.getUsername(), name))
                .findFirst()
                .orElse(null);
    }
}
