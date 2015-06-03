<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.awt.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="context.Article" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Puzzle CMS</title></head>
<style>
    button {
        background: #E6E6FA;
        border: 1px solid #7a7b7e;
        width: 120px;
        height: 30px;
        border-radius: 5px;
    }

</style>

<body bgcolor="#FFFFF0">

<form action="NewArticle.jsp" method="post">
    <button><b>Add new article</b></button>
</form>
<BR> <BR>

<table style="border: 1px solid; width: 100%; text-align:center">
    <thead style="background:#dbc1ac">
    <tr>
        <th>Select</th>
        <th>Title</th>
        <th>Preview</th>
        <th>Author</th>
        <th>History</th>
        <th>Next step</th>
    </tr>
    </thead>

    <tbody style="background:#e7ddbe">

    <% ArrayList<Article> articleList= (ArrayList) session.getAttribute("articleList");
        for(Article article: articleList) {%>

    <tr>
        <th><input type="checkbox" name="id" value="select"></th>
        <th><a href= <%out.print(article.getUrl());%>><%out.print(article.getTitle());%></a></th>
        <th><% out.print(article.getDescription());%></th>
        <th><% out.print(article.author.getName());%></th>
        <th><a href=ArticleDetails.jsp> show history</a></th>
        <th><a href=ArticleDetails.jsp> finish working with article</a></th>
    </tr>

    <%}%>
    </tbody>
</table>
</thead>
</body>
</html>