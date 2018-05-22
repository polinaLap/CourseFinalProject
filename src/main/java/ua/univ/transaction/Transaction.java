package ua.univ.transaction;

import ua.univ.exceptions.DataBaseException;
import ua.univ.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;


public class Transaction {
    private static ConnectionPool pool = ConnectionPool.getInstance();
    private static Connection connection;
    private Transaction (){}
    public static void beginTransaction() throws DataBaseException {
        if (connection!=null) {
            throw new DataBaseException("Transaction already exists");
        }
        try {
            connection = pool.connectionCheck();
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DataBaseException(e);
        }
    }
    public static void endTransaction() throws DataBaseException {
        if (connection==null) {
            throw new DataBaseException("Transaction already finished");
        }

        try {
            connection.close();
        } catch (SQLException e) {
            throw new DataBaseException(e);
        }
        connection=null;
    }
    public static void rollback() throws DataBaseException {
        if (connection==null) {
            throw new DataBaseException("Transaction already finished");
        }

        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new DataBaseException(e);
        }
    }
    public static void commit() throws DataBaseException {
        if (connection==null) {
            throw new DataBaseException();
        }
        try {
            connection.commit();
        } catch (SQLException e) {
            throw new DataBaseException(e);
        }
    }
    public static Connection getConnection() throws DataBaseException {
        if (connection!=null) {
            return connection;
        }
        try {
            Connection connection = pool.connectionCheck();
            connection.setAutoCommit(true);
            return connection;
        } catch (SQLException e) {
            throw new DataBaseException(e);
        }

    }
}
