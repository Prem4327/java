import java.io.*;

public class bytestream{
    public static void main(String[] args) throws IOException {

        FileOutputStream fout = new FileOutputStream("output.txt");

        System.out.println("Enter text:");

        int ch;

        while ((ch = System.in.read()) != '\n') {
            fout.write(ch);
        }

        fout.close();

        System.out.println("Data written to file successfully.");
    }
}