import java.net.*;

public class TCP{
    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);

        System.out.println("Waiting for client...");

        Socket socket = server.accept();

        System.out.println("Client connected");

        socket.close();
        server.close();
    }
}