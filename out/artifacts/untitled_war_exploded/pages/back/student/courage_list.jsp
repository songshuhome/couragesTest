<%@ taglib prefix="c" uri="http://www.ylcto.cn/c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://"
                + request.getServerName() + ":" + request.getServerPort()
                + path + "/";
    %>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <base href="<%=basePath%>">
    <title>江农课检系统</title>
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/basic.css" rel="stylesheet" />
    <link href="assets/css/custom.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<div id="wrapper">
    <jsp:include page="/pages/back/student/studentHeader.jsp"></jsp:include>
    <!-- 此处编写内容  -->
    <div id="page-wrapper">

        <div id="page-inner">

            <div class="col-md-12">
                <div class="col-md-9 col-md-offset-2" style="padding-top: 15%">
                    <c:if test="${allcourage==null}">
                      <h2 class="col-md-4 col-md-offset-4 color-bar fa-font h2 text-success" >没课休息<h2>
                    </c:if>
                    <c:if test="${allcourage!=null}">
                        <c:forEach items="${allcourage}" var="courage">
                             <table class="table active text-primary  font-menu-button color-bar" >
                                 <tr bgcolor="#eee8aa " aria-setsize="6">
                                     <td >班级</td>
                                     <td>${courage.grade}</td>
                                 </tr>
                                 <tr>
                                     <td>课程</td>
                                     <td>${courage.lesson}</td>
                                 </tr>
                                 <tr>
                                     <td>日期</td>
                                     <td>${courage.date}</td>
                                 </tr>
                                <tr>
                                     <td>地点</td>
                                     <td>${courage.site}</td>
                                 </tr>

                                 <tr>
                                     <td>老师</td>
                                     <td>${courage.teacher}</td>
                                 </tr>

                             </table>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/pages/back/footer.jsp"></jsp:include>
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="assets/js/jquery.metisMenu.js"></script>
    <script src="assets/js/custom.js"></script>
</body>
</html>
