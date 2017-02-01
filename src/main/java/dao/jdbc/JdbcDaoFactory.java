package dao.jdbc;

import dao.DaoConnection;
import dao.DaoFactory;
import dao.interfaces.BetDao;
import dao.interfaces.HorseDao;
import dao.interfaces.RideDao;
import dao.interfaces.UserDao;
import org.apache.log4j.Logger;

import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 * Created by daniel on 05/01/17.
 */
public class JdbcDaoFactory implements DaoFactory {

    private static final Logger logger = Logger.getLogger(JdbcDaoFactory.class);

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
