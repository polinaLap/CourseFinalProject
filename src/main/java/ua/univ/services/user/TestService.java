package ua.univ.services.user;

import ua.univ.dao.QuestionDAO;
import ua.univ.dao.TestDAO;
import ua.univ.entities.Question;
import ua.univ.entities.Test;
import ua.univ.exceptions.DataBaseException;
import ua.univ.factories.DAOFactory;
import ua.univ.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TestService {
    private static final DAOFactory daoFactory=DAOFactory.getInstance();
    public Test getTest(String name)  {
        Test test=null;
        try{
            try{
                Transaction.beginTransaction();
                String description = daoFactory.getTestDAO().getTestDescription(name);
                List<Question> questions= new ArrayList<Question>();
                List<Integer> questionsIds = daoFactory.getTestDAO().getQuestionIds(name);
                QuestionDAO qd = daoFactory.getQuestionDAO();
                for (int id:questionsIds) {
                    questions.add(qd.getQuestion(id));
                }
                test= new Test(name,description,questions);
            }
            catch (DataBaseException e){
                Transaction.rollback();
            }
            finally {
                Transaction.endTransaction();
            }
        }
        catch (DataBaseException e){
            return null;
        }
        return test;
    }
}
