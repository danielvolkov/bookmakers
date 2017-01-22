package services.impl;

import dao.DaoConnection;
import dao.factory.DaoFactory;
import dao.interfaces.UserDao;
import dao.jdbc.JdbcDaoFactory;
import model.entity.User;
import services.UserService;

import java.sql.SQLException;

/**
 * Created by daniel on 14/01/17.
 */
public class UserServiceImpl implements UserService{
    private DaoFactory daoFactory;

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
        try(DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            UserDao userDao = daoFactory.createUserDao(daoConnection);
            if( user != null ){
                daoConnection.begin();
                userDao.create(user);
                daoConnection.commit();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void update(User user) {

    }


    @Override
    public User findUser(String email) {
        User user = null;
        try (DaoConnection daoConnection = daoFactory.getDaoConnection()) {
            UserDao userDao = daoFactory.createUserDao(daoConnection);
            if (userDao != null){
                daoConnection.begin();
                user = userDao.findByEmail(email);
                daoConnection.commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }




}
