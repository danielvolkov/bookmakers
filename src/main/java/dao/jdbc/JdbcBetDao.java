package dao.jdbc;

import dao.interfaces.BetDao;
import model.entity.Bet;

import java.sql.Connection;
import java.util.List;

/**
 * Created by daniel on 07/01/17.
 */
public class JdbcBetDao implements BetDao {
    private Connection connection;

    public JdbcBetDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Bet find(int id) {
        return null;
    }

    @Override
    public List<Bet> findAll() {
        return null;
    }

    @Override
    public void create(Bet bet) {

    }

    @Override
    public void update(Bet bet) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Bet> findbyType(String type) {
        return null;
    }
}
