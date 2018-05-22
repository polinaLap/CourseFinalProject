package ua.univ.dao;

import org.apache.log4j.Logger;
import ua.univ.entities.Question;
import ua.univ.entities.Test;
import ua.univ.exceptions.DataBaseException;
import ua.univ.pool.ConnectionPool;
import ua.univ.transaction.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TestDAO {
    final static Logger logger = Logger.getLogger(TestDAO.class);
    final static int maxQuestionCount=10;
    private static final String ADD_TEST = "insert into tests " +
            "(name, description, question1, question2, question3, question4, question5," +
            " question6, question7, question8, question9, question10) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_TEST_DESCRIPTION ="select description from tests where name=?";
    private static final String GET_TEST_QUESTIONS_IDS ="select question1, question2, question3," +
            " question4, question5, question6, question7, question8, question9, question10 from tests where name=?";
    private static final String GET_ALL_TESTS ="select name, description from tests";
    public void addTest(Test test) throws DataBaseException {
        Connection con = Transaction.getConnection();
        boolean res = true;
        PreparedStatement st = null;
        try {
            st =con.prepareStatement(ADD_TEST);
            st.setString(1,test.getName());
            st.setString(2,test.getDescription());
            for (int i=0;i<maxQuestionCount;i++) {
                if(i<test.getQuestions().size())st.setInt(i+3,test.getQuestion(i).getId());
                else st.setNull(i+3,Types.INTEGER);
            }
            st.executeUpdate();
            logger.info("Add test "+test.getName());
        }
        catch (SQLException e){
            logger.error(e.getMessage());
            throw new DataBaseException(e);
        }

    }
    public String getTestDescription(String testName) throws DataBaseException {
        Connection con = Transaction.getConnection();
        String description ="";
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st =con.prepareStatement(GET_TEST_DESCRIPTION);
            st.setString(1,testName);
            rs = st.executeQuery();
            while (rs.next()){
                description=rs.getString(1);
                break;
            }
        }
        catch (SQLException e){
            logger.error(e.getMessage());
            throw new DataBaseException(e);
        }

        return  description;
    }
    public List<Integer> getQuestionIds(String testName) throws DataBaseException {
        Connection con = Transaction.getConnection();
        List<Integer> result = new ArrayList<>();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st =con.prepareStatement(GET_TEST_QUESTIONS_IDS);
            st.setString(1,testName);
            rs = st.executeQuery();
            while (rs.next()){
                for (int i = 0; i < maxQuestionCount; i++) {
                    if(rs.getObject(i+1)!=null) result.add(rs.getInt(i+1));
                }
                break;
            }
        }
        catch (SQLException e){
            logger.error(e.getMessage());
            throw new DataBaseException(e);
        }
        return  result;
    }
    public List<List<String>> getAllTests() throws DataBaseException {
        List<List<String>> res =new ArrayList<>();
        Connection con = Transaction.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(GET_ALL_TESTS);
            rs = st.executeQuery();
            while (rs.next()){
                List<String> name_desc= new ArrayList<>();
                name_desc.add(rs.getString(1));
                name_desc.add(rs.getString(2));
                res.add(name_desc);
            }
        }
        catch (SQLException e){
            logger.error(e.getMessage());
            throw new DataBaseException(e);
        }

        return res;
    }

}
