package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * ���� Listener ��������� ������������ "�������"
 * ������ �������� � ����������� ������.
 */
public class MyHttpSessionListener implements HttpSessionListener {

    /** ���������� ����� ������ ��������� */
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {}

    /** ���������� ����� ������ ������������ */
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {}
}
