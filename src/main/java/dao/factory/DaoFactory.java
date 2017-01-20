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
public interface DaoFactory {
     BetDao createBetDao(DaoConnection daoConnection);
     HorseDao createHorseDao(DaoConnection daoConnection);
     RideDao createRideDao(DaoConnection daoConnection);
     UserDao createUserDao(DaoConnection daoConnection);
     DaoConnection getDaoConnection();


}
