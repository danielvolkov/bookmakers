package dao.jdbc;

import dao.interfaces.BetDao;
import model.entity.Bet;
import model.entity.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by daniel on 07/01/17.
 */
public class JdbcBetDao implements BetDao {

    public static final String CREATE = "INSERT INTO bets ( ride_id, summ, bet_type_id, horse_id,user_id) " +
            "VALUES(?, ?, ?, ?,?)";


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

}
