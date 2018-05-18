package ua.univ.commands;

import ua.univ.dao.TestDAO;
import ua.univ.entities.Question;
import ua.univ.entities.Test;
import ua.univ.resource.ConfigurationManager;
import ua.univ.resource.MessageManager;
import ua.univ.services.AddTestService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class AddTestCommand implements IActionCommand{

    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.addtest");
        List<Question> questions = new ArrayList<>();
        boolean ok=true;
        String testName = request.getParameter("testname");
        String testDesc = request.getParameter("testdesc");
        for (int i = 0; i < 10; i++) {
            String question = request.getParameter("question"+(i+1));
            if(question.isEmpty()) break;
            String trueAnswer = request.getParameter("trueAnswer"+(i+1));
            if(trueAnswer.isEmpty()) {ok=false;break;}
            String answer1 = request.getParameter("answer"+(i+1)+"A");
            String answer2 = request.getParameter("answer"+(i+1)+"B");
            if((answer1.isEmpty()||answer2.isEmpty())||(i==0&&question.isEmpty())) {ok=false;break;}
            String answer3 = request.getParameter("answer"+(i+1)+"C");
            String answer4 = request.getParameter("answer"+(i+1)+"D");

            List<String> answers = new ArrayList<>();
            answers.add(answer1);
            answers.add(answer2);
            answers.add(answer3);
            answers.add(answer4);
            questions.add(new Question(question,answers,Integer.valueOf(trueAnswer)));
        }
        Test test = new Test(testName,testDesc,questions);
        if(!ok){
            request.setAttribute("saved",
                    MessageManager.getProperty("message.inputerror"));
        }
        else if(!AddTestService.add(test)){
            request.setAttribute("saved",
                    MessageManager.getProperty("message.databaseError"));
        }
        else request.setAttribute("saved",
                    MessageManager.getProperty("message.saved"));
        return page;
    }
}
