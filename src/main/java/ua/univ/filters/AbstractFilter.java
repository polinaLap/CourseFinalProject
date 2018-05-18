package ua.univ.filters;

import ua.univ.resource.ConfigurationManager;

import javax.servlet.*;
import java.io.IOException;

public abstract class AbstractFilter implements Filter {
    protected String indexPath;
    public void init(FilterConfig fConfig) throws ServletException {
        indexPath = ConfigurationManager.getProperty("path.page.index");
    }
    public abstract void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException;
    public void destroy() { }
}
