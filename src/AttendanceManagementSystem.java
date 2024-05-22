import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AttendanceManagementSystem {
    private final Map<String, Boolean> attendanceRecords;

    public AttendanceManagementSystem() {
        attendanceRecords = new HashMap<>();
    }

    public void markAttendance(String studentName) {
        attendanceRecords.put(studentName, true);
        System.out.println(studentName + "'s attendance has been marked.");
    }

    public void displayAttendance() {
        System.out.println("Attendance Records:");
        for (Map.Entry<String, Boolean> entry : attendanceRecords.entrySet()) {
            System.out.println(entry.getKey() + ": " + (entry.getValue() ? "Present" : "Absent"));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceManagementSystem attendanceSystem = new AttendanceManagementSystem();

        while (true) {
            System.out.println("\nAttendance Management System");
            System.out.println("1. Mark Attendance");
            System.out.println("2. Display Attendance");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student's name: ");
                    String studentName = scanner.next();
                    attendanceSystem.markAttendance(studentName);
                    break;
                case 2:
                    attendanceSystem.displayAttendance();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
