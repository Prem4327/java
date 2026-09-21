
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

// Simple POJO matching JSON structure
class Student {
    int id;
    String name;
    String course;
    
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Course: " + course;
    }
}

public class GsonLab {
    public static void main(String[] args) {
        String json = "[" +
                "{\"id\": 1, \"name\": \"Alice\", \"course\": \"Java\"}," +
                "{\"id\": 2, \"name\": \"Bob\", \"course\": \"Python\"}" +
                "]";

        Gson gson = new Gson();

        // 1. Parse JSON Array to List of Objects
        Type studentListType = new TypeToken<List<Student>>() {}.getType();
        List<Student> students = gson.fromJson(json, studentListType);

        System.out.println("--- Parsed Students ---");
        for (Student s : students) {
            System.out.println(s);
        }

        // 2. Convert Java Object back to JSON
        Student newStudent = new Student();
        newStudent.id = 3;
        newStudent.name = "Charlie";
        newStudent.course = "Data Science";

        String outputJson = gson.toJson(newStudent);
        System.out.println("\n--- Generated JSON ---");
        System.out.println(outputJson);
    }
}
Steps to Run the Gson Example
Unlike StAX, Gson is not built into Java.  You must manually download the library and include it in your classpath. 
1. Download the Gson JAR
Go to the Maven Repository or Google's release page.
Download the latest version (e.g., gson-2.10.1.jar).
Save this file in the same folder as your Java code (GsonLab.java). 
2. Compile the Program
You must tell the compiler where to find the Gson classes using the -cp (classpath) flag. 
Windows:
javac -cp ".;gson-2.10.1.jar" GsonLab.java
(Note: Use ; to separate the current directory . from the jar file) 
Mac/Linux:
javac -cp ".:gson-2.10.1.jar" GsonLab.java
(Note: Use : to separate the current directory . from the jar file) 
3. Run the Program
You must include the JAR in the classpath again when running the application. 
Windows:
java -cp ".;gson-2.10.1.jar" GsonLab
Mac/Linux:
java -cp ".:gson-2.10.1.jar" GsonLab
Expected Output:
--- Parsed Students ---
ID: 1, Name: Alice, Course: Java
ID: 2, Name: Bob, Course: Python


--- Generated JSON ---
{"id":3,"name":"Charlie","course":"Data Science"}