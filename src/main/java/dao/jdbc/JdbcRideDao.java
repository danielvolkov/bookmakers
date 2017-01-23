package dao.jdbc;

import dao.interfaces.RideDao;
import model.entity.Ride;

import util.Attributes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 07/01/17.
 */
public class JdbcRideDao implements RideDao {

    public static final String CREATE = "INSERT INTO rides (start_time, is_finished, bookmaker_id) " +
            "VALUES(?, ?, ?)";

    public static final String FIND_BY_ID = "SELECT * FROM rides JOIN roles ON users.role_id = roles.role_id WHERE email = ?";

    public static final String UPDATE_RIDE = "UPDATE users SET balance = ? WHERE email = ?";

    public static final String FIND_ALL = "SELECT * FROM rides JOIN users ON rides.boomaker_id = users.user_id";


    private Connection connection;

    public JdbcRideDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Ride find(int id) {

        return null;
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
            statement.setDate(1, (Date) ride.getStartDataTime());
            statement.setBoolean(2, ride.isFinished());
            statement.setInt(3, ride.getBookmakerId());
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Ride ride) {
        throw  new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Ride> findFinishedRides(boolean status) {
        return null;
    }


    private Ride getRideFromResultSet(ResultSet resultSet) throws SQLException {
        Integer rideId = resultSet.getInt(Attributes.RIDE_ID);
        Date startTime = resultSet.getDate(Attributes.START_TIME);
        boolean isFinished = resultSet.getBoolean(Attributes.IS_FINISHED);
        Integer winnerId = resultSet.getInt(Attributes.WINNER_ID);
        Integer loserId =  resultSet.getInt(Attributes.LOSE_ID);
        String bookmakerEmail = resultSet.getString(Attributes.EMAIL);

        return new Ride(rideId, winnerId, loserId, startTime, isFinished, bookmakerEmail);
    }
}