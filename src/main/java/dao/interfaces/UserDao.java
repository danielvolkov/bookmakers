package dao.interfaces;

import model.entity.User;

import java.util.List;

/**
 * Created by daniel on 05/01/17.
 */
public interface UserDao extends GenericDao<User> {
    List<User> findByRole(String role);
    User findByName(String name);
}
