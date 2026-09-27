<!--
Program 6:
    JSP program to display student list from student table
-->

<%@ page import="java.sql.*" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student Display</title>
</head>
<body>
    <%
    try {
        Connection con;
        Statement st;
        Class.forName("org.apache.derby.jdbc.ClientDriver");

        con = DriverManager.getConnection("jdbc:derby://localhost:1527/src/StudentDisplay/database/student", "root", "1234");
        st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM student");

        while(rs.next()){
        int regno = rs.getInt("regno");
        String name = rs.getString("name");
        String add = rs.getString("address");
        String course = rs.getString("course");
    %>
    <a href="StudentDetails.jsp?rno=<%=regno%>&nm=<%=name%>&add=<%=add%>&cs=<%=course%>"><%=name%><br></a>
    <%
        }
    } catch (Exception e) {
        out.println(e);
    }
    %>
</body>
</html>
