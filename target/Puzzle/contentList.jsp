<%@ page import="java.util.ArrayList" %>
<%@ page import="hibernate.tables.Content" %>
<%@ page import="context.ContentList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Puzzle CMS</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../dist/css/style.css">
    <link rel="stylesheet" href="../dist/css/normalize.css">
    <link rel="stylesheet" href="../dist/css/demo.css">
    <link rel="stylesheet" href="../dist/css/pushy.css">
    <link rel="stylesheet" href="../dist/css/bootstrap/css/bootstrap.css">
    <link id="header_template" rel="import" href="templates/header_template.html">
    <link id="footer_template" rel="import" href="templates/footer_template.html">
    <link id="content_page" rel="import" href="templates/content_page.html">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
</head>

<body>
<script>
    var link = document.querySelector('#header_template');
    var content = link.import;
    var el = content.querySelector('.header');
    document.body.appendChild(el.cloneNode(true));
</script>
<nav class="pushy pushy-left">
    <ul>
        <li><a href="/article_list">Materials</a></li>
        <li><a href="/userlist">Users</a></li>
        <li><a href="/front">Front page</a></li>
        <li><a href="/tags">Tags</a></li>
    </ul>
</nav>
<div class="site-overlay"></div>
<div id="container">
    <div class="menu-btn">&#9776; Menu</div>

    <h1 style="text-align:center">Articles</h1>
</div>

<div class="container" style="width: 300px;">
    <form action="NewArticle.jsp" method="post">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Add new</button>
    </form>
</div>

<form action= "/add_to_front" method="get">

    <div class="container" style="width: 300px;">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Add to front page</button>
    </div>

    <div id="content_page_main_materials" class="container">

        <div class="row" style="height: 20px"></div>
        <table class="table table-striped">
            <tr>
                <th>Select</th>
                <th>Title</th>
                <th>Preview</th>
                <th>Author</th>
                <th>History</th>
                <th>Next step</th>
                <th>Status</th>
            </tr>
            <tbody>

            <% ArrayList<Content> contentList= (ArrayList) session.getAttribute("contentList");
                for(Content content: contentList) {%>

            <tr>
                <%String statusRef = "/editstatus?id="+ content.getId();
                    String historyRef = "/contenthistory?contentId=" + content.getId();%>
                <th><input type="checkbox" name="contentList" value=<%out.print(content.getId());%> ></th>
                <th><a href= <%out.print(content.getUrl());%>><%out.print(content.getTitle());%></a></th>
                <th><% out.print(content.getDescriptionOfContent());%></th>
                <th><% out.print(content.getAuthor().getLogin());%></th>
                <th><a href=<%out.print(historyRef);%>> show history</a></th>
                <th><a href=<%out.print(statusRef);%>> finish working with article</a></th>
                <th><% out.print(content.getArticleStatus());%></th>
            </tr>

            <%}%>
            </tbody>
        </table>
    </div>
</form>
<%int pageAmount = (Integer) session.getAttribute("pageAmount");
    int currentPage = 2;
%>
<div class="paginator text-center">
    <ul class="pagination">
        <li><a href="/article_list?page=1">1</a></li>
        <%while (currentPage <= pageAmount){
            String ref = "/article_list?page=" + currentPage;%>
        <li><a href=<%out.print(ref);%>><%out.print(currentPage);%></a></li>
        <%currentPage++;}%>
    </ul>
</div>
<script src="../dist/js/pushy.min.js"></script>
</body>
</html>
