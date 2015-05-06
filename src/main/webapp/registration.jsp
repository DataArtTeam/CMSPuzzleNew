<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>JSP Page</title>
</head>
<body>
	<form action="/CMSPuzzle-1.0-SNAPSHOT/registration" method="post">
		<h4>User does not exist. You must register</h4>
		<table border=1>
			<tr>
				<td>Login</td>
				<td><input name="login" type=text></td>
			</tr>
			<tr>
				<td>Your firstname</td>
				<td><input name="firstname" type=text></td>
			</tr>
			<tr>
				<td>Your lastname</td>
				<td><input name="lastname" type=text></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input name="password" type="password"></td>
			</tr>
			<tr>
				<td>Password confirmation</td>
				<td><input name="password_confirmation" type="password"></td>
			</tr>
			<tr>
				<td>Login</td>
				<td><input name="login" type=text></td>
			</tr>
			<tr>
				<td>Role</td>
				<td><input name="role" type=></td>
			</tr>
			
			<tr>
				<td colspan="2"><input type="submit" value="submit"></td>
			</tr>
		</table>

	</form>
</body>
</html>