package services.impl;

import dao.DaoConnection;
import dao.DaoFactory;
import dao.interfaces.BetDao;
import dao.interfaces.HorseDao;
import dao.interfaces.RideDao;
import dao.interfaces.UserDao;
import dao.jdbc.JdbcDaoFactory;
import exceptions.MaxBetException;

import exceptions.NosuchMoneyException;
import model.entity.Bet;
import model.entity.Horse;
import model.entity.Ride;
import model.entity.User;
import services.BetService;
import util.constants.Attributes;

import java.util.List;
import java.util.Objects;

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
    public void makeBet(User client, Bet bet) throws NosuchMoneyException, MaxBetException {
        Objects.requireNonNull(bet);
        try(DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            BetDao betDao = daoFactory.createBetDao(daoConnection);
            UserDao userDao = daoFactory.createUserDao(daoConnection);
            RideDao rideDao = daoFactory.createRideDao(daoConnection);
            daoConnection.begin();
            User existClient = userDao.findByEmail(client.getEmail());
            if( existClient.getBalance() >= bet.getBetSum() ) {
                Ride ride = rideDao.find(bet.getRideId());
                if( ride.getMaxSumm() >= bet.getBetSum()) {
                    betDao.create(bet);
                    User bookmaker = userDao.findByEmail(ride.getBookmakerEmail());
                    existClient.deposite(bet.getBetSum() * (-1));
                    bookmaker.deposite(bet.getBetSum());
                    userDao.update(bookmaker);
                    userDao.update(existClient);
                } else {
                    throw new MaxBetException();
                }
            }else {
                throw new NosuchMoneyException();
            }
            daoConnection.commit();

        } catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public List<Bet> findBetsByUser(User user) throws Exception {
        try(DaoConnection daoConnection = daoFactory.getDaoConnection()) {

            BetDao betDao = daoFactory.createBetDao(daoConnection);
            HorseDao horseDao = daoFactory.createHorseDao(daoConnection);
            List<Bet> bets = betDao.findByUser(user);
            for (Bet bet: bets ) {
                Horse horse = horseDao.find(bet.getHorseId());
                bet.setHorse(horse);
                Ride ride = bet.getRide();
                if(ride.isFinished()) {
                    ride.setWinnerHorse(horseDao.find(ride.getWinnerId()));
                    ride.setLooserHorse(horseDao.find(ride.getLooserId()));
                }
                bet.setRide(ride);
            }
            return bets;
        }

    }

    @Override
    public void calculateResults(Ride ride) {
        try(DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            BetDao betDao = daoFactory.createBetDao(daoConnection);
            UserDao userDao = daoFactory.createUserDao(daoConnection);
            List<Bet> bets =  betDao.findByRideId(ride.getRideId());
            for (Bet bet : bets ) {
                Integer predictionHorseId =  getHorseIdFromRideByBetType(ride,bet);
                if(isBetPassed(bet, predictionHorseId)){
                    Long totalSumm = (long) (bet.getBetSum()*ride.getCoefficient()) ;
                    bet.setTotalSumm( totalSumm );
                    bet.setPassed(true);
                    calculateMoney(ride,bet, userDao);
                    System.out.println(bet.getBetId());
                    betDao.update(bet);

                }
            }

        }

    }

    private boolean isBetPassed(Bet bet, Integer predictionHorseId){
        boolean result = false;
        if(predictionHorseId.equals(bet.getHorseId())){
            result = true;
        }
        return result;
    }

    private Integer getHorseIdFromRideByBetType(Ride ride, Bet bet) {
        Integer horseRideId;
        if(bet.getBetTypeString().equals(Attributes.WINNER)){
            horseRideId = ride.getWinnerId();
        } else{
            horseRideId = ride.getLooserId();
        }
        return horseRideId;
    }

    private void calculateMoney(Ride ride, Bet bet, UserDao userDao){

        User bookmaker = userDao.findByEmail(ride.getBookmakerEmail());
        bookmaker.deposite(bet.getTotalSumm()*(-1));
        userDao.update(bookmaker);

        User client = userDao.find(bet.getUserId());
        client.deposite(bet.getTotalSumm());
        userDao.update(client);

    }


}
