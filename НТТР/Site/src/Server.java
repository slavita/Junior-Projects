import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) throws IOException {
        final int backlog = 64;
        final InetSocketAddress socketAddress = new InetSocketAddress(80);

        /**
         * Поставщик услуг class для HttpServer. Подклассы HttpServerProvider
         * обеспечивают реализацию HttpServer и связанные классы.
         * @provider() - Первый вызов этого метода определяет местоположение
         * объекта провайдера значения по умолчанию
         */
        HttpServerProvider provider = HttpServerProvider.provider();

        /** создает HttpsServer из этого провайдера(backlog - отставание сокета) */
        HttpServer server = provider.createHttpServer(socketAddress,backlog);

        /**
         * Ставит обработчик на данный URL.
         * Создает HttpContext, первоначально не определяя обработчик.
         * Обработчик должен позже быть определен, используя
         * HttpContext.setHandler(HttpHandler). HttpContext представляет
         * отображение с пути URI на обработчик обмена на этом HttpServer.
         * После того, как создаваемый, и когда обработчик был установлен,
         * все запросы, полученные сервером для пути, будут обработаны,
         * вызывая объект-обработчик
         */
        HttpContext baseContext = server.createContext("/");
        baseContext.setHandler(new PageHttpHandler("" +
        "<html>\n" +
        "    <body>\n" +
        "      <p><a href=\"/a.do\">a.do</a></p>\n" +
        "      <p><a href=\"/b.do\">b.do</a></p>\n" +
        "    <body>\n" +
        "<html>"
        ));

        HttpContext aContext = server.createContext("/a.do");
        aContext.setHandler(new PageHttpHandler("" +
        "<html>\n" +
        "    <body>\n" +
        "      <p><a href=\"/b.do\">b.do</a></p>\n" +
        "    <body>\n" +
        "<html>"
        ));

        HttpContext bContext = server.createContext("/b.do");
        bContext.setHandler(new PageHttpHandler("" +
        "<html>\n" +
        "    <body>\n" +
        "      <p><a href=\"/a.do\">a.do</a></p>\n" +
        "    <body>\n" +
        "<html>"
        ));


        /** Запускает этот сервер в новом фоновом потоке */
        server.start();

    }
}
