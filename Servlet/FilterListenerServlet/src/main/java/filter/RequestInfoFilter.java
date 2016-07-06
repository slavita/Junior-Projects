package filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RequestInfoFilter extends BaseFilter {
    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /**  ���������� ��� ������ HTTP, � ������� � ���� �������� ���������� */
        String method = servletRequest.getMethod();

        /**
         * ���������� ��������-�������� (IP) ����� ������� ��� ���������� ������,
         * ������� �������� ������.��� ��������� HTTP, �� �� ����� ��� ��������
         * ���������� CGI REMOTE_ADDR.
         */
        String remoteAddr = servletRequest.getRemoteAddr();

        /** ���������� ������ �������, ������� ���������� � ������� URL ����� ����. */
        String queryString = servletRequest.getQueryString();

        /** ���������� ��� � ������ ��������� */
        String protocol = servletRequest.getProtocol();

        System.out.println(">> RequestInfoFilter: method = " + method + ", remoteAddr = " + remoteAddr + ", queryString = " + queryString + ", protocol =  " + protocol);
        System.out.println();

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
