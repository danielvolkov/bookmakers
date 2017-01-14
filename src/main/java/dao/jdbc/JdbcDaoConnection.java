package dao.jdbc;

import dao.DaoConnection;
import dao.factory.DaoFactory;

import java.sql.Connection;

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

    }

    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }

    @Override
    public void close() throws Exception {

    }
}
