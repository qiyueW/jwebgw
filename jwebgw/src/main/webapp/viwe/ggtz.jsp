<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jspf/zuiAndJQ.jspf"%>
        <title>发布与公告</title>
        <script>
            $(function () {
                var Gobj = new GJS();
                Gobj.setElementHeight("treeIDShowDIV", 250);
                $('#mendianModelID').on('hide.zui.modal', function () {
                    $(this).removeData("zui.modal");
                    $("#contentBoxShowID1").html("");
                })
                Gobj.setElementHeight("contentBoxShowID1", 70)
                var divW = $("#treeIDShowDIV").width();
                $("#treeIDShowDIV2_0").width(divW - 17);
                $("#treeIDShowDIV").width(divW);
            });
        </script>
    </head>
    <body style="background-color: #FFFFF4">
        <div class="navbar navbar-inverse navbar-fixed-top navbar-layoutit"style="background-color:#ffffff">
            <!--<div class="navbar-collapse">-->
            <ul  class="nav nav-tabs" >
                <li>
                    <a href="${path_home}/spage/index/s/selectOne.jw">首页</a>
                </li>
                <li class="active">
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
                        <li class="divider"></li>
                        <li>
                            <a href="${path_home}/loginUser.jsp">用户登陆</a>
                        </li>
                        <li class="divider"></li>
                    </ul>
                </li>
            </ul>
            <!--</div>-->
            <!--/.navbar-collapse -->
        </div>
        <!--/.navbar-fixed-top -->
        <div class="container" style=" margin-top: 50px;">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="page-header" style="color: #008">
                        <h2>
                            <p>公告通知</p> <p><small>notice</small></p>
                        </h2>
                    </div>
                    <!--                    -->
                </div>
            </div>
            <div id="treeIDShowDIV2_0" style="overflow:hidden">
                <div id="treeIDShowDIV"style="overflow-y: scroll;">
                    <table class="table table-fixed">
                        <tr>
                            <td>标题</td><td style="width:140px;">时间</td><td style="width:90px;">发布人</td>
                        </tr>
                        <c:forEach var="o" items="${obj}">
                            <tr>
                                <td>
                                    <a href="${path_home}/spage/notice/view/selectOne.jw?id=${o.spage_notice_zj}" data-toggle="modal" data-target="#mendianModelID">${o.spage_notice_biaoti}</a>
                                </td>
                                <td>
                                    ${o.spage_notice_fabushijian}
                                </td>
                                <td>
                                    ${o.spage_notice_zhidanren}
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>

        </div>
        <div class="modal" id="mendianModelID" >
            <div class="modal-dialog modal-fullscreen">
                <div class="modal-content" id="contentBoxShowID1" style="overflow-y: scroll;">

                </div>
                <div class="modal-footer" style=" text-align:center;">

                    <button type="button" class="btn btn-primary" data-dismiss="modal">点我关闭窗口</button>

                </div>
<!--                <div id="updatesayMyIdea" style="margin: 10px;">

                </div>-->
            </div>
        </div>
    </body>
</html>
