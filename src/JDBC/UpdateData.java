package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateData {
    public static <shani, Anil> void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/emp";
        String user = "root";
        String passowrd = "root";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection coon = DriverManager.getConnection(url,user,passowrd);
            Statement stmt = coon.createStatement();
            String query = "update empe1 set name ='Anil Chauhan' where name ='shani Chauhan'";
            stmt.executeUpdate(query);
            System.out.println("Data Update");
            stmt.close();
            coon.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
