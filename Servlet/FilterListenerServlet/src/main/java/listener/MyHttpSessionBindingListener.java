package listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Этот Listener так-же используется для прослушивания событий происходящих с атрибутами
 * в сессии. Разница между HttpSessionAttributeListener и HttpSessionBindingListener:
 * HttpSessionAttributeListener: декларируется в web.xml (декларирование см ниже),
 * экземпляр класса создается автоматически (контейнером) в единственном числе  и
 * применяется ко всем сессиям HttpSessionBindingListener: экземпляр этого класса должен
 * быть создан и закреплён за определённой сессией программистом "вручную", количество
 * экземпляров регулируется программистом.
 */
public class MyHttpSessionBindingListener implements HttpSessionBindingListener {

    /** Вызывается когда объект добавляется в сессию */
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {}

    /**  Вызывается когда объект удаляется из сессии */
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {}
}
