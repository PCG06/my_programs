/*
Program 4:
    Java Servlet program to find new and repeated users of a webpage using cookies
*/

package Cookies;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

public class Cookies extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String user = request.getParameter("user");
            boolean isNewUser = true;
            Cookie[] cookies = request.getCookies();

            if (cookies != null) {
                for (Cookie c : cookies) {
                    if (c.getName().equals(user)) {
                        isNewUser = false;
                        break;
                    }
                }
            }

            String msg;

            if (isNewUser) {
                Cookie userCookie = new Cookie(user, "visited");
                userCookie.setMaxAge(60 * 60 * 24); // 60s * 60m * 24h
                response.addCookie(userCookie);
                msg = "Hi, " + user + "! Welcome to our page.";
            } else {
                msg = "Thank you for visiting again, " + user + ".";
            }

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User visit</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + msg + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            e.printStackTrace();
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
