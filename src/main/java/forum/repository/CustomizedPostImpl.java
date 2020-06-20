package forum.repository;

import forum.model.Post;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * CustomizedPostImpl.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/26/2020
 */
@Transactional(readOnly = true)
public class CustomizedPostImpl implements CustomizedPost<Post> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Post> findByUserName(final String userName) {
        String sql = "FROM Post p WHERE p.author= :userName";
        return this.em.createQuery(sql, Post.class)
                .setParameter("userName", userName)
                .getResultList();
    }

    @Override
    public Post findByUserNameAndId(final String userName, final Integer id) {
        String sql = "FROM Post p WHERE p.author= :userName AND p.id= :id";
        return this.em.createQuery(sql, Post.class)
                .setParameter("userName", userName)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    @Transactional
    public Post savePost(final Post post) {
        if (post.isNew()) {
            this.em.persist(post);
            return post;
        } else {
            return this.em.merge(post);
        }
    }

    @Override
    @Transactional
    public boolean delete(final Integer id) {
        String sql = "DELETE FROM Post AS p WHERE p.id= :id";
        final Query query = this.em.createQuery(sql);
        return query.setParameter("id", id).executeUpdate() != 0;
    }

}
