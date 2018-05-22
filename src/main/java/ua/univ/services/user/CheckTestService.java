package ua.univ.services.user;

import ua.univ.dao.SuccessDAO;
import ua.univ.entities.Question;
import ua.univ.entities.Test;
import ua.univ.entities.User;
import ua.univ.exceptions.DataBaseException;
import ua.univ.factories.DAOFactory;

import java.util.List;

public class CheckTestService {
    private static final DAOFactory daoFactory=DAOFactory.getInstance();
    public int check(Test test, List<String> answers, User user){
        int mark =0;
        for (int i = 0; i < test.getQuestions().size(); i++) {
            Question curQuest = test.getQuestion(i);
            if(answers.get(i)!=null&&
                    answers.get(i).equals(curQuest.getAnswerVariants().get(curQuest.getIndexOfTrueAnswer()-1))) {
                curQuest.setOkAnswer(true);
                mark++;}
            else curQuest.setOkAnswer(false);
        }
        try{
            daoFactory.getSuccessDAO().setPassedTest(user,test,mark);
        }
        catch (DataBaseException e){
            return -1;
        }
        return mark;
    }
}
