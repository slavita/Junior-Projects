package listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * ���� Listener ������������ ���������� ������ � ������,
 * ���� ������ ����� "�����������" ����� ���������� JVM
 * � ������������� �����������.
 */

public class MyHttpSessionActivationListener implements HttpSessionActivationListener {
    public MyHttpSessionActivationListener() {
        System.out.println(">> MyHttpSessionActivationListener - NEW");
    }

    /** ���������� ����� ���, ��� ������ ������ ��������� ����� ��������� */
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println(">> HttpSession - will passivate, id = " + httpSessionEvent.getSession().getId());
    }


    /** ���������� ����� ����, ��� ������ ����� �������� ����� �������� */
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println(">> HttpSession - did activate, id = " + httpSessionEvent.getSession().getId());
    }
}
