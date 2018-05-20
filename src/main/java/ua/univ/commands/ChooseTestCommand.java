package ua.univ.commands;

import ua.univ.entities.Test;
import ua.univ.resource.ConfigurationManager;
import ua.univ.services.TestService;

import javax.servlet.http.HttpServletRequest;

public class ChooseTestCommand implements IActionCommand {
    private static final String PARAM_NAME_TEST = "testName";
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String testName = request.getParameter(PARAM_NAME_TEST);
        Test test = new TestService().getTest(testName);
        request.getSession().setAttribute("test",test);
        request.setAttribute("test",test);
        page = ConfigurationManager.getProperty("path.page.test");
        return page;
    }
}
