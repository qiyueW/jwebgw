<%@include file="/WEB-INF/jspf/power/adminUserPower.jspf"%>
<%    if (!pck.checkUser("J7_2_2_1")) {
        return;
    }
    boolean update, dell;
    update = pck.checkUserORAdmin("J7_2_2_2");
    dell = pck.checkUserORAdmin("J7_2_2_3");
    String showPower = pck.getStrTool()
            .put(update, "{text: '修改', click: update}")
            .put(true, "{line: true}")
            .put(dell, "{text: '删除', click: dell}")
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
//-------------------------------全局变量-------------------------------------------------
            var UPDATE;
            var GRID;
            var ADD;
            $(function () {
                var Gobj=new GJS();
                
                GRID = $("#divID_GRID").ligerGrid({
                    columns: [
                        {display: '名称', name: 'jingyankufl_name', width: 390, align: 'left'}
                    ], width: '100%'
                    , usePager: false
                    , height:Gobj.getHeightPX(50)
                    , tree: {
                       columnName: 'jingyankufl_name'
                        , columnId: 'jingyankufl_id'
                        , idField: 'jingyankufl_id'
                        , parentIDField: 'jingyankufl_pid'
                    }
                     , url: '${path_home}/base/tree/jingyankufl/s/selectVast/GRID.jw'
                });
                $("#toptoolbar").ligerToolBar({items: [<%=showPower%>]});
            });
//-------------------------------增删改操作-----------------------------------------------
            function update() {
                var row = GRID.getSelectedRow();
                if (!row) {
                    msg_tip("错误", "请选择行");
                    return;
                } else if (row.jingyankufl_id.length > 10) {
                    UPDATE = openURL_Event("修改系列", UPDATE, "${path_home}/base/tree/jingyankufl/u/update/select.jw?selectUpdateID=" + row.jingyankufl_id, 555, 900, f_d);
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
                    ids = ids + "," + rows[i].jingyankufl_id;
                }
                ids = ids.substring(1);
                if (rows.length < 1) {
                    msg_tip("操作提示", "请选择行", 200, 50);
                    return;
                } else {
                    if (post_json("${path_home}/base/tree/jingyankufl/d/dell.jw", {"ids": ids})) {
                        GRID.reload();
                    }
                }
            }
        </script>
    </head>
    <body>  
        <div id="toptoolbar"></div> 
        <div id="divID_GRID" style="margin:0; padding:0"></div>
    </body>
</html>
