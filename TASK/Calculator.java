package TASK;

import java.util.Scanner;

public class Calculator {

    // Method for addition
    public static double add(double num1, double num2) {
        return num1 + num2;
    }

    // Method for subtraction
    public static double subtract(double num1, double num2) {
        return num1 - num2;
    }

    // Method for multiplication
    public static double multiply(double num1, double num2) {
        return num1 * num2;
    }

    // Method for division with zero check
    public static double divide(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Error: Division by zero is not allowed!");
        }
        return num1 / num2;
    }

    // Method to display menu
    public static void displayMenu() {
        System.out.println("\n=== Java Console Calculator ===");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        System.out.println("5. Exit");
        System.out.print("Choose an operation (1-5): ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to Java Console Calculator!");

        while (running) {
            displayMenu();

            try {
                int choice = scanner.nextInt();

                if (choice == 5) {
                    running = false;
                    System.out.println("Thank you for using the calculator. Goodbye!");
                    continue;
                }

                if (choice < 1 || choice > 5) {
                    System.out.println("Invalid choice! Please select 1-5.");
                    continue;
                }

                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                double result = 0;
                String operation = "";

                switch (choice) {
                    case 1:
                        result = add(num1, num2);
                        operation = "+";
                        break;
                    case 2:
                        result = subtract(num1, num2);
                        operation = "-";
                        break;
                    case 3:
                        result = multiply(num1, num2);
                        operation = "*";
                        break;
                    case 4:
                        result = divide(num1, num2);
                        operation = "/";
                        break;
                }

                System.out.printf("Result: %.2f %s %.2f = %.2f%n", num1, operation, num2, result);

            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only.");
                scanner.nextLine(); // Clear the invalid input
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }
}