package dao.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import dao.DaoConnection;
import dao.factory.DaoFactory;
import dao.interfaces.BetDao;
import dao.interfaces.HorseDao;
import dao.interfaces.RideDao;
import dao.interfaces.UserDao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Created by daniel on 05/01/17.
 */
public class JdbcDaoFactory extends DaoFactory {

    private Connection connection;

    private static final String DB_URL = "url";

    private JdbcDaoFactory(){

    }

    @Override
    public BetDao createBetDao() {
        return new JdbcBetDao(connection);
    }

    @Override
    public HorseDao createHorseDao() {
        return new JdbcHorseDao(connection);
    }

    @Override
    public RideDao createRideDao() {
        return new JdbcRideDao(connection);
    }

    @Override
    public UserDao createUserDao() {
        return new JdbcUserDao(connection);
    }

    @Override
    public DaoConnection getDaoConnection() {
        //реализовать здесь коннекшн пул
        return null;
    }
}
