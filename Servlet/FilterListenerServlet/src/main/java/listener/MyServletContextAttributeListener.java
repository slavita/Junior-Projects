package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 *  ���� Listener ������������ ��� "��������" �������,
 *  ������������ � ���������� � ������� ��������� (ServletContext).
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener {

    /** ���������� ����� ������� ����������� � ServletContext */
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {}

    /** ���������� ����� ������� ��������� �� ServletContext-a */
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {}

    /** ���������� ����� ������� ������ �������� */
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {}
}
