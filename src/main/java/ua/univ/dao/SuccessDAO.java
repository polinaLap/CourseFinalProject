package ua.univ.dao;

import org.apache.log4j.Logger;
import ua.univ.entities.User;
import ua.univ.entities.Success;
import ua.univ.entities.Test;
import ua.univ.entities.User;
import ua.univ.exceptions.DataBaseException;
import ua.univ.pool.ConnectionPool;
import ua.univ.transaction.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuccessDAO{
    final static Logger logger = Logger.getLogger(SuccessDAO.class);
    private final static String SET_PASSED_TEST = "insert into success (testname,studentemail, mark) values(?,?,?)";
    private final static String GET_SUCCESS_BY_USER = "select testname, mark from success where studentemail=?";
    private final static String GET_SORTED_USERS = "select studentemail, avg(mark) as sr from success group by studentemail order by sr desc";
    public void setPassedTest(User student, Test test,int mark) throws DataBaseException {
         Connection con = Transaction.getConnection();
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
             throw new DataBaseException(e);
         }

    }
    public Success getSuccess(User user) throws DataBaseException {
        Connection con = Transaction.getConnection();
        Success result = new Success();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(GET_SUCCESS_BY_USER);
            st.setString(1,user.getEmail());
            rs = st.executeQuery();
            while (rs.next()){
                String testname = rs.getString(1);
                int mark = rs.getInt(2);
                result.addTestMark(testname,mark);
            }
        }
        catch (SQLException e){
            logger.error(e.getMessage());
            throw new DataBaseException();
        }
        return  result;
    }
    public List<String> getSortedUsersBySuccess() throws DataBaseException {
        List<String> res = new ArrayList<>();
        Connection con = Transaction.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(GET_SORTED_USERS);
            rs = st.executeQuery();
            while (rs.next()){
                res.add(rs.getString(1));
            }
        }
        catch (SQLException e){
            logger.error(e.getMessage());
            throw new DataBaseException(e);
        }

        return  res;
    }
}
