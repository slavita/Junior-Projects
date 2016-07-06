package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * Этот Listener используется при "слушании" событий происходящих с атрибутами  запроса.
 */
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

    /** Вызывается когда атрибут добавляется в запрос */
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {}

    /**  Вызывается когда атрибут удаляется из запроса */
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {}

    /** Вызывается когда атрибут меняет значение */
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {}
}
