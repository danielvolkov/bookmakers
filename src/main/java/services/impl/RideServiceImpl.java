package services.impl;

import dao.DaoConnection;
import dao.factory.DaoFactory;
import dao.interfaces.RideDao;
import dao.interfaces.UserDao;
import dao.jdbc.JdbcDaoFactory;
import model.entity.Ride;
import model.entity.User;
import services.RideService;

import java.util.List;

/**
 * Created by daniel on 14/01/17.
 */
public class RideServiceImpl implements RideService {

    private DaoFactory daoFactory;

    private RideServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    private static class LazyHolder{
        private static final RideServiceImpl INSTANCE =
                new RideServiceImpl(JdbcDaoFactory.getInstance());
    }

    public static RideServiceImpl getInstance(){
        return RideServiceImpl.LazyHolder.INSTANCE;
    }


    @Override
    public void create(Ride ride) throws Exception {
        try (DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            RideDao rideDao = daoFactory.createRideDao(daoConnection);
            if (ride != null) {
                daoConnection.begin();
                rideDao.create(ride);
                daoConnection.commit();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateWithConfirm(Ride ride) throws Exception {

    }

    @Override
    public List<Ride> findRides() throws Exception {
        try (DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            RideDao rideDao = daoFactory.createRideDao(daoConnection);
            return  rideDao.findAll();
        }
    }
}
