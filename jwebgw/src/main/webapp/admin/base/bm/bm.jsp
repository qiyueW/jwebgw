<%@include file="/WEB-INF/jspf/power/adminUserPower.jspf"%>
<%    if (!pck.checkUserORAdmin("J51_1")) {
        return;
    }
    boolean update, dell;
    update = pck.checkUserORAdmin("J51_2");
    dell = pck.checkUserORAdmin("J51_3");
    String path = application.getAttribute("path_home").toString();
    String showPower = pck.getStrTool()
            .put(dell, "{text: '删除', click: dell}")
            .put(true, "{line: true}")
            .put(update, "{text: '修改', click: update}")
            .put(true, "{line: true}")
            .put(true, "{text: '导出', click: downExcel}")
            .getString();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
<!--后台UI组件End-->

<!DOCTYPE html>
<html>
    <head>
        <title>JSP Page</title>
        <script type="text/javascript">
//-------------------------------全局变量-------------------------------------------------
            var UPDATE;
            var GRID;
            var ADD;

            $(function () {
                var Gobj = new GJS();
                Gobj.JT();
                GRID = $("#divID_GRID").ligerGrid({
                    columns: [
                        {display: '部门', name: 'bm_name', width: 390, align: 'left'}
                    ], width: '100%'
                    , usePager: false
                    , height: Gobj.getHeightPX(20)
                    , tree: {
                        columnName: 'bm_name'
                                //, columnId: 'bm_id'
                        , idField: 'bm_id'
                        , parentIDField: 'bm_pid'
                    }
                    , url: '${path_home}/base/bm/selectVast/GRID.jw'
                });
                $("#toptoolbar").ligerToolBar({items: [<%=showPower%>]});
            });
//-------------------------------GRID列函数-----------------------------------------------

//-------------------------------增删改操作-----------------------------------------------

            function downExcel() {
                window.location.href="${path_home}/base/bm/office/exceldow.jw";
            }
            function update() {
                var row = GRID.getSelectedRow();
                if (!row) {
                    msg_tip("错误", "请选择行");
                    return;
                } else if (row.bm_id.length > 10) {
                    UPDATE = openURL_Event("修改系列", UPDATE, "${path_home}/base/bm/update/select.jw?selectUpdateID=" + row.bm_id, 555, 900, f_d);
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
                    ids = ids + "," + rows[i].bm_id;
                }
                ids = ids.substring(1);
                if (rows.length < 1) {
                    msg_tip("操作提示", "请选择行", 200, 50);
                    return;
                } else {
                    if (post_json("${path_home}/base/bm/dell.jw", {"ids": ids})) {
                        GRID.reload();
                    }
                }
            }
        </script>
    </head>
    <body>  
        <div id="toptoolbar"></div> 
        <div id="divID_GRID"></div>

    </body>
</html>
