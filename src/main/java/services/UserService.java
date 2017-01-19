package services;

import model.entity.User;

/**
 * Created by daniel on 14/01/17.
 */
public interface UserService {
    void create(User user);
    void delete(Integer id);
    void update(User user);
    User findUser(Integer id);
    User findUser(String email);
}
