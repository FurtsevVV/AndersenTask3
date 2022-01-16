<%--
  Created by IntelliJ IDEA.
  User: valentin
  Date: 16.01.2022
  Time: 7:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update PD</title>
</head>
<body>
<h1>Update Planet Details</h1>
<div><strong>Current PD</strong></div>
<%
    if (request.getAttribute("id") != null) {
        out.println("<p>" + "ID: " + request.getAttribute("id").toString() + "</p>");
    }
%>
<%
    if (request.getAttribute("planet") != null) {
        out.println("<p>" + "Planet: " + request.getAttribute("planet").toString() + "</p>");
    }
%>
<%
    if (request.getAttribute("population") != null) {
        out.println("<p>" + "Population: " + request.getAttribute("population").toString() + "</p>");
    }
%>


<form method="post">
    <label>Set Planet Details</label><br>
    <input name="planet"/><br><br>
    <input name="population"/><br><br>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
