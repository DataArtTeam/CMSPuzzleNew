<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="content-type" content="text/html; charset=utf-8" />
  <title>
    Edit user data
  </title>
</head>

<body>
<h1>Please enter user`s data</h1>

<FORM name="form1" method="post">
  Имя: <INPUT type="text" name="name" size="20" maxlength="20"><BR>
  E-mail: <INPUT type="text" name="email" size="20" maxlength="20">
  <BR>
  <select name="menu" size="1">
    <%Iterator itr;%>
    <% List data= (List)request.getAttribute("role");
      itr=data.iterator();
    %>
    <option selected="selected" value="<%=itr%>"><%=itr.next()%></option>
    <option value="<%=itr%>"><%=itr.next()%></option>"
    <option value="<%=itr%>"><%=itr.next()%></option>
    <option value="<%=itr%>"><%=itr.next()%></option>
    <option value="<%=itr%>"><%=itr.next()%></option>
  </select>
  <BR><BR>
  <INPUT type="submit" name="submit" value="Confirm"><BR>
</FORM>

<BR><BR>

<%! boolean flagStart = true; %>
<%! String s_name=""; %>
<%! String s_email=""; %>
<%! String s_role=""; %>
<%! String change_date=""; %>

<table border="1px" cellpadding="8px">
  <tr>
    <th>Имя</th>
    <th>E-mail</th>
    <th>Роль</th>
    <th>Дата регистрации</th>
  </tr>

  <% if(!flagStart){ %>
  <%  s_name=request.getParameter("name");
  %><%
                  s_email=request.getParameter("email");
                  s_role=request.getParameter("menu");
                  change_date=" "+new Date(); %>

  <% out.println("<tr>");
    out.println("<td>" + s_name + "</td>");
    out.println("<td>" + s_email + "</td>");
    out.println("<td>" + s_role + "</td>");
    out.println("<td>" + change_date + "</td>");
    out.println("</tr>");
  %>
  <% } else
    flagStart = false; %>
</table>
</body>
</html>