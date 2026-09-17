import java.sql.*;

public class ReadStudents {
    public static void main(String[] args) {

        try {
Class.forName("com.mysql.cj.jdbc.Driver");
            // Connect to MySQL
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/studentsdb",
                "root",
                ""
            );

            // SQL query
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM admission");

            // Read and display data
            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " " +
                    rs.getString(2) + " " +
                    rs.getString(3)
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}