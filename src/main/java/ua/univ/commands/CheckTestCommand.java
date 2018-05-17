package ua.univ.commands;

import ua.univ.entities.Question;
import ua.univ.entities.Test;
import ua.univ.entities.User;
import ua.univ.resource.ConfigurationManager;
import ua.univ.services.CheckTestService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class CheckTestCommand implements IActionCommand {
    private static final String PARAM_NAME_TEST = "test";
    private static final String PARAM_NAME_MARK = "curMark";
    @Override
    public String execute(HttpServletRequest request) {
        Test test = (Test)request.getSession().getAttribute(PARAM_NAME_TEST);
        List<String> answers = new ArrayList<>(test.getQuestions().size());
        for (Question q : test.getQuestions()) {
            answers.add(request.getParameter(q.getQuestion()));
        }
        int mark = CheckTestService.check(test,answers, (User)request.getSession().getAttribute("user"));
        request.getSession().setAttribute(PARAM_NAME_TEST,test);
        request.getSession().setAttribute(PARAM_NAME_MARK,mark);

        return ConfigurationManager.getProperty("path.page.testresult");
    }
}
