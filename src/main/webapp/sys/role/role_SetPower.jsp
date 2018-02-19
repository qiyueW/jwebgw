<%@include file="/WEB-INF/jspf/power/adminPower.jspf"%>
<%    if (!pck.checkAdmin("X2_3")) {
        return;
    }
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%--<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>--%>
<!--后台UI组件End-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script> 
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>

        <script type="text/javascript"src="sys/role/jsdj/js/jsdj_treeMenu.js"></script>
        <script type="text/javascript"src="sys/role/js/role_treeMenu.js"></script>
        <style>
            .powertable{
                border:1px;
            } 
            .tableDivH {
                height:498px; 
            }
            .powertablediv{
                height:498px; 
                overflow-y: scroll;
            }
        </style>
        <script type="text/javascript">
            var jsdj_zj = "";
            $(function () {
//======================================================================================================                
//检出分类树                  
                var setting0 = {
                    treeId: "jsdj_zj",
                    async: {enable: true, type: "post", url: "${path_home}/sys/power/jsdj/s/selectAllByJson.jw"},
                    data: {
                        simpleData: {enable: true, idKey: "jsdj_zj", rootPId: "0"},
                        key: {name: "jsdj_mc"}
                    }, view: {
                        expandSpeed: ""
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {//点击部门时，重新加载管理员树。参数为
                            jsdj_zj = ztree_getNodeSonValue(treeNode, "jsdj_zj");//动态上传参数
                            $.fn.zTree.getZTreeObj("divID_role_Tree").reAsyncChildNodes(null, "refresh");
                        },
                        onAsyncSuccess: function () {
                            $.fn.zTree.getZTreeObj("divID_Tree").expandAll(true);
                        }
                    }
                };
                $.fn.zTree.init($("#divID_Tree"), setting0);

//======================================================================================================
//检出人员 
                var setting2 = {
                    treeId: "role_id", check: {enable: true},
                    async: {enable: true, type: "post", url: "${path_home}/sys/power/role/s/selectVastByJson.jw",
                        otherParam: ["jsdj_zj", function () {
                                return jsdj_zj;
                            }]
                    },
                    data: {
                        simpleData: {enable: true, idKey: "role_id", rootPId: "0"},
                        key: {name: "role_name"}
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {
                            //点击管理员时，取消权限树所有原有选择。
                            var treeObj = $.fn.zTree.getZTreeObj("divID_Power");
                            treeObj.checkAllNodes(false);
                            //重装上权限
                            if (null != treeNode.role_id && treeNode.role_id.length > 0) {
                                var mynode;
                                $.post("${path_home}/sys/power/role/s/selectOneRolePower.jw", {role_id: treeNode.role_id}, function (d) {
                                    treeObj.expandAll(false);
                                    for (var i = 0; i < d.length; i++) {
                                        mynode = treeObj.getNodeByParam("power_id", d[i].power_id, null);//通过id列，检出节点
                                        if (null != mynode) {//节点不为空，把节点设置为勾选状态
                                            treeObj.checkNode(mynode, true, false);
                                        }
                                    }
                                    ztree_expandNotChoonse("divID_Power")
                                }, "json");
                            }
                        }
                    }
                };
                $.fn.zTree.init($("#divID_role_Tree"), setting2);
//======================================================================================================                
//检出权限树                
                var setting = {
                    treeId: "power_id", check: {enable: true},
                    async: {enable: true, type: "post", url: "${path_home}/sys/admin/manager/p/showMenu.jw"},
                    data: {
                        simpleData: {enable: true, idKey: "power_id", pIdKey: "power_pid", name: "power_name", rootPId: "0"},
                        key: {name: "power_name"}
                    }, view: {
                        expandSpeed: ""
                    }
                };
                $.fn.zTree.init($("#divID_Power"), setting);

            });

//-------------------------------GRID列函数-----------------------------------------------
            function reloadRole() {
                jsdj_zj = "";//动态上传参数
                $.fn.zTree.getZTreeObj("divID_role_Tree").reAsyncChildNodes(null, "refresh");
            }
            function toSetPower() {
                var rp = ztree_getNodesValues("divID_role_Tree", "role_id", 1);
                var pp = ztree_getNodesValues("divID_Power", "power_id", 1);

                if (rp == "") {
                    aalert('请选择将要附值的权限', '操作失误');
//                    alert("请选择将要附值的权限")
                    return;
                }
                ccomfire("${path_home}/sys/power/role/setpower/update.jw"
                        , {role_id: rp, power_id: pp}, '请再次确认重新设置权限操作');
            }
            function toClearPower() {
                var rp = getTreeChecked("divID_role_Tree", "role_id");
                if (rp == "") {
                    $.ligerDialog.warn('请选择需要清空权限的角色！');
                    return;
                }
                $.ligerDialog.confirm('请再次确认【清空角色权限】操作!', function (yes) {
                    if (yes) {
                        alert(rp + "//" + pp);
                    }
                })
            }
//-------------------------------增删改操作-----------------------------------------------
//            function update() {
//                var row = GRID.getSelectedRow();
//                if (!row) {
//                    msg_tip("错误", "请选择行");
//                    return;
//                } else if (row.role_id.length > 10) {
//                    UPDATE = openURL_Event("修改系列", UPDATE, "${path_home}/sys/power/role/u/update/select.jw?selectUpdateID=" + row.role_id, 555, 900, f_d);
//                }
//                function f_d() {
//                    UPDATE = null;
//                    GRID.reload();
//                }
//            }
        </script>
    </head>
    <body>  
        <div style=" min-width: 800px">
            <table class="powertable">
                <tr style="background-color: #00b7ee">
                    <th style=" width: 250px;">角色分类</th>
                    <th style=" width: 250px;">角色</th>
                    <th style=" width: 300px;">权限</th>
                    <th>管理操作</th>
                </tr>
                <tr style=" height:500px">
                    <td style=" background-color:#d4f1ff">
                        <div id="divID_Tree"  class="ztree powertablediv">---</div>
                    </td>
                    <td>
                        <div id="divID_role_Tree" class="ztree powertablediv">角色</div>
                    </td>
                    <td style=" background-color:#d4f1ff">
                        <div id="divID_Power" class="ztree powertablediv">权限</div>
                    </td>
                    <td>
                        <div class="tableDivH">
                            <div style="margin:10px;">
                                <div style="font-size:13px; color: red;">
                                    <a href="javascript:void(0)" onclick="toSetPower();"><div style="color: red;">设置权限</div></a>
                                </div>
                            </div>
                            <div style="margin:10px;">
                                <div style="font-size:12px">
                                    <a href="javascript:void(0)" onclick="reloadRole();">加载<br/>所有角色</a>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
