package com.codedifferently;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DInsertDBExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/ROSTER";
    static final String USER = "root";
    static final String PASS = "tdd-cd";
    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            // Execute a query
            System.out.println("Inserting records into the table...");
            String sql = "INSERT INTO STUDENTS (first, last, age) VALUES ('Zara', 'Ali', 18)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO STUDENTS (first, last, age) VALUES ('Mahnaz', 'Fatma', 25)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO STUDENTS (first, last, age)  VALUES ('Zaid', 'Khan', 30)";
            stmt.executeUpdate(sql);
            sql = "INSERT INTO STUDENTS (first, last, age) VALUES( 'Sumit', 'Mittal', 28)";
            stmt.executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
