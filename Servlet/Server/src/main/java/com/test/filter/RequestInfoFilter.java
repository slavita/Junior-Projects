package com.test.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by SERGE on 06.07.2014.
 */
public class RequestInfoFilter extends BaseFilter {
    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String method = servletRequest.getMethod();
        String remoteAddr = servletRequest.getRemoteAddr();
        String queryString = servletRequest.getQueryString();
        String protocol = servletRequest.getProtocol();
        System.out.println(">> RequestInfoFilter: method = " + method + ", remoteAddr = " + remoteAddr + ", queryString = " + queryString + ", protocol =  " + protocol);
        System.out.println();

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
