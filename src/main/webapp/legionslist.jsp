<%--
  Created by IntelliJ IDEA.
  User: valentin
  Date: 14.01.2022
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Legions list</title>
</head>
<body>
<H1>List of Legions</H1>

<p><a href='<c:url value="/create-legion" />'>Create new legion</a></p>

<table>
    <tr>
        <th><strong>ID: </strong></th>
        <th><strong>Legion name: </strong></th>
        <th><strong>Operations: </strong></th>
    </tr>
    <c:forEach var="legions" items="${legionList}">

        <tr>
            <td>${legions.id}</td>
            <td>${legions.legion_name}</td>
            <td>
                <form method="post" action="<c:url value="/deleteLegion" />">
                    <input type="text" hidden name="id" value="${legions.getId()}">
                    <input type="submit" name="delete" value="Delete legion">
                </form>
            </td>
            <td>
                <form method="get" action="<c:url value="/updateLegion"/>">
                    <input type="number" hidden name="id" value="${legions.getId()}">
                    <input type="submit" value="Change Name">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="/">Main page</a>
</body>
</html>


