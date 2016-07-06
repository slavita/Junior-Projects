package filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RequestInfoFilter extends BaseFilter {
    @Override
    public void doFilter(HttpServletRequest servletRequest, HttpServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /**  ¬озвращает им€ метода HTTP, с которым с этой просьбой обратились */
        String method = servletRequest.getMethod();

        /**
         * ¬озвращает интернет-ѕротокол (IP) адрес клиента или последнего прокси,
         * который отправил запрос.ƒл€ сервлетов HTTP, то же самое как значение
         * переменной CGI REMOTE_ADDR.
         */
        String remoteAddr = servletRequest.getRemoteAddr();

        /** ¬озвращает строку запроса, котора€ содержитс€ в запросе URL после пути. */
        String queryString = servletRequest.getQueryString();

        /** ¬озвращает им€ и версию протокола */
        String protocol = servletRequest.getProtocol();

        System.out.println(">> RequestInfoFilter: method = " + method + ", remoteAddr = " + remoteAddr + ", queryString = " + queryString + ", protocol =  " + protocol);
        System.out.println();

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
