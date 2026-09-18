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