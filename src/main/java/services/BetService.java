package services;

import model.entity.Bet;
import model.entity.User;

import java.util.List;

/**
 * Created by daniel on 14/01/17.
 */
public interface BetService {
    void makeBet(User user,Bet bet);
    List<Bet> findBetsByUserId(Integer userId) throws Exception;
    void calculate();
}
