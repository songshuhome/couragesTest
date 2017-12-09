<%@ taglib prefix="c" uri="http://www.ylcto.cn/c" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
            <span class="sr-only">江农课检系统</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/pages"/back/index.jsp>江农课检系统</a>
    </div>
    <!--顶部-->
    <div class="header-right">
        <a href="/pages/back/AdminServlet/logout" class="btn btn-danger" title="Logout"> 退出系统</a>
    </div>
</nav>
<!-- 导航 -->
<nav class="navbar-default navbar-side" role="navigation">
    <div class="sidebar-collapse">
        <ul class="nav" id="main-menu">
            <li>
                <div class="user-img-div">
                    <img src="assets/img/jxau.jpg" class="img-thumbnail" />

                    <div class="inner-text">
                           登录人员:${name}
                        <br />
                        <small>上次登录日期:
                            <c:if test="${lastdate!=null}">
                                ${lastdate}

                            </c:if>
                        </small>
                    </div>
                </div>
            </li>

            <li>
                <a class="active-menu" href="index.html"><i class="fa fa-dashboard "></i>导航</a>
            </li>
            <!--用户信息-->
            <li>
                <a href="#"><i class="fa fa-desktop "></i>用户管理 <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="/pages/back/member/member_insert.jsp"><i class="fa fa-toggle-on"></i>用户录入</a>
                    </li>
                </ul>
            </li>
            <!--管理员信息-->
            <c:if test="${flag==1}">
                <li>
                    <a href="#"><i class="fa fa-yelp"></i>超级管理员操作<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/pages/back/admin/admin_insert.jsp"><i class="fa fa-toggle-on"></i>增加管理员</a>
                        </li>
                    </ul>
                </li>
            </c:if>
            <!--人员管理-->
            <li>
                <a href="#"><i class="fa fa-yelp "></i>蓝点成员管理 <span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="invoice.html"><i class="fa fa-coffee"></i>增加人员</a>
                    </li>
                    <li>
                        <a href="/pages/back/member/MemberServlet"><i class="fa fa-flash "></i>人员列表</a>
                    </li>
                </ul>
            </li>
            <!--任务情况-->
            <li>
                <a href="#"><i class="fa fa-bicycle "></i>任务情况<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <li>
                        <a href="form.html"><i class="fa fa-desktop "></i>任务完成情况 </a>
                    </li>
                </ul>
            </li>


        </ul>
    </div>
</nav>