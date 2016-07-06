package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 *  Этот Listener используется для "слушания" событий,
 *  происходящих с атрибутами в сервлет контексте (ServletContext).
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener {

    /** Вызывается когда атрибут добавляется в ServletContext */
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {}

    /** Вызывается когда атрибут удаляется из ServletContext-a */
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {}

    /** Вызывается когда атрибут меняет значение */
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {}
}
