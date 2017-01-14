package dao;

/**
 * Created by daniel on 13/01/17.
 */
public interface DaoConnection extends AutoCloseable {
    void begin();
    void commit();
    void rollback();
}
