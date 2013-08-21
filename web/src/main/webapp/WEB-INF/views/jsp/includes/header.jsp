<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Static navbar -->
<header class="navbar navbar-static-top">
    <div class="container">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".nav-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/">Avalon</a>
        <div class="nav-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/dashboard">仪表盘</a></li>
                <li class="dropdown">
                    <a href="/artcles" class="dropdown-toggle" data-toggle="dropdown">文章管理<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">文章</a></li>
                        <li><a href="#">评论</a></li>
                        <li><a href="#">多媒体</a></li>
                    </ul>
                </li>
                <li><a href="/users">用户管理</a></li>
                <li><a href="/resources">资源管理</a></li>
                <li><a href="/roles">角色管理</a></li>
                <li><a href="/authoritys">权限管理</a></li>
                <li class="dropdown">
                    <a href="#contact" class="dropdown-toggle" data-toggle="dropdown">系统扩展<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">国际化</a></li>
                        <li><a href="#">主题</a></li>
                        <li><a href="#">插件</a></li>
                    </ul>
                </li>

            </ul>

            <ul class="nav navbar-nav pull-right">
                <li><a href="#">Link</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</header>