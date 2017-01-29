package dao.jdbc;

import dao.interfaces.BetDao;
import model.entity.Bet;
import model.entity.Ride;
import model.entity.User;
import org.apache.log4j.Logger;
import util.constants.Attributes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 07/01/17.
 */
public class JdbcBetDao implements BetDao {

    private static final Logger logger = Logger.getLogger(JdbcBetDao.class);

    public static final String CREATE =
            "INSERT INTO bets ( ride_id, summ, bet_type_id, horse_id,client_id) " +
            "VALUES(?, ?, ?, ?,?)";
    public static final String FIND_BY_USER =
            "SELECT * FROM bets " +
            "JOIN rides ON bets.ride_id = rides.ride_id " +
            "JOIN users ON rides.bookmaker_id = users.user_id "+
            "LEFT JOIN bet_type ON bets.bet_type_id = bet_type.bet_type_id WHERE client_id = ?";
    public static final String FIND_BY_RIDE =
            "SELECT * FROM bets JOIN bet_type ON bets.bet_type_id = bet_type.bet_type_id  WHERE ride_id = ?";

    public static final String UPDATE_BET =
            "UPDATE bets SET is_passed = ?, total_summ = ? WHERE bet_id = ?";

    private Connection connection;

    public JdbcBetDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Bet find(int id) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public List<Bet> findAll() {
        return null;
    }


    @Override
    public void create(Bet bet) {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(CREATE);
            statement.setInt(1, bet.getRideId());
            statement.setLong(2, bet.getBetSum());
            statement.setInt(3, bet.getBetType());
            statement.setInt(4, bet.getHorseId());
            statement.setInt(5, bet.getUserId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void update(Bet bet) {
        try(PreparedStatement statement =
                    connection.prepareStatement(UPDATE_BET)){
            statement.setBoolean(1, bet.getPassed());
            statement.setDouble(2, bet.getTotalSumm());
            statement.setInt(3, bet.getBetId());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }



    @Override
    public List<Bet> findByUser(User user) {
        List<Bet> bets = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_USER);
            statement.setInt(1,user.getUserId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Bet bet = getBetFromResultSet(resultSet);
                bet.setRide(JdbcRideDao.getRideFromResultSet(resultSet));
                bets.add(bet);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return bets;
    }

    @Override
    public List<Bet> findByRideId(Integer rideId) {
        List<Bet> bets = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_RIDE);
            statement.setInt(1,rideId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Bet bet = getBetFromResultSet(resultSet);
                bets.add(bet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bets;
    }

    private Bet getBetFromResultSet(ResultSet resultSet) throws SQLException{
        Bet bet = new Bet();
        bet.setBetId(resultSet.getInt(Attributes.BET_ID));
        bet.setTotalSumm(resultSet.getLong(Attributes.TOTAL_SUMM));
        bet.setRideId(resultSet.getInt(Attributes.RIDE_ID));
        bet.setBetSum(resultSet.getLong(Attributes.BET_SUMM));
        bet.setHorseId(resultSet.getInt(Attributes.HORSE_ID));
        bet.setPassed(resultSet.getBoolean(Attributes.IS_PASSED));
        bet.setBetTypeString(resultSet.getString(Attributes.BET_TYPE));
        bet.setUserId(resultSet.getInt(Attributes.CLIENT_ID));
        return bet;
    }

}
