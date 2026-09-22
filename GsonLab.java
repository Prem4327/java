
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

//javac -cp "E:\Fillodemo\gson-2.10.1.jar" "E:\Fillodemo\GsonLab.java"
//java -cp "E:\Fillodemo;E:\Fillodemo\gson-2.10.1.jar" GsonLab

@@@sppremkumar0001