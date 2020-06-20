package forum.repository;

import java.util.List;

/**
 * IRepository.
 *
 * @param <T> type
 * @param <U> type
 * @author Maxim Vanny
 * @version 5.0
 * @since 6/21/2020
 */
public interface IRepository<T, U> {
    /**
     * Method to save.
     *
     * @param objectT a object
     * @param objectU a key of object in inner map
     * @return a new object
     */
    T save(T objectT, U objectU);

    /**
     * Method to get.
     *
     * @param id     a id object
     * @param object a key of object in inner map
     * @return object
     */
    T get(int id, U object);

    /**
     * Method to delete.
     *
     * @param id     a id object
     * @param object a key of object in inner map
     * @return result
     */
    boolean delete(int id, U object);

    /**
     * Method to get.
     *
     * @param object a id of post
     * @return all objects
     */

    List<T> getAll(U object);

    /**
     * Method to get.
     *
     * @return all objects
     */
    List<T> getAll();
}
