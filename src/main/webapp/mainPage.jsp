<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="context.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Puzzle CMS</title></head>
<body>

</form><H1>Materials</H1>

<form action="ArticleDetails.jsp" method="post">
    <input type="submit" value="ADD NEW" />
</form>

<table style="border: 1px solid; width: 100%; text-align:center">
    <thead style="background:#00796B">
    <tr>
        <th>Select</th>
        <th>Title</th>
        <th>Preview</th>
        <th>Author</th>
    </tr>
    </thead>

    <tbody style="background:#B2DFDB">

    <% ArrayList<Article> articleList= (ArrayList) session.getAttribute("articleList");
        for(Article article: articleList) {%>

    <tr>
        <th><input type="checkbox" name="id" value="select"></th>
        <th><% out.print(article.getTitle());%></th>
        <th><% out.print(article.getDescription());%></th>
        <th><% out.print(article.author.getUsername());%></th>
    </tr>

    <%}%>
    </tbody>
</table>
</thead>
</body>
</html>