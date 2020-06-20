package forum.repository;

import forum.model.Message;
import forum.model.Post;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * CustomizedMessageImpl.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/26/2020
 */
@Transactional(readOnly = true)
public class CustomizedMessageImpl implements CustomizedMessage<Message> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Message> findByPost(final Post post) {
        String sql = "FROM Message m WHERE m.post= :post";
        return this.em.createQuery(sql, Message.class)
                .setParameter("post", post)
                .getResultList();
    }

    @Override
    public List<Message> findByUserNameAndPost(final String userName, final Post post) {
        String sql = "FROM Message m WHERE m.author= :userName AND m.post= :post";
        return this.em.createQuery(sql, Message.class)
                .setParameter("author", userName)
                .setParameter("post", post)
                .getResultList();
    }

    @Override
    public Message findByPostAndMsgId(final Post post, final Integer id) {
        String sql = "FROM Message m WHERE m.post= :post AND m.id= :id";
        return this.em.createQuery(sql, Message.class)
                .setParameter("post", post)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    @Transactional
    public Message saveMsg(final Message message) {
        if (message.isNew()) {
            this.em.persist(message);
            return message;
        } else {
            return this.em.merge(message);
        }
    }

    @Override
    @Transactional
    public boolean deleteMsg(final Integer id) {
        String sql = "DELETE FROM Message AS m WHERE m.id= :id";
        final Query query = this.em.createQuery(sql);
        return query.setParameter("id", id).executeUpdate() != 0;
    }
}
