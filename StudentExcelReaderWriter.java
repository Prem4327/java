import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class StudentExcelReaderWriter {

    public static void main(String[] args) {

        Fillo fillo = new Fillo();
        String excelFilePath = "student1.xlsx";

        try {
            // Establish connection to Excel file
            Connection connection = fillo.getConnection(excelFilePath);

            // ------------------------------------------------
            // 1. READ DATA
            // ------------------------------------------------
            System.out.println("--- Student Records Before Changes ---");

            String selectQuery = "SELECT * FROM Sheet1";
            Recordset recordset = connection.executeQuery(selectQuery);

            while (recordset.next()) {

                String id = recordset.getField("ID");
                String name = recordset.getField("Name");
                String course = recordset.getField("Course");

                System.out.println(id + "\t" + name + "\t" + course);
            }

            recordset.close();


            // ------------------------------------------------
            // 2. WRITE / INSERT NEW RECORD
            // ------------------------------------------------
            String insertQuery =
                    "INSERT INTO Sheet1 (ID, Name, Course) " +
                    "VALUES ('4', 'David', 'Java')";

            connection.executeUpdate(insertQuery);

            System.out.println("\nNew student record inserted successfully.");


            // ------------------------------------------------
            // 3. UPDATE EXISTING RECORD
            // ------------------------------------------------
            String updateQuery =
                    "UPDATE Sheet1 SET Course = 'Python' " +
                    "WHERE ID = '2'";

            connection.executeUpdate(updateQuery);

            System.out.println("Student record updated successfully.");


            // ------------------------------------------------
            // 4. READ DATA AGAIN
            // ------------------------------------------------
            System.out.println("\n--- Student Records After Changes ---");

            recordset = connection.executeQuery(selectQuery);

            while (recordset.next()) {

                String id = recordset.getField("ID");
                String name = recordset.getField("Name");
                String course = recordset.getField("Course");

                System.out.println(id + "\t" + name + "\t" + course);
            }

            recordset.close();

            // Close Excel connection
            connection.close();

        } catch (Exception e) {

            System.err.println("Error processing Excel file: "
                    + e.getMessage());

            e.printStackTrace();
        }
    }
}