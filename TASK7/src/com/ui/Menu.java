package com.ui;

import com.service.EmployeeService;
import java.sql.SQLException;
import java.util.Scanner;


public class Menu {
    
    private EmployeeService employeeService;
    private Scanner scanner;
    private boolean running;
    
    public Menu(){
        this.employeeService = new EmployeeService();
        this.scanner = new Scanner(System.in);
        this.running = true;
    }
    
    public void displayMenu(){
        System.out.println("\n=== EMPLOYEE DATABASE MANAGEMENT SYSTEM ===");
        System.out.println("1. Add Employee");
        System.out.println("2. View All Employee");
        System.out.println("3. Update Employee");
        System.out.println("4. Delete Employee");
        System.out.println("5. Exit");
        System.out.print("Choose an option (1-5): ");            
    }
    
    public void handleOption(int option) throws SQLException{
        switch(option){
            case 1:
                employeeService.addEmloyee();
                break;
            case 2:
                employeeService.viewAllEmployees();
                break;
            case 3:
                employeeService.updateEmployee();
                break;
            case 4:
                employeeService.deleteEmployee();
                break;
            case 5:
                running = false;
                System.out.println("Thank you for using Employee Database System!");
                break;
            default:
                System.out.println("Invalid option! Please choose between 1-5.");    
        }
    }
    
    public void run() throws SQLException {
        System.out.println("Welcome to Employee Database System!");
        while(running){
            displayMenu();
            
            try{
                int option = Integer.parseInt(scanner.nextLine());
                handleOption(option);
            }catch(NumberFormatException e){
                System.out.println("Please enter a valid Number!");
            }
        }
        
        employeeService.closeScanner();
        scanner.close();
    }
    
}
