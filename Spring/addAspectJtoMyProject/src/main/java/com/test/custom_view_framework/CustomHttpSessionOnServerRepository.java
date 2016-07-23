package com.test.custom_view_framework;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class CustomHttpSessionOnServerRepository {
    private final static Map<String, CustomHttpSession> sessions = new ConcurrentHashMap<>();
    private final static Timer timer = new Timer();


    public static CustomHttpSession getSession(String sessionID){
        return getSession(sessionID, true);
    }

    private static CustomHttpSession getSession(final String sessionID, boolean canCreate) {
        CustomHttpSession result = sessions.get(sessionID);
        if(result == null && canCreate){
            result = new CustomHttpSession();
            sessions.put(sessionID, result);

            TimerTask task = new TimerTask() {
                public void run()
                {
                    deleteSession(sessionID);
                    System.out.println("Сессия удалена по истечению " + CustomHttpSession.lifetime/1000 + " секунд");
                }
            };
            timer.schedule(task, CustomHttpSession.lifetime);
        }
        return result;
    }

    private static void deleteSession(String sessionID){
        sessions.remove(sessionID);
    }
}
