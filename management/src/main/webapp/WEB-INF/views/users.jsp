<%--
    控制面板
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<jsp:include page="../layouts/namespace.jsp"/>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理</title>
    <!-- Core CSS - Include with every page -->
    <link href="${ctx}/assets/stylesheets/bootstrap.min.css" rel="stylesheet">

    <!-- Page-Level Plugin CSS - Dashboard -->
    <link href="${ctx}/assets/plugins/font-awesome-4.0.3/css/font-awesome.min.css" rel="stylesheet">
    <link href="${ctx}/assets/plugins/bounce-menu/css/style4.css" rel="stylesheet">
    <link href="${ctx}/assets/plugins/data-tables/css/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Theme CSS - Include with use page -->
    <%--<link href="${ctx}/assets/stylesheets/bootstrap-theme.min.css" rel="stylesheet">--%>
    <link href="${ctx}/assets/stylesheets/avalon-theme.css" rel="stylesheet">

</head>
<body>
<jsp:include page="../layouts/header.jsp"/>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12 col-md-12 main">
            <h1 class="page-header">用户管理</h1>
            <div class="row">
               <div class="col-sm-12">
                   <div class="panel panel-info">
                       <div class="panel-heading">
                           <h3 class="panel-title">用户管理</h3>
                       </div>
                       <div class="panel-body">
                       <div class="table-responsive">
                       <table class="table table-bordered table-hover" id="dataTables-users">
                           <thead>
                           <tr>
                               <th>账号</th>
                               <th>email</th>
                               <th>操作</th>
                           </tr>
                           </thead>
                           <tbody>

                           </tbody>
                       </table>
                       </div>
                       <!-- /.table-responsive -->

                       </div>
                   </div>
               </div>
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

<script src="${ctx}/assets/plugins/data-tables/js/jquery.dataTables.min.js"></script>
<script src="${ctx}/assets/plugins/data-tables/js/dataTables.bootstrap.js"></script>
<!-- Theme Scripts - Include with every page -->


<script>

    var datatable2Rest = function(sSource, aoData, fnCallback) {
        console.log("aaa");
        console.log(sSource);
        console.log(aoData);
        var paramMap = {};
        for ( var i = 0; i < aoData.length; i++) {
            paramMap[aoData[i].name] = aoData[i].value;
        }
        console.log(paramMap);
        //page calculations
        var pageSize = paramMap.iDisplayLength;
        var start = paramMap.iDisplayStart;
        var pageNum = (start == 0) ? 1 : (start / pageSize) + 1; // pageNum is 1 based

        // extract sort information
        var sortCol = paramMap.iSortCol_0;
        var sortDir = paramMap.sSortDir_0;
        var sortName = paramMap['mDataProp_' + sortCol];

        //create new json structure for parameters for REST request
        var restParams = new Array();
        restParams.push({"name" : "limit", "value" : pageSize});
        restParams.push({"name" : "page", "value" : pageNum });
        restParams.push({"name" : "sort", "value" : sortName });
        restParams.push({"name" : sortName + ".dir", "value" : sortDir });
        console.log(restParams);
        //if we are searching by name, override the url and add the name parameter
        var url = sSource;
        if (paramMap.sSearch != '') {
            url += "/search/findByNameContains";
            restParams.push({ "name" : "name", "value" :  paramMap.sSearch});
        }

        console.log(restParams);

        $.ajax({
            "dataType" : 'json',
            "type" : "GET",
            "url" : url,
            "data" : restParams,
            "success" : function(data) {
                var page = data.page;
                data.iTotalRecords = page.totalPages;
                data.iTotalDisplayRecords = page.totalElements;
                console.log(data);
                fnCallback(data);
            },
            "fnClick": function ( nButton, oConfig, oFlash ) {
                console.log("===============");
            }
        });
    };

    $(document).ready(function() {


        var usersTable = $('#dataTables-users').dataTable( {
            bProcessing: true,
            sAjaxSource:'assets/users',
            "sAjaxDataProp" : '_embedded.users',
            "aoColumns" : [ {
                mDataProp : 'username',
                sName:"ssss"
            }, {
                mDataProp : 'email'
            },{
                "mData": null,
                "mRender": function ( data, type, full ) {
                    return '<a href="'+data+'">'+full.username+'</a>';
                }
            } ],
            oLanguage: {
                "sProcessing":   "处理中...",
                "sLengthMenu":   "显示 _MENU_ 项结果",
                "sZeroRecords":  "没有匹配结果",
                "sInfo":         "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty":    "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix":  "",
                "sSearch":       "搜索:",
                "sUrl":          "",
                "sEmptyTable":     "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands":  ",",
                "oPaginate": {
                    "sFirst":    "首页",
                    "sPrevious": "上页",
                    "sNext":     "下页",
                    "sLast":     "末页"
                },
                "oAria": {
                    "sSortAscending":  ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },
            "bServerSide" : true,
            "fnServerData" : datatable2Rest

        });


    });

</script>
</body>
</html>

