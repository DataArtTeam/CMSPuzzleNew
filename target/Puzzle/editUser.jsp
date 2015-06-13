<%@ page import="context.UserSession" %>
<%@ page import="hibernate.tables.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Puzzle CMS|User</title>
</head>
<body>

<form action="/commituser" method="get">

    <%User user = (User)session.getAttribute("userName");%>

    <form action="/commituser">
        <input type="text" name="login" title="User" value=<%out.print(user.getLogin());%>>
        <BR>
        New role:
        <BR>
        <select name="newRole">
            <option value="ADMINISTRATOR">ADMINISTRATOR</option>
            <option value="CORRECTOR">CORRECTOR</option>
            <option value="EDITOR">EDITOR</option>
            <option value="AUTHOR">AUTHOR</option>
            <option value="UNCONFIRMED">UNCONFIRMED</option>
        </select>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
