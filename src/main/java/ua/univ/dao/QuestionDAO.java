package ua.univ.dao;

import org.apache.log4j.Logger;
import ua.univ.entities.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO extends AbstractDAO{
    final static Logger logger = Logger.getLogger(AbstractDAO.class);
    private static final String ADD_QUESTION ="insert into questions (id, question, answer1,answer2,answer3,answer4, trueanswer) " +
            "values(?,?,?,?,?,?,?)";
    private static final String GET_QUESTION ="select * from questions where id=?";

    public void addQuestion(Question question, Connection con) {
        if (con ==null) return;
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(ADD_QUESTION);
            st.setInt(1,question.getId());
            st.setString(2,question.getQuestion());
            for (int i = 0; i <4; i++) {
                if(i<question.getAnswerVariants().size()){
                    st.setString(i+3,question.getAnswerVariants().get(i));
                }
                else{ st.setNull(i+3,Types.NVARCHAR);}
            }
            st.setInt(6,question.getIndexOfTrueAnswer());
            st.executeUpdate();
            logger.info("Add question "+question.getId()+" to database.");
        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }
    }
    public Question getQuestion(int id, Connection con){
        Question res =null;
        if (con ==null) return res;
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
                res = new Question(id,rs.getString(6),answers,rs.getInt(7));
                break;
            }
        }
        catch (SQLException e){
            logger.error(e.getMessage());
        }

        return res;
    }
}
