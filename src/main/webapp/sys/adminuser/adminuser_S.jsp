<%@include file="/WEB-INF/jspf/power/superAminPower.jspf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <script type="text/javascript">
            var GRID;
            $(function () {
                GRID = $("#divID_GRID").ligerGrid({
                    columns: [
                        {display: '部门', name: 'bm_name', width: 200, align: 'center'}
                        , {display: '用户名', name: 'user_name', width: 90, align: 'center', render: function (item) {
                                return "<a href=\"javascript:void(0)\" onclick=\"selectone('" + item.user_id + "')\">" + item.user_name + "</a>"
                            }}
                        , {display: '账号', name: 'user_account', width: 110, align: 'center'}
                        , {display: '上次登陆时间', name: 'user_uptimelogin', width: 130, align: 'center'}
                        , {display: '邮箱', name: 'user_email', width: 160, align: 'center'}
                        , {display: '类别', name: 'user_sort', width: 60, align: 'center'}
                        , {display: '状态', name: 'user_style', width: 50, align: 'center'}
                        , {display: '创建时间', name: 'user_time', width: 130, align: 'center'}
                    ]
                    , usePager: false
                    , url: '${path_home}/sys/power/adminuser/s/selectVast.jw'
                    , width: '1000px'
                    , height: '700px'
                    , checkbox: true
                    , selectRowButtonOnly: true
                    , toolbar: {
                        items: [
                            {text: '删除', click: dell, img: path_home + 'lib/ligerUI/skins/icons/delete.gif'}
                            , {line: true}
                            , {text: '修改', click: update, img: path_home + 'lib/ligerUI/skins/icons/modify.gif'}
                            , {line: true}
                            , {text: '停用|启用', click: update12, img: path_home + 'lib/ligerUI/skins/icons/settings.gif'}
                        ]
                    }
                });
            });
            function update12() {
                var rows = GRID.getSelecteds();
                var ids = "";
                for (var i = 0; i < rows.length; i++) {
                    ids = ids + ",'" + rows[i].user_id + "'";
                }
                ids = ids.substring(1);
                if (rows.length < 1) {
                    msg_tip("操作提示", "请选择行", 400, 200);
                    return;
                } else {
                    $.ligerDialog.confirm('确认要对选中的' + rows.length + '个用户进行反状态操作吗?', true, function (yes, value) {
                        if (yes) {
                            if (post_json("${path_home}/sys/power/adminuser/u/updateStyle.jw", {"ids": ids})) {
                                GRID.reload();
                            }
                        }
                    })
                }
            }
            var SELECTONE;
            function selectone(id) {
                SELECTONE = openURL_Event("明细", SELECTONE, "${path_home}/sys/power/adminuser/s/selectOne.jw?id=" + id, 555, 670, f_d);
                function f_d() {
                    SELECTONE = null;
                }
            }
            var UPDATE;
            function update() {
                var row = GRID.getSelectedRow();
                if (!row) {
                    msg_tip("操作提示", "请选择行", 400, 200);
                    return;
                } else if (row.user_id.length > 10) {
                    UPDATE = openURL_Event("修改系列", UPDATE, "${path_home}/sys/power/adminuser/u/update/select.jw?selectUpdateID=" + row.user_id, 555, 870, f_d);
                }
                function f_d() {
                    UPDATE = null;
                    GRID.reload();
                }
            }

            function dell() {
                var rows = GRID.getSelecteds();
                var ids = "";
                for (var i = 0; i < rows.length; i++) {
                    ids = ids + ",'" + rows[i].user_id + "'";
                }
                ids = ids.substring(1);
                if (rows.length < 1) {
                    msg_tip("操作提示", "请选择行", 400, 200);
                    return;
                } else {
                    $.ligerDialog.confirm('确认要删除选中的' + rows.length + '个用户注册信息吗?', true, function (yes, value) {
                        if (yes) {
                            if (post_json("${path_home}/sys/power/adminuser/d/dell.jw", {"ids": ids})) {
                                GRID.reload();
                            }
                        }
                    })
                }
            }
        </script>
    </head>
    <body>

        <div id="divID_GRID" style="float: left"></div>
    </body>
</html>
