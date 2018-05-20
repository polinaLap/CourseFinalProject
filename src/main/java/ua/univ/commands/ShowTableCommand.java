package ua.univ.commands;

import ua.univ.entities.User;
import ua.univ.resource.ConfigurationManager;
import ua.univ.resource.MessageManager;
import ua.univ.services.ShowTableService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowTableCommand implements IActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        List<User> table = new ShowTableService().getTable();
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
