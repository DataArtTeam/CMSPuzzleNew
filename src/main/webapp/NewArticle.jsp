<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
<%@page import="com.ckeditor.CKEditorConfig"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Puzzle CMS | Article</title>
</head>

<header>
    <H1>Editing article</H1>
</header>

<form action="/createArticle" method="GET">

    <table>
        <tr>
            <td>Name*: </td> <td><input type="text" name="name" value="" size=40 maxlength=100/></td><br/>
        </tr>
        <br>
        <tr>
            <td>Title*: </td> <td><input type="text" name="title" value= "" size=40 maxlength=100/><br/></td>
        </tr>
        <br>
    </table>

    <div align="left">
        <p>
            <%
                String value = "Type here...";
                Map<String, String> attr = new HashMap<String, String>();
                CKEditorConfig settings = new CKEditorConfig();
                settings.addConfigValue("toolbar", "Full");
            %>
            <ckeditor:editor textareaAttributes="<%=attr %>"
                             basePath="../ckeditor/" config="<%=settings %>"
                             editor="editor1" value="<%= value %>"/>
        </p>
    </div>

    <div align="left">
        <table>
            <tr>
                <td>Keywords*: </td> <td><input type="text" name="keywords" value="" size=100 maxlength=100/></td><br/>
            </tr>
            <br>
            <tr>
                <td>Description*: </td> <td><input type="text" name="description" value= "" size=100 maxlength=255/></td><br/>
            </tr>
            <br><br>
            <br>
            <tr>
                <td>Link*: </td> <td><input type="text" name="link" value="" size=100 maxlength=100/></td><br/>
            </tr>
            <tr>
                <td>Image name*: </td> <td><input type="text" name="imageName" value="" size=100 maxlength=100/></td><br/>
            </tr>
            <br>
        </table>
        <br><br>
        <button><b>Submit</b></button>
    </div>
</form>

<form action="/checktag" method="get">
    <button><b>Add tags</b></button>
</form>

<div align="right">
    <form action="/main" method="get">
        <button><b>Close</b></button>
    </form>
</div>

<br/>
</body>
</html>
