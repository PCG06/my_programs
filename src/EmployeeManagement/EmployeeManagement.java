/*
Program 5:
    JDBC program to create an employee database
*/

/*
CREATE TABLE employee (
    empid INT PRIMARY KEY,
    name VARCHAR(25),
    dept VARCHAR(15),
    salary DOUBLE
);
*/

package EmployeeManagement;

import java.sql.*;
import java.util.Scanner;

class Employee {
    private Connection con;
    private Statement st;
    private Scanner sc = new Scanner(System.in);

    private void connectDB() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/src/EmployeeManagement/database/employee",
                "root",
                "1234");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertEmployee() {
        try {
            connectDB();

            System.out.print("Enter emp id: ");
            int empid = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter employee name: ");
            String name = sc.nextLine();

            System.out.print("Enter department: ");
            String dept = sc.nextLine();

            System.out.print("Enter salary: ");
            double salary = sc.nextInt();

            int rows = st.executeUpdate("INSERT INTO employee VALUES (" +
                            empid + ", '" + name + "', '" + dept + "', " + salary + ")");

            if (rows > 0)
                System.out.println("Employee data inserted successfully!");
            else
                System.out.println("Employee data not added.");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteEmployee() {
        try {
            connectDB();

            System.out.print("Enter emp id: ");
            int empid = sc.nextInt();

            int rows = st.executeUpdate("DELETE FROM employee WHERE empid = " + empid);

            if (rows > 0)
                System.out.println("Employee data deleted successfully!");
            else
                System.out.println("Employee not found");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void viewReport() {
        try {
            connectDB();

            ResultSet rs = st.executeQuery("SELECT dept, COUNT(*) as total_emps, SUM(salary) AS total_salary " +
                                "FROM employee GROUP BY dept");

            if (!rs.next()) {
                System.out.println("No employees found.");
                return;
            }

            System.out.println("\n--------------------------------");
            System.out.println("DEPT\tEMPLOYEES\tTOTAL_SALARY");
            System.out.println("--------------------------------");

            do {
                System.out.println(
                    rs.getString("dept") + "\t" +
                    rs.getString("total_emps") + "\t" +
                    rs.getDouble("total_salary")
                );
            } while (rs.next());

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void increaseSalaries() {
        try {
            connectDB();

            System.out.print("Enter department: ");
            String dept = sc.nextLine();

            System.out.print("Enter increase salary amount: ");
            double salary = sc.nextDouble();

            System.out.println(dept);
            System.out.println(salary);

            int rows = st.executeUpdate("UPDATE employee SET salary = salary + " + salary + " WHERE dept = '" + dept + "'");

            if (rows > 0)
                System.out.println("Increased salary for " + rows + " employee(s)");
            else
                System.out.println("Department not found.");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Employee em = new Employee();
        int ch;

        System.out.println("---Menu---");
        System.out.println("1. Insert employee");
        System.out.println("2. Remove employee");
        System.out.println("3. View report");
        System.out.println("4. Update salaries");
        System.out.println("5. Exit");

        do {
            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();
            System.out.println();

            switch (ch) {
                case 1:
                    em.insertEmployee();
                    break;

                case 2:
                    em.deleteEmployee();
                    break;

                case 3:
                    em.viewReport();
                    break;

                case 4:
                    em.increaseSalaries();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Enter again.");
            }
        } while (ch != 5);
    }
}
