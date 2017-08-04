
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: trina2
  Date: 8/4/17
  Time: 11:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Report</title>
</head>
<body>

<%--table below will display list of registered users in SQL in desc. order by date/time--%>
<table border=1>
    <c:forEach var="myvar" items="${list}">
        <tr>
            <td> ${myvar.firstName}</td>
            <td> ${myvar.lastName}</td>
            <td> ${myvar.address1}</td>
            <td> ${myvar.address2}</td>
            <td> ${myvar.city}</td>
            <td> ${myvar.state}</td>
            <td> ${myvar.zipCode}</td>
            <td> ${myvar.country}</td>
            <td> ${myvar.date}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
