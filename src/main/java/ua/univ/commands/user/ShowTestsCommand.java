package ua.univ.commands.user;

import ua.univ.commands.IActionCommand;
import ua.univ.factories.ServiceFactory;
import ua.univ.resource.ConfigurationManager;
import ua.univ.services.user.TestListService;

import javax.servlet.http.HttpServletRequest;

public class ShowTestsCommand implements IActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.tests");
        request.getSession().setAttribute("testsList",ServiceFactory.getInstance().getTestListService().getTests());
        return page;
    }
}
