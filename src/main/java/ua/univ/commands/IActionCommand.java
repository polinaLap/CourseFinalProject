package ua.univ.commands;

import javax.servlet.http.HttpServletRequest;

public interface IActionCommand {
    String execute(HttpServletRequest request);
}
