CKEditor Development Community Web Site

LoginHelp/GuidePreferencesRegisterAbout Trac
WikiTimelineRoadmapBrowse SourceView TicketsSearch
Back to Ticket #8584
Ticket #8584: standalone.jsp
File standalone.jsp, 3.5 KB (added by j.swiderski, 3 years ago)
Line
1	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
2	<!--
3	Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
4	For licensing, see LICENSE.html or http://ckeditor.com/license
5	-->
6	<%@ taglib uri="http://ckeditor.com" prefix="ckeditor" %>
7	<%@page import="com.ckeditor.CKEditorConfig"%>
8	<%@page import="java.util.ArrayList"%>
9	<%@page import="java.util.List"%>
10	<%@page import="java.util.HashMap"%>
11	<%@page import="java.util.Map"%>
12	<%@page language="Java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
13	<%
    14	response.setHeader("X-Content-Security-Policy","allow *; script-src 'self' http://ajax.googleapis.com; options inline-script");
    15	%>
16	<html xmlns="http://www.w3.org/1999/xhtml">
17	<head>
    18	        <title>Creating CKEditor Instances &mdash; CKEditor Sample</title>
    19	        <meta content="text/html; charset=utf-8" http-equiv="content-type"/>
    20	        <link type="text/css" rel="stylesheet" href="../ckeditor/_samples/sample.css" />
    21	        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
    22	        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.9/jquery-ui.min.js"></script>
    23	</head>
24	<body>
25	        <h1 class="samples">
    26	                CKEditor Sample &mdash; Creating CKEditor Instances
    27	        </h1>
28	        <!-- This <div> holds alert messages to be display in the sample page. -->
29	        <div id="alerts">
    30	                <noscript>
    31	                        <p>
    32	                                <strong>CKEditor requires JavaScript to run</strong>. In a browser with no JavaScript
    33	                                support, like yours, you should still see the contents (HTML data) and you should
    34	                                be able to edit it normally, without a rich editor interface.
    35	                        </p>
    36	                </noscript>
    37	        </div>
38	        <div class="description">
    39	        <p>
    40	                This sample shows how to create a CKEditor instance with Java.
    41	        </p>
    42	        <pre class="samples">
43	&lt;%
44	String value = "My first &lt;strong&gt;CKEditor&lt;/strong&gt; Java tag";
45	
46	CKEditorConfig settings = new CKEditorConfig();
47	settings.addConfigValue("width", "500");
48	settings.addConfigValue("toolbar", "Basic");
49	%&gt;
50	
51	&lt;ckeditor:editor basePath="/ckeditor/" config="&lt;%=settings %&gt;" editor="textarea_id" value="&lt;%= value %&gt;"/&gt;</pre>
    52	        <p>
    53	                Note that <code><em>textarea_id</em></code> in the code above is the <code>id</code> and <code>name</code> attribute of
    54	                the <code>&lt;textarea&gt;</code> element that will be created.
    55	        </p>
    56	        </div>
57	        <!-- This <fieldset> holds the HTML code that you will usually find in your pages. -->
58	        <form action="assets/sample_posteddata.jsp" method="post">
    59	                <p>
    60	                        <label for="editor1">
    61	                                Editor 1:</label>
    62	                </p>
    63	                <p>
    64	                        <%
    65	                                String value = "My first <strong>CKEditor</strong> Java tag";
    66	                                Map<String, String> attr = new HashMap<String, String>();
    67	                                attr.put("rows", "8");
    68	                                attr.put("cols", "50");
    69	                                CKEditorConfig settings = new CKEditorConfig();
    70	                                settings.addConfigValue("width", "1024");
    71	                                settings.addConfigValue("toolbar", "Full");
    72	                        %>
    73	                        <ckeditor:editor textareaAttributes="<%=attr %>"
                                                   74	                                basePath="../ckeditor/" config="<%=settings %>"
                                                   75	                                editor="editor1" value="<%= value %>"/>
    76	                        <input type="submit" value="Submit"/>
    77	                </p>
    78	        </form>
79	        <div id="footer">
    80	                <hr />
    81	                <p>
    82	                        CKEditor - The text editor for the Internet - <a class="samples" href="http://ckeditor.com/">http://ckeditor.com</a>
    83	                </p>
    84	                <p id="copy">
    85	                        Copyright &copy; 2003-2011, <a class="samples" href="http://cksource.com/">CKSource</a> - Frederico
    86	                        Knabben. All rights reserved.
    87	                </p>
    88	        </div>
89	</body>
90	</html>
Download in other formats:
Original Format
© 2003 – 2012 CKSource – Frederico Knabben. All rights reserved. | Terms of use | Privacy policy