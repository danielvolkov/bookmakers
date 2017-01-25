package dao.jdbc;

import dao.interfaces.BetDao;
import model.entity.Bet;
import model.entity.Ride;
import model.entity.User;
import util.Attributes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 07/01/17.
 */
public class JdbcBetDao implements BetDao {

    public static final String CREATE = "INSERT INTO bets ( ride_id, summ, bet_type_id, horse_id,user_id) " +
            "VALUES(?, ?, ?, ?,?)";
    public static final String FIND_BY_USER = "SELECT * FROM bets " +
            "JOIN rides ON bets.ride_id = rides.ride_id " +
            "JOIN users ON rides.bookmaker_id = users.user_id "+
            "LEFT JOIN bet_type ON bets.bet_type_id = bet_type.bet_type_id WHERE client_id = ?";



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
            statement.setInt(2, bet.getBetSum());
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

    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void calculate() {

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
    private Bet getBetFromResultSet(ResultSet resultSet) throws SQLException{

        Double total = resultSet.getDouble(Attributes.TOTAL_SUMM);
        Integer rideId = resultSet.getInt(Attributes.RIDE_ID);
        Integer betSumm = resultSet.getInt(Attributes.BET_SUMM);
        Integer horse_id = resultSet.getInt(Attributes.HORSE_ID);
        boolean isPassed = resultSet.getBoolean(Attributes.IS_PASSED);
        String betType = resultSet.getString(Attributes.BET_TYPE);
        return new Bet(total,isPassed,betSumm,betType,horse_id,rideId);
    }

}
