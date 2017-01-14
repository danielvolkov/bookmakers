package dao.jdbc;

import dao.interfaces.RideDao;
import model.entity.Ride;

import java.sql.Connection;
import java.util.List;

/**
 * Created by daniel on 07/01/17.
 */
public class JdbcRideDao implements RideDao {
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
        return null;
    }

    @Override
    public void create(Ride ride) {

    }

    @Override
    public void update(Ride ride) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Ride> findFinishedRides(boolean status) {
        return null;
    }
}
