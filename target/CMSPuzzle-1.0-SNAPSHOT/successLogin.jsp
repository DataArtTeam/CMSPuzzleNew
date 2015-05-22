
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Страница успешного входа в систему</title>
</head>
<body>
<br>
<h1>Login is successful</h1>
<jsp:useBean id="user" class="authorization.User" scope="application"/>
<br>

<input type="submit" value="LOGOUT"/>
</body>
</html>
