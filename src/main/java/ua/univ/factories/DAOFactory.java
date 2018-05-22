package ua.univ.factories;

import ua.univ.dao.QuestionDAO;
import ua.univ.dao.SuccessDAO;
import ua.univ.dao.TestDAO;
import ua.univ.dao.UserDAO;

public class DAOFactory {
    private static DAOFactory instance=new DAOFactory();
    public static DAOFactory getInstance(){return instance;}
    private static UserDAO userDAO;
    private static TestDAO testDAO;
    private static QuestionDAO questionDAO;
    private static SuccessDAO successDAO;
    private DAOFactory(){
        userDAO=new UserDAO();
        testDAO=new TestDAO();
        questionDAO=new QuestionDAO();
        successDAO= new SuccessDAO();
    }
    public UserDAO getUserDAO() {
        return userDAO;
    }

    public TestDAO getTestDAO() {
        return testDAO;
    }

    public QuestionDAO getQuestionDAO() {
        return questionDAO;
    }

    public SuccessDAO getSuccessDAO() {
        return successDAO;
    }
}
