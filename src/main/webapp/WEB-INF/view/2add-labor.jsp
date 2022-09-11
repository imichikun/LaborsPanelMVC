<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<body>
    <h2> Labor Properties </h2>
<br>

<form:form action="saveLabor" modelAttribute="labor">
    <form:hidden path="id"/>

        Name <form:input path="name"/>
        <form:errors path="name"/>
        <br><br>
        Surname <form:input path="surname"/>
        <form:errors path="surname"/>
        <br><br>
        Department <form:input path="department"/>
        <br><br>
        Salary <form:input path="salary"/>
        <form:errors path="salary"/>
        <br><br>
        Email <form:input path="email"/>
        <form:errors path="email"/>
        <br><br>

    <input type="submit" value="OK">
</form:form>

<body>
<html>