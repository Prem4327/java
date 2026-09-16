import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ReadStudentExcel {
    public static void main(String[] args) {
        Fillo fillo = new Fillo();
        
        // Change to "student.xls" if your file uses the older format
        String excelFilePath = "student1.xlsx"; 

        try {
            // Establishes a connection to the Excel file
            Connection connection = fillo.getConnection(excelFilePath);
            
            // "Sheet1" is the name of your Excel worksheet tab
            String query = "Select * From Sheet1"; 
            Recordset recordset = connection.executeQuery(query);
            
            System.out.println("--- Student Records ---");

            // Loop through the spreadsheet rows like a JDBC ResultSet
            while (recordset.next()) {
                // Change these strings to match your actual column header names exactly
                String id = recordset.getField("ID");
                String name = recordset.getField("Name");
                String course = recordset.getField("Course");
                
                System.out.println(id + "\t" + name + "\t" + course);
            }
            
            recordset.close();
            connection.close();
            
        } catch (Exception e) {
            System.err.println("Error reading Excel file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}