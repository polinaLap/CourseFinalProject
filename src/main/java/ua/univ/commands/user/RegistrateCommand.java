package ua.univ.commands.user;

import ua.univ.commands.IActionCommand;
import ua.univ.factories.ServiceFactory;
import ua.univ.resource.ConfigurationManager;
import ua.univ.resource.MessageManager;
import ua.univ.services.common.RegistrateService;

import javax.servlet.http.HttpServletRequest;

public class RegistrateCommand implements IActionCommand {
    private static final String PARAM_NAME_NAME= "name";
    private static final String PARAM_NAME_LOGIN = "login";
    private static final String PARAM_NAME_PASSWORD = "password";
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.registration");
        String name = request.getParameter(PARAM_NAME_NAME);
        String email = request.getParameter(PARAM_NAME_LOGIN);
        String password = request.getParameter(PARAM_NAME_PASSWORD);
        if(name.equals("")||email.equals("")||password.equals("")){
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
        }
        else if(! ServiceFactory.getInstance().getRegistrateService().registrate(name,email,password)) {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.alreadyExists"));
        }
        else page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
