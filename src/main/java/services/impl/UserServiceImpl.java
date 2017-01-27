package services.impl;

import dao.DaoConnection;
import dao.factory.DaoFactory;
import dao.interfaces.UserDao;
import dao.jdbc.JdbcDaoFactory;
import model.entity.User;
import services.UserService;

import java.sql.SQLException;
import java.util.Objects;

/**
 * Created by daniel on 14/01/17.
 */
public class UserServiceImpl implements UserService{


    private DaoFactory daoFactory; //TODO setter

    private UserServiceImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    private static class LazyHolder{
        private static final UserServiceImpl INSTANCE =
                new UserServiceImpl(JdbcDaoFactory.getInstance());
    }

    public static UserServiceImpl getInstance(){
        return LazyHolder.INSTANCE;
    }

    @Override
    public void create(User user) {
        Objects.requireNonNull(user);
        try(DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            UserDao userDao = daoFactory.createUserDao(daoConnection);
            userDao.create(user);
        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void updateBalance(User user,Long summ) throws Exception {
        try (DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            UserDao userDao = daoFactory.createUserDao(daoConnection);
            daoConnection.begin();
            User existUser = userDao.findByEmail(user.getEmail());
            existUser.deposite(summ);
            userDao.update(existUser);
            daoConnection.commit();
        }
    }


    @Override
    public User findUser(String email) throws Exception {
        try (DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            UserDao userDao = daoFactory.createUserDao(daoConnection);
            return  userDao.findByEmail(email);
        }

    }
    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

}
