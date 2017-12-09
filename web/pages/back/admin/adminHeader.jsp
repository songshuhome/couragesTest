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
        <a class="navbar-brand" href="/pages/login.jsp">江农课检系统</a>
    </div>
    <!--顶部-->
    <div class="header-right">
        <a href="/pages/back/DAOServlet/logout" class="btn btn-danger" title="Logout"> 退出系统</a>
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
                <a class="active-menu" href="/login.jsp"><i class="fa fa-dashboard "></i>导航</a>
            </li>
            <!--用户信息-->
            <c:if test="${flag!=1}">
            <li>
                <a href="#"><i class="fa fa-desktop "></i>课检统计<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">
                    <%--<li>--%>
                        <%--<a href="/pages/Lchart/login "><i class="fa fa-toggle-on"></i>每周统计</a>--%>
                    <%--</li>--%>
                    <li>
                        <a href="/pages/back/admin/adminChart.jsp"><i class="fa fa-toggle-on"></i>每月统计</a>
                    </li>

                </ul>
            </li>
             </c:if>
            <!--超级管员功能-->
               <c:if test="${flag==1}">
                   <li>
                       <a href="#"><i class="fa fa-yelp"></i>超级管理员操作<span class="fa arrow"></span></a>
                       <ul class="nav nav-second-level">
                           <li>
                               <a href="/pages/back/admin/adminInsert.jsp"><i class="fa fa-toggle-on"></i>增加管理员</a>
                           </li>
                           <%--<li>--%>
                               <%--<a href="/pages/back/teacher/studentmark.jsp"><i class="fa fa-toggle-on"></i>统计表</a>--%>
                           <%--</li>--%>
                       </ul>
                   </li>
               </c:if>
            <!--请假签到-->
            <li>
                <a href="#"><i class="fa fa-yelp "></i>课检查询<span class="fa arrow"></span></a>
                <ul class="nav nav-second-level">

                    <li>
                        <a href="/pages/back/admin/students_char.jsp"><i class="fa fa-toggle-on"></i>个人课检查询</a>
                    </li>
                    <li>
                        <a href="/pages/back/admin/gradeAbsent.jsp"><i class="fa fa-toggle-on"></i>班级课检查询</a>
                    </li>
                </ul>
            </li>

        </ul>
    </div>
</nav>
