<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@page import="com.ckeditor.CKEditorConfig"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Puzzle CMS | Article</title>
    <style>
        button {
            background: #E6E6FA;
            border: 1px solid #7a7b7e;
            width: 120px;
            height: 30px;
            border-radius: 5px;
        }
        header {
            display: block;
            height: 50px;
            background: #eee5de;
        }
        .header-cms {
            background: #eee5de
        height: 50px;
            text-align: start;
        }
    </style>
</head>

<body bgcolor="#FFFFF0">

<header>
    <div class="header-cms">
        <H1>Editing article</H1>
    </div>
</header>

<div align="left">
    <p>
        <%
            String value = "Type here...";
            Map<String, String> attr = new HashMap<String, String>();
            attr.put("rows", "8");
            attr.put("cols", "50");
            CKEditorConfig settings = new CKEditorConfig();
            settings.addConfigValue("toolbar", "Full");
        %>
        <ckeditor:editor textareaAttributes="<%=attr %>"
                         basePath="../ckeditor/" config="<%=settings %>"
                         editor="editor1" value="<%= value %>"/>
    </p>
</div>

<form action="/validateArticle" method="GET">

    <div align="left">
        <table>
            <tr>
                <td>Name*: </td> <td><input type="text" name="name" value="" size=40 maxlength=100/></td><br/>
            </tr>
            <br>
            <tr>
                <br><td>Title*: </td> <td><input type="text" name="title" value= "" size=40 maxlength=100/><br/></td>
            </tr>
            <br>
            <tr>
                <br><td>Keywords*: </td> <td><input type="text" name="keywords" value="" size=100 maxlength=100/></td><br/>
            </tr>
            <br>
            <tr>
                <br><td>Description*: </td> <td><input type="text" name="description" value= "" size=100 maxlength=255/></td><br/>
            </tr>
            <br><br>
            <br>
        </table>
        <form action="/createArticle" method="get">
            <br><br>
            <button><b>Submit</b></button>
        </form>
    </div>
</form>

<div align="right">
    <form action="Tabs.jsp" method="get">
        <button><b>Close</b></button>
    </form>
</div>

<br/>
</body>
</html>
