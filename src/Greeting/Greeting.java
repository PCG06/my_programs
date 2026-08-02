/*
    Lab 6:
*/

package Greeting;

import java.time.LocalTime;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greeting")
public class Greeting extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        LocalTime time = LocalTime.now();
        String greet = getGreeting(time.getHour());
        String bgColor = request.getParameter("bgColor");

        if (bgColor == null || bgColor.equals(""))
            bgColor = "White";

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Greeting Servlet</title>");
        out.println("</head>");
        out.println("<body style='background-color: " + bgColor + "; text-align: center;'>");
        out.println("<h2>Current System Time: " + time + "</h2>");
        out.println("<h1>" + greet + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private String getGreeting(int hour) {
        if (hour < 12)
            return "Good Morning";
        else if (hour < 16)
            return "Good Afternoon";
        else if (hour < 20)
            return "Good Evening";
        else
            return "Good Night";
    }
}
