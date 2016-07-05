import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException{
        /**
         * создаем сокет сервера и привязываем его к порту 80
         */
        ServerSocket serverSocket = new ServerSocket(80);

        while (true){
            System.out.println("ожидание TCP-соединения ...");

            /**
             * Эта функция погружает программу в ожидание того момента,
             * когда клиент будет присоединяться к сокету сервера. Как
             * только соединение установлено, функция возвратит объект
             * класса Socket для общения с клиентом.
             */
            Socket socket = serverSocket.accept();

            System.out.println("Получено первое сообщение!");
            try (InputStream in = socket.getInputStream();
                 OutputStream out = socket.getOutputStream()){
                // READ request
                byte[] request = readRequestFully(in);
                System.out.println("   --------------------");
                System.out.print(new String(request));
                System.out.println("   --------------------");
                //WRITE response
                byte[]  response = new Date().toString().getBytes();
                out.write(response);
            } finally {
                socket.close();
            }
        }
    }


    public static boolean isRequestEnd(byte[] request, int length){
        if(length < 4){
            return false;
        }
        return request[length - 4] == '\r' &&
                request[length - 3] == '\n' &&
                request[length - 2] == '\r' &&
                request[length - 1] == '\n';
    }

    public static byte[] readRequestFully(InputStream in) throws IOException {
        byte[] buff = new byte[8192];
        int headerLen = 0;
        while (true){
            int count = in.read(buff);
            if(count < 0){
                throw new RuntimeException("Входящий соединение закрыто или данных нет");
            } else {
                headerLen += count;
                if (isRequestEnd(buff, headerLen)) {
                    return Arrays.copyOfRange(buff, 0, headerLen);
                }
                if (headerLen == buff.length){
                    throw new RuntimeException("Слишком большой заголовок HTTP...");
                }
            }
        }
    }
}

