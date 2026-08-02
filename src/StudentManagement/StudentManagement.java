/*
Program 3:
    JDBC program to create a student database
*/

/*
CREATE TABLE student (
    regno INT PRIMARY KEY,
    name VARCHAR(25),
    address VARCHAR(50),
    class VARCHAR(10),
    course VARCHAR(10)
);
*/

package StudentManagement;

import java.sql.*;
import java.util.Scanner;

class Student {
    private Connection con;
    private Statement st;
    private Scanner sc = new Scanner(System.in);

    private void connectDB() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/src/StudentManagement/database/student",
                "root",
                "1234");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertStudent() {
        try {
            connectDB();

            System.out.print("Enter reg no: ");
            int regno = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter address: ");
            String address = sc.nextLine();

            System.out.print("Enter class: ");
            String clas = sc.nextLine();

            System.out.print("Enter course: ");
            String course = sc.nextLine();

            int rows = st.executeUpdate("INSERT INTO student VALUES (" +
                            regno + ", '" + name + "', '" + address + "', '" + clas + "', '" + course + "')");

            if (rows > 0)
                System.out.println("Student data inserted successfully!");
            else
                System.out.println("Student data not added.");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteStudent() {
        try {
            connectDB();

            System.out.print("Enter reg no: ");
            int regno = sc.nextInt();

            int rows = st.executeUpdate("DELETE FROM student WHERE regno =  " + regno);

            if (rows > 0)
            System.out.println("Student data deleted successfully!");
            else
            System.out.println("Student data not found.");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateAddress() {
        try {
            connectDB();

            System.out.println("Enter reg no: ");
            int regno = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter address: ");
            String address = sc.nextLine();

            int rows = st.executeUpdate("UPDATE student SET address = '" + address + "' " +
                            "WHERE regno = " + regno);

            if (rows > 0)
                System.out.println("Student address updated successfully!");
            else
                System.out.println("Student data not found.");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void searchStudent() {
        try {
            connectDB();

            System.out.print("Enter reg no: ");
            int regno = sc.nextInt();

            ResultSet rs = st.executeQuery("SELECT * FROM student WHERE regno = " + regno);

            if (!rs.next()) {
                System.out.println("Student data not found.");
                return;
            } else {
                System.out.println("REGNO\tNAME\tADDRESS\tCLASS\tCOURSE");
                System.out.println(
                    rs.getInt("regno") + "\t" +
                    rs.getString("name") + "\t" +
                    rs.getString("address") + "\t" +
                    rs.getString("class") + "\t" +
                    rs.getString("course")
                );
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student stu = new Student();
        int ch;

        System.out.println("---Menu---");
        System.out.println("1. Insert student");
        System.out.println("2. Delete student");
        System.out.println("3. Update address");
        System.out.println("4. Search student");
        System.out.println("5. Exit");

        do {
            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();
            System.out.println();

            switch (ch) {
                case 1:
                    stu.insertStudent();
                    break;

                case 2:
                    stu.deleteStudent();
                    break;

                case 3:
                    stu.updateAddress();
                    break;

                case 4:
                    stu.searchStudent();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Enter again.");
            }
        } while (ch != 5);

        sc.close();
    }
}
