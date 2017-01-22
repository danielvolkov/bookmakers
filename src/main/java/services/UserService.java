package services;

import model.entity.User;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by daniel on 14/01/17.
 */
public interface UserService {
    void create(User user);
    void delete(Integer id);
    void updateBalance(User user,double summ) throws Exception;
    User findUser(String email) throws Exception;
}
