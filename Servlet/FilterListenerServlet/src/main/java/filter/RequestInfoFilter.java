package filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RequestInfoFilter extends BaseFilter {
    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /**  Возвращает имя метода HTTP, с которым с этой просьбой обратились */
        String method = servletRequest.getMethod();

        /**
         * Возвращает интернет-Протокол (IP) адрес клиента или последнего прокси,
         * который отправил запрос.Для сервлетов HTTP, то же самое как значение
         * переменной CGI REMOTE_ADDR.
         */
        String remoteAddr = servletRequest.getRemoteAddr();

        /** Возвращает строку запроса, которая содержится в запросе URL после пути. */
        String queryString = servletRequest.getQueryString();

        /** Возвращает имя и версию протокола */
        String protocol = servletRequest.getProtocol();

        System.out.println(">> RequestInfoFilter: method = " + method + ", remoteAddr = " + remoteAddr + ", queryString = " + queryString + ", protocol =  " + protocol);
        System.out.println();

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
