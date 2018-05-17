package ua.univ.dao;

import org.apache.log4j.Logger;
import ua.univ.entities.Question;
import ua.univ.entities.Test;
import ua.univ.pool.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class TestDAO extends AbstractDAO {
    final static Logger logger = Logger.getLogger(TestDAO.class);
    private static final String ADD_TEST = "insert into tests " +
            "(name, description, question1, question2, question3, question4, question5, question6, question7, question8, question9, question10) " +
            "values(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String GET_TEST ="select * from tests where name=?";
    private static final String GET_ALL_TESTS ="select name, description from tests";
    public void addTest(Test test){
        Connection con = getConnection();
        if (con ==null) return;
        PreparedStatement testSt = null;
        try {
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            Savepoint savepoint = con.setSavepoint("savePoint");
            testSt =con.prepareStatement(ADD_TEST);
            testSt.setString(1,test.getName());
            testSt.setString(2,test.getDescription());
            PreparedStatement st = null;
            for (int i=0;i<10;i++) {
                try{
                    if(i<test.getQuestions().size()){
                        testSt.setInt(i+3,test.getQuestion(i).getId());
                        QuestionDAO q = new QuestionDAO();
                        q.addQuestion(test.getQuestion(i), con);
                    }
                    else{
                        testSt.setNull(i+2,Types.INTEGER);
                    }
                }
                catch (SQLException e){
                    logger.error(e.getMessage()+"  Executing rollback to savepoint.");
                }
            }
            testSt.executeUpdate();
            con.commit();
            con.releaseSavepoint(savepoint);
            logger.info("Add test "+test.getName());

        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            closeConnection(con);
        }
    }
    public Test getTest(String testName){
        Connection con = getConnection();
        Test res = null;
        if (con ==null) return res;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            con.setAutoCommit(false);
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            st =con.prepareStatement(GET_TEST);
            st.setString(1,testName);
            rs = st.executeQuery();
            while (rs.next()){
                String description = rs.getString(2);
                List<Question> questions = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    QuestionDAO q = new QuestionDAO();
                    Question quest = q.getQuestion(rs.getInt(i+3),con);
                    if(quest!=null) questions.add(quest);
                }
                res = new Test(testName,description,questions);
                break;
            }
            con.commit();

        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
        finally {
            closeConnection(con);
        }
        return  res;
    }
    public List<List<String>> getAllTests(){
        List<List<String>> res =new ArrayList<>();
        Connection con = pool.connectionCheck();
        if (con ==null) return res;
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
        }
        finally {
            closeConnection(con);
        }
        return res;
    }

}
