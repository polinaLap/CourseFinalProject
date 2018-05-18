package ua.univ.commands;

import ua.univ.entities.User;
import ua.univ.resource.ConfigurationManager;
import ua.univ.resource.MessageManager;
import ua.univ.services.UserSuccessService;

import javax.servlet.http.HttpServletRequest;

public class ShowSuccessCommand implements IActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page=null;
        User cur_user = (User)request.getSession().getAttribute("user");
        if(UserSuccessService.getSuccess(cur_user)){
        page = ConfigurationManager.getProperty("path.page.success");
        }
        else{
            request.setAttribute("error",
                    MessageManager.getProperty("message.databaseError"));
            page = ConfigurationManager.getProperty("path.page.menu");
        }
        return page;
    }
}
