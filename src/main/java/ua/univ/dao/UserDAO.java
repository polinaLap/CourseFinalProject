package ua.univ.dao;

import org.apache.log4j.Logger;
import ua.univ.entities.User;
import ua.univ.entities.User;
import ua.univ.exceptions.DataBaseException;
import ua.univ.pool.ConnectionPool;
import ua.univ.transaction.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO{
    final static Logger logger = Logger.getLogger(UserDAO.class);
    private static final String ADD_STUDENT = "insert into students (name, email,password) values(?,?,?)";
    private static final String GET_USER = "select name, password from students where email=?";

    public void addUser(User user) throws DataBaseException {
        Connection con = Transaction.getConnection();
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(ADD_STUDENT);
            st.setString(1,user.getName());
            st.setString(2,user.getEmail());
            st.setString(3,user.getPassword());
            st.executeUpdate();
            logger.info("Add student "+user.getEmail()+" to database.");
        }
        catch (SQLException e){
            logger.error(e.getMessage());
            throw new DataBaseException(e);
        }

    }
    public User getUser(String email) throws DataBaseException {
        User result =null;
        Connection con = Transaction.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(GET_USER);
            st.setString(1,email);
            rs = st.executeQuery();
            while (rs.next()){
                result = new User(rs.getString(1),email,rs.getString(2));
                break;
            }
        }
        catch (SQLException e){
            logger.error(e.getMessage());
            throw new DataBaseException(e);
        }

        return result;
    }
}
