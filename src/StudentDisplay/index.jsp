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

        con = DriverManager.getConnection("jdbc:derby://localhost:1527/Collegedb");
        st = con.createStatement();
        String query = "Select * from studentdb";
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
        int regno = rs.getInt("stregno");
        String name = rs.getString("stname");
        String add = rs.getString("staddress");
        String course = rs.getString("stcourse");
    %>
    <a href="student_details.jsp?rno=<%=regno%>&nm=<%=name%>&add=<%=add%>&cs=<%=course%>"><%=name%><br></a>
    <%
        }
    } catch (Exception e) {
        out.println(e);
    }
    %>
</body>
</html>
