package com.mycompany.employeemanagementsystem;

import java.sql.*;

public class Database {
    public static Connection connectDb() {
        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost/EmployeeManagmentSystem", "root", "");
            return connect;
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
} 
