import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception
    {
        // Netzwerksachen
        ServerSocket srvSocket = new ServerSocket(9999);


        while (true) {
            Socket clientSocket = srvSocket.accept();
            ServerThread st = new ServerThread(clientSocket);
            st.start();
        }


    }
}
