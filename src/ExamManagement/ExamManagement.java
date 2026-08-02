/*
Program 4:
    JDBC program to create an exam database and calculate result
*/

/*
CREATE TABLE student (
    regno INT PRIMARY KEY,
    name VARCHAR(25),
    class VARCHAR(10),
    course VARCHAR(10)
);

CREATE TABLE exam (
    regno INT,
    sub1 INT,
    sub2 INT,
    sub3 INT,
    total INT,
    perc DOUBLE,
    result VARCHAR(12)
);
*/

package ExamManagement;

import java.sql.*;
import java.util.Scanner;


class Exam {
    private Connection con;
    private Statement st;
    private Scanner sc = new Scanner(System.in);

    private void connectDB() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/src/ExamManagement/database/exam",
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

            System.out.print("Enter class: ");
            String clas = sc.nextLine();

            System.out.print("Enter course: ");
            String course = sc.nextLine();

            int rows = st.executeUpdate("INSERT INTO student VALUES ( " +
                            regno + ", '" + name + "', '" + clas + "', '" + course + "')");

            if (rows > 0)
                System.out.println("Student data entered successfully!");
            else
                System.out.println("Student data not entered");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertAndCalcMarks() {
        try {
            connectDB();

            System.out.print("Enter reg no: ");
            int regno = sc.nextInt();

            System.out.print("Enter marks in 3 subjects: ");
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int m3 = sc.nextInt();

            int total = m1 + m2 + m3;
            double perc = total / 3d;
            String result;

            if (m1 < 35 || m2 < 35 || m3 < 35)
            {
                result = "Fail";
            } else {
                if (perc > 80)
                    result = "Distinction";
                else if (perc > 70)
                    result = "First class";
                else if (perc > 60)
                    result = "Second class";
                else
                    result = "Pass class";
            }

            int rows = st.executeUpdate("INSERT INTO exam VALUES ( " +
                            regno + ", " + m1 + ", " + m2 + ", " + m3 + ", " + total + ", " + perc + ", '" + result + "')");

            if (rows > 0)
                System.out.println("Marks data inserted successfully!");
            else
                System.out.println("Marks not added.");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayStudent() {
        try {
            connectDB();

            System.out.print("Enter reg no: ");
            int regno = sc.nextInt();

            ResultSet rs = st.executeQuery("SELECT s.*, e.sub1, e.sub2, e.sub3, e.total, e.perc, e.result FROM " +
                                "student s INNER JOIN exam e ON s.regno = e.regno AND s.regno = " + regno);

            if (!rs.next()) {
                System.out.println("Student data not found.");
                return;
            }

            System.out.println("REGNO\tNAME\tCLASS\tCOURSE\tSUB1\tSUB2\tSUB3\tTOTAL\tPERC\tRESULT");
            System.out.println(
                rs.getInt("regno") + "\t" +
                rs.getString("name") + "\t" +
                rs.getString("class") + "\t" +
                rs.getString("course") + "\t" +
                rs.getInt("sub1") + "\t" +
                rs.getInt("sub2") + "\t" +
                rs.getInt("sub3") + "\t" +
                rs.getInt("total") + "\t" +
                rs.getDouble("perc") + "\t" +
                rs.getString("result") + "\t"
            );

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class ExamManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Exam ex = new Exam();
        int ch;

        System.out.println("---Menu---");
        System.out.println("1. Insert student");
        System.out.println("2. Insert marks");
        System.out.println("3. Display student");
        System.out.println("4. Exit");

        do {
            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();
            System.out.println();

            switch (ch) {
                case 1:
                    ex.insertStudent();
                    break;

                case 2:
                    ex.insertAndCalcMarks();
                    break;

                case 3:
                    ex.displayStudent();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Enter again.");
            }
        } while (ch != 4);

        sc.close();
    }
}
