<%@ page import="java.util.*, java.text.*" %>
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
          <option selected="selected" value="user">User</option>
          <option value="editor">Editor</option>
          <option value="moderator">Moderator</option>
          <option value="administration">Administrator</option>
        </select>  
        <BR><BR> 
        <INPUT type="submit" name="submit" value="Confirm"><BR>
    </FORM>

    <BR><BR>
    <%-- private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    pattern = Pattern.compile(EMAIL_PATTERN); --%>

    <%! boolean flagStart = true; %>
    <%! String s_name=""; %>
    <%! String s_email=""; %>
    <%! String s_rank=""; %>
    <%! String change_date=""; %> 

    <table border="1px" cellpadding="8px">
        <%-- Названия колонок в таблице --%>
        <tr>
            <th>Имя</th>
            <th>E-mail</th>
            <th>Роль</th>
            <th>Дата регистрации</th>
        </tr>

        <% if(!flagStart){ %>
            <%  s_name=request.getParameter("name");

                %><%-- matcher = pattern.matcher(s_name);
                boolean valid=matcher.matches();
                if(valid==true){ --%><%

                  s_email=request.getParameter("email");
                  s_rank=request.getParameter("menu");
                  change_date=" "+new Date(); %>  
             
                  <% out.println("<tr>");
                     out.println("<td>" + s_name + "</td>");
                     out.println("<td>" + s_email + "</td>");
                     out.println("<td>" + s_rank + "</td>");
                     out.println("<td>" + change_date + "</td>");  
                     out.println("</tr>");
                 %>
        <% } else
                flagStart = false; %>
    </table>
</body>
</html>