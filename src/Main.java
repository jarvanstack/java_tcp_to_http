
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @author Jarvan
 * @version 1.0
 * @create 2021/6/5 17:20
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9000);
        while (true) {
            Socket socket = serverSocket.accept();
            OutputStream outputStream = socket.getOutputStream();
            StringBuilder respBuf = new StringBuilder();
            respBuf.append("HTTP/1.1 200 OK\n");
            respBuf.append("Content-Length: 2\n");
            respBuf.append("Content-Type:text/html:charset=UTF-8\n\n");
            respBuf.append("OK");
            outputStream.write(respBuf.toString().getBytes());
            outputStream.flush();
            outputStream.close();
            socket.close();
        }
    }
}
