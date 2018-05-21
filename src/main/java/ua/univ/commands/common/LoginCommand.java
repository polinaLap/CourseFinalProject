package ua.univ.commands.common;

import ua.univ.commands.IActionCommand;
import ua.univ.entities.User;
import ua.univ.entities.UserType;
import ua.univ.factories.ServiceFactory;
import ua.univ.services.common.LoginService;
import ua.univ.resource.ConfigurationManager;
import ua.univ.resource.MessageManager;
import ua.univ.validation.Validator;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements IActionCommand {

    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String login = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        if(!Validator.checkEmail(login)||!Validator.antiIngection(login)||!Validator.antiIngection(pass))
            return stay(request);
        User user = ServiceFactory.getInstance().getLoginService().checkLogin(login,pass);
        if(user!=null){
            request.getSession().setAttribute("user",user);
            if(user.getType()==UserType.ADMIN) page = ConfigurationManager.getProperty("path.page.adminmenu");
            else{ page = ConfigurationManager.getProperty("path.page.menu");}
        }
        else page=stay(request);
        return page;
    }
    private String stay(HttpServletRequest request){
        request.setAttribute("errorLoginPassMessage",
                MessageManager.getProperty("message.loginerror"));
        return ConfigurationManager.getProperty("path.page.login");
    }
}
