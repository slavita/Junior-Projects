package listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * Этот Listener используется атрибутами сессии в случае,
 * если сессия будет "мигрировать" между различными JVM
 * в распределённых приложениях.
 */

public class MyHttpSessionActivationListener implements HttpSessionActivationListener {
    public MyHttpSessionActivationListener() {
        System.out.println(">> MyHttpSessionActivationListener - NEW");
    }

    /** Вызывается перед тем, как сессия станет пассивной перед миграцией */
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println(">> HttpSession - will passivate, id = " + httpSessionEvent.getSession().getId());
    }


    /** Вызывается после того, как сессия стала активной после миграции */
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println(">> HttpSession - did activate, id = " + httpSessionEvent.getSession().getId());
    }
}
