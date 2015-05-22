<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@page import="com.ckeditor.CKEditorConfig"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Puzzle CMS | Article</title>
    <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
    <link type="text/css" rel="stylesheet" href="../ckeditor/_samples/sample.css" />
</head>
<body>

<h1>Edit Article</h1>

<form action="assets/sample_posteddata.jsp" method="post">

    <p>
        <%
            String value = "";
            Map<String, String> attr = new HashMap<String, String>();
            attr.put("rows", "8");
            attr.put("cols", "50");
            CKEditorConfig settings = new CKEditorConfig();
            settings.addConfigValue("width", "500");
            settings.addConfigValue("toolbar", "Basic");
        %>
        <ckeditor:editor textareaAttributes="<%=attr %>"
                         basePath="../ckeditor/" config="<%=settings %>"
                         editor="editor1" value="<%= value %>"/>
        <input type="submit" value="Submit"/>
    </p>
</form>

</body>
</html>
