package services;


import model.entity.Horse;

import java.util.List;

/**
 * Created by daniel on 14/01/17.
 */
public interface HorseService {
    List<Horse> getHorses() throws Exception;
    Horse getHorse(Integer id);
}
