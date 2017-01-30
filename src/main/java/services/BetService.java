package services;


import exceptions.MaxBetException;
import exceptions.NosuchMoneyException;
import model.entity.Bet;
import model.entity.Ride;
import model.entity.User;

import java.util.List;

/**
 * Created by daniel on 14/01/17.
 */
public interface BetService {
    void makeBet(User user,Bet bet)  throws NosuchMoneyException, MaxBetException;
    List<Bet> findBetsByUser(User user) throws Exception;
    void calculateResults(Ride ride);
}
