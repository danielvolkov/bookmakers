package dao.interfaces;

import java.util.List;

/**
 * Created by daniel on 05/01/17.
 */
public interface GenericDao<E> {
    E find(int id);
    List<E> findAll();
    void create(E e);
    void update(E e);
    void delete(int id);

}
