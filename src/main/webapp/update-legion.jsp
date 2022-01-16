<%--
  Created by IntelliJ IDEA.
  User: valentin
  Date: 15.01.2022
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Legion Name</title>
</head>
<body>
<h1>Update Legion name</h1>
<div><strong>Current legion</strong></div>

<%
    if (request.getAttribute("id") != null) {
        out.println("<p>" + "ID: " + request.getAttribute("id").toString() + "</p>");
    }
%>
<%
    if (request.getAttribute("legion_name") != null) {
        out.println("<p>" + "Name: " + request.getAttribute("legion_name").toString() + "</p>");
    }
%>


<form method="post">
    <label>Set Legion name</label><br>
    <input name="legion_name"/><br><br>
    <input type="submit" value="Save"/>
</form>
    </body>


</html>
