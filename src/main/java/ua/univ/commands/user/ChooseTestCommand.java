package ua.univ.commands.user;

import ua.univ.commands.IActionCommand;
import ua.univ.entities.Test;
import ua.univ.factories.ServiceFactory;
import ua.univ.resource.ConfigurationManager;
import ua.univ.services.user.TestService;

import javax.servlet.http.HttpServletRequest;

public class ChooseTestCommand implements IActionCommand {
    private static final String PARAM_NAME_TEST = "testName";
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String testName = request.getParameter(PARAM_NAME_TEST);
        Test test = ServiceFactory.getInstance().getTestService().getTest(testName);
        request.getSession().setAttribute("test",test);
        request.setAttribute("test",test);
        page = ConfigurationManager.getProperty("path.page.test");
        return page;
    }
}
