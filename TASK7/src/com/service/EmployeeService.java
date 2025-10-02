package com.service;

import com.dao.EmployeeDAO;
import com.model.Employee;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class EmployeeService {
    
    private EmployeeDAO empDAO;
    private Scanner scanner;

    public EmployeeService() {
        this.empDAO = new EmployeeDAO();
        this.scanner = new Scanner(System.in);
    }
    
    public void addEmloyee() throws SQLException{
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter Department: ");        
        String department = scanner.nextLine();
        
        System.out.print("Enter Salary: ");
        Double salary = scanner.nextDouble();
        
        scanner.nextLine(); // consume nextLine
        
        Employee employee = new Employee(name, email, department, salary);
        
        if(empDAO.addEmployee(employee)){
            System.out.println("Employee added successfully!");
        }else{
            System.out.println("Failed to add employee.");
        }
    }
    
    public void viewAllEmployees() throws SQLException{
        List<Employee> employees = empDAO.getAllEmployees();
        
        System.out.println("\n === Employee List ===");
        System.out.printf("%-10S %-20s %-30s %-15s %-20s %-12s\n", 
            "EMPID", "NAME", "EMAIL", "DEPARTMENT", "SALARY", "HIRE DATE");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
    
        if(employees.isEmpty()){
            System.out.println("No employee found.");
        }else{
            for(Employee emp : employees){
            System.out.printf("%-10s %-20s %-30s %-15s %-20s %-12s\n",
            emp.getEmpId(),
            emp.getName(),
            emp.getEmail(),
            emp.getDepartment(),
            emp.getSalary(),
            emp.getHireDate());
    }
        }
    }
    
    
    public void updateEmployee() throws SQLException{
        viewAllEmployees();
        System.out.print("\nEnter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // consume nextLine
        
        Employee existEmp = empDAO.getEmployeeById(id);
        if(existEmp == null){
            System.out.println("No employee found with ID: "+id);
            return;
        }
        
        System.out.print("Enter new Name (" + existEmp.getName() + "): ");
        String name = scanner.nextLine();
        
        System.out.print("Enter new Name (" + existEmp.getEmail() + "): ");
        String email = scanner.nextLine();
        
        System.out.print("Enter new Name (" + existEmp.getDepartment() + "): ");
        String department = scanner.nextLine();
        
        System.out.print("Enter new Name (" + existEmp.getSalary() + "): ");
        Double salary = scanner.nextDouble();
        
        scanner.nextLine(); // consume nextLine
        
        //Use existing values if input is empty
        Employee updateEmp = new Employee(
            name.isEmpty() ? existEmp.getName() : name,
            email.isEmpty() ? existEmp.getEmail() : email,
            department.isEmpty() ? existEmp.getDepartment() : department,
            salary
        ); 
        
        updateEmp.setEmpId(id);
        
        if(empDAO.updateEmployee(updateEmp)){
            System.out.println("Employee update sucessfully!");
        }else{
            System.out.println("Failed to update employee.");
        }        
    }
    
    
    public void deleteEmployee() throws SQLException{
        viewAllEmployees();
        System.out.print("\nEnter employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        Employee emp = empDAO.getEmployeeById(id);
        if(emp == null){
        System.out.println("No employee found with ID: " + id);
            return;
        }
        
        System.out.println("Are you sure you want to delete: " + emp.getName() +"? (y/n)");
        String confirm = scanner.nextLine();
        
        if(confirm.equalsIgnoreCase("y")){
            if(empDAO.deleteEmployee(id)){
                System.out.println("Employee deleted successfully!");
            }else{
                System.out.println("Failed to delete employee");
            }
        }else{
            System.out.println("Deletion failed.");
        }            
    } 
    
    
    public void closeScanner() {
        scanner.close();
    }
    
}
