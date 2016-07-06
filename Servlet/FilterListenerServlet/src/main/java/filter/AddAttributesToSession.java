package filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;


public class AddAttributesToSession extends BaseFilter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = servletRequest.getSession(true);

        Enumeration<String> iter = filterConfig.getInitParameterNames();
        while(iter.hasMoreElements()){
            String initParameterName = iter.nextElement();
            String initParameterValue = filterConfig.getInitParameter(initParameterName);
            session.setAttribute(initParameterName, initParameterValue);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
