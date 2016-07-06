package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Этот Listener позволяет разроботчику "уловить"
 * момент создания и уничтожения сессии.
 */
public class MyHttpSessionListener implements HttpSessionListener {

    /** Вызывается когда сессия создается */
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {}

    /** Вызывается когда сессия уничтодается */
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {}
}
