package task2;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentImplement {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    // Method for addStudent
    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        // Check if ID already exists
        for (Student s : students) {
            if (s.getId() == id) {
                System.out.println("⚠️ Student with ID " + id + " already exists!");
                return; // stop execution
            }
        }
        sc.nextLine(); // consume newline
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    // View all students
    public static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No records found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    // Update student details
    public static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : students) {
            if (s.getId() == id) {
                sc.nextLine();
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();
                s.setName(name);
                s.setMarks(marks);
                System.out.println("Record updated!");
                found = true;
                break;
            }
        }
        if (!found)
            System.out.println("Student not found!");
    }

    // Delete student
    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();
        boolean removed = students.removeIf(s -> s.getId() == id);
        if (removed) {
            System.out.println("Student deleted!");
        } else {
            System.out.println("Student not found!");
        }

    }

}
