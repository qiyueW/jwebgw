<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/power/adminUserPower.jspf"%>
<%    if (!pck.checkUser("Y100_3_1")) {
        return;
    }
    boolean update, dell;
    update = pck.checkUserORAdmin("Y100_3_2");
    dell = pck.checkUserORAdmin("Y100_3_3");
    String path = application.getAttribute("path_home").toString();
    String showPower = pck.getStrTool()
            .put(update, " ", "\"<a href=\\\"" + path + "/spage/jingyanku/u/selectOne.jw?selectUpdateID=\"+id+\"\\\"   target=\\\"_blank\\\">修改</a>  \"")
            .put(dell, "+", "\"<a href=\\\"javascript:void(0)\\\" onclick=\\\"dell('\" + id + \"')\\\">删除</a>  \"")
            .getString();
%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
<%@include file="/WEB-INF/jspf/artDialog.jspf"%>
<%@include file="/WEB-INF/jspf/ztree.jspf"%>

<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <!--        <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
                <link rel="stylesheet" href="lib/bootstrap/css/bootstrap-theme.min.css" />
                <script src="lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>-->
        <script type="text/javascript">
            var GRID;
            var SHOWVASTBM = true;
            function dell(id) {
                ccomfire("${path_home}/spage/jingyanku/d/dell.jw", {id: id}, "请确认删除操作", function (sd) {
//                    aalert(sd.msg);
                    if (sd.statusCode == 1) {
                        GRID.reload();
                    }
                })
            }
            $(function () {
//                $("#mylayoutBJ").ligerLayout({leftWidth: 200}); //这一句可是关键啊
                var Gobj = new GJS();
                Gobj.JT();
                Gobj.setElementHeight("treeIDShowDIV", 50)
//                Gobj.setElementHeight("treeIDShowDIV2", 50)
                //divID_Tree


                GRID = $("#divID_GRID").ligerGrid({
                    columns: [
                        {display: '分类名', name: 'jingyankufl_name', width: 100, align: 'left'}
                        , {display: '标题', name: 'spage_jingyanku_biaoti', width: 190, align: 'left', render: function (item) {
                                return "<a href=\"${path_home}/spage/jingyanku/s/selectOne.jw?selectUpdateID=" + item.spage_jingyanku_zj + "\" target=\"_blank\">" + item.spage_jingyanku_biaoti + "</a>"
                            }}
                        , {display: '制单人', name: 'spage_jingyanku_zhidanren', width: 100, align: 'left'}
                        , {display: '发布时间', name: 'spage_jingyanku_fabushijian', width: 140, align: 'center'}
                        , {display: '制单时间', name: 'spage_jingyanku_zhidanshijian', width: 140, align: 'center'}
                        , {display: '操作', name: 'wtjh_cdate', width: 90, align: 'center', render: function (item) {
//                                return "<a href=\"${path_home}/spage/jingyanku/u/selectOne.jw?selectUpdateID=" + item.spage_jingyanku_zj + "\" target=\"_blank\">修改</a>";
                                var id = item.spage_jingyanku_zj;
                                return <%=showPower%>
                            }}
                    ]
                    , usePager: true
                    , url: '${path_home}/spage/jingyanku/s/selectVast.jw'
                    , width: '99%'
                    , height: Gobj.getHeightPX(50)
                });

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
                            GRID.setParm("jingyankufl_id", id);
                            GRID.reload();
                        },
                        onAsyncSuccess: function () {
                            $.fn.zTree.getZTreeObj("divID_Tree").expandAll(true);
                        }
                    }
                };
                $.fn.zTree.init($("#divID_Tree"), setting0);
            });
        </script>
    </head>
    <body>
        <table>
            <tr>
                <td>
                    <div style=" margin-left: 9px"><input type="checkbox" id="showTreeVastID" checked>多层展示</div>
                    <div id="treeIDShowDIV" style="overflow-y:scroll; width:300px;">
                        <div id="divID_Tree" class="ztree"></div>
                    </div>
                </td>
                <td>
                     <div id="divID_GRID"></div>
                </td>
            </tr>
        </table>
        <!--        
                <div id="mylayoutBJ">
                    <div position="left" >
                        <div id="showtreeF" style="overflow-y: scroll">
                            <div style=" margin-left: 9px"><input type="checkbox" id="showTreeVastID" checked>多层展示</div>
                            <div id="divID_Tree"  class="ztree">---</div>
                        </div>
                    </div>
                    <div position="center">
                        <div id="divID_GRID"></div>
                    </div>
                </div>-->

    </body>
</html>
