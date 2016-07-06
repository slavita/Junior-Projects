package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Этот Listener позволяет разработчику "уловить" момент когда ServletContext
 * инициализируется либо уничтожается. Его можно использовать, например,
 * для открытия соединения с базой данных в момент создания контекста и
 * закрытия соединения в момент уничтожения контекста.
 */
public class MyServletContextListener implements ServletContextListener {
    public MyServletContextListener() {
        System.out.println(">> MyServletContextListener - NEW");
    }

    /**  Вызывается сразу после создания ServletContext-a  */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(">> ServletContext created, contextPath = " + servletContextEvent.getServletContext().getContextPath());
    }

    /** Вызывается перед тем как ServletContext будет уничтожен */
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(">> ServletContext destroyed");
    }
}
