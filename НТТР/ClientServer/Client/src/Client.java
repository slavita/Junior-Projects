import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException{
        int serverPort = 80;

        InetAddress ipAddress = InetAddress.getByName("127.0.0.1");
        System.out.println("IP address : " + ipAddress.toString() + " port : " + serverPort);

        Socket socket = new Socket(ipAddress, serverPort);
        System.out.println("");

        InputStream sin = socket.getInputStream();
        OutputStream sout = socket.getOutputStream();

        DataInputStream in = new DataInputStream(sin);
        DataOutputStream out = new DataOutputStream(sout);

        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (true){
            line = keyboard.readLine();
            System.out.println("Отправка строки на сервер...");
            out.writeUTF(line);
            out.flush();
            line = in.readUTF();
            System.out.println("Сервер прислал это : " + line + '\n');
        }
    }
}
