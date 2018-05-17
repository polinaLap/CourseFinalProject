package ua.univ.services;

import ua.univ.dao.SuccessDAO;
import ua.univ.entities.Question;
import ua.univ.entities.Test;
import ua.univ.entities.User;

import java.util.List;

public class CheckTestService {
    public static int check(Test test, List<String> answers, User user){
        int mark =0;
        for (int i = 0; i < test.getQuestions().size(); i++) {
            Question curQuest = test.getQuestion(i);
            if(answers.get(i)!=null&&
                    answers.get(i).equals(curQuest.getAnswerVariants().get(curQuest.getIndexOfTrueAnswer()-1))) {
                curQuest.setOkAnswer(true);
                mark++;}
            else curQuest.setOkAnswer(false);
        }
        new SuccessDAO().setPassedTest(user,test,mark);
        return mark;
    }
}
