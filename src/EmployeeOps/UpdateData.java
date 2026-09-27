/*
Program 7:
    Java Servlet program to perform operations on employee table
*/

package EmployeeOps;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateData extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String action = request.getParameter("update");

            if (action.equals("insert")) {
                int empid = Integer.parseInt(request.getParameter("empid"));
                String name = request.getParameter("name");
                String dept = request.getParameter("dept");
                double salary = Double.parseDouble(request.getParameter("salary"));

                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/src/EmployeeOps/database/employee", "root", "password");
                    PreparedStatement ps = con.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?)");

                    ps.setInt(1, empid);
                    ps.setString(2, name);
                    ps.setString(3, dept);
                    ps.setDouble(4, salary);

                    int rows = ps.executeUpdate();

                    if (rows > 0)
                        out.println("<h2>Employee data inserted successfully</h2>");
                    else
                        out.println("<h2>Employee data not inserted</h2>");

                    ps.close();
                    con.close();
                } catch (Exception e) {
                    out.println("<h3>Error: " + e.getMessage() + "</h3>");
                }
            } else if (action.equals("delete")) {
                int empid = Integer.parseInt(request.getParameter("empid"));

                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/src/EmployeeOps/database/employee", "root", "password");
                    PreparedStatement ps = con.prepareStatement("DELETE FROM employee WHERE empid=?");

                    ps.setInt(1, empid);

                    int rows = ps.executeUpdate();

                    if (rows > 0)
                        out.println("<h2>Employee data deleted successfully</h2>");
                    else
                        out.println("<h2>Employee data not found</h2>");

                    ps.close();
                    con.close();
                } catch (Exception e) {
                    out.println("<h3>Error: " + e.getMessage() + "</h3>");
                }
            } else {
                out.println("<h2>Unauthorized operation</h2>");
            }

            out.println("<br><br>");
            out.println("<a href='../Employee'>Back to home</a>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
