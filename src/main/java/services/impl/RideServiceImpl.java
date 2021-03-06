package services.impl;

import dao.DaoConnection;
import dao.DaoFactory;
import dao.interfaces.RideDao;
import dao.jdbc.JdbcDaoFactory;
import model.entity.Ride;
import services.BetService;
import services.RideService;
import util.RideRandomUtil;

import java.util.List;
import java.util.Objects;

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
    public void create(Ride ride) {
        Objects.requireNonNull(ride);
        try (DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            RideDao rideDao = daoFactory.createRideDao(daoConnection);
            daoConnection.begin();
            rideDao.create(ride);
            daoConnection.commit();
        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateWithConfirm(Integer rideId) throws Exception {
        try (DaoConnection daoConnection = daoFactory.getDaoConnection()){
            RideDao rideDao = daoFactory.createRideDao(daoConnection);
            daoConnection.begin();
            Ride existingRide = rideDao.find(rideId);
            if(!existingRide.isFinished()){
                Ride newRide = generateResults(existingRide);
                rideDao.update(newRide);
                calculateBets(newRide);
            }
            daoConnection.commit();
        }
    }

    @Override
    public List<Ride> findRides() throws Exception {
        try (DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            RideDao rideDao = daoFactory.createRideDao(daoConnection);
            return  rideDao.findAll();
        }
    }

    @Override
    public Ride findRide(Integer rideId)  {
        try (DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            RideDao rideDao = daoFactory.createRideDao(daoConnection);
            return  rideDao.find(rideId);
        }
    }


    private Ride generateResults(Ride ride){
        int[] horsesId = RideRandomUtil.horseIdGenerator();
        ride.setLooserId(horsesId[0]);
        ride.setWinnerId(horsesId[1]);
        ride.setFinished(true);
        return ride;
    }

    private void calculateBets(Ride ride){
        BetService betService = BetServiceImpl.getInstance();
        betService.calculateResults(ride);
    }

}
