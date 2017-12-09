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
    <jsp:include page="/pages/back/teacher/teacherHeader.jsp"></jsp:include>
    <!-- 此处编写内容  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <c:if test="${allstudent != null}">
                <table class="table table-border">
                    <tr>
                        <th>签到</th>
                        <th>请假</th>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>班级</th>
                        <th>联系电话</th>
                    </tr>
                    <c:forEach items="${allstudent}" var="student">
                        <tr>
                            <td>
                                <c:if test="${student.flag == null}">

                                </c:if>
                                <c:if test="${student.flag == 1}">
                                       缺到
                                </c:if>
                            </td>
                            <td>
                                <c:if test="${student.statu == 1}">
                                    请假
                                </c:if>
                                <c:if test="${student.statu == null}">

                                </c:if>
                            </td>
                            <td>${student.sid}</td>
                            <td>${student.name}</td>
                            <td>${student.grade}</td>
                            <td>${student.phone}</td>
                        </tr>
                    </c:forEach>
                </table>
                <div class="col-md-5 col-md-offset-5">
                    <jsp:include page="/pages/split_bar.jsp"></jsp:include>
                </div>
            </c:if>
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

