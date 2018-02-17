<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name=Keywords content="JWeb JWeb框架 JWeb官网 框架 mvc框架 jweb 框架 java">
        <meta name=Description content="JWeb框架 高效、创新、小巧且强健">
        <meta name=renderer content=webkit>
        <%@include file="/WEB-INF/jspf/zuiAndJQ.jspf"%>
        <title>您好</title>
    </head>
    <body style="background-color: #FFFFF4">
        <!--background-color: #FFFFF4-->
        <div class="navbar navbar-inverse navbar-fixed-top navbar-layoutit"style="background-color:#ffffff">
            <!--<div class="navbar-collapse">-->
            <ul  class="nav nav-tabs" >
                <li class="active">
                    <a href="#">首页</a>
                </li>
                <li>
                    <a href="${path_home}/spage/notice/view/selectVast.jw">发布与公告</a>
                </li>
                <li>
                    <a href="${path_home}/viwe/jingyanku.jsp">经验库</a>
                </li>

                <li class="dropdown pull-right">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">人员通道<strong class="caret"></strong></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="${path_home}/viwe/ryzhuce.jsp">人员注册</a>
                        </li>
                        <li>
                            <a href="${path_home}/loginUser.jsp">用户登陆</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!--</div>-->
            <!--/.navbar-collapse -->
        </div>
        <!--/.navbar-fixed-top -->
        ${obj.spage_indexpage_neirong}
    </body>
</html>
