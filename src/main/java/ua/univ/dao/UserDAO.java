package ua.univ.dao;

import org.apache.log4j.Logger;
import ua.univ.entities.User;
import ua.univ.entities.User;
import ua.univ.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDAO extends AbstractDAO {
    final static Logger logger = Logger.getLogger(UserDAO.class);
    private static final String ADD_STUDENT = "insert into students (name, email,password) values(?,?,?)";
    private static final String GET_USER = "select name, password from students where email=?";

    public boolean addUser(User user) {
        Connection con = getConnection();
        if (con ==null) return false;
        boolean res = true;
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
            res = false;
            logger.error(e.getMessage());
        }
        finally {
            closeConnection(con);
        }
        return res;
    }
    public User getUser(String email){
        User res =null;
        Connection con = pool.connectionCheck();
        if (con ==null) return res;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(GET_USER);
            st.setString(1,email);
            rs = st.executeQuery();
            while (rs.next()){
                res = new User(rs.getString(1),email,rs.getString(2));
                break;
            }
        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            closeConnection(con);
        }
        return res;
    }
    public User getUserWithSuccess(String email){
        User res= getUser(email);
        new SuccessDAO().getSuccess(res);
        return res;

    }


}
