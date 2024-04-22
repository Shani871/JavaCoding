package JDBC;
import java.sql.*;

public class ConnectionJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/emp";
        String user = "root";
        String pswd = "root";
        try{
            // JDBC Driver : it is a collection of classes which implement interfaces defined in the JDBC.
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, pswd);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO empe1 VALUES (105, 'Sanjeev', 'Engineering CS')";
            stmt.executeUpdate(query);
            System.out.println("Data stored successfully in Database");
            // Close the connection and statement to release resources
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // print the exception stack trace for debugging
            throw new RuntimeException(e);
        }
    }
}
