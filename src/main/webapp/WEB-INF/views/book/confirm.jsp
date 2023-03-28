<%--
  Created by IntelliJ IDEA.
  User: ahacia
  Date: 28.03.2023
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Czy na pewno chcesz usunąc ksiązkę o id ${id}
<br><br>
<a href="/book/all">Nie</a> <a href="/book/form/delete/${id}">Tak</a>
</body>
</html>
