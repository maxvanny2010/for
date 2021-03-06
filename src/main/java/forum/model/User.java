package forum.model;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * User.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/17/2020
 */
public class User {
    /**
     * field a id.
     */
    private Integer id;
    /**
     * field a user name.
     */
    private String username;
    /**
     * field a password.
     */
    private String password;

    /**
     * field a password.
     */
    private boolean enable;

    /**
     * field a role.
     */
    private Role role;

    /**
     * Constructor.
     */
    public User() {
    }

    /**
     * Constructor.
     *
     * @param aId       id
     * @param aUsername user name
     * @param aPassword password
     * @param aRole     role
     */
    public User(final Integer aId, final String aUsername,
                final String aPassword, final Role aRole) {
        this.id = aId;
        this.username = aUsername;
        this.password = aPassword;
        this.role = aRole;
    }

    /**
     * Method to get.
     *
     * @return enable
     */
    public final boolean isEnable() {
        return this.enable;
    }

    /**
     * Method to set.
     *
     * @param aEnable a enable of user
     **/
    public void setEnable(final boolean aEnable) {
        this.enable = aEnable;
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
     * @param aId a id
     **/
    public final void setId(final Integer aId) {
        this.id = aId;
    }

    /**
     * Method to get.
     *
     * @return a user name
     */
    public final String getUsername() {
        return this.username;
    }

    /**
     * Method to set.
     *
     * @param aUsername a user name
     **/
    public final void setUsername(final String aUsername) {
        this.username = aUsername;
    }

    /**
     * Method to get.
     *
     * @return password
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Method to set.
     *
     * @param aPassword a password
     **/
    public final void setPassword(final String aPassword) {
        this.password = aPassword;
    }

    /**
     * Method to get.
     *
     * @return a role
     */
    public final Role getRole() {
        return this.role;
    }

    /**
     * Method to set.
     *
     * @param aRole a role
     **/
    public final void setAuthority(final Role aRole) {
        this.role = aRole;
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        final User user = (User) o;
        return getId().equals(user.getId())
                && getUsername().equals(user.getUsername())
                && getPassword().equals(user.getPassword())
                && getRole() == user.getRole();
    }

    /**
     * Method to check new user or not.
     *
     * @return result
     */
    public final boolean isNew() {
        return Objects.isNull(this.id);
    }

    @Override
    public final int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getRole());
    }

    @Override
    public final String toString() {
        return new StringJoiner(", ",
                User.class.getSimpleName() + "[", "]")
                .add("id=" + this.id)
                .add("username='" + this.username + "'")
                .add("password='" + this.password + "'")
                .add("role=" + this.role)
                .toString();
    }
}
