
<html>
<head>
    <title>Puzzle CMS</title>
    <script>
        $(document).ready(function() {
            $('.nav-tabs > li > a').click(function(event){
                event.preventDefault();
                var active_tab_selector = $('.nav-tabs > li.active > a').attr('href');
                var actived_nav = $('.nav-tabs > li.active');
                actived_nav.removeClass('active');
                $(this).parents('li').addClass('active');
                $(active_tab_selector).removeClass('active');
                $(active_tab_selector).addClass('hide');
                var target_tab_selector = $(this).attr('href');
                $(target_tab_selector).removeClass('hide');
                $(target_tab_selector).addClass('active');
            });
        });
    </script>
    <style>
        .nav {
            margin-bottom: 18px;
            margin-left: 0;
            list-style: none;
        }

        .nav > li > a {
            display: block;
        }

        .nav-tabs{
            *zoom: 1;
        }

        .nav-tabs:before,
        .nav-tabs:after {
            display: table;
            content: "";
        }

        .nav-tabs:after {
            clear: both;
        }

        .nav-tabs > li {
            float: left;
        }

        .nav-tabs > li > a {
            padding-right: 12px;
            padding-left: 12px;
            margin-right: 2px;
            line-height: 14px;
        }

        .nav-tabs {
            border-bottom: 1px solid #ddd;
        }

        .nav-tabs > li {
            margin-bottom: -1px;
        }

        .nav-tabs > li > a {
            padding-top: 8px;
            padding-bottom: 8px;
            line-height: 18px;
            border: 1px solid transparent;
            -webkit-border-radius: 4px 4px 0 0;
            -moz-border-radius: 4px 4px 0 0;
            border-radius: 4px 4px 0 0;
        }

        .nav-tabs > li > a:hover {
            border-color: #eeeeee #eeeeee #dddddd;
        }

        .nav-tabs > .active > a,
        .nav-tabs > .active > a:hover {
            color: #555555;
            cursor: default;
            background-color: #ffffff;
            border: 1px solid #ddd;
            border-bottom-color: transparent;
        }

        li {
            line-height: 18px;
        }

        .tab-content.active{
            display: block;
        }

        .tab-content.hide{
            display: none;
        }
      /** End: to style navigation tab **/
    </style>
</head>
<body>
<%@ include file="/Logout.jsp" %>
<div>
    <ul class="nav nav-tabs">
        <li class="active">
            <a href="#Materials">Materials</a>
        </li>
        <li>
            <a href="#Users">Users</a>
        </li>
    </ul>
</div>
<section id="Materials" class="tab-content active">
    <div>
        <%@ include file="/mainPage.jsp" %>
    </div>
</section>
<section id="Users" class="tab-content hide">
    <div>

    </div>
</section>
</body>
</html>