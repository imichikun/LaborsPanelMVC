<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<body>
    <h2> All Labors List </h2>
<br>

<table>
    <tr>
        <th>Name </th> <th>Surname </th> <th>Department </th> <th>Salary </th> <th>Email </th>

        <th>HR officer</th>

        <th>Director</th>

    </tr>

    <c:forEach var="allLaborsVar" items="${labors}">

        <c:url var="var4ButtonUpdate" value="/updateInfo">
            <c:param name="var4ButtonUpdateParam" value="${allLaborsVar.id}"/>
        </c:url>

        <c:url var="var4ButtonDelete" value="/deleteLabor">
            <c:param name="var4ButtonDeleteParam" value="${allLaborsVar.id}"/>
        </c:url>

        <tr>
            <td>${allLaborsVar.name}</td>
            <td>${allLaborsVar.surname}</td>
            <td>${allLaborsVar.department}</td>
            <td>${allLaborsVar.salary}</td>
            <td>${allLaborsVar.email}</td>

            <security:authorize access="hasAnyRole('HR','DIRECTOR')">
            <td>
                <input type="button" value="Update"
                    onclick="window.location.href = '${var4ButtonUpdate}'"/>
            </td>
            </security:authorize>

            <security:authorize access="hasRole('DIRECTOR')">
            <td>
            <input type="button" value="Delete"
                    onclick="window.location.href = '${var4ButtonDelete}'"/>
            </td>
            </security:authorize>

            </tr>
    </c:forEach>
</table>
<br>

    <security:authorize access="hasAnyRole('HR', 'DIRECTOR')">
    <input type="button" value="addLabor"
        onclick="window.location.href = 'addLabor'"/>
    </security:authorize>

</body>
</html>