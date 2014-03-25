<%--
    页面头部
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<!-- Static navbar -->
<div class="navbar navbar-default navbar-static-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">切换显示</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">avalon 管理系统</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="../navbar/">设置</a></li>
                <li><a href="../navbar-fixed-top/">管理员</a></li>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</div><!--./navbar-->

<nav id="bt-menu" class="bt-menu">
    <a href="#" class="bt-menu-trigger"><span>Menu</span></a>
    <ul>
        <li><a href="${ctx}/dashborad" class="fa fa-tachometer" title="控制面板">控制面板</a></li>
        <li><a href="${ctx}/users" class="fa fa-user" title="用户管理">用户管理</a></li>
        <li><a href="${ctx}/permissions" class="fa fa-gavel" title="权限管理">权限管理</a></li>
    </ul>
    <ul>
        <li><a href="${ctx}/resoures" class="fa fa-clipboard" title="资源管理">资源管理</a></li>
        <li><a href="${ctx}/roles" class="fa fa-users" title="角色管理">角色管理</a></li>
    </ul>
</nav><!--./bt-menu-->