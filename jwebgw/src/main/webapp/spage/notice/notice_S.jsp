<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/power/adminUserPower.jspf"%>
<%    if (!pck.checkUser("Y100_1_1")) {
        return;
    }
    boolean update, dell;
    update = pck.checkUserORAdmin("Y100_1_2");
    dell = pck.checkUserORAdmin("Y100_1_3");
    String path = application.getAttribute("path_home").toString();
    String showPower = pck.getStrTool()
            .put(update, " ", "\"<a href=\\\"" + path + "/spage/notice/u/selectOne.jw?selectUpdateID=\"+id+\"\\\"   target=\\\"_blank\\\">修改</a>  \"")
            .put(dell, "+", "\"<a href=\\\"javascript:void(0)\\\" onclick=\\\"dell('\" + id + \"')\\\">删除</a>  \"")
            .getString();
%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
<%@include file="/WEB-INF/jspf/artDialog.jspf"%>


<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <!--        <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
                <link rel="stylesheet" href="lib/bootstrap/css/bootstrap-theme.min.css" />
                <script src="lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>-->
        <script type="text/javascript">
            var GRID;
            function dell(id) {
                ccomfire("${path_home}/spage/notice/d/dell.jw", {id: id}, "请确认删除操作",function (sd) {
                    if (sd.statusCode == 1) {
                        GRID.reload();
                    }
                })
            }
            $(function () {
                var Gobj = new GJS();
                Gobj.JT();
                GRID = $("#divID_GRID").ligerGrid({
                    columns: [
                        {display: '标题', name: 'spage_notice_biaoti', width: 190, align: 'left', render: function (item) {
                                return "<a href=\"${path_home}/spage/notice/selectOne.jw?selectUpdateID=" + item.spage_notice_zj + "\" target=\"_blank\">" + item.spage_notice_biaoti + "</a>"
                            }}
                        , {display: '制单人', name: 'spage_notice_zhidanren', width: 100, align: 'left'}
                        , {display: '发布时间', name: 'spage_notice_fabushijian', width: 140, align: 'center'}
                        , {display: '制单时间', name: 'spage_notice_zhidanshijian', width: 140, align: 'center'}
                        , {display: '操作', name: 'wtjh_cdate', width: 90, align: 'center', render: function (item) {
//                                return "<a href=\"${path_home}/spage/notice/u/selectOne.jw?selectUpdateID=" + item.spage_notice_zj + "\" target=\"_blank\">修改</a>";
                                var id = item.spage_notice_zj;
                                return <%=showPower%>
                            }}
                    ]
                    , usePager: true
                    , url: '${path_home}/spage/notice/selectVast.jw'
                    , width: '99%'
                    , height: Gobj.getHeightPX(20)
                });
            });
        </script>
    </head>
    <body>
        <div id="divID_GRID"></div>
    </body>
</html>
