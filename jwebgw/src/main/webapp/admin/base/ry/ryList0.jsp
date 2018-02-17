<%@include file="/WEB-INF/jspf/power/adminUserPower.jspf"%>
<%    if (!pck.checkUserORAdmin("J43_1")) {
        return;
    }
    boolean update, dell;
    update = pck.checkUserORAdmin("J43_2");
    dell = pck.checkUserORAdmin("J43_3");
    String showPower = pck.getStrTool()
            .put(update, "{text: '审核', click: update}")
            .put(true, "{line: true}")
            .put(dell, "{text: '删除', click: dell}")
            .getString();
%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <!--        <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
                <link rel="stylesheet" href="lib/bootstrap/css/bootstrap-theme.min.css" />
                <script src="lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>-->
        <script type="text/javascript" src="admin/base/bm/js/bm_treeMenu.js"></script>

        <script type="text/javascript">
            var GRID;
            $(function () {
                var Gobj = new GJS();
                Gobj.JT();
                
                wt_bm_menu("divID_Tree", function (data) {
                    $("#bm_id").val(data.data['bm_id']);
                    /* $("#bm_name").val(data.data['bm_name']); */
                    var id = getMyNodeID("bm_id", data.data);
                    id = "'" + id.replace(/,/g, "','") + "'";
                    GRID.setParm("bm_id", id);
                    GRID.setParm("nameOrAccount", $("#nameOrAccount").val());
                    GRID.reload();
                });

                GRID = $("#divID_GRID").ligerGrid({
                    columns: [
                        {display: '部门', name: 'bm_name', width: 125, align: 'center'}
                        , {display: '岗位', name: 'gw_name', width: 75, align: 'center'}
                        , {display: '名字', name: 'ry_name', width:95, align: 'center'}
                        , {display: '账号', name: 'ry_account', width: 80, align: 'center'}
                        , {display: '性别', name: 'ry_sex', width: 46, align: 'center'}
                        , {display: '入职日期', name: 'ry_cdate', width:75, align: 'center'}
                        , {display: '人员类别', name: 'ry_sort', width: 70, align: 'center', render: function (item) {
                                switch (item.ry_sort) {
                                    case "0":
                                        return "新建";
                                    case "1":
                                        return "管理员";
                                    case "2":
                                        return "职员";
                                    case "3":
                                        return "职员";
                                    default:
                                        return item.ry_sort;
                                }
                            }
                        }
                        , {display: '通信', name: 'ry_phone', width: 120, align: 'center'}
                        , {display: '邮箱', name: 'ry_email', width: 170, align: 'center'}
                        , {display: '状态', name: 'ry_style', width: 60, align: 'center', render: function (item) {
                                switch (item.ry_style) {
                                    case "0":
                                        return "新建";
                                    case "1":
                                        return "审核";
                                    case "2":
                                        return "停用";
                                    default:
                                        return item.ry_style;
                                }
                            }
                        }
                        , {display: '备注', name: 'ry_info', width: 120, align: 'center'}
                        , {display: 'ry_id', name: 'ry_id', hide: true}
                        , {display: 'bm_id', name: 'bm_id', hide: true}
                        , {display: 'bm_id', name: 'gw_id', hide: true}
                    ]
                    , usePager: true
                    , url: '${path_home}/base/ry/selectVast0.jw'
                    , width: '1000px'
                    , height: Gobj.getHeightPX(30)
                    , checkbox: true
                    , selectRowButtonOnly: true
                            //           , onSelectRow: f_foodimgManager
                });

                $("#toptoolbar").ligerToolBar({items: [<%=showPower%>]});
            });
            function update() {
                var rows = GRID.getSelecteds();
                var ids = "";
                for (var i = 0; i < rows.length; i++) {
                    ids = ids + ",'" + rows[i].ry_id + "'";
                }
                ids = ids.substring(1);
                if (rows.length < 1) {
                    msg_tip("操作提示", "请选择行", 400, 200);
                    return;
                } else {
                    $.ligerDialog.confirm('确认要通过选中的' + rows.length + '个用户注册信息吗?', true, function (yes, value) {
                        if (yes) {
                            if (post_json("${path_home}/base/ry/update0.jw", {"ids": ids})) {
                                GRID.reload();
                            }
                        }
                    })
                }
            }
            function dell() {
                var rows = GRID.getSelecteds();
                var ids = "";
                for (var i = 0; i < rows.length; i++) {
                    ids = ids + ",'" + rows[i].ry_id + "'";
                }
                ids = ids.substring(1);
                if (rows.length < 1) {
                    msg_tip("操作提示", "请选择行", 400, 200);
                    return;
                } else {
                    $.ligerDialog.confirm('确认要删除选中的' + rows.length + '个用户注册信息吗?', true, function (yes, value) {
                        if (yes) {
                            if (post_json("${path_home}/base/ry/dell0.jw", {"ids": ids})) {
                                GRID.reload();
                            }
                        }
                    })
                }
            }

            function f_selectBytitle() {
                GRID.removeParm("bm_id");
                GRID.setParm("nameOrAccount", $("#nameOrAccount").val());
                GRID.reload();
            }

            function f_tonull() {
                GRID.removeParm("nameOrAccount");
                GRID.removeParm("bm_id");
                $("#nameOrAccount").val("");
            }

        </script>
    </head>
    <body>
        <div id="layout1" style="width: 100%">
            <div position="left" style="width: 300px; font-size: small;">
                <div style="overflow: auto; "> <!-- height: auto; -->
                    <div style="margin: 5px;">
                        <button class="btn"  onclick="f_tonull();">X</button>
                        <input type="text"  id="nameOrAccount" /> 
                        <button class="btn"  onclick="f_selectBytitle();">查找</button>	
                    </div>
                    <div id="divID_Tree" style="height: 89%;overflow-y: scroll;">---</div>
                </div>
            </div>

            <div class="l-layout-center" style="top: 0px; left: 300px; height: 100%;">
                <div id="toptoolbar"></div>
                <div id="divID_GRID" style="float: left"></div>
            </div>
        </div>
    </body>
</html>
