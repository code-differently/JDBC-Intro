package com.codedifferently;

import java.sql.*;

public class FUpdateDbExample {
    static final String DB_URL = "jdbc:mysql://localhost:3306/ROSTER";
    static final String USER = "root";
    static final String PASS = "tdd-cd";
    static final String QUERY = "SELECT id, first, last, age FROM STUDENTS";
    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "UPDATE STUDENTS " +
                    "SET age = 30 WHERE id in (1, 2)";
            stmt.executeUpdate(sql);
            ResultSet rs = stmt.executeQuery(QUERY);
            while(rs.next()){
                //Display values
                System.out.print("ID: " + rs.getInt("id"));
                System.out.print(", Age: " + rs.getInt("age"));
                System.out.print(", First: " + rs.getString("first"));
                System.out.println(", Last: " + rs.getString("last"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
