package services.impl;

import dao.DaoConnection;
import dao.DaoFactory;
import dao.interfaces.HorseDao;
import dao.jdbc.JdbcDaoFactory;
import model.entity.Horse;
import services.HorseService;

import java.util.List;

/**
 * Created by daniel on 14/01/17.
 */
public class HorseServiceImpl implements HorseService{
    private DaoFactory daoFactory;

    private HorseServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    private static class LazyHolder{
        private static final HorseServiceImpl INSTANCE =
                new HorseServiceImpl(JdbcDaoFactory.getInstance());
    }

    public static HorseServiceImpl getInstance(){
        return HorseServiceImpl.LazyHolder.INSTANCE;
    }

    @Override
    public List<Horse> getHorses() throws Exception {
        try (DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            HorseDao horseDao = daoFactory.createHorseDao(daoConnection);
            return  horseDao.findAll();
        }
    }

    @Override
    public Horse getHorse(Integer id) {
        throw new UnsupportedOperationException();
    }
}
