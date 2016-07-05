import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** HttpServlet предназначен для написания 
 * сервлетов по типу общения клиент­сервер,
 * а именно используя HTTP протокол.
 */
public class MainServlet extends HttpServlet {

    /**
     *
     * @param request  — это запрос, который пришел к сервлету;
     * @param response — это ответ который даст сервлет.Например, у этого него методы,
     *                    чтобы получить доступ к HTTP-заголовкам и cookie.
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /** Устанавливает тип контента ответа, отправляемого клиенту,
         * если ответ еще не фиксировался. Данный тип контента может
         * включать спецификацию кодировки символов */
        response.setContentType("text/html;charset=utf­8");

        /** Возвращает PrintWriter объект, который может отправить символьный текст клиенту. */
        PrintWriter out = response.getWriter();

        out.print("<h1>Hello bitch</h1>");

    }

}