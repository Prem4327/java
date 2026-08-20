import java.net.*;
import java.io.*;

public class Serversidehi{
    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);

        System.out.println("Waiting for client...");

        Socket socket = server.accept();

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

        out.println("Hi");

        System.out.println("Hi sent to client");

        socket.close();
        server.close();
    }
}