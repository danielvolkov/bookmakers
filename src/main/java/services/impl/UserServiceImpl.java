package services.impl;

import controller.security.Encryptor;
import dao.DaoConnection;
import dao.factory.DaoFactory;
import dao.interfaces.UserDao;
import dao.jdbc.JdbcDaoFactory;
import exceptions.NoSuchMoneyException;
import model.entity.User;
import services.UserService;

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
            user.setPassword(Encryptor.encrypt(user.getPassword()));
            userDao.create(user);
        }
    }

    @Override
    public User login(User loginUser) {
        Objects.requireNonNull(loginUser);
        try(DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            UserDao userDao = daoFactory.createUserDao(daoConnection);
            User existUser = userDao.findByEmail(loginUser.getEmail());
            if ( existUser != null){
                String existPassword = existUser.getPassword();
                String loginPassword = loginUser.getPassword();
                if (existPassword.equals(loginPassword)){
                    existUser.setPassword(null);
                    return existUser;
                }
            }
            throw new RuntimeException();
        }
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

    public void withdrawMoney(User user,Long summ)  {
        try (DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            UserDao userDao = daoFactory.createUserDao(daoConnection);
            daoConnection.begin();
            User existUser = userDao.findByEmail(user.getEmail());

            if(existUser.getBalance() > summ) {
                existUser.deposite(summ*(-1));
                userDao.update(existUser);
            }else {
                throw new NoSuchMoneyException();
            }

            daoConnection.commit();
        }
    }


    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

}
