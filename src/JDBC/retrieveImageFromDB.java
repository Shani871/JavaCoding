package JDBC;

import java.sql.*;
import java.io.*;
public class retrieveImageFromDB {
    public static void main(String[] args) {
        try{ Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/anil","root","root");
            PreparedStatement ps=con.prepareStatement("SELECT * FROM emp");
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                Blob b=rs.getBlob(2);
                byte barr[]=b.getBytes(1,(int)b.length());
                FileOutputStream fout=new
                        FileOutputStream("C:\\Users\\shani\\IdeaProjects\\JavaCoding\\Photo\\DSC01790.png");
                fout.write(barr);
                fout.close();
            }
            System.out.println("Image Retrieved Successfully");
                    con.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
