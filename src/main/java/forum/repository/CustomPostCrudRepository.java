package forum.repository;

import forum.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CustomPostCrudRepository.
 *
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/26/2020
 */
@Repository
public interface CustomPostCrudRepository
        extends CrudRepository<Post, Long>, CustomizedPost<Post> {
}
