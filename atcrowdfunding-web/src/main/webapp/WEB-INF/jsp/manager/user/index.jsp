<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/8/8
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" href="${APP_PATH}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/font-awesome.min.css">
    <link rel="stylesheet" href="${APP_PATH}/css/main.css">
    <style>
        .tree li {
            list-style-type: none;
            cursor: pointer;
        }

        table tbody tr:nth-child(odd) {
            background: #F4F4F4;
        }

        table tbody td:nth-child(even) {
            color: #C00;
        }
    </style>
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <div><a class="navbar-brand" style="font-size:32px;" href="#">众筹平台 - 用户维护</a></div>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li style="padding-top:8px;">
                    <%@include file="/WEB-INF/jsp/common/userinfo.jsp" %>
                </li>
                <li style="margin-left:10px;padding-top:8px;">
                    <button type="button" class="btn btn-default btn-danger">
                        <span class="glyphicon glyphicon-question-sign"></span> 帮助
                    </button>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <div class="tree">
                <%@include file="/WEB-INF/jsp/common/menu.jsp" %>
            </div>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"><i class="glyphicon glyphicon-th"></i> 数据列表</h3>
                </div>
                <div class="panel-body">
                    <form class="form-inline" role="form" style="float:left;">
                        <div class="form-group has-feedback">
                            <div class="input-group">
                                <div class="input-group-addon">查询条件</div>
                                <input id="queryText" class="form-control has-success" type="text"
                                       placeholder="请输入查询条件">
                            </div>
                        </div>
                        <button type="button" id="queryBtn" class="btn btn-warning"><i
                                class="glyphicon glyphicon-search"></i> 查询
                        </button>
                    </form>
                    <button type="button" class="btn btn-danger" style="float:right;margin-left:10px;"
                            onclick="deleteUsers()"><i class=" glyphicon glyphicon-remove"></i> 删除
                    </button>
                    <button type="button" class="btn btn-primary" style="float:right;margin-left:10px;"
                            onclick="window.location.href='${APP_PATH}/user/add.htm'"><i
                            class="glyphicon glyphicon-plus"></i> 新增
                    </button>
                    <button type="button" class="btn btn-primary" style="float:right;"
                            onclick="window.location.href='${APP_PATH}/user/addBatch.htm'"><i
                            class="glyphicon glyphicon-plus"></i> 批量新增
                    </button>
                    <br>
                    <hr style="clear:both;">
                    <div class="table-responsive">
                        <table class="table  table-bordered">
                            <thead>
                            <tr>
                                <th width="30">#</th>
                                <th width="30"><input type="checkbox" onclick="selectAllBox(this)"></th>
                                <th>账号</th>
                                <th>名称</th>
                                <th>邮箱地址</th>
                                <th width="100">操作</th>
                            </tr>
                            </thead>
                            <tbody id="dataBody">
                            <%-- JSP注释
                            <!-- HTML注释
                            <c:forEach items="${users}" var="user" varStatus="status">
                               <tr>
                                 <td>${status.count}</td>
                                 <td><input type="checkbox"></td>
                                 <td>${user.loginacct}</td>
                                 <td>${user.username}</td>
                                 <td>
                                     <button type="button" class="btn btn-success btn-xs"><i class=" glyphicon glyphicon-check"></i></button>
                                     <button type="button" class="btn btn-primary btn-xs"><i class=" glyphicon glyphicon-pencil"></i></button>
                                     <button type="button" class="btn btn-danger btn-xs"><i class=" glyphicon glyphicon-remove"></i></button>
                                 </td>
                               </tr>
                            </c:forEach>
                             -->
                             --%>
                            </tbody>
                            <tfoot>
                            <tr>
                                <td colspan="6" align="center">
                                    <ul class="pagination"></ul>
                                    <!--
                                        <li class="disabled"><a href="#">上一页</a></li>
                                        <li ><a href="#">1 <span class="sr-only">(current)</span></a></li>
                                        <li class="active"><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li><a href="#">下一页</a></li>
                                         -->

                                </td>
                            </tr>

                            </tfoot>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${APP_PATH}/jquery/jquery-2.1.1.min.js"></script>
<script src="${APP_PATH}/bootstrap/js/bootstrap.min.js"></script>
<script src="${APP_PATH}/script/docs.min.js"></script>
<script src="${APP_PATH}/script/layer/layer.js"></script>
<script type="text/javascript">
    $(function () {
        $(".list-group-item").click(function () {
            if ($(this).find("ul")) {
                $(this).toggleClass("tree-closed");
                if ($(this).hasClass("tree-closed")) {
                    $("ul", this).hide("fast");
                } else {
                    $("ul", this).show("fast");
                }
            }
        });
        <c:if test="${empty param.pageno}">
        pageQuery(1);
        </c:if>
        <c:if test="${not empty param.pageno}">
        pageQuery(${param.pageno});
        </c:if>
    });
    $("tbody .btn-success").click(function () {
        window.location.href = "assignRole.html";
    });
    $("tbody .btn-primary").click(function () {
        window.location.href = "edit.html";
    });

    $("#queryBtn").click(function () {
        var queryText = $("#queryText");
        if (queryText.val() == "") {
            layer.msg("请输入查询条件", {time: 1500, icon: 5, shift: 6}, function () {
                queryText.focus();
            });
            return;
        }
        flg = true;
        pageQuery(1);
    });
    var flg = false;

    function pageQuery(pageno) {
        var loadingIndex = -1;
        var jsonData = {
            pageno: pageno,
            pagesize: 10
        };
        if (flg) {
            //jsonData.querytext = $("#queryText").val();
            jsonData["querytext"] = $("#queryText").val();
        }
        $.ajax({
            url: "${APP_PATH}/user/pageQuery.do",
            type: "POST",
            data: jsonData,
            beforeSend: function () {
                loadingIndex = layer.msg('处理中', {icon: 16});
            },
            success: function (result) {
                layer.close(loadingIndex);
                flg = false;
                if (result.success) {
                    var userPage = result.data;
                    var dataContent = "";
                    $.each(userPage.datas, function (i, user) {
                        dataContent = dataContent + '<tr>';
                        dataContent = dataContent + '  <td>' + (i + 1) + '</td>';
                        dataContent = dataContent + '  <td><input type="checkbox" value="' + user.id + '"></td>';
                        dataContent = dataContent + '  <td>' + user.loginacct + '</td>';
                        dataContent = dataContent + '  <td>' + user.username + '</td>';
                        dataContent = dataContent + '  <td>' + (user.email || "") + '</td>';
                        dataContent = dataContent + '  <td>';
                        dataContent = dataContent + '      <button type="button" class="btn btn-success btn-xs" onclick="window.location.href=\'${APP_PATH}/user/assign.htm?id=' + user.id + '\'"><i class=" glyphicon glyphicon-check"></i></button>';
                        dataContent = dataContent + '      <button type="button" class="btn btn-primary btn-xs" onclick="updateUser(' + user.id + ', ' + pageno + ')"><i class=" glyphicon glyphicon-pencil"></i></button>';
                        dataContent = dataContent + '	   <button type="button" class="btn btn-danger btn-xs" onclick="deleteUser(' + user.id + ', \'' + user.loginacct + '\')"><i class=" glyphicon glyphicon-remove"></i></button>';
                        dataContent = dataContent + '  </td>';
                        dataContent = dataContent + '</tr>';
                    });

                    $("#dataBody").html(dataContent);

                    // 生成页码
                    var pageContent = "";
                    if (pageno > 1) {
                        pageContent = pageContent + '<li><a href="#" onclick="pageQuery(' + (pageno - 1) + ')">上一页</a></li>';
                    }

                    for (var i = 1; i <= userPage.totalno; i++) {
                        if (i == pageno) {
                            pageContent = pageContent + '<li class="active"><a href="#">' + i + '</a></li>';
                        } else {
                            pageContent = pageContent + '<li><a href="#" onclick="pageQuery(' + i + ')">' + i + '</a></li>';
                        }
                    }

                    if (pageno < userPage.totalno) {
                        pageContent = pageContent + '<li><a href="#" onclick="pageQuery(' + (pageno + 1) + ')">下一页</a></li>';
                    }

                    $(".pagination").html(pageContent);
                } else {
                    layer.msg("用户分页查询失败", {time: 1500, icon: 5, shift: 6});
                }
            }
        });
    }

    function updateUser(id, pageno) {
        window.location.href = "${APP_PATH}/user/edit.htm?pageno=" + pageno + "&id=" + id;
    }

    function deleteUser(id, loginacct) {
        layer.confirm("删除用户信息:" + loginacct + "，是否继续？", {icon: 3, title: '提示'}, function (cindex) {
            // 删除用户
            $.ajax({
                type: "POST",
                url: "${APP_PATH}/user/delete.do",
                data: {
                    id: id
                },
                success: function (result) {
                    if (result.success) {
                        layer.msg("用户删除成功", {time: 1500, icon: 6}, function () {
                            pageQuery(1);
                        });
                    } else {
                        layer.msg("用户删除失败", {time: 1500, icon: 5, shift: 6});
                    }
                }
            });
            layer.close(cindex);
        }, function (cindex) {
            layer.close(cindex);
        });
    }

    function selectAllBox(cbox) {
        // 全选框的选中状态
        var flg = cbox.checked;
        // 获取所有的用户复选框
        // $.each(list, function(i, n){});
        // jquery集合.each(function(i, n){});
        $("#dataBody :checkbox").each(function (i, c) {
            c.checked = flg;
        });
    }

    function deleteUsers() {
        // 获取用户复选框选择的数量
        var userBoxes = $("#dataBody :checked");
        if (userBoxes.length == 0) {
            layer.msg("请选择需要删除的用户", {time: 1500, icon: 5, shift: 6});
        } else {
            layer.confirm("删除选择的用户信息，是否继续？", {icon: 3, title: '提示'}, function (cindex) {
                // 删除用户
                var jsonData = {};

                userBoxes.each(function (i, n) {
                    //jsonData["users["+i+"].id"] = n.value;
                    jsonData["ids[" + i + "]"] = n.value;
                });

                $.ajax({
                    type: "POST",
                    url: "${APP_PATH}/user/deletes.do",
                    data: jsonData,
                    success: function (result) {
                        if (result.success) {
                            layer.msg("用户删除成功", {time: 1500, icon: 6}, function () {
                                pageQuery(1);
                            });
                        } else {
                            layer.msg("用户删除失败", {time: 1500, icon: 5, shift: 6});
                        }
                    }
                });
                layer.close(cindex);
            }, function (cindex) {
                layer.close(cindex);
            });
        }
    }
</script>
</body>
</html>