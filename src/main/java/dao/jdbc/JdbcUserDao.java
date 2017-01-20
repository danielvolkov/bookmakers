package dao.jdbc;

import dao.interfaces.UserDao;
import model.entity.User;
import util.Attributes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by daniel on 07/01/17.
 */
public class JdbcUserDao implements UserDao {


    public static final String CREATE= "INSERT INTO users (name, password, email, role_id,balance) " +
            "VALUES(?, ?, ?, ?, ?)";

    public static final String SELECT_ALL ="SELECT * FROM users JOIN roles ON users.role_id = roles.role_id";
    public static final String FIND_BY_EMAIL ="SELECT * FROM users JOIN roles ON users.role_id = roles.role_id WHERE email = ?";
    private Connection connection;

    public JdbcUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User find(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new LinkedList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                User user = getUserByResultSet(resultSet);
                userList.add(user);
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }

    @Override
    public void create(User user) {
        try{
            PreparedStatement statement =
                    connection.prepareStatement(CREATE);
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getRoleInt());
            statement.setDouble(5,user.getBalance());
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
        throw new UnsupportedOperationException();
    }


    @Override
    public User findByEmail(String email) {
        User user = null;
        try{
            PreparedStatement statement = connection.prepareStatement(FIND_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            user = getUserByResultSet(resultSet);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    private User getUserByResultSet(ResultSet resultSet) throws SQLException{
        String email = resultSet.getString(Attributes.EMAIL);
        String name = resultSet.getString(Attributes.NAME);
        int role = resultSet.getInt(Attributes.ROLE);
        double balance = resultSet.getDouble(Attributes.BALANCE);
        return new User(email,name,role,balance);
    }
}
