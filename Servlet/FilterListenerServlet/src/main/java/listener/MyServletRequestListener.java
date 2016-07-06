package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Ётот Listener используетс€, соответственно, дл€ того,
 * чтоб "уловить" момент создани€ и уничтожени€ запроса.
 */
public class MyServletRequestListener implements ServletRequestListener {

    /** ¬ызываетс€ когда запрос уничтожаетс€ */
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {}

    /** ¬ызываетс€ когда запрос инициализируетс€ */
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {}
}
