package dao.interfaces;

import model.entity.Bet;

import java.util.List;

/**
 * Created by daniel on 05/01/17.
 */
public interface BetDao extends GenericDao<Bet> {
    List<Bet> findbyType(String type);
}
