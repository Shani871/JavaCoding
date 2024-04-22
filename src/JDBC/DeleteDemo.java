package JDBC;

import java.sql.*;
public class DeleteDemo {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
            Connection con =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/emp",
                            "root", "root");
            if (con != null) {
                System.out.println("Connected");
                String query = "DELETE FROM empe1 WHERE userID=105";
                Statement stmt = con.createStatement();
                int rowsAffected = stmt.executeUpdate(query);
                if (rowsAffected > 0)
                    System.out.println(rowsAffected + " record(s) deleted successfully");
                else
                    System.out.println("Errror in deletion");
                con.close();
            } else
                System.out.println("Fail to connect DB");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Class does not exist");
        }
    }
}
