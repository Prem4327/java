import java.net.*;
import java.io.*;

public class Clientsidehi{
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);

        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream())
        );

        String message = in.readLine();

        System.out.println("Received message: " + message);

        socket.close();
    }
}