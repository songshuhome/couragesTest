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
                <div class="col-md-6 col-md-offset-4" style="padding-top: 25%">
                    <h1 class="h1 text-primary">欢迎登录江农课检系统</h1>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/pages/back/footer.jsp"></jsp:include>
    <script src="assets/js/jquery-1.10.2.js"></script>
    <script src="assets/js/bootstrap.js"></script>
    <script src="assets/js/jquery.metisMenu.js"></script>
    <script src="assets/js/custom.js"></script>
        <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=q0QGeu2AFgkdtlSgU2wSuAgOVHplbqGy"></script>
        <script type="text/javascript">
           function  getPath() {
               // 百度地图API功能
               var map = new BMap.Map("allmap");
               var point = new BMap.Point(116.331398,39.897445);
               map.centerAndZoom(point,12);
               var thispoint;

               var geolocation = new BMap.Geolocation();
               geolocation.getCurrentPosition(function(r){
                   if(this.getStatus() == BMAP_STATUS_SUCCESS){
                       var mk = new BMap.Marker(r.point);
                       map.addOverlay(mk);
                       map.panTo(r.point);
                       thispoint=r.point.lng;
                       alert('您的位置：'+r.point.lng+','+r.point.lat);
                       if(thispoint>=100&&thispoint<=120){
                           return "/pages/back/student/studentleave.jsp"
                       }
                       else{
                            return "/pages/back/student/studentLogin.jsp";
                       }
                   }
                   else {
                       alert('failed'+this.getStatus());
                       return  "/pages/back/student/studentLogin.jsp";
                   }
               },{enableHighAccuracy: true})
               //关于状态码
               //BMAP_STATUS_SUCCESS	检索成功。对应数值“0”。
               //BMAP_STATUS_CITY_LIST	城市列表。对应数值“1”。
               //BMAP_STATUS_UNKNOWN_LOCATION	位置结果未知。对应数值“2”。
               //BMAP_STATUS_UNKNOWN_ROUTE	导航结果未知。对应数值“3”。
               //BMAP_STATUS_INVALID_KEY	非法密钥。对应数值“4”。
               //BMAP_STATUS_INVALID_REQUEST	非法请求。对应数值“5”。
               //BMAP_STATUS_PERMISSION_DENIED	没有权限。对应数值“6”。(自 1.1 新增)
               //BMAP_STATUS_SERVICE_UNAVAILABLE	服务不可用。对应数值“7”。(自 1.1 新增)
               //BMAP_STATUS_TIMEOUT	超时。对应数值“8”。(自 1.1 新增)

           }

        </script>
</body>
</html>
