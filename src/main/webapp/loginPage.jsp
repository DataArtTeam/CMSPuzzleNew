<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Puzzle CMS| Login</title>
</head>

<BODY>
<H1>Login to PuzzleCms</H1>
<h2>Please enter username and password</h2>

<table>
    <tr>
        <form action="Tabs.jsp" method="post">
            <table>
                <tr>
                    <td> User : </td><td> <input name="username" size=15 type="text" /> </td>
                </tr>
                <tr>
                    <td> Password : </td><td> <input name="password" size=15 type="text" /> </td>
                </tr>
            </table>
            <BR><BR>
            <input type="submit" value="LOGIN" />
            <BR><BR>
        </form>
    </tr>

    <tr>
        <form action="registration.jsp" method="post">
            <input type="submit" value="REGISTER" />
        </form>
    </tr>
</table>
</BODY>
</html>