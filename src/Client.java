import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        // Netzwerk
        Socket client = new Socket("localhost",9999);

        // SCHREIBEN
        PrintWriter out = new PrintWriter(client.getOutputStream(),true);

        // LESEN
        BufferedReader bfr = new BufferedReader(new InputStreamReader(client.getInputStream()));

        // Lesen von Konsole
        InputStreamReader stdin = new InputStreamReader(System.in);
        BufferedReader stdinreader = new BufferedReader(stdin);

        String value = "";
        while ((value = stdinreader.readLine()) != null)
        {
            out.println(value);
            System.out.println(bfr.readLine());
        }


    }
}
