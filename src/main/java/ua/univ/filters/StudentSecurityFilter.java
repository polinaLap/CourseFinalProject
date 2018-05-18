package ua.univ.filters;

import ua.univ.entities.User;
import ua.univ.entities.UserType;
import ua.univ.resource.ConfigurationManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = { "/user/*" })
public class StudentSecurityFilter extends AbstractFilter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        User user = (User)httpRequest.getSession().getAttribute("user");
        if(user==null||user.getType()!=UserType.STUDENT){
            httpRequest.getSession().invalidate();
            httpResponse.sendRedirect(httpRequest.getContextPath() + indexPath);
            return;
        }
        chain.doFilter(request, response); }

}