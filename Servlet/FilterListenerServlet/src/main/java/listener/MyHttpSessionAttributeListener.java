package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/** Этот Listener используется для "слушания" событий происходящих с атрибутами в сессии. */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {


    /** Вызывается когда атрибут добавляется в сессию */
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {}

    /**  Вызывается когда атрибут удаляется из запроса */
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {}

    /**  Вызывается когда атрибут меняет значение */
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {}
}
