package com.test.custom_view_framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CustomHttpSessionClientRepository {

    public static CustomHttpSession getSession(HttpServletRequest request){
        throw new UnsupportedOperationException();
    }

    public static void saveSession(HttpServletResponse response, CustomHttpSession session){
        throw new UnsupportedOperationException();
    }
}
