package dao.jdbc;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import dao.DaoConnection;
import dao.factory.DaoFactory;
import dao.interfaces.BetDao;
import dao.interfaces.HorseDao;
import dao.interfaces.RideDao;
import dao.interfaces.UserDao;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.ConnectionPoolDataSource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by daniel on 05/01/17.
 */
public class JdbcDaoFactory implements DaoFactory {


    private static final String DB_URL = "url";
    private static final String JDBC_SOURCE= "java:comp/env/jdbc/bookmaker";

    private JdbcDaoFactory(){ }

    private static class LazyHolder {
        private static DaoFactory INSTANCE = new JdbcDaoFactory();
    }

    public static DaoFactory getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public BetDao createBetDao(DaoConnection daoConnection) {
        return new JdbcBetDao( daoConnection.getConnection() );
    }

    @Override
    public HorseDao createHorseDao(DaoConnection daoConnection) {
        return new JdbcHorseDao( daoConnection.getConnection() );
    }

    @Override
    public RideDao createRideDao(DaoConnection daoConnection) {
        return new JdbcRideDao( daoConnection.getConnection() );
    }

    @Override
    public UserDao createUserDao(DaoConnection daoConnection) {
        return new JdbcUserDao( daoConnection.getConnection() );
    }


    @Override
    public DaoConnection getDaoConnection() {
        try{
            InitialContext context = new InitialContext();
            DataSource dataSource = (DataSource) context.lookup(JDBC_SOURCE);
            return new JdbcDaoConnection(dataSource.getConnection());
        } catch (Exception e) {
            throw new RuntimeException(e);//TODO specific runtime exception add messagekey
        }
    }
}
