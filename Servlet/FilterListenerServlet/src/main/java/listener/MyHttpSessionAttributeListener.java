package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/** ���� Listener ������������ ��� "��������" ������� ������������ � ���������� � ������. */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {


    /** ���������� ����� ������� ����������� � ������ */
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {}

    /**  ���������� ����� ������� ��������� �� ������� */
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {}

    /**  ���������� ����� ������� ������ �������� */
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {}
}
