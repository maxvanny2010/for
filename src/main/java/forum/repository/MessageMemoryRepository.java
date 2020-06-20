package forum.repository;

import forum.model.Message;
import forum.util.PostUtil;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * PostMessageRepository.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/21/2020
 */
@Repository
public class MessageMemoryRepository implements MessageRepository {
    /**
     * field a repository.
     */
    private final Map<Integer, Map<Integer, Message>> repo
            = new ConcurrentHashMap<>();
    /**
     * field a id.
     */
    private final AtomicInteger counter = new AtomicInteger(0);

    {
        PostUtil.getMessage("A", "user")
                .forEach(message -> this.save(message, 0));
        PostUtil.getMessage("A", "any")
                .forEach(message -> this.save(message, 0));
        PostUtil.getMessage("B", "user")
                .forEach(message -> this.save(message, 1));
        PostUtil.getMessage("B", "any")
                .forEach(message -> this.save(message, 1));
    }

    @Override
    public final Message save(final Message message, final Integer idPost) {
        Map<Integer, Message> messages = this.repo.get(idPost);
        final boolean isMessages = Objects.isNull(messages);
        if (message.isNew()) {
            message.setId(this.counter.getAndIncrement());
            message.setCreated(LocalDateTime.of(LocalDate.now(), LocalTime.NOON));
            if (isMessages) {
                messages = new HashMap<>();
                messages.put(message.getId(), message);
                this.repo.put(idPost, messages);
            } else {
                messages.put(message.getId(), message);
            }
            return message;
        }
        //block update
        if (isMessages) {
            return null;
        }
        return messages.computeIfPresent(message.getId(), (k, v) -> message);
    }

    @Override
    public final Message get(final int id, final Integer idPost) {
        final Map<Integer, Message> messages = this.repo.get(idPost);
        if (Objects.isNull(messages)) {
            return null;
        }
        return messages.get(id);

    }

    @Override
    public final boolean delete(final int id, final Integer idPost) {
        final Message message = this.get(id, idPost);
        if (Objects.isNull(message)) {
            return false;
        }
        final Message remove = this.repo.get(idPost).remove(id);
        if (this.repo.get(idPost).size() == 0) {
            this.repo.remove(idPost);
        }
        return Objects.nonNull(remove);
    }

    @Override
    public final List<Message> getAll(final Integer idPost) {
        final Map<Integer, Message> messages = this.repo.get(idPost);
        if (Objects.isNull(messages)) {
            return new ArrayList<>();
        }
        return messages.values()
                .stream()
                .sorted(Comparator.comparing(Message::getCreated).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public final List<Message> getAll() {
        final Collection<Map<Integer, Message>> values = this.repo.values();
        if (values.isEmpty()) {
            return new ArrayList<>();
        }
        return values
                .stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(Message::getCreated).reversed())
                .collect(Collectors.toList());

    }
}
