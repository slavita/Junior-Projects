package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Этот Listener используется, соответственно, для того,
 * чтоб "уловить" момент создания и уничтожения запроса.
 */
public class MyServletRequestListener implements ServletRequestListener {

    /** Вызывается когда запрос уничтожается */
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {}

    /** Вызывается когда запрос инициализируется */
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {}
}
