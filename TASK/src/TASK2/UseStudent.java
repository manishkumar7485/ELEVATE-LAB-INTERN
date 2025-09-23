package TASK2;

import java.util.Scanner;

public class UseStudent {
    // private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // StudentImplement s = new StudentImplement();

            switch (choice) {
                case 1:
                    StudentImplement.addStudent();
                    break;
                case 2:
                    StudentImplement.viewStudents();
                    break;
                case 3:
                    StudentImplement.updateStudent();
                    break;
                case 4:
                    StudentImplement.deleteStudent();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1-5.");
            }
        }

        scanner.close();
    }

}
