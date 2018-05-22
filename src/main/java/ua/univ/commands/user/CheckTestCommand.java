package ua.univ.commands.user;

import ua.univ.commands.IActionCommand;
import ua.univ.entities.Question;
import ua.univ.entities.Test;
import ua.univ.entities.User;
import ua.univ.factories.ServiceFactory;
import ua.univ.resource.ConfigurationManager;
import ua.univ.resource.MessageManager;
import ua.univ.services.user.CheckTestService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CheckTestCommand implements IActionCommand {
    private static final String PARAM_NAME_TEST = "test";
    private static final String PARAM_NAME_MARK = "curMark";
    private static final String PARAM_NAME_ANSWERS = "answers";
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.testresult");
        Test test = (Test)request.getSession().getAttribute(PARAM_NAME_TEST);
        List<String> answers = new ArrayList<>(test.getQuestions().size());
        for (Question q : test.getQuestions()) {
            answers.add(request.getParameter(String.valueOf(q.getId())));
        }
        int mark = ServiceFactory.getInstance().getCheckTestService().check(test,answers,
                (User)request.getSession().getAttribute("user"));
        if(mark>=0){
        request.getSession().setAttribute(PARAM_NAME_TEST,test);
        request.getSession().setAttribute(PARAM_NAME_ANSWERS,answers);
        request.getSession().setAttribute(PARAM_NAME_MARK,mark);
        }
        else {
            page=ConfigurationManager.getProperty("path.page.test");
            request.setAttribute("testError",
                    MessageManager.getProperty("message.databaseError"));
        }

        return page;
    }
}
