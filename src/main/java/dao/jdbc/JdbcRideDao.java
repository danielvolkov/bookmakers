package dao.jdbc;

import dao.interfaces.RideDao;
import model.entity.Ride;

import org.apache.log4j.Logger;
import util.constants.Attributes;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by daniel on 07/01/17.
 */
public class JdbcRideDao implements RideDao {

    private static final Logger logger = Logger.getLogger(JdbcRideDao.class);

    public static final String CREATE = "INSERT INTO rides (start_time, is_finished, bookmaker_id,max_summ,coefficient) " +
            "VALUES(?, ?, ?, ?, ?)";

    public static final String FIND_BY_ID = "SELECT * FROM rides JOIN users ON rides.bookmaker_id = users.user_id WHERE  ride_id = ?";

    public static final String UPDATE_RIDE = "UPDATE rides SET is_finished = ?, winner_id = ?, lose_id = ? WHERE ride_id = ?";

    public static final String FIND_ALL = "SELECT * FROM rides JOIN users ON rides.bookmaker_id = users.user_id";


    private Connection connection;

    public JdbcRideDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Ride find(int id) {
        Ride ride;
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_BY_ID);
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            ride = getRideFromResultSet(resultSet);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return ride;
    }

    @Override
    public List<Ride> findAll() {
        List<Ride> rides = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(FIND_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
               rides.add(getRideFromResultSet(resultSet));
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rides;
    }

    @Override
    public void create(Ride ride) {
        try {
            PreparedStatement statement =
                    connection.prepareStatement(CREATE);

            statement.setDate(1, new Date(ride.getStartDataTime().getTime()) );
            statement.setBoolean(2, ride.isFinished());
            statement.setInt(3, ride.getBookmakerId());
            statement.setLong(4,ride.getMaxSumm());
            statement.setDouble(5,ride.getCoefficient());
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Ride ride) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_RIDE);
            statement.setBoolean(1, ride.isFinished());
            statement.setInt(2, ride.getWinnerId());
            statement.setInt(3,ride.getLooserId());
            statement.setInt(4,ride.getRideId());
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
    public List<Ride> findFinishedRides(boolean status) {
        return null;
    }


    public static Ride getRideFromResultSet(ResultSet resultSet) throws SQLException {

        Ride ride = new Ride();
        ride.setRideId(resultSet.getInt(Attributes.RIDE_ID));
        ride.setStartDataTime(resultSet.getDate(Attributes.START_TIME));
        ride.setFinished(resultSet.getBoolean(Attributes.IS_FINISHED));
        ride.setWinnerId(resultSet.getInt(Attributes.WINNER_ID));
        ride.setLooserId(resultSet.getInt(Attributes.LOSE_ID));
        ride.setBookmakerEmail(resultSet.getString(Attributes.EMAIL));
        ride.setMaxSumm(resultSet.getLong(Attributes.MAX_BET));
        ride.setCoefficient(resultSet.getDouble(Attributes.COEF));
        return ride;
    }
}