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

<form action="ArticleDetails.jsp" method="post">
    <button><b>Add new article</b></button>
</form>
<button><b>Delete articles</b></button>
<BR> <BR>

<table style="border: 1px solid; width: 100%; text-align:center">
    <thead style="background:#d3dce3">
    <tr>
        <th>Select</th>
        <th>Title</th>
        <th>Preview</th>
        <th>Author</th>
        <th>Date</th>
    </tr>
    </thead>
    <tbody style="background:#ccc">

    </tbody>
</table>
</body>
</html>