package dao.jdbc;

import dao.interfaces.HorseDao;
import model.entity.Horse;
import util.constants.Attributes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by daniel on 07/01/17.
 */
public class JdbcHorseDao implements HorseDao {

    public static final String SELECT_ALL ="SELECT * FROM horses";
    public static final String SELECT_BY_ID ="SELECT * FROM horses WHERE horse_id = ?";
    private Connection connection;

    public JdbcHorseDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Horse find(int id) {
        Horse horse;
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            horse = getHorseFromResultSet(resultSet);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return horse;
    }

    @Override
    public List<Horse> findAll() {
        List<Horse> horses = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                horses.add(getHorseFromResultSet(resultSet));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return horses;
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


    private Horse getHorseFromResultSet(ResultSet resultSet) throws SQLException{
        Integer horseId = resultSet.getInt(Attributes.HORSE_ID);
        String horseName =  resultSet.getString(Attributes.NAME);
        String horseColor =  resultSet.getString(Attributes.COLOR);
        return  new Horse(horseId,horseName,horseColor);
    }
}
