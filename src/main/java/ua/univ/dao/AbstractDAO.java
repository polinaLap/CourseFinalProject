package ua.univ.dao;

import org.apache.log4j.Logger;
import ua.univ.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

public class AbstractDAO {
    protected static Logger logger;
    protected ConnectionPool pool;
    public AbstractDAO(){
        this.pool = ConnectionPool.getInstance();
    }
    protected Connection getConnection(){
        return pool.connectionCheck();
    }
    protected void  closeConnection(Connection con){
        try{
            con.close();
        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
    }

}
