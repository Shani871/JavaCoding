package JDBCPRa;

import java.sql.*;

public class Retrivedata {
    public static void main(String[] args) {
        String url = " jdbc:mysql://localhost:3306/emp";
        String user = "root";
        String passwords = "root";
         try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url,user,passwords);
            Statement sts = conn.createStatement();
            String queary = "select*from emp1";
             ResultSet rs = sts.executeQuery(queary);
             while (rs.next()){
                 System.out.println(rs.getInt(1)+" ");

             }
             conn.close();




         } catch (ClassNotFoundException | SQLException e) {
             throw new RuntimeException(e);
         }
    }
}
