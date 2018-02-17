 <%@include file="/WEB-INF/jspf/power/adminPower.jspf"%>
<%   if (!pck.checkAdmin("X2_2_1")) {
        return;
    }
    boolean update, dell;
    update = pck.checkAdmin("X2_2_2");
    dell = pck.checkAdmin("X2_2_3");
    String showPower = pck.getStrTool()
            .put(update, "{text: '修改', click: update, img: path_home + 'lib/ligerUI/skins/icons/modify.gif'}")
            .putByNotEmptyQZ("{line: true}")
            .put(dell, "{text: '删除', click: dell, img: path_home + 'lib/ligerUI/skins/icons/delete.gif'}")
            .getString();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
<!--后台UI组件End-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript"src="sys/role/jsdj/js/jsdj_treeMenu.js"></script>

        <script type="text/javascript">
//-------------------------------全局变量-------------------------------------------------
            var UPDATE;
            var GRID;
            $(function () {
                role_jsdj_menu("divID_Tree", ajaxServerRole)
//                function(data){
//                    alert(data.data['jsdj_zj']);
//                }
                GRID = $('#divID_GRID').ligerGrid({
                    columns: [
                        {display: '名称', name: 'role_name', width: 160, align: 'center'}
                        , {display: '创建时间', name: 'role_create', width: 260, align: 'center'}
                        , {display: '备注', name: 'role_info', width: 260, align: 'center'}

                    ]
                    , usePager: true
                    , rownumbers: true
//                    ,scrollToPage:true
                    , checkbox: true
                    , selectRowButtonOnly: true
                    , url: path_home + 'sys/power/role/s/selectVast.jw'
                    , width: '1080px'
                    , height: '95%'
                    , pageSize: 100
                    , pageSizeOptions: [100, 200, 400, 500, 600, 700]
                    , toolbar: {
                        items: [<%=showPower%>]
                    }
                });

                $("#xsth_S_S").on('click', function () {
                    navtab.selectTabItem("showDataTap");
                    GRID.removeParm("khsc_mc");
                    GRID.removeParm("xsth_rq1");
                    GRID.removeParm("xsth_rq2");
                    GRID.setParm("khsc_mc", $('#khsc_mc').val());
                    GRID.setParm("xsth_rq1", $('#xsth_rq1').val());
                    GRID.setParm("xsth_rq2", $('#xsth_rq2').val());
                    GRID.reload();
                });

            });
//-------------------------------GRID列函数-----------------------------------------------
            function ajaxServerRole(data) {
                var id = null == data ? "" : data.data['jsdj_zj'];
                GRID.removeParm("jsdj_zj");
                GRID.setParm("jsdj_zj", id);
                GRID.reload();
            }
//-------------------------------增删改操作-----------------------------------------------
            function update() {
                var row = GRID.getSelectedRow();
                if (!row) {
                    msg_tip("错误", "请选择行");
                    return;
                } else if (row.role_id.length > 10) {
                    UPDATE = openURL_Event("修改系列", UPDATE, "${path_home}/sys/power/role/u/update/select.jw?selectUpdateID=" + row.role_id, 555, 900, f_d);
                }
                function f_d() {
                    UPDATE = null;
                    GRID.reload();
                }
            }
            function dell() {
                var rows = GRID.getSelectedRows();
                var ids = "";
                for (var i = 0; i < rows.length; i++) {
                    ids = ids + "," + rows[i].role_id;
                }
                ids = ids.substring(1);
                if (rows.length < 1) {
                    msg_tip("操作提示", "请选择行", 200, 100);
                    return;
                } else {
                    $.ligerDialog.confirm('请确认删除', function (yes, value) {
                        if (yes == true) {
                            if (post_json("${path_home}/sys/power/role/d/dell.jw", {"ids": ids})) {
                                GRID.reload();
                            }
                        }
                    });
                }
            }
        </script>
    </head>
    <body>  

        <div id="layout1" style="width: 100%">
            <div position="left">
                 <div style="overflow: auto; "> <!-- height: auto; -->
                    <div style="margin: 5px;">
                        <button class="btn"  onclick="ajaxServerRole();">列出所有角色</button>	
                    </div>
                    <div id="divID_Tree" style="height: 89%;overflow-y: scroll;">---</div>
                </div>
            </div>

            <div class="l-layout-center" style="top: 0px; left: 150px; height: 100%;">
                <div id="toptoolbar"></div>
                <div id="divID_GRID" style="float: left"></div>
            </div>
        </div>
    </body>
</html>
