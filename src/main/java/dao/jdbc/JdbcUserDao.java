package dao.jdbc;

import dao.interfaces.UserDao;
import model.entity.User;
import org.apache.log4j.Logger;
import util.UserUtil;
import util.constants.Attributes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by daniel on 07/01/17.
 */
public class JdbcUserDao implements UserDao {

    private static final Logger logger = Logger.getLogger(JdbcUserDao.class);

    public static final String CREATE= "INSERT INTO users (name, password, email, role_id,balance) " +
            "VALUES(?, ?, ?, ?, ?)";

    public static final String FIND_BY_EMAIL = "SELECT * FROM users JOIN roles ON users.role_id = roles.role_id WHERE email = ?";
    public static final String FIND_BY_ID = "SELECT * FROM users JOIN roles ON users.role_id = roles.role_id WHERE user_id = ?";
    public static final String UPDATE_BALANCE = "UPDATE users SET balance = ? WHERE email = ?";

    private Connection connection;

    public JdbcUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public User find(int id) {
        User user = null;
        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_ID)){
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet != null){
                resultSet.next();
                user = getUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
        }
        return user;
    }

    @Override
    public List<User> findAll() { throw  new UnsupportedOperationException();
    }

    @Override
    public void create(User user) {
        try(PreparedStatement statement = connection.prepareStatement(CREATE)){
            statement.setString(1, user.getName());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getRole().getRoleId());
            statement.setLong(5,user.getBalance());
            statement.executeUpdate();
            //TODO
        } catch (SQLException e) {
        }
    }

    @Override
    public void update(User user) {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_BALANCE)){
            statement.setLong(1, user.getBalance());
            statement.setString(2, user.getEmail());
            statement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }


    @Override
    public User findByEmail(String email) {
        User user = null;
        try(PreparedStatement statement = connection.prepareStatement(FIND_BY_EMAIL)){
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet != null){
                resultSet.next();
                user = getUserFromResultSet(resultSet);
            }
        } catch (SQLException e) {
        }
        return user;
    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException{
        User user = new User();
        user.setUserId(resultSet.getInt(Attributes.USER_ID));
        user.setEmail(resultSet.getString(Attributes.EMAIL));
        user.setName(resultSet.getString(Attributes.NAME));
        user.setPassword(resultSet.getString(Attributes.PWD));
        String role = resultSet.getString(Attributes.ROLE);
        user.setRole(UserUtil.stringToEnumRole(role));
        user.setBalance(resultSet.getLong(Attributes.BALANCE));
        return user;
    }
}
