package com.ui;

import com.util.dbUtil;


public class Main {
    public static void main(String[] args) {
        try{
            //Initialize database connection
            dbUtil.getConnection();
            
            // start the Application
            Menu menu = new Menu();
            menu.run();
        }finally{
            //Ensure databse connection is close
            dbUtil.closeConnection();
        }
    }
}
