<%--
    控制面板
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<jsp:include page="../layouts/namespace.jsp"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>权限管理</title>
    <!-- Core CSS - Include with every page -->
    <link href="${ctx}/assets/stylesheets/bootstrap.min.css" rel="stylesheet">

    <!-- Page-Level Plugin CSS - Dashboard -->
    <link href="${ctx}/assets/plugins/font-awesome-4.0.3/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/assets/plugins/bounce-menu/css/style4.css" rel="stylesheet">

    <!-- Theme CSS - Include with use page -->
    <%--<link href="${ctx}/assets/stylesheets/bootstrap-theme.min.css" rel="stylesheet">--%>


</head>
<body>
<jsp:include page="../layouts/header.jsp"/>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12 col-md-12 main">
            <h1 class="page-header">Dashboard</h1>

            <div class="row placeholders">

            </div>

            <h2 class="sub-header">Section title</h2>
            <div class="table-responsive">

            </div>
        </div>
    </div>
</div><!--./container-fluid-->

<jsp:include page="../layouts/footer.jsp"/>

<!-- Core Scripts - Include with every page -->
<script src="${ctx}/assets/javascripts/jquery-2.1.0.min.js"></script>
<script src="${ctx}/assets/javascripts/bootstrap.min.js"></script>

<!-- Page-Level Plugin Scripts - Dashboard -->
<script src="${ctx}/assets/plugins/bounce-menu/js/classie.js"></script>
<script src="${ctx}/assets/plugins/bounce-menu/js/borderMenu.js"></script>
<!-- Theme Scripts - Include with every page -->

</body>
</html>

