/*
Program 7:
    Java Servlet program to perform operations on employee table
*/

package EmployeeOps;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Employee extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String btn = request.getParameter("btn");

            if (btn.equals("Data Entry")) {
                response.sendRedirect("insert.html");
            } else if (btn.equals("Delete")) {
                response.sendRedirect("delete.html");
            } else if (btn.equals("View Data")) {
                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/src/EmployeeOps/database/employee", "root", "password");
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM employee");
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Employee details</title>");
                    out.println("<style>");
                    out.println("body { font-family: Arial; text-align: center; }");
                    out.println("table { margin: auto; border-collapse: collapse; }");
                    out.println("th, td { padding: 10px; border: 1px solid black; }");
                    out.println("th { background-color: lightgray; }");
                    out.println("a { text-decoration: none; }");
                    out.println("</style>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1>Employee details</h1>");

                    if (rs.next()) {
                        out.println("<table>");
                        out.println("<tr>");
                        out.println("<th>Employee ID</th>");
                        out.println("<th>Name</th>");
                        out.println("<th>Department</th>");
                        out.println("<th>Salary</th>");
                        out.println("</tr>");

                        do {
                            out.println("<tr>");
                            out.println("<td>" + rs.getInt("empid") + "</td>");
                            out.println("<td>" + rs.getString("name") + "</td>");
                            out.println("<td>" + rs.getString("dept") + "</td>");
                            out.println("<td>" + rs.getDouble("salary") + "</td>");
                            out.println("</tr>");
                        } while (rs.next());

                        out.println("</table>");
                    } else {
                        out.println("<h3>No employees to display</h3>");
                    }

                    out.println("<br>");
                    out.println("<a href='../Employee'>Back to home</a>");
                    out.println("</body>");
                    out.println("</html>");

                    rs.close();
                    st.close();
                    con.close();
                } catch (Exception e) {
                    out.println("<h3>Error: " + e.getMessage() + "</h3>");
                }
            } else { // home page
                response.sendRedirect("index.html");
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
