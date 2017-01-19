package dao.jdbc;

import dao.interfaces.UserDao;
import model.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by daniel on 07/01/17.
 */
public class JdbcUserDao implements UserDao {

    private static final String SELECT_FROM_CITY = "SELECT * FROM users";
    private static final String USER_ID = "user_id";
    private static final String NAME = "name";
    public static final String CREATE= "INSERT INTO users (name, password, email, role_id) " +
            "VALUES(?, ?, ?, ?, ?)";
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
        try{
            PreparedStatement statement =
                    connection.prepareStatement(CREATE);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getRole());
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


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
