package controller.parser;

import model.entity.Entity;
import model.entity.Ride;
import model.entity.User;

/**
 * Created by daniel on 1/23/17.
 */
public class RideParser implements Parser {
    Ride ride;

    public RideParser(User user) {
        this.ride = new Ride(user.getUserId());

    }

    @Override
    public Ride getEntity() {

        return ride;
    }
}
