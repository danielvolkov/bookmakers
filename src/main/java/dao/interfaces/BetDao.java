package dao.interfaces;

import model.entity.Bet;
import model.entity.User;

import java.util.List;

/**
 * Created by daniel on 05/01/17.
 */
public interface BetDao extends GenericDao<Bet> {
    void calculate();
    List<Bet> findByUser(User user);
}
