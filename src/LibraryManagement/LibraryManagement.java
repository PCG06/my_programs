/*
Program 1:
    JDBC program to create a library database with a book table
*/
package LibraryManagement;

import java.sql.*;
import java.util.Scanner;

/*
CREATE TABLE book (
    bookid INT PRIMARY KEY,
    bookname VARCHAR(25),
    author VARCHAR(25),
    publication VARCHAR(25),
    price DOUBLE,
    copies INT
);
*/

class Library {
    private Connection con;
    private Scanner sc = new Scanner(System.in);

    private void connectDB() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/src/LibraryManagement/database/library",
                "root",
                "1234");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertBook() {
        try {
            connectDB();

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter book name: ");
            String name = sc.nextLine();

            System.out.print("Enter author: ");
            String author = sc.nextLine();

            System.out.print("Enter publication: ");
            String publication = sc.nextLine();

            System.out.print("Enter price: ");
            double price = sc.nextDouble();

            System.out.print("Enter no. of copies: ");
            int copies = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("INSERT INTO book VALUES (?, ?, ?, ?, ?, ?)");

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, author);
            ps.setString(4, publication);
            ps.setDouble(5, price);
            ps.setInt(6, copies);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book inserted successfully!");
            else
                System.out.println("Book not inserted.");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteBook() {
        try {
            connectDB();

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("DELETE FROM book WHERE bookid = ?");

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book deleted successfully!");
            else
                System.out.println("Book not found.");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updatePrice() {
        try {
            connectDB();

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            System.out.print("Enter new price: ");
            double price = sc.nextDouble();

            PreparedStatement ps = con.prepareStatement("UPDATE book SET price = ? WHERE bookid = ?");

            ps.setDouble(1, price);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book price updated successfully!");
            else
                System.out.println("Book not found.");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateCopies() {
        try {
            connectDB();

            System.out.print("Enter Book ID: ");
            int id = sc.nextInt();

            System.out.print("Enter new copies: ");
            int copies = sc.nextInt();

            PreparedStatement ps = con.prepareStatement("UPDATE book SET copies = ? WHERE bookid = ?");

            ps.setInt(1, copies);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Book copies updated successfully!");
            else
                System.out.println("Book not found.");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();
        int ch;

        System.out.println("---Menu---");
        System.out.println("1. Insert book");
        System.out.println("2. Delete book");
        System.out.println("3. Update price");
        System.out.println("4. Update copies");
        System.out.println("5. Exit");

        do {
            System.out.print("\nEnter your choice: ");
            ch = sc.nextInt();
            System.out.println();

            switch (ch) {
                case 1:
                    lib.insertBook();
                    break;

                case 2:
                    lib.deleteBook();
                    break;

                case 3:
                    lib.updatePrice();
                    break;

                case 4:
                    lib.updateCopies();
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
