package com.test.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SERGE on 06.07.2014.
 */
public class ProcessingTimeFilter extends BaseFilter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getInitParameterNames());
        System.out.println(">> ProcessingTimeFilter - init");
    }

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        long inTime = System.nanoTime();
        chain.doFilter(req, res);
        long outTime = System.nanoTime();
        System.out.println(">> ProcessingTimeFilter: dt = " + (outTime - inTime));
        System.out.println();
    }


    @Override
    public void destroy() {
        System.out.println(">> ProcessingTimeFilter - destroy");
    }
}
