<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/8/8
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keys" content="">
    <meta name="author" content="">
    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/login.css">
    <style>

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <div><a class="navbar-brand" href="${APP_PATH}/index.htm" style="font-size:32px;">尚筹网-创意产品众筹平台</a></div>
        </div>
    </div>
</nav>

<div class="container">
    <h1 id=error></h1>
    <form id="loginForm" action="${APP_PATH}/doLogin.htm" method="post" class="form-signin" role="form">
        <h2 class="form-signin-heading"><i class="glyphicon glyphicon-cloud"></i> 用户登录</h2>
        <div class="form-group has-success has-feedback">
            <input type="text" class="form-control" id="loginacct" name="loginacct" value="huoqiang"
                   placeholder="请输入登录账号" autofocus>
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <input type="password" class="form-control" id="userpswd" name="userpswd" value="123456"
                   placeholder="请输入登录密码" style="margin-top:10px;">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <select class="form-control">
                <option value="member">会员</option>
                <option value="user">管理</option>
            </select>
        </div>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住我
            </label>
            <br>
            <label>
                忘记密码
            </label>
            <label style="float:right">
                <a href="${APP_PATH}/reg.htm">我要注册</a>
            </label>
        </div>
        <a class="btn btn-lg btn-success btn-block" onclick="dologin()"> 登录</a>
    </form>
</div>
<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/script/layer/layer.js"></script>
<script>
    function dologin() {
        /*
        var type = $(":selected").val();
        if ( type == "user" ) {
            window.location.href = "main.html";
        } else {
            window.location.href = "index.html";
        }
        */
        // 判断页面元素是否输入
        var loginacct = $("#loginacct");
        if (loginacct.val() == "") {
            // 如果没有输入，那么提示错误信息
            //alert("登录账号不能为空，请输入");
            layer.msg("登录账号不能为空，请输入", {time: 1000, icon: 5, shift: 6}, function () {
                loginacct.focus();
            });
            return;
        }

        var userpswd = $("#userpswd");
        if (userpswd.val() == "") {
            //alert("登录密码不能为空，请输入");
            layer.msg("登录密码不能为空，请输入", {time: 1000, icon: 5, shift: 6}, function () {
                userpswd.focus();
            });
            return;
        }

        // 提交表单
        //$("#loginForm").submit();

        // 使用AJAX实现数据的提交，进行登陆操作

        // $.post -- url, [data], [callback], [type]
        //url 必选 , 表示提交的服务器路径
        //data 表示发送请求时传送过的参数
        //callback : 发送请求成功后的回调方法(根据http响应状态码判断请求是否发送成功只有200 能调用. 404 和 500 都不能调用)
        //type 表示发送请求之后后台返回的类型 . 可以是 : xml , html , script , json , text ,_default

        // $.get  -- url, [data], [callback], [type]

        // $.ajax -- url, async, data,   success,error,  dataType
        //url : 必选 , 表示提交的服务器路径
        //data : 表示发送到服务器的数据(Object[json对象] , String[名值对])
        //success : 请求成功时回调的方法
        //error : 请求错误时回调的方法
        //datatype : 表示发送请求之后后台返回的类型 . 可以是 : xml , html , script , json , text ,_default
        //async : 默认为true , 默认情况下所有的请求均是异步请求 , 如果要同步,要设置为false

        // JSON对象
        // {} 表示对象 .   []表示集合 ;
        // json对象中属性名可以不用加引号.
        // {"name":"zhangsan", "age":10, "flg":true, "test": function(){}} []
        // {name:"zhangsan", age:10}
        // {"na.me":"xxxxx"}
        //$("#loginForm").submit();
        var loadingIndex = -1;
        var config = {
            url: "${APP_PATH}/doLogin.do",
            type: "POST",
            data: {
                loginacct: loginacct.val(),
                userpswd: userpswd.val()
            },
            //发送请求前可修改 XMLHttpRequest 对象的函数，如添加自定义 HTTP 头
            beforeSend: function () {
                loadingIndex = layer.load(0, {time: 10 * 1000});
                ;
            },
            //dataType : 指定返回类型. 因为在SpringMVC中配置了 ,  所以可加可不加
            //dataType: "json",
            success: function (result) {
                //alert(result.success);
                layer.close(loadingIndex);
                if (result.success) {
                    window.location.href = "${APP_PATH}/main.htm";
                } else {
                    layer.msg("User Isn't Exist , Please Try Again", {time: 1000, icon: 5, shift: 6});
                    //$("h1").html("User Isn't Exist , Please Try Again")(row 35)
                    //$("h1").text("User Isn't Exist , Please Try Again")(row 35)
                    //$("#error").html("User Isn't Exist , Please Try Again")(row 35)
                }
            }
        };
        $.ajax(config);

        <%--$.ajax({--%>
        <%--//url: "${APP_PATH}/doLogin.do",--%>
        <%--url : "${APP_PATH}/index.htm"--%>
        <%--type: "POST",--%>
        <%--data: {--%>
        <%--loginacct: loginacct.val(),--%>
        <%--userpswd: userpswd.val(),--%>
        <%--},--%>
        <%--success: function (result) {--%>
        <%--alert(result);--%>
        <%--},--%>
        <%--dataType: "json"--%>

        <%--});--%>
    }
</script>
</body>
</html>
