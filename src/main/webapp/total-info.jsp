<%--
  Created by IntelliJ IDEA.
  User: valentin
  Date: 16.01.2022
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Total Info</title>
</head>
<body>
<H1>Total Info</H1>

<p><a href='<c:url value="/addtotalinfo" />'>Add total info</a></p>

<table>
    <tr>
        <th><strong>Planet: </strong></th>
        <th><strong>Population: </strong></th>
        <th><strong>Legion: </strong></th>
        <th><strong>Contingent: </strong></th>
    </tr>
    <c:forEach var="totalList" items="${totallist}">

        <tr>
            <td>${totalList.getPlanetname()}</td>
            <td>${totalList.getPopulation()}</td>
            <td>${totalList.getLegion()}</td>
            <td>${totalList.getLeg_contingent()}</td>

        </tr>
    </c:forEach>
</table>

<a href="/">Main page</a>



</body>
</html>
