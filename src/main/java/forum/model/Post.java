package forum.model;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Post.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/16/2020
 */
public class Post {
    /**
     * field a id.
     */
    private Integer id;
    /**
     * field a name.
     */
    private String name;
    /**
     * field a description.
     */
    private String desc;
    /**
     * field a time to create.
     */
    private LocalDateTime created;

    /**
     * field a author.
     */
    private String author;

    /**
     * Constructor.
     */
    public Post() {
    }

    /**
     * Constructor.
     *
     * @param aId      id
     * @param aName    name
     * @param aDesc    description
     * @param aCreated create date and time
     */
    public Post(final Integer aId, final String aName, final String aDesc,
                final LocalDateTime aCreated, final String aAuthor) {
        this.id = aId;
        this.name = aName;
        this.desc = aDesc;
        this.created = aCreated;
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
    public int getId() {
        return this.id;
    }

    /**
     * Method to set.
     *
     * @param aId id
     */
    public void setId(final Integer aId) {
        this.id = aId;
    }

    /**
     * Method to set.
     *
     * @param aId id
     **/
    public void setId(final int aId) {
        this.id = aId;
    }

    /**
     * Method to get.
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method to set.
     *
     * @param aName name of post
     **/
    public void setName(final String aName) {
        this.name = aName;
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
     * @return a time of create
     */
    public LocalDateTime getCreated() {
        return this.created;
    }

    /**
     * Method to set.
     *
     * @param aCreated created
     **/
    public void setCreated(final LocalDateTime aCreated) {
        this.created = aCreated;
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
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Post)) {
            return false;
        }
        final Post post = (Post) o;
        return getId() == post.getId()
                && getName().equals(post.getName())
                && getDesc().equals(post.getDesc())
                && getCreated().equals(post.getCreated())
                && getAuthor().equals(post.getAuthor());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getName(), getDesc(),
                getCreated(), getAuthor());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                Post.class.getSimpleName() + "[", "]")
                .add("\n")
                .add("id=" + this.id)
                .add("name='" + this.name + "'")
                .add("desc='" + this.desc + "'")
                .add("created=" + this.created)
                .add("author=" + this.author)
                .toString();
    }
}
