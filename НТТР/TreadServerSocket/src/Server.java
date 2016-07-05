/**
 * Обработчик, который вызывается, чтобы обработать запросы HTTP.
 * void handle(HttpExchange exchange)
 * Обрабатывает данный запрос и генерирует соответствующий ответ.
 * Контейнер вызывает этот метод, когда это получает входящий запрос.
 */


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;


public class Server{
    public static void main(String[] args) throws IOException {

        ExecutorService threadPool = new ThreadPoolExecutor
                (
                        4, 64,
                        60L, TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(256)
                );
        ServerSocket serverSocket = new ServerSocket(81, 256);

        while (true) {
            final Socket socket = serverSocket.accept();
            threadPool.submit(new HttpHandler(socket));
        }

    }

}

