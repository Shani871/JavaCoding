package JDBC;

import java.sql.*;

public class ShowDatabase {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/emp";
        String user = "root";
        String pswd = "root";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,pswd);
            Statement stmst = conn.createStatement();
            String query = " select*from empe1";
            ResultSet rst = stmst.executeQuery(query);
            while (rst.next()){
                System.out.println(rst.getInt(1)+" "+ rst.getString(2)+" "+ rst.getString(3));
            }
            stmst.close();
            conn.close();

        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
