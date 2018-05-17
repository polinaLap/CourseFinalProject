package ua.univ.commands;

import ua.univ.entities.User;
import ua.univ.resource.ConfigurationManager;
import ua.univ.services.UserSuccessService;

import javax.servlet.http.HttpServletRequest;

public class ShowSuccessCommand implements IActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.success");
        User cur_user = (User)request.getSession().getAttribute("user");
        request.getSession().setAttribute("successList", UserSuccessService.getSuccess(cur_user));
        return page;
    }
}
