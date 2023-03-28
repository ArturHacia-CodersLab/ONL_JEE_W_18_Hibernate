<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 19.03.2023
  Time: 12:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<form method="post">--%>
<%--    Login:<input type="text" name="login"/><br>--%>
<%--    Hasło:<input type="password" name="password"/><br>--%>
<%--    Email:<input type="email" name="email"/><br>--%>
<%--    <input type="submit" value="Wyślij"/>--%>
<%--</form>--%>
<form:form method="post" modelAttribute="person">
    Login:<form:input path="login"/><br>
    Hasło:<form:password path="password"/><br>
    Email:<form:input type="email" path="email"/><br>
    <input type="submit" value="Wyślij"/>
</form:form>
</body>
</html>
