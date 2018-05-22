package ua.univ.services.admin;

import ua.univ.dao.TestDAO;
import ua.univ.entities.Question;
import ua.univ.entities.Test;
import ua.univ.exceptions.DataBaseException;
import ua.univ.factories.DAOFactory;
import ua.univ.transaction.Transaction;

public class AddTestService {
    private static final DAOFactory daoFactory=DAOFactory.getInstance();
    public boolean add(Test test){
        try{
            try{
                Transaction.beginTransaction();
                daoFactory.getTestDAO().addTest(test);
                for (Question q :test.getQuestions()) {
                    daoFactory.getQuestionDAO().addQuestion(q);
                }
                Transaction.commit();
            }
            catch (DataBaseException e){
                Transaction.rollback();
                return false;
            }
            finally {
                Transaction.endTransaction();
            }
        }
        catch (DataBaseException e){
            return false;
        }
        return true;
    }
}
