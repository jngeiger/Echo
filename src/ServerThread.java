import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket clientSocket;
    public ServerThread(Socket clientSocket)
    {
        this.clientSocket = clientSocket;
    }
    public void run()
    {
        // Einlesen
        BufferedReader bis = null;
        try {
            bis = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Ausgeben
        PrintWriter osw = null;
        try {
            osw = new PrintWriter(clientSocket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Verarbeitungsvariablen
        String echo = "Echo: ";
        String input = "";

        // Echo Logik
        while (true)
        {
            try {
                if (!((input = bis.readLine()) != null)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            osw.println(echo + input);
        }
    }
}
