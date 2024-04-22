package JDBC;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImageStore {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/anil";
        String user = "root";
        String pswd = "root";
        String imagePath = "C:\\Users\\shani\\IdeaProjects\\JavaCoding\\DSC01790.png";

        try (Connection conn = DriverManager.getConnection(url, user, pswd)) {
            // Read image file
            try (FileInputStream fis = new FileInputStream(imagePath)) {
                String query = "INSERT INTO emp VALUES (?, ?, ?, ?)";
                PreparedStatement prs = conn.prepareStatement(query);
                // Set values
                prs.setInt(1, 101); // Assuming the first column is an integer
                prs.setString(2, "shani");
                prs.setInt(3, 10125); // Assuming the third column is an integer
                prs.setBinaryStream(4, fis, (int) imagePath.length());

                // Execute update
                int rowsAffected = prs.executeUpdate();
                if (rowsAffected > 0) {
                    System.out.println("Image inserted successfully.");
                } else {
                    System.out.println("Failed to insert image.");
                }
                prs.close();
            } catch (FileNotFoundException e) {
                System.err.println("Image file not found: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("Error reading image file: " + e.getMessage());
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
