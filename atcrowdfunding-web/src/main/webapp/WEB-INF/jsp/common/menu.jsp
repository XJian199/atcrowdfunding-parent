<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/8/8
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@page pageEncoding="UTF-8" %>
<ul style="padding-left:0px;" class="list-group">
    <li class="list-group-item tree-closed">
        <a href="${APP_PATH}/main.htm"><i class="glyphicon glyphicon-dashboard"></i> 控制面板</a>
    </li>
    <li class="list-group-item tree-closed">
        <span><i class="glyphicon glyphicon glyphicon-tasks"></i> 权限管理 <span class="badge" style="float:right">3</span></span>
        <ul style="margin-top:10px;display:none;">
            <li style="height:30px;">
                <a href="${APP_PATH}/user/index.htm"><i class="glyphicon glyphicon-user"></i> 用户维护</a>
            </li>
            <li style="height:30px;">
                <a href="${APP_PATH}/role/index.htm"><i class="glyphicon glyphicon-king"></i> 角色维护</a>
            </li>
            <li style="height:30px;">
                <a href="${APP_PATH}/permission/index.htm"><i class="glyphicon glyphicon-lock"></i> 许可维护</a>
            </li>
        </ul>
    </li>
    <li class="list-group-item tree-closed">
        <span><i class="glyphicon glyphicon-ok"></i> 业务审核 <span class="badge" style="float:right">3</span></span>
        <ul style="margin-top:10px;display:none;">
            <li style="height:30px;">
                <a href="${APP_PATH}/auth/cert.htm"><i class="glyphicon glyphicon-check"></i> 实名认证审核</a>
            </li>
            <li style="height:30px;">
                <a href="${APP_PATH}/auth/adv.htm"><i class="glyphicon glyphicon-check"></i> 广告审核</a>
            </li>
            <li style="height:30px;">
                <a href="${APP_PATH}/auth/project.htm"><i class="glyphicon glyphicon-check"></i> 项目审核</a>
            </li>
        </ul>
    </li>
    <li class="list-group-item tree-expanded">
        <span><i class="glyphicon glyphicon-th-large"></i> 业务管理 <span class="badge" style="float:right">7</span></span>
        <ul style="margin-top:10px;display:none;">
            <li style="height:30px;">
                <a href="${APP_PATH}/cert/index.htm"><i class="glyphicon glyphicon-picture"></i> 资质维护</a>
            </li>
            <li style="height:30px;">
                <a href="${APP_PQTH}/type.htm"><i class="glyphicon glyphicon-equalizer"></i> 分类管理</a>
            </li>
            <li style="height:30px;">
                <a href="process.html"><i class="glyphicon glyphicon-random"></i> 流程管理</a>
            </li>
            <li style="height:30px;">
                <a href="advertisement.html"><i class="glyphicon glyphicon-hdd"></i> 广告管理</a>
            </li>
            <li style="height:30px;">
                <a href="${APP_PQTH}/message.htm"><i class="glyphicon glyphicon-comment"></i> 消息模板</a>
            </li>
            <li style="height:30px;">
                <a href="${APP_PQTH}/project_type.htm"><i class="glyphicon glyphicon-list"></i> 项目分类</a>
            </li>
            <li style="height:30px;">
                <a href="${APP_PQTH}/tag.htm"><i class="glyphicon glyphicon-tags"></i> 项目标签</a>
            </li>
        </ul>
    </li>
    <li class="list-group-item tree-closed">
        <a href="${APP_PQTH}/param.htm"><i class="glyphicon glyphicon-list-alt"></i> 参数管理</a>
    </li>

    <%--<c:forEach items="${rootPermission.children}" var="childPermission">--%>
        <%--<c:if test="empty childPermission.children">--%>
            <%--<li class="list-group-item tree-closed">--%>
                <%--<a href="${APP_PATH}${childPermission.url}"><i--%>
                        <%--class="${childPermission.icon}">${childPermission.name}</i></a>--%>
            <%--</li>--%>
        <%--</c:if>--%>
        <%--<c:if test="${not empty childPermission.children}">--%>
            <%--<li class="list-group-item tree-closed">--%>
                <%--<span><i class="${childPermission.icon}"></i>${childPermission.name}<span class="badge"--%>
                                                                                          <%--style="float:right">${fn:length(childPermission.children)}</span></span>--%>
                <%--<ul style="margin-top:10px;display:none;">--%>
                    <%--<c:forEach items="${childPermission.children}" var="childrenPermission">--%>
                        <%--<li style="height: 30px;">--%>
                            <%--<a href="${APP_PATH}${childPermission.url}"><i--%>
                                    <%--class="${childPermission.icon}"></i>${childPermission.name}</a>--%>
                        <%--</li>--%>
                    <%--</c:forEach>--%>
                <%--</ul>--%>
            <%--</li>--%>
        <%--</c:if>--%>
    <%--</c:forEach>--%>
</ul>
