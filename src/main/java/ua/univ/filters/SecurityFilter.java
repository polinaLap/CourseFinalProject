package ua.univ.filters;

import ua.univ.entities.User;
import ua.univ.entities.UserType;
import ua.univ.resource.ConfigurationManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebFilter("/*")
public class SecurityFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String path = httpRequest.getRequestURI();
        User user = (User)httpRequest.getSession().getAttribute("user");
        if(checkPath(path,"\\/jsp\\/.*")||
                (checkPath(path,"\\/admin\\/.*")&&(user==null||!user.getType().equals(UserType.ADMIN)))||
                (checkPath(path,"\\/user\\/.*")&&(user==null||!user.getType().equals(UserType.STUDENT))))
            httpResponse.sendRedirect(httpRequest.getContextPath() + ConfigurationManager.getProperty("path.page.index"));
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

    private boolean checkPath(String path, String regex){
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(path);
        return m.matches();
    }
}
