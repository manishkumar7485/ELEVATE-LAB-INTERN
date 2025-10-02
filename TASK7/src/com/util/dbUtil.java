package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class dbUtil {
    private static Connection conn = null;

    public dbUtil() {
    }
    
    public static Connection getConnection(){
        try {
            if(conn == null){
                ResourceBundle rb = ResourceBundle.getBundle("application");
                String connString = rb.getString("db.connectionString");
//                String driverName = rb.getString("db.driverName");
                String userName = rb.getString("db.username");
                String password = rb.getString("db.password");
                try{
                    Class.forName(rb.getString("db.driverName"));
                }catch(ClassNotFoundException cnf){
                    System.out.println("Mysql Driver not found: " + cnf.getMessage());
                    cnf.printStackTrace();
                }
                conn = DriverManager.getConnection(connString, userName, password);
                System.out.println("Connection Opened Sucessfully.");
            }
        } catch (SQLException ex) {
                System.out.println("Connection failed: " + ex.getMessage());
        }
        return conn;
    }
    
    //Close Connection    
    
    public static void closeConnection(){
	try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                conn = null;
                System.out.println("Database Connection closed. ");
            }
	} catch (SQLException e) {
            System.out.println("Error closing connection: " + e.getMessage());
	    e.printStackTrace();
	}
    }    
}
