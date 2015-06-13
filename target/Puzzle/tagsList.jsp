<%@ page import="hibernate.tables.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="hibernate.tables.Tag" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Puzzle CMS|Tags</title></head>
    <meta charset="utf-8">
    <meta httap-equiv="X-UA-Compatible" content="IE=edge">
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
        <li><a href="/articlelist">Materials</a></li>
        <li><a href="/userlist">Users</a></li>
        <li><a href="/mainarticles">Main materials</a></li>
        <li><a href="/tags">Tags</a></li>
    </ul>
</nav>
<div class="site-overlay"></div>
<div id="container">
    <div class="menu-btn">&#9776; Menu</div>

    <h1 style="text-align:center">Tags</h1>
</div>

<div class="container" style="width: 300px;">
    <form action="newTag.jsp" method="post">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Add new</button>
    </form>
</div>

<div id="content_page_main_materials" class="container">
    <div class="row">

    </div>

    <div class="row" style="height: 20px"></div>
    <table class="table table-striped">
        <tr>
            <th>Name</th>
        </tr>
        <tbody>
            <% ArrayList<Tag> tagList= (ArrayList) session.getAttribute("tagList");
            for(Tag tag: tagList) {%>

        <tr>
            <th><% out.print(tag.getName());%></th>
        </tr>
            <%}%>
    </table>
</div>
<div class="paginator text-center">
    <ul class="pagination">
        <li><a href="#">&laquo;</a></li>
        <li><a href="#">1</a></li>
        <li class="active"><a href="#">2</a></li>
        <li><a href="#">&raquo;</a></li>
    </ul>
</div>
<script src="../dist/js/pushy.min.js"></script>
</body>
</html>
