/*
Program 2:
    Java Servlet program to create a shopping page
*/

package Shopping;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@WebServlet("/shopping")
public class Shopping extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String[] products = request.getParameterValues("products");

            Map<String, Integer> prices = Map.of(
                "Laptop", 50000,
                "Mobile", 25000,
                "Headphones", 2000,
                "Keyboard", 1500
            );

            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Shopping Servlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2> Hello, " + name + "!</h2>");
            out.println("Your items:");
            out.println("<table>");
            int totalPrices = 0;
            for (String product : products) {
                int qty = Integer.parseInt(request.getParameter("qty_" + product));
                int price = prices.get(product) * qty;
                totalPrices += price;

                out.println("<tr>");
                out.println("<td>" + product + "</td>");
                out.println("<td>" + qty + "</td>");
                out.println("<td>" + price + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br>");
            out.println("Total amount: " + totalPrices);
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