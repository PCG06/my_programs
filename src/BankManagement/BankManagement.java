/*
Program 2:
    JDBC program to create a bank database with customer and transaction tables
*/

/*
CREATE TABLE customer (
    accno INT PRIMARY KEY,
    name VARCHAR(25),
    acctype VARCHAR(5),
    balance DOUBLE
);

CREATE TABLE transactions (
    accno INT,
    trans_date DATE,
    trans_type VARCHAR(10),
    particulars VARCHAR(25),
    trans_amt DOUBLE
);
*/

package BankManagement;

import java.sql.*;
import java.util.Scanner;

class BankManagement {
    private static Connection con;
    private static Statement st;
    private static Scanner sc = new Scanner(System.in);

    private static void connectDB() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/src/BankManagement/database/bank",
                "root",
                "1234");
            st = con.createStatement();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deposit() {
        try {
            connectDB();

            System.out.print("Enter acc no: ");
            int acc = sc.nextInt();

            System.out.print("Enter amount: ");
            double amt = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter particulars: ");
            String part = sc.nextLine();

            int rows = st.executeUpdate(
                "UPDATE customer SET balance = balance + " + amt +
                " WHERE accno = " + acc
            );

            if (rows > 0) {
                st.executeUpdate(
                    "INSERT INTO transactions VALUES " +
                    "(" + acc + ", CURRENT_DATE, 'deposit ', '" + part + "', " + amt + ")"
                );

                System.out.println("Amount deposited into account!");
            } else {
                System.out.println("Account not found.");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void withdraw() {
        try {
            connectDB();

            System.out.print("Enter acc no: ");
            int acc = sc.nextInt();

            System.out.print("Enter amount: ");
            double amt = sc.nextDouble();
            sc.nextLine();

            System.out.print("Enter particulars: ");
            String part = sc.nextLine();

            ResultSet rs = st.executeQuery(
                "SELECT balance FROM customer WHERE accno = " + acc
            );

            if (!rs.next()) {
                System.out.println("Account not found.");
                return;
            }

            double bal = rs.getDouble("balance");

            if (amt > bal) {
                System.out.println("Not enough balance!");
                return;
            }

            if (amt > bal - 1000) {
                System.out.println("Maintain minimum balance!");
                return;
            }

            int rows = st.executeUpdate(
                "UPDATE customer SET balance = balance - " + amt +
                " WHERE accno = " + acc);

            if (rows > 0) {
                st.executeUpdate(
                    "INSERT INTO transactions VALUES" +
                    "(" + acc + ", CURRENT_DATE, 'withdraw', '" + part + "', " + amt + ")"
                );

                System.out.println("Amount withdrawn from account!");
            } else {
                System.out.println("Account not found.");
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void report() {
        System.out.println("---Report---");
        System.out.println("1. Daily report");
        System.out.println("2. Periodical report");

        System.out.print("\nEnter your choice: ");
        int ch = sc.nextInt();
        System.out.println();

        switch (ch) {
            case 1:
                dailyReport();
                break;
            case 2:
                periodicalReport();
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void dailyReport() {
        try {
            connectDB();

            System.out.print("Enter acc no: ");
            int acc = sc.nextInt();

            ResultSet cust = st.executeQuery(
                "SELECT * FROM customer WHERE accno = " + acc
            );

            if (!cust.next()) {
                System.out.println("Account not found.");
                return;
            }

            System.out.println();
            System.out.println("\n--------------------------------------");
            System.out.println("ACC_NO\tNAME\tACC_TYPE\tBALANCE");
            System.out.println("--------------------------------------");
            System.out.println(
                cust.getInt("accno") + "\t" +
                cust.getString("name") + "\t" +
                cust.getString("acctype") + "\t" +
                cust.getDouble("balance")
            );

            ResultSet trans = st.executeQuery(
                "SELECT * FROM transactions WHERE " +
                " accno = " + acc + " AND trans_date = CURRENT_DATE"
            );

            if (!trans.next()) {
                System.out.println("Transactions not found.");
                return;
            }

            System.out.println("\n---------------------------------------------------------------");
            System.out.println("ACCNO\tTRANS_DATE\tTRANS_TYPE\tPARTICULARS\tTRANS_AMT");
            System.out.println("---------------------------------------------------------------");
            do {
                System.out.println(
                    trans.getInt("accno") + "\t" +
                    trans.getDate("trans_date") + "\t" +
                    trans.getString("trans_type") + "\t" +
                    trans.getString("particulars") + "\t" +
                    trans.getDouble("trans_amt")
                );
            } while (trans.next());

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void periodicalReport()  {
        try {
            connectDB();

            System.out.print("Enter from date (YYYY-MM-DD): ");
            sc.nextLine();
            String from = sc.nextLine();

            System.out.print("Enter to date (YYYY-MM-DD): ");
            String to = sc.nextLine();

            ResultSet trans = st.executeQuery(
                "SELECT * FROM transactions WHERE " +
                "trans_date BETWEEN '" + from + "' AND '" + to + "'"
            );

            if (!trans.next()) {
                System.out.println("Transactions not found.");
                return;
            }

            System.out.println("\n---------------------------------------------------------------");
            System.out.println("ACCNO\tTRANS_DATE\tTRANS_TYPE\tPARTICULARS\tTRANS_AMT");
            System.out.println("---------------------------------------------------------------");
            do {
                System.out.println(
                    trans.getInt("accno") + "\t" +
                    trans.getDate("trans_date") + "\t" +
                    trans.getString("trans_type") + "\t" +
                    trans.getString("particulars") + "\t" +
                    trans.getDouble("trans_amt")
                );
            } while (trans.next());

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        int ch;

        System.out.println("---Menu---");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Report");
        System.out.println("4. Exit");

        do {
            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();
            System.out.println();

            switch (ch) {
                case 1:
                    deposit();
                    break;

                case 2:
                    withdraw();
                    break;

                case 3:
                    report();
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
