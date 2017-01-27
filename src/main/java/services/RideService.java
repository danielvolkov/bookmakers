package services;

import model.entity.Ride;
import model.entity.User;

import java.util.List;

/**
 * Created by daniel on 14/01/17.
 */
public interface RideService {
    void create(Ride ride) throws Exception;
    void delete(Integer id);
    void updateWithConfirm(Integer rideId) throws Exception;
    List<Ride> findRides() throws Exception;
    Ride findRide(Integer rideId) throws Exception;
}
