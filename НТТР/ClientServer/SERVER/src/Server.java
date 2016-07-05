import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException{
        int port = 80;

        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Ожидание подключения клиента ...");

        Socket socket = serverSocket.accept();

        System.out.println("Клиент подключился!");


        InputStream sin = socket.getInputStream();
        OutputStream sout = socket.getOutputStream();

        DataInputStream in = new DataInputStream(sin);
        DataOutputStream out = new DataOutputStream(sout);

        String line;
        while (true){
            line = in.readUTF();
            System.out.println("Клиент прислал  : " + line);
            System.out.println("Отсылаем строку назад.");
            out.writeUTF(line);
            out.flush();
            System.out.println("Ожидаем следущее сообщение ..." + '\n');
        }
    }
}
