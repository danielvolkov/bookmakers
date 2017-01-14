package dao.jdbc;

import dao.interfaces.HorseDao;
import model.entity.Horse;

import java.sql.Connection;
import java.util.List;

/**
 * Created by daniel on 07/01/17.
 */
public class JdbcHorseDao implements HorseDao {
    private Connection connection;

    public JdbcHorseDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Horse find(int id) {
        return null;
    }

    @Override
    public List<Horse> findAll() {
        return null;
    }

    @Override
    public void create(Horse horse) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(Horse horse) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Horse findByName(String name) {
        return null;
    }
}
