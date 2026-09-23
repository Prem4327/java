import java.security.MessageDigest;
import java.util.HexFormat;

public class HashingDemo {
    public static void main(String[] args) throws Exception {
        String data = "Hello World";
        
        // Get the "Grinder" (SHA-256)
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(data.getBytes());
        
        // Convert to readable Hex
        System.out.println("Hash: " + HexFormat.of().formatHex(hash));
        // Output: a591a6d40bf420404a011733cfb7b190d62c65bf0bcda32b57b277d9ad9f146e
        
        // Change one letter? The hash changes completely!
    }
}

