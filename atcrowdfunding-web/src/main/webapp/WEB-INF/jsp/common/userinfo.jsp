<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/8/8
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" %>
<div class="btn-group">
    <button type="button" class="btn btn-default btn-success dropdown-toggle" data-toggle="dropdown">
        <i class="glyphicon glyphicon-user"></i> ${loginUser.username} <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" role="menu">
        <li><a href="#"><i class="glyphicon glyphicon-cog"></i> 个人设置</a></li>
        <li><a href="#"><i class="glyphicon glyphicon-comment"></i> 消息</a></li>
        <li class="divider"></li>
        <li><a href="${APP_PATH}/logout.htm"><i class="glyphicon glyphicon-off"></i> 退出系统</a></li>
    </ul>
</div>
