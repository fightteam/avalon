<%--
    用户管理
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<jsp:include page="../layouts/namespace.jsp"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>avalon 管理系统</title>
    <!-- Core CSS - Include with every page -->
    <link href="${ctx}/assets/stylesheets/bootstrap.min.css" rel="stylesheet">

    <!-- Page-Level Plugin CSS - Dashboard -->
    <link href="${ctx}/assets/plugins/font-awesome-4.0.3/css/font-awesome.min.css" rel="stylesheet">

    <!-- Theme CSS - Include with use page -->
    <%--<link href="${ctx}/assets/stylesheets/bootstrap-theme.min.css" rel="stylesheet">--%>
    <link href="${ctx}/assets/stylesheets/avalon-theme.css" rel="stylesheet">

</head>
<body>


<div id="wrapper">
    <jsp:include page="../layouts/header.jsp"/>

    <jsp:include page="../layouts/side.jsp"/>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">用户管理</h1>
            </div> <!-- /.col-lg-12 -->
        </div><!-- /.row -->
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="btn-toolbar" role="toolbar">
                            <button type="button" class="btn btn-default">
                                <i class="glyphicon glyphicon-plus"></i>
                                增加
                            </button>
                        </div>
                    </div><!-- /.panel-heading -->
                    <div class="panel-body">
                        <div class="table-responsive">
                            <table class="table table-hover">
                                <thead>
                                <tr>
                                    <th>#</th>
                                    <th>名称</th>
                                    <th>权限定义</th>
                                    <th>是否可用</th>
                                    <th>资源类型</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${page}" varStatus="status" var="a">

                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div><!-- /.panel-body -->
                </div><!-- /.panel -->
            </div><!-- /.col-lg-12 -->
        </div><!-- /.row -->




    </div><!-- /#page-wrapper -->

</div><!-- /#wrapper -->

<jsp:include page="../layouts/footer.jsp"/>


<!-- Core Scripts - Include with every page -->
<script src="${ctx}/assets/plugins/jquery/jquery-2.1.0.min.js"></script>
<script src="${ctx}/assets/plugins/bootstrap/bootstrap.min.js"></script>

<!-- Page-Level Plugin Scripts - Dashboard -->
<script src="${ctx}/assets/plugins/metis-menu/jquery.metisMenu.js"></script>
<!-- Theme Scripts - Include with every page -->
<script src="${ctx}/assets/javascripts/admin-base.js"></script>

<script>


</script>
</body>
</html>

