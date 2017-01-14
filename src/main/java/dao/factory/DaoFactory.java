package dao.factory;

import dao.DaoConnection;
import dao.interfaces.BetDao;
import dao.interfaces.HorseDao;
import dao.interfaces.RideDao;
import dao.interfaces.UserDao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * Created by daniel on 05/01/17.
 */
public abstract class DaoFactory {
    protected abstract BetDao createBetDao();
    protected abstract HorseDao createHorseDao();
    protected abstract RideDao createRideDao();
    protected abstract UserDao createUserDao();
    protected abstract DaoConnection getDaoConnection();

    public static final String DB_FILE = "/db.properties";
    private static final String DB_FACTORY_CLASS = "daoFactory.class";



    private static class LazyHolder {
        private static DaoFactory INSTANCE;
        static {
            try {
                InputStream inputStream = DaoFactory.class.getResourceAsStream(DB_FILE);
                Properties dbProps = new Properties();
                dbProps.load(inputStream);
                String factoryClass = dbProps.getProperty(DB_FACTORY_CLASS);
                INSTANCE = (DaoFactory) Class.forName(factoryClass).newInstance();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public static DaoFactory getInstance() {

        return LazyHolder.INSTANCE;
    }
}
