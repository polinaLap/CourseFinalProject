package ua.univ.commands.common;

import ua.univ.commands.IActionCommand;
import ua.univ.factories.ServiceFactory;
import ua.univ.resource.ConfigurationManager;
import ua.univ.resource.MessageManager;
import ua.univ.services.common.RegistrateService;
import ua.univ.validation.Validator;

import javax.servlet.http.HttpServletRequest;

public class RegistrateCommand implements IActionCommand {
    private static final String PARAM_NAME_NAME= "name";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        String name = request.getParameter(PARAM_NAME_NAME);
        String email = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        if(!Validator.checkEmail(email)||!Validator.antiIngection(email)||
                !Validator.antiIngection(password)||!Validator.antiIngection(name)||
                name.isEmpty()||password.isEmpty())
            return stay(request);
        else if(! ServiceFactory.getInstance().getRegistrateService().registrate(name,email,password)) {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.alreadyExists"));
        }
        else page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
    private String stay(HttpServletRequest request){
        request.setAttribute("errorLoginPassMessage",
                MessageManager.getProperty("message.loginError"));

        return ConfigurationManager.getProperty("path.page.registration");
    }
}
