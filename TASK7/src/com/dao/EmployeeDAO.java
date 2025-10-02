package com.dao;

import com.model.Employee;
import com.util.dbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class EmployeeDAO {
    private static Connection conn = null;
    private static PreparedStatement  ps = null;
    
    //Create - Add new Employee
    public boolean addEmployee(Employee employee) throws SQLException{
        String sql = "INSERT INTO EMPLOYEES(NAME, EMAIL, DEPARTMENT, SALARY, HIRE_DATE)"
                + "VALUES(?, ?, ?, ?, CURDATE())";
        try{
            conn = dbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getSalary());
            
            int rs = ps.executeUpdate();
            return rs > 0;
        }catch(SQLException e){
            System.out.println("Error adding employee: " + e.getMessage());
            return false;
        }
    }
    
    //Read - Get All employees
    public List<Employee> getAllEmployees() throws SQLException{
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM EMPLOYEES";
        
        try{
            conn = dbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Employee employee = new Employee();
                employee.setEmpId(rs.getInt("empid"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setDepartment(rs.getString("department"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setHireDate(rs.getDate("hire_date"));
                
                employees.add(employee);                
            }                
        }catch(SQLException e){
            System.out.println("Error retrieving employees: " + e.getMessage());
        }
        return employees;
    }
    
    //Update - Update Employee
    public boolean updateEmployee(Employee employee){
        String sql = "UPDATE EMPLOYEES SET NAME = ?, EMAIL = ?, DEPARTMENT = ?,"
                + "SALARY = ? WHERE EMPID = ?";
        try{
            conn = dbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getEmail());
            ps.setString(3, employee.getDepartment());
            ps.setDouble(4, employee.getSalary());
            ps.setInt(5, employee.getEmpId());
            
            int rs = ps.executeUpdate();
            return rs > 0;
        }catch(SQLException e){
            System.out.println("Error updating employee: " + e.getMessage());
            return false;
        }
    }
    
    //Delete - delete employee
    public boolean deleteEmployee(int empId){
        String sql = "DELETE FROM EMPLOYEES WHERE EMPID = ?";
        
        try{
            conn = dbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, empId);            
            int rs = ps.executeUpdate();
            return rs > 0;
        }catch(SQLException e){
            System.out.println("Error deleting employee: " + e.getMessage());
            return false;
        }
    }
    
    //Get Employee by ID
    public Employee getEmployeeById(int id){
        Employee employee = null;
        
        String sql = "SELECT * FROM EMPLOYEES WHERE EMPID = ?";
        try{
            conn = dbUtil.getConnection();
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, id);            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                employee = new Employee();
                employee.setEmpId(rs.getInt("empid"));
                employee.setName(rs.getString("name"));
                employee.setEmail(rs.getString("email"));
                employee.setDepartment(rs.getString("department"));
                employee.setSalary(rs.getDouble("salary"));
                employee.setHireDate(rs.getDate("hire_date"));
            }   
            rs.close();
        }catch(SQLException e){
            System.out.println("Error retrieving employee: " + e.getMessage());
        }        
        return employee;
    }
    
}
