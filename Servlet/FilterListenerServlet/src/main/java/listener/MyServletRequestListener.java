package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * ���� Listener ������������, ��������������, ��� ����,
 * ���� "�������" ������ �������� � ����������� �������.
 */
public class MyServletRequestListener implements ServletRequestListener {

    /** ���������� ����� ������ ������������ */
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {}

    /** ���������� ����� ������ ���������������� */
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {}
}
