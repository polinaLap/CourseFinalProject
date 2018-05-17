package ua.univ.commands;

import ua.univ.dao.TestDAO;
import ua.univ.entities.User;
import ua.univ.entities.UserType;
import ua.univ.services.LoginService;
import ua.univ.resource.ConfigurationManager;
import ua.univ.resource.MessageManager;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements IActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        User user = LoginService.checkLogin(login,pass);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            if(user.getType()==UserType.ADMIN) page = ConfigurationManager.getProperty("path.page.adminmain");
            else{ page = ConfigurationManager.getProperty("path.page.menu");}
        }
        else{
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
