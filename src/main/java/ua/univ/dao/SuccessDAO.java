package ua.univ.dao;

import org.apache.log4j.Logger;
import ua.univ.entities.User;
import ua.univ.entities.Success;
import ua.univ.entities.Test;
import ua.univ.entities.User;
import ua.univ.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuccessDAO extends AbstractDAO{
    final static Logger logger = Logger.getLogger(SuccessDAO.class);
    private final static String SET_PASSED_TEST = "insert into success (testname,studentemail, mark) values(?,?,?)";
    private final static String GET_SUCCESS_BY_USER = "select testname,count(1), max(mark) from success where studentemail=? group by testname";
    public void setPassedTest(User student, Test test,int mark){
         Connection con = getConnection();
         if (con ==null) return;
         PreparedStatement st = null;
         try {
             st = con.prepareStatement(SET_PASSED_TEST);
             st.setString(1,test.getName());
             st.setString(2,student.getEmail());
             st.setInt(3,mark);
             st.executeUpdate();
             logger.info("Add success to student "+student.getEmail()+" to database.");
         }
         catch (SQLException e){
             logger.error(e.getMessage());
         }
         finally {
             closeConnection(con);
         }
    }
    public List<List<String>> getSuccess(User user){
        List<List<String>> res = new ArrayList<>();
        Connection con = getConnection();
        if (con ==null) return res;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(GET_SUCCESS_BY_USER);
            st.setString(1,user.getEmail());
            rs = st.executeQuery();
            while (rs.next()){
                List<String> row = new ArrayList<>(3);
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                res.add(row);
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
}
