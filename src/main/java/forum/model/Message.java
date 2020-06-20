package forum.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Message.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/17/2020
 */
public class Message {
    /**
     * field a id.
     */
    private Integer id;
    /**
     * field a description.
     */
    private String desc;
    /**
     * field a time of create.
     */
    private LocalDateTime created;

    /**
     * field a author.
     */
    private String author;

    /**
     * Constructor.
     */
    public Message() {
    }

    /**
     * Constructor.
     *
     * @param aId       id
     * @param aDesc     description
     * @param aDateTime date and time a create
     * @param aAuthor   a author
     */
    public Message(final Integer aId, final String aDesc,
                   final LocalDateTime aDateTime,
                   final String aAuthor) {
        this.id = aId;
        this.desc = aDesc;
        this.created = aDateTime;
        this.author = aAuthor;
    }

    /**
     * Method to get.
     *
     * @return author
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Method to set.
     *
     * @param aAuthor a author
     **/
    public void setAuthor(final String aAuthor) {
        this.author = aAuthor;
    }

    /**
     * Method to get.
     *
     * @return id
     */
    public final Integer getId() {
        return this.id;
    }

    /**
     * Method to set.
     *
     * @param aId id
     **/
    public void setId(final Integer aId) {
        this.id = aId;
    }

    /**
     * Method to get.
     *
     * @return description
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * Method to set.
     *
     * @param aDesc description
     **/
    public void setDesc(final String aDesc) {
        this.desc = aDesc;
    }

    /**
     * Method to get.
     *
     * @return date and time
     */
    public LocalDateTime getCreated() {
        return this.created;
    }

    /**
     * Method to set.
     *
     * @param aDateTime date and time create
     **/
    public void setCreated(final LocalDateTime aDateTime) {
        this.created = aDateTime;
    }

    /**
     * Method to check post.
     *
     * @return is new post or not
     */
    public boolean isNew() {
        return Objects.isNull(this.id);
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Message.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("desc='" + this.desc + "'")
                .add("dateTime=" + this.created)
                .add("author=" + this.author)
                .toString();
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Message)) {
            return false;
        }
        final Message message = (Message) o;
        return getId().equals(message.getId())
                && getDesc().equals(message.getDesc())
                && getCreated().equals(message.getCreated())
                && getAuthor().equals(message.getAuthor());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getDesc(), getCreated(), getAuthor());
    }
}
