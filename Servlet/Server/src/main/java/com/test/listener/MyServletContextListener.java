package com.test.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by SERGE on 06.07.2014.
 */
public class MyServletContextListener implements ServletContextListener {
    public MyServletContextListener() {
        System.out.println(">> MyServletContextListener - NEW");
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(">> ServletContext created, contextPath = " + servletContextEvent.getServletContext().getContextPath());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(">> ServletContext destroyed");
    }
}
