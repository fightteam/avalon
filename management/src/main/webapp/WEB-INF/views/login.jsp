<%--
    登录页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" trimDirectiveWhitespaces="true" %>
<jsp:include page="../layouts/namespace.jsp"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <!-- Core CSS - Include with every page -->
    <link href="${ctx}/assets/stylesheets/bootstrap.min.css" rel="stylesheet">
    <!-- Page-Level Plugin CSS - login -->
    <link href="${ctx}/assets/stylesheets/login.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please Sign In</h3>
                </div>
                <div class="panel-body">
                    <form role="form">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="账号或Email" name="username" type="text" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="密码" name="password" type="password" value="">
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="验证码" name="password" type="text" value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">记住我
                                </label>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <a href="index.html" class="btn btn-lg btn-success btn-block">Login</a>
                            <a href="index.html" class="btn btn-lg btn-primary btn-block">忘记密码？</a>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../layouts/footer.jsp"/>
</body>
</html>
