package ua.univ.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;

public class ConnectionPool {
    private final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(ConnectionPool.class);
    private final static String connectionString = "jdbc:mysql://localhost:3306/studentstesting" +
            "?verifyServerCertificate=false&useSSL=false&requireSSL=false&useLegacyDatetimeCode=false&amp&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password="2585";
    private final int initialConnections = 5;
    private Vector connectionsAvailable = new Vector();
    private Vector connectionsUsed = new Vector();
    private static ConnectionPool instance = new ConnectionPool();
    public static ConnectionPool getInstance() {
        return instance;
    }
    private void registerDriver(){
        try{Class.forName("com.mysql.cj.jdbc.Driver");}
        catch(ClassNotFoundException e){
            logger.error(e.getMessage());
        }
    }
    private Connection getConnection() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(connectionString,user,password);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
        return con;
    }

    private ConnectionPool() {
        registerDriver();
        for (int count = 0; count < initialConnections; count++)
            connectionsAvailable.addElement(getConnection());
    }

    public Connection connectionCheck(){
        Connection newConnection = null;
        if (connectionsAvailable.size() == 0) {
            newConnection = getConnection();
            connectionsUsed.addElement(newConnection);
        } else {
            newConnection = (Connection) connectionsAvailable.lastElement();

            connectionsAvailable.removeElement(newConnection);

            connectionsUsed.addElement(newConnection);
        }
        return newConnection;
    }

    public int availableCount() {
        return connectionsAvailable.size();
    }

}
