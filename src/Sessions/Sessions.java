/*
    Lab 6:
*/

package Sessions;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sessions")
public class Sessions extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String user = request.getParameter("user");
            String item = request.getParameter("item");
            int qty = Integer.parseInt(request.getParameter("qty"));

            HttpSession session = request.getSession(true);

            session.setAttribute("user", user);
            session.setAttribute("item", item);
            session.setAttribute("qty", qty);

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Session Servlet</title>");
            out.println("</head>");
            out.println("<h2>Session details</h2>");
            out.println("Session ID: " + session.getId() + "<br><br>");
            out.println("Creation time: " + new java.util.Date(session.getCreationTime()) + "<br>");
            out.println("Last accessed time: " + new java.util.Date(session.getLastAccessedTime()) + "<br>");
            out.println("Max inactive interval: " + session.getMaxInactiveInterval() + " seconds<br><br>");
            out.println("User name: " + session.getAttribute("user") + "<br>");
            out.println("Item name: " + session.getAttribute("item") + "<br>");
            out.println("Item quantity: " + session.getAttribute("qty") + "<br><br>");
            out.println("Is new session?: " + session.isNew() + "<br>");
            out.println("</body>");
            out.println("</html>");
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
