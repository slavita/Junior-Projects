import com.sun.net.httpserver.HttpExchange;

/** Обработчик, который вызывается, чтобы обработать запросы HTTP. */
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class PageHttpHandler  implements HttpHandler{
    private final String htmlPage;

    public PageHttpHandler(String htmlPage) {
        this.htmlPage = htmlPage;
    }

    /** Обрабатывает данный запрос и генерирует соответствующий ответ. */
    @Override
    public void handle(HttpExchange exchange) throws IOException {

        /**
         *  Команда отправки заголовков. Должен вызываться перед следующим ходом.
         *  Первый аргумент статус страницы (200 - страница загружена,
         *  404 - не найдена, 302 - перемещена), второй - длина тела ответа,
         *  если 0, то выставляется заголовок "Transfer-Encoding: chunked",
         *  т.е. тело неопределенной длины.
         */
        exchange.sendResponseHeaders(200, htmlPage.length());

        /** Возвращает OutputStream для отправки тела ответа.*/
        OutputStream os = exchange.getResponseBody();

        /** Передаем байты */
        os.write(htmlPage.getBytes(StandardCharsets.US_ASCII));

        /**
         * Когда тело полностью отправлено клиенту, поток должен
         * быть закрыт(!) чтобы разорвать обмен данными.
         */
        os.close();
    }
}


/** {@link com.sun.net.httpserver.HttpExchange}
 1. getRequestMethod() для определения метода отправки
 2. getRequestHeaders() получить заголовки клиента (не перевод)
 3. getRequestBody() возвращает InputStream для чтения тела запроса.
    После чтения тела запроса, поток закрывается
 4. getResponseHeaders() получить и установить любые заголовки ответа,
    кроме content-length
 5. sendResponseHeaders(int,long) команда отправки заголовков.
    Должен вызываться перед следующим ходом. Первый аргумент
    статус страницы (200 - страница загружена, 404 - не найдена,
    302 - перемещена), второй - длина тела ответа, если 0, то
    выставляется заголовок "Transfer-Encoding: chunked", т.е.
    тело неопределенной длины.
 6. getResponseBody() возвращает OutputStream для отправки тела ответа.
    Когда тело полностью отправлено клиенту, поток должен быть закрыт(!)
    чтобы разорвать обмен данными.
 */