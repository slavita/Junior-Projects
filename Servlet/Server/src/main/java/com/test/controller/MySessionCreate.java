package com.test.controller;

import com.test.custom_view_framework.CustomHttpSession;
import com.test.custom_view_framework.CustomHttpSessionOnServerRepository;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class MySessionCreate  extends HttpServlet {
    public static String sessionID = null;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        Cookie fromClient = null;

        for(Cookie cookie : cookies){
            if("sessionID".equals(cookie.getName())){
                fromClient = cookie;
                break;
            }
        }

        if(fromClient == null) {
            sessionID = String.valueOf((int) (Math.random() * 1_000_000_000));
            resp.addCookie(new Cookie("sessionID", sessionID));
        } else {
            sessionID = fromClient.getValue();
        }


        CustomHttpSession session = CustomHttpSessionOnServerRepository.getSession(sessionID);
        AtomicInteger counter = (AtomicInteger)session.getAttribute("counter");



       if(counter == null){
            counter = new AtomicInteger(1);
            session.putAttribute("counter", counter);
        }
           int numberOfVisits = counter.getAndIncrement();
           resp.getWriter().write("You visit this page: " + numberOfVisits + " time");

    }
}
