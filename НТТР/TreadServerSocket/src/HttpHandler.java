import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.Callable;
import com.sun.net.httpserver.HttpServer;

public class HttpHandler implements Callable<Void>{
    private final Socket socket;

    public HttpHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public Void call() throws Exception {
        try(InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream()){

            byte[] request = readRequestFully(in);
            System.out.println("   --------------------");
            System.out.println(new String(request, "ISO-8859-1"));
            System.out.println("   --------------------");

            byte[]  response = new Date().toString().getBytes();
            out.write(response);
        }
        return null;
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
        while (true) {
            int count = in.read(buff);
            if (count < 0) {
                throw new RuntimeException("Входящий соединение закрыто или данных нет");
            } else {
                headerLen += count;
                if (isRequestEnd(buff, headerLen)) {
                    return Arrays.copyOfRange(buff, 0, headerLen);
                }
                if (headerLen == buff.length) {
                    throw new RuntimeException("Слишком большой заголовок HTTP...");
                }
            }
        }
    }
}
