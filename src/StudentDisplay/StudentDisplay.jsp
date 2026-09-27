<!--
Program 6:
    JSP program to display student list from student table
-->

<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Student Display</title>
</head>
<body>
    <h2>Hello!!</h2>
    <%
    String rn = request.getParameter("rno");
    String nm = request.getParameter("nm");
    String add = request.getParameter("add");
    String cs = request.getParameter("cs");
    %>
    <table>
        <tr>
            <td>Reg No</td>
            <td><%=rn%></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><%=nm%></td>
        </tr>
        <tr>
            <td>Address</td>
            <td><%=add%></td>
        </tr>
        <tr>
            <td>Course</td>
            <td><%=cs%></td>
        </tr>
    </table>
</body>
</html>