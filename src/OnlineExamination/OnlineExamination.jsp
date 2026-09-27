<!--
Program 5:
    JSP Program to implement an online exam
-->

<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Online Examination</title>
</head>
<body>
    <%!
    public static Connection con = null;
    public static Statement st;
    public static ResultSet rs;
    public static int score = 0;
    public static String name;
    public static int answer;
    public static int correct;

    void dbOpen() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/src/OnlineExamination/database/exam", "root", "1234");
            st = con.createStatement();
            rs = st.executeQuery("SELECT * FROM questions");
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.print(e.getMessage());
        }
    }

    void dbClose() {
        try {
            rs.close();
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    %>

    <%
    name = request.getParameter("uname");

    if (con == null) {
        score = 0;
        dbOpen();
        out.println("<h4 align='center'>Welcome to the online exam</h4>");
    } else {
        answer = Integer.parseInt(request.getParameter("ans"));
        correct = rs.getInt(correct);

        if (answer == correct)
            score++;
    }

    out.println("<table align='center' border='1'>");

    try {
        if (rs.next()) {
    %>

    <form action="" method="post">
        <tr>
            <td><%=rs.getString("qid")%></td>
            <td><%=rs.getString("question")%></td>
        </tr>
        <tr>
            <td><input type="radio" value="1" name="ans"></td>
            <td><%=rs.getString("option1")%></td>
        </tr>
        <tr>
            <td><input type="radio" value="2" name="ans"></td>
            <td><%=rs.getString("option2")%></td>
        </tr>
        <tr>
            <td><input type="radio" value="3" name="ans"></td>
            <td><%=rs.getString("option3")%></td>
        </tr>
        <tr>
            <td><input type="radio" value="4" name="ans"></td>
            <td><%=rs.getString("option4")%></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Next"></td>
        </tr>
    </form>

    <%
        } else {
            out.println("You have scored " + score + " marks.");
            out.println("Thank you for using the software");
            dbClose();
        }

        out.println("</table>");
    } catch (SQLException e) {
        e.getMessage();
    }
    %>
</body>
</html>
