/*
Program 8:
    Java Servlet program to authenticate a login form
*/

package Login;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

public class Login extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String user = request.getParameter("user");
            String pword = request.getParameter("password");

            if (user == null || pword == null || user.trim().isEmpty() || pword.trim().isEmpty()) {
                out.println("<h3>Username/Password cannot be empty!</h3>");
            } else {
                try {
                    Class.forName("org.apache.derby.jdbc.ClientDriver");
                    Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/src/Login/database/login", "root", "password");
                    PreparedStatement ps = con.prepareStatement("SELECT password FROM login WHERE username=?");
                    ps.setString(1, user);

                    ResultSet rs = ps.executeQuery();

                    if (rs.next()) {
                        String pwordDB = rs.getString("password");

                        if (pword.trim().equals(pwordDB.trim())) {
                            out.println("<h2 align='center'>");
                            out.println("Hi, " + user + "<br>");
                            out.println("Welcome to the page!");
                            out.println("</h2>");
                        } else {
                            out.println("<h3 align='center'>Wrong password</h3>");
                        }
                    } else {
                        response.sendRedirect("error.html");
                    }

                    rs.close();
                    ps.close();
                    con.close();
                } catch (ClassNotFoundException e) {
                    out.println("JDBC Driver not found!");
                } catch (SQLException e) {
                    out.println("Database error: " + e.getMessage());
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}