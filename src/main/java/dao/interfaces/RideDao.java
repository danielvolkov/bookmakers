package dao.interfaces;

import model.entity.Ride;

import java.util.List;

/**
 * Created by daniel on 05/01/17.
 */
public interface RideDao extends GenericDao<Ride> {
    List<Ride> findFinishedRides(boolean status);
}
