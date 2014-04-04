<%--
    页面导航
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<nav class="navbar-default navbar-static-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="side-menu">

            <li>
                <a href="${ctx}"><i class="fa fa-dashboard fa-fw"></i> 控制面板</a>
            </li>
            <li>
                <a href="#"><i class="fa fa-unlock-alt fa-fw"></i> 权限管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="${ctx}/resources">资源管理</a>
                    </li>
                    <li>
                        <a href="${ctx}/operations">操作管理</a>
                    </li>
                    <li>
                        <a href="${ctx}/permissions">权限管理</a>
                    </li>
                    <li>
                        <a href="${ctx}/roles">角色管理</a>
                    </li>
                    <li>
                        <a href="${ctx}/users">用户管理</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
            <li>
                <a href="#"><i class="glyphicon glyphicon-book fa-fw"></i>图书管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="${ctx}/books">书籍管理</a>
                    </li>
                    <li>
                        <a href="${ctx}/comments">点评管理</a>
                    </li>
                </ul>
            </li>
            <li>
                <a href="#"><i class="glyphicon glyphicon-facetime-video fa-fw"></i> 书堂管理<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="${ctx}/rooms">书堂管理</a>
                    </li>
                    <li>
                        <a href="${ctx}/chats">聊天管理</a>
                    </li>
                    <li>
                        <a href="${ctx}/materials">资料管理</a>
                    </li>
                </ul>
                <!-- /.nav-second-level -->
            </li>
        </ul>
        <!-- /#side-menu -->
    </div>
    <!-- /.sidebar-collapse -->
</nav>
<!-- /.navbar-static-side -->

