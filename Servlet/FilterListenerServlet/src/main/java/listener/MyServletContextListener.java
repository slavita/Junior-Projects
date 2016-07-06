package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ���� Listener ��������� ������������ "�������" ������ ����� ServletContext
 * ���������������� ���� ������������. ��� ����� ������������, ��������,
 * ��� �������� ���������� � ����� ������ � ������ �������� ��������� �
 * �������� ���������� � ������ ����������� ���������.
 */
public class MyServletContextListener implements ServletContextListener {
    public MyServletContextListener() {
        System.out.println(">> MyServletContextListener - NEW");
    }

    /**  ���������� ����� ����� �������� ServletContext-a  */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(">> ServletContext created, contextPath = " + servletContextEvent.getServletContext().getContextPath());
    }

    /** ���������� ����� ��� ��� ServletContext ����� ��������� */
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(">> ServletContext destroyed");
    }
}
