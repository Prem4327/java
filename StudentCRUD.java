import java.sql.*;
import java.util.Scanner;

public class StudentCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/studentsdb";
    static final String USER = "root";
    static final String PASSWORD = "";

    static Connection con;
    static Scanner sc = new Scanner(System.in);

    // Constructor - establish connection
    public StudentCRUD() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("Database connected successfully!");

        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }


    // ================= CREATE =================
    public void insertStudent() {

        try {

            System.out.print("Enter Registration Number: ");
            int regno = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Mobile Number: ");
            long mobile = sc.nextLong();
            sc.nextLine();

            System.out.print("Enter Mail ID: ");
            String mailid = sc.nextLine();

            String sql = "INSERT INTO admission " +
                         "(regno, name, mobile, mailid) " +
                         "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, regno);
            ps.setString(2, name);
            ps.setLong(3, mobile);
            ps.setString(4, mailid);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student inserted successfully!");
            }

            ps.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // ================= READ =================
    public void displayStudents() {

        try {

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM admission"
            );

            System.out.println("\n==============================================================");
            System.out.println("RegNo\tName\t\tMobile\t\tMail ID");
            System.out.println("==============================================================");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("regno") + "\t" +
                        rs.getString("name") + "\t\t" +
                        rs.getLong("mobile") + "\t\t" +
                        rs.getString("mailid")
                );
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // ================= UPDATE =================
    public void updateStudent() {

        try {

            System.out.print("Enter Registration Number to update: ");
            int regno = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Mobile Number: ");
            long mobile = sc.nextLong();
            sc.nextLine();

            System.out.print("Enter New Mail ID: ");
            String mailid = sc.nextLine();

            String sql = "UPDATE admission SET " +
                         "name=?, mobile=?, mailid=? " +
                         "WHERE regno=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setLong(2, mobile);
            ps.setString(3, mailid);
            ps.setInt(4, regno);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Registration number not found.");
            }

            ps.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // ================= DELETE =================
    public void deleteStudent() {

        try {

            System.out.print("Enter Registration Number to delete: ");
            int regno = sc.nextInt();

            String sql = "DELETE FROM admission WHERE regno=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, regno);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Registration number not found.");
            }

            ps.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}