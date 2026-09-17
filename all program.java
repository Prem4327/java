public class TestStudentsCRUD {

    public static void main(String[] args) {

        StudentCRUD student = new StudentCRUD();

        int choice;

        do {
            System.out.println("\n===== STUDENT ADMISSION MENU =====");
            System.out.println("1. Insert Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = StudentCRUD.sc.nextInt();

            switch (choice) {

                case 1:
                    student.insertStudent();
                    break;

                case 2:
                    student.displayStudents();
                    break;

                case 3:
                    student.updateStudent();
                    break;

                case 4:
                    student.deleteStudent();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}
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
                URL, USER, PASSWORD
            );

            System.out.println("Database connected successfully!");

        } catch (Exception e) {
            System.out.println("Connection Error: " + e.getMessage());
        }
    }


    // CREATE
    public void insertStudent() {

        try {
            System.out.print("Enter Registration Number: ");
            int regno = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Mobile Number: ");
            int mobile = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Mail ID: ");
            String mailid = sc.nextLine();

            String sql = "INSERT INTO admission " +
                         "(regno, name, mobile, mailid) " +
                         "VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, regno);
            ps.setString(2, name);
            ps.setInt(3, mobile);
            ps.setString(4, mailid);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student inserted successfully!");

            ps.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // READ
    public void displayStudents() {

        try {
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(
                "SELECT * FROM admission"
            );

            System.out.println("\n==============================================");
            System.out.println("RegNo\tName\tMobile\t\tMail ID");
            System.out.println("==============================================");

            while (rs.next()) {

                System.out.println(
                    rs.getInt("regno") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getInt("mobile") + "\t\t" +
                    rs.getString("mailid")
                );
            }

            rs.close();
            stmt.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    // UPDATE
    public void updateStudent() {

        try {
            System.out.print("Enter Registration Number to update: ");
            int regno = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Mobile Number: ");
            int mobile = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter New Mail ID: ");
            String mailid = sc.nextLine();

            String sql = "UPDATE admission SET " +
                         "name=?, mobile=?, mailid=? " +
                         "WHERE regno=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, name);
            ps.setInt(2, mobile);
            ps.setString(3, mailid);
            ps.setInt(4, regno);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Student updated successfully!");
            else
                System.out.println("Registration number not found.");

            ps.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }