package dao.jdbc;

import dao.interfaces.UserDao;
import model.entity.User;

import java.sql.Connection;
import java.util.List;

/**
 * Created by daniel on 07/01/17.
 */
public class JdbcUserDao implements UserDao {

    private static final String SELECT_FROM_CITY = "SELECT * FROM city";
    private static final String USER_ID = "user_id";
    private static final String NAME = "name";
    private Connection connection;

    public JdbcUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User find(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void create(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> findByRole(String role) {
        return null;
    }

    @Override
    public User findByName(String name) {
        return null;
    }
}
