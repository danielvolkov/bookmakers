package dao.jdbc;

import dao.DaoConnection;
import dao.factory.DaoFactory;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by daniel on 13/01/17.
 */
public class JdbcDaoConnection implements DaoConnection{

    private Connection connection;
    private boolean isTransactionCommited = false;
    private boolean isTransactionBegin = false;

    public JdbcDaoConnection(Connection connection) {
        this.connection = connection;
    }

    public Connection getConnection() {
        return connection;
    }

    @Override
    public void begin() {
        try {
            isTransactionBegin = true;
            connection.setAutoCommit(false);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void commit() {
        try {
            connection.commit();
            connection.setAutoCommit(true);
            isTransactionCommited = true;
        }catch (SQLException e ){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void rollback() {
        try {
            isTransactionCommited = true;
            connection.rollback();
            connection.setAutoCommit(true);
        }catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public void close() throws Exception {
        try {
            if(isTransactionBegin && !isTransactionCommited ){
                rollback();
            }
            connection.close();
        } catch (SQLException e){
            e.printStackTrace();
            throw new RuntimeException();
        }

    }
}
