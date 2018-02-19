 <!--%@include file="/WEB-INF/jspf/power/userPower.jspf"%-->
<!--%    if (!pck.checkUser("J32_1")) {
        return;
    }
    boolean update, dell;
    update = pck.checkUser("J32_2");
    dell = pck.checkUser("J32_3");
    String showPower = pck.getStrTool()
            .put(update, "{text: '修改', click: update}")
            .put(true, "{line: true}")
            .put(dell, "{text: '删除', click: dell}")
            .getString();
%-->
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
                GRID = $('#divID_GRID').ligerGrid({
                    columns: [
                         {display: '排序', name: 'mybean_px', width:50, align: 'center'}
//                        ,{display: '代号', name: 'mybean_dm', width: 160, align: 'center'}
                        , {display: '名称', name: 'mybean_mc', width: 260, align: 'center'}
                        , {display: '备注', name: 'mybean_bz', width: 260, align: 'center'}
//                        , {display: '主键', name: 'mybean_zj', hide: true}
                    ]
                    , usePager: false
                    , url: path_home + 'cc/mybean/s/selectVast.jw'
                    , width: '800'
                    , height: '95%'
                });
                $("#toptoolbar").ligerToolBar({items: [
                       <!--%=showPower%-->
                       {text: '修改', click: update},{text: '删除', click: dell}
                    ]});
            });
//-------------------------------GRID列函数-----------------------------------------------

//-------------------------------增删改操作-----------------------------------------------
            function update() {
                var row = GRID.getSelectedRow();
                if (!row) {
                    msg_tip("错误", "请选择行");
                    return;
                } else if (row.mybean_zj.length > 10) {
                    UPDATE = openURL_Event("修改系列", UPDATE, "${path_home}/cc/mybean/u/update/select.jw?selectUpdateID=" + row.mybean_zj, 555, 900, f_d);
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
                    ids = ids + "," + rows[i].mybean_zj;
                }
                ids = ids.substring(1);
                if (rows.length < 1) {
                    msg_tip("操作提示", "请选择行", 200, 50);
                    return;
                } else {
                    $.ligerDialog.confirm('请确认删除', function (yes, value) {
                        if (yes == true) {
                            if (post_json("${path_home}/cc/mybean/d/dell.jw", {"ids": ids})) {
                                GRID.reload();
                            }
                        }
                    });

                }
            }
        </script>
    </head>
    <body>  
        <div id="toptoolbar"></div> 
        <div id="divID_GRID" style="margin:0; padding:0"></div>
    </body>
</html>
