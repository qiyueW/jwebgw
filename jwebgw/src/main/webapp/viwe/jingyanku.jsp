<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="/WEB-INF/jspf/zuiAndJQ.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <title>经验库</title>
        <script>
            var SHOWVASTBM = true;
            var path_home = "${path_home}/";
            function getTableTR(obj) {
                var str = '<tr>'
                        + '<td>' + obj.jingyankufl_name + '</td>'
                        + '<td><a href="' + path_home + 'spage/jingyanku/s/view/selectOne.jw?id=' + obj.spage_jingyanku_zj + '"  data-toggle="modal" data-target="#mendianModelID">' + obj.spage_jingyanku_biaoti + '</a></td>'
                        + '<td>' + obj.spage_jingyanku_fabushijian + '</td>'
                        + '<td>' + obj.spage_jingyanku_zhidanren + '</td>'
                        + '</tr>';
                return str;
            }
            function onButtonFromServer() {
                getDateFromServer(null);
            }
            function getDateFromServer(id) {
                $.post("${path_home}/spage/jingyanku/s/view/selectVast.jw"
                        , {
                            jingyankufl_id: id
                            , bt: $.trim($("#spage_jingyanku_biaoti2").val())
                            , key: $.trim($("#spage_jingyanku_gjc2").val())
                        }, function (data) {
                    var str = "";
                    $("#contentTableID tr:gt(0)").empty();
                    var $tr = $("#contentTableID tr:last");
                    for (var i = 0; i < data.length; i++) {
                        str = str + getTableTR(data[i]);
//                        $tr.after(getTableTR(data[i]));
                    }
                    $tr.after(str);
                }, "json");
            }
            $(function () {
                var Gobj = new GJS();
                Gobj.setElementHeight("treeIDShowDIV", 210);
                Gobj.setElementHeight("treeIDShowDIV2", 180);
//                Gobj.setElementWidthPX("contentTableID", 220)
                $('#mendianModelID').on('hide.zui.modal', function () {
                    $(this).removeData("zui.modal");
                    $("#contentBoxShowID1").html("");
                })
                $("input").keydown(function (event) {
                    if (event.keyCode == 13) {
                        getDateFromServer(null);
                    }
                })

                var divW = $("#treeIDShowDIV2").width();
                $("#treeIDShowDIV2_0").width(divW - 17);
                $("#treeIDShowDIV2").width(divW);
                Gobj.setElementHeight("contentBoxShowID1", 70)
                var setting0 = {
                    treeId: "jingyankufl_id",
                    async: {enable: true, type: "post", url: "${path_home}/base/tree/jingyankufl/s/selectVast.jw"},
                    data: {
                        simpleData: {enable: true, idKey: "jingyankufl_id", pIdKey: "jingyankufl_pid", rootPId: "0"},
                        key: {name: "jingyankufl_name"}
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {//点击部门时，重新加载管理员树。参数为
                            SHOWVASTBM = document.getElementById("showTreeVastID").checked;
                            var id = SHOWVASTBM ? ztree_getNodeSonValue(treeNode, "jingyankufl_id") : treeNode.jingyankufl_id;//动态上传参数
                            getDateFromServer(id);
                        },
                        onAsyncSuccess: function () {
                            $.fn.zTree.getZTreeObj("divID_Tree").expandAll(true);
                        }
                    }
                };
                $.fn.zTree.init($("#divID_Tree"), setting0);


            })
        </script>
    </head>
    <body style="background-color: #FFFFF4">
        <div class="navbar navbar-inverse navbar-fixed-top navbar-layoutit"style="background-color: #ffffff">
            <!--<div class="navbar-collapse">-->
            <ul  class="nav nav-tabs" >
                <li>
                    <a href="${path_home}/spage/index/s/selectOne.jw">首页</a>
                </li>
                <li>
                    <a href="${path_home}/spage/notice/view/selectVast.jw">发布与公告</a>
                </li>
                <li class="active">
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
                        <table>
                            <tr>
                                <td>标题</td><td><input type="text" autocomplete="false" id="spage_jingyanku_biaoti2"/></td>
                                <td rowspan="2">
                                    <div><button onclick="onButtonFromServer();">执行查询</button></div>
                                </td>
                            </tr>
                            <tr>
                                <td>关键词</td><td><input type="text" autocomplete="false" id="spage_jingyanku_gjc2"/></td>
                            </tr>
                        </table>
                    </div>
                    <!--                    -->
                </div>
            </div>
            <div class="row clearfix">
                <table>
                    <tr>
                        <td>
                            <div style=" margin-left: 9px"><input type="checkbox" id="showTreeVastID" checked>多层展示</div>
                            <div id="treeIDShowDIV" style="overflow-y:scroll; width:200px;">
                                <div id="divID_Tree" class="ztree"></div>
                            </div>
                        </td>
                        <td>
                            <div id="treeIDShowDIV2_0" style="overflow:hidden">
                                <div id="treeIDShowDIV2" style="overflow-y:scroll;">
                                    <table class="table table-fixed"  id="contentTableID">
                                        <tr>
                                            <td style="width:130px;">归档类别</td><td>标题</td><td style="width:145px;">时间</td><td style="width:85px;">发布人</td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </td>

                    </tr>
                </table>
            </div>
        </div>
        <div class="modal" id="mendianModelID" >
            <div class="modal-dialog modal-fullscreen">
                <div class="modal-content" id="contentBoxShowID1" style="overflow-y: scroll;">

                </div>
                <div class="modal-footer" style=" text-align:center;">

                    <button type="button" class="btn btn-primary" data-dismiss="modal">点我关闭窗口</button>

                </div>
                <div id="updatesayMyIdea" style="margin: 10px;">

                </div>
            </div>
        </div>
    </body>
</html>
