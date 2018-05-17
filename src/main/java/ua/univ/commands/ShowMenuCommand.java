package ua.univ.commands;

import ua.univ.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class ShowMenuCommand implements IActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.menu");
        return page;
    }
}
