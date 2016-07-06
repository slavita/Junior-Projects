package listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * ���� Listener ���-�� ������������ ��� ������������� ������� ������������ � ����������
 * � ������. ������� ����� HttpSessionAttributeListener � HttpSessionBindingListener:
 * HttpSessionAttributeListener: ������������� � web.xml (�������������� �� ����),
 * ��������� ������ ��������� ������������� (�����������) � ������������ �����  �
 * ����������� �� ���� ������� HttpSessionBindingListener: ��������� ����� ������ ������
 * ���� ������ � �������� �� ����������� ������� ������������� "�������", ����������
 * ����������� ������������ �������������.
 */
public class MyHttpSessionBindingListener implements HttpSessionBindingListener {

    /** ���������� ����� ������ ����������� � ������ */
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {}

    /**  ���������� ����� ������ ��������� �� ������ */
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {}
}
