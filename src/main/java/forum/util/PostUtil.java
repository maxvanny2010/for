package forum.util;

import forum.model.Message;
import forum.model.Post;
import forum.model.Role;
import forum.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * PostUtil.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/17/2020
 */
public final class PostUtil {
    /**
     * Constructor.
     */
    private PostUtil() {
    }

    /**
     * Method to get.
     *
     * @return templates of post
     */
    public static List<Post> getPosts(final String userName, final String word) {
        final User one = new User(null, userName, "secret", Role.ROLE_USER);
        return new ArrayList<>(Collections.singletonList(
                new Post(null, "куплю " + word, "куплю " + word + " ради " + word,
                        LocalDateTime.of(LocalDate.now(), LocalTime.NOON), one.getUsername())
        ));
    }

    /**
     * Method to get.
     *
     * @return templates of message
     */
    public static List<Message> getMessage(final String word, final String author) {
        return new ArrayList<>(Arrays.asList(
                new Message(null, " я тоже хочу купить " + word,
                        LocalDateTime.of(LocalDate.now(), LocalTime.NOON), author),
                new Message(null, " я передумал и не хочу купить " + word,
                        LocalDateTime.of(LocalDate.now(), LocalTime.NOON), author)
        ));
    }
}
