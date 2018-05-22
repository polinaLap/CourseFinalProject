package ua.univ.dao;

import org.apache.log4j.Logger;
import ua.univ.entities.Question;
import ua.univ.exceptions.DataBaseException;
import ua.univ.transaction.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    final static Logger logger = Logger.getLogger(QuestionDAO.class);
    private static int maxAnsCount=4;
    private static final String ADD_QUESTION ="insert into questions (id,question, answer1,answer2,answer3,answer4, trueanswer) " +
            "values(?,?,?,?,?,?,?)";
    private static final String GET_QUESTION ="select * from questions where id=?";
    private static final String GET_MAX_ID ="(select max(id) from questions)";

    public void addQuestion(Question question) throws DataBaseException {
        Connection con = Transaction.getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            PreparedStatement st_getId = con.prepareStatement(GET_MAX_ID);
            rs=st_getId.executeQuery();
            int id = 0;
            while (rs.next()){
                id=rs.getInt(1)+1;
                break;
            }
            question.setId(id);
            st = con.prepareStatement(ADD_QUESTION);
            st.setInt(1,id);
            st.setString(2,question.getQuestion());
            for (int i = 0; i <maxAnsCount; i++) {
                    if(i<question.getAnswerVariants().size())
                        st.setString(i+3,question.getAnswerVariants().get(i));
                    else st.setNull(i+3,Types.NVARCHAR);
            }
            st.setInt(7,question.getIndexOfTrueAnswer());
            st.executeUpdate();
        }
        catch (SQLException e){
            logger.error(e.getMessage());
            throw new DataBaseException(e);
        }

    }
    public Question getQuestion(int id) throws DataBaseException {
        Question result =null;
        Connection con = Transaction.getConnection();
        if (con ==null) return result;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = con.prepareStatement(GET_QUESTION);
            st.setInt(1,id);
            rs = st.executeQuery();
            while (rs.next()){
                List<String> answers = new ArrayList<>();
                for (int i = 0; i < 4; i++) {
                    String tmp =rs.getString(i+2);
                    if(tmp!=null)answers.add(tmp);
                }
                result = new Question(rs.getString(6),answers,rs.getInt(7));
                result.setId(id);
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
