<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 19.03.2023
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    Tytuł: <form:input path="title"/><br>
    Ocena: <form:input path="rating" type="number"/><br>
    Opis: <form:textarea path="description"/><br>
    Wydawca: <form:select path="publisher.id">
        <form:option value="0" label="-- wybierz --"/>
        <form:options items="${publishers}" itemLabel="name" itemValue="id"/>
    </form:select><br>
    <input type="submit"/>
</form:form>
</body>
</html>
