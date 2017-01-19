package dao;

import java.sql.Connection;

/**
 * Created by daniel on 13/01/17.
 */
public interface DaoConnection extends AutoCloseable {
    Connection getConnection();
    void begin();
    void commit();
    void rollback();
}
