package ua.univ.commands.admin;

import ua.univ.commands.IActionCommand;
import ua.univ.entities.User;
import ua.univ.factories.ServiceFactory;
import ua.univ.resource.ConfigurationManager;
import ua.univ.resource.MessageManager;
import ua.univ.services.admin.ShowTableService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowTableCommand implements IActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        List<User> table = ServiceFactory.getInstance().getShowTableService().getTable();
        if(!table.isEmpty()) {
            page = ConfigurationManager.getProperty("path.page.table");
            request.getSession().setAttribute("table", table);
        }
        else{
            page = ConfigurationManager.getProperty("path.page.adminmenu");
            request.setAttribute("error",
                    MessageManager.getProperty("message.databaseError"));
        }
        return page;
    }
}
