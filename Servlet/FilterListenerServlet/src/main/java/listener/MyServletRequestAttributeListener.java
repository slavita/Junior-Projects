package listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

/**
 * ���� Listener ������������ ��� "��������" ������� ������������ � ����������  �������.
 */
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {

    /** ���������� ����� ������� ����������� � ������ */
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {}

    /**  ���������� ����� ������� ��������� �� ������� */
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {}

    /** ���������� ����� ������� ������ �������� */
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {}
}
