package services.impl;

import dao.DaoConnection;
import dao.factory.DaoFactory;
import dao.interfaces.BetDao;
import dao.interfaces.HorseDao;
import dao.interfaces.RideDao;
import dao.interfaces.UserDao;
import dao.jdbc.JdbcDaoFactory;
import model.entity.Bet;
import model.entity.Horse;
import model.entity.Ride;
import model.entity.User;
import services.BetService;

import java.util.List;

/**
 * Created by daniel on 14/01/17.
 */
public class BetServiceImpl implements BetService {
    private DaoFactory daoFactory;

    private BetServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    private static class LazyHolder{
        private static final BetServiceImpl INSTANCE =
                new BetServiceImpl(JdbcDaoFactory.getInstance());
    }

    public static BetServiceImpl getInstance(){
        return BetServiceImpl.LazyHolder.INSTANCE;
    }


    @Override
    public void makeBet(User client, Bet bet) {
        try(DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            BetDao betDao = daoFactory.createBetDao(daoConnection);
            UserDao userDao = daoFactory.createUserDao(daoConnection);
            RideDao rideDao = daoFactory.createRideDao(daoConnection);
            if( (bet != null) ){
                daoConnection.begin();
                betDao.create(bet);
                User existClient = userDao.findByEmail(client.getEmail());
                Ride ride = rideDao.find(bet.getRideId());
                User bookmaker = userDao.findByEmail(ride.getBookmakerEmail());
                existClient.deposite(bet.getBetSum()*(-1));
                bookmaker.deposite(bet.getBetSum());
                userDao.update(bookmaker);
                userDao.update(existClient);
                daoConnection.commit();
            }

        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public List<Bet> findBetsByUser(User user) throws Exception {
        try(DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            daoConnection.begin();
            BetDao betDao = daoFactory.createBetDao(daoConnection);
            HorseDao horseDao = daoFactory.createHorseDao(daoConnection);
            List<Bet> bets = betDao.findByUser(user);
            for (Bet bet : bets ) {

                bet.setHorse(horseDao.find(bet.getHorseId()));

                Ride ride = bet.getRide();
                if(ride.isFinished()) {
                    ride.setWinnerHorse(horseDao.find(ride.getWinnerId()));
                    ride.setLooserHorse(horseDao.find(ride.getLooserId()));
                }
                bet.setRide(ride);
            }
            daoConnection.commit();
            return betDao.findByUser(user);
        }

    }



    @Override
    public void calculate() {
        throw new UnsupportedOperationException();
    }
}
