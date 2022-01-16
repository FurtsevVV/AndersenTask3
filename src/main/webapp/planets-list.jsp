<%--
  Created by IntelliJ IDEA.
  User: valentin
  Date: 15.01.2022
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Planet Details List</title>
</head>
<body>
<H1>Planet Details List</H1>

<p><a href='<c:url value="/create-legion" />'>New Planet Details</a></p>

<table>
    <tr>
        <th><strong>Planet ID: </strong></th>
        <th><strong>Planet Name: </strong></th>
        <th><strong>Population: </strong></th>
        <th><strong>Operations: </strong></th>
    </tr>
    <c:forEach var="planets" items="${planetList}">

        <tr>
            <td>${planets.planet_id}</td>
            <td>${planets.planet}</td>
            <td>${planets.population}</td>
            <td>
           <!--     <form method="post" action="<c:url value="/deletePlanet" />">
                    <input type="text" hidden name="id" value="${planets.getPlanet_id()}">
                    <input type="submit" name="delete" value="Delete legion">
                </form>
            </td>
            <td>
                <form method="get" action="<c:url value="/updateLegion"/>">
                    <input type="number" hidden name="id" value="${legions.getId()}">
                    <input type="submit" value="Change Name">
                </form> -->
            </td>
            <td></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
