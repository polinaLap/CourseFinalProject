package ua.univ.commands;

import ua.univ.dao.TestDAO;
import ua.univ.resource.ConfigurationManager;
import ua.univ.services.TestListService;

import javax.servlet.http.HttpServletRequest;

public class ShowTestsCommand implements IActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.tests");
        request.getSession().setAttribute("testsList",TestListService.getTests());
        return page;
    }
}
