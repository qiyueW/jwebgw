<%@include file="/WEB-INF/jspf/power/adminPower.jspf"%>
<%    if (!pck.checkAdmin("X3_3")) {
        return;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!--后台UI组件End-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script> 
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
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
//-------------------------------全局变量-------------------------------------------------
            var bm_ids = "";
            var G_role_id = "";
            $(function () {

                //检出部门树                  
                var setting1 = {
                    treeId: "bm_id",
                    async: {enable: true, type: "post", url: "${path_home}/sys/power/user/s/selectVast/myBM.jw"}, //base/bm/selectVast
                    data: {
                        simpleData: {enable: true, idKey: "bm_id", pIdKey: "bm_pid", rootPId: "0"},
                        key: {name: "bm_name"}
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {//点击部门时，重新加载管理员树。参数为
                            bm_ids = ztree_getNodeSonValue(treeNode, "bm_id");//动态上传参数
                            $.fn.zTree.getZTreeObj("divID_Tree_RY").reAsyncChildNodes(null, "refresh");
                        },
                        onAsyncSuccess: function () {
                            $.fn.zTree.getZTreeObj("divID_Tree_BM").expandAll(true);
                        }
                    }
                };
                $.fn.zTree.init($("#divID_Tree_BM"), setting1);
//======================================================================================================
//检出人员 
                var setting2 = {
                    treeId: "ry_id", check: {enable: true},
                    async: {enable: true, type: "post", url: "${path_home}/base/ry/selectVast/adminpower/json.jw",
                        otherParam: ["bm_ids", function () {
                                return bm_ids;
                            }],
                        dataFilter: ajaxDataFilter
                    },
                    data: {
                        simpleData: {enable: true, idKey: "ry_id", rootPId: "0"},
                        key: {name: "ry_name"}
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {
                            var treeObj = $.fn.zTree.getZTreeObj("divID_role_Tree");
//                            treeObj.expandAll(false);
                            treeObj.checkAllNodes(false);
                            //重装上权限
                            if (null != treeNode.ry_id && treeNode.ry_id.length > 0) {
                                var mynode;
                                $.post("${path_home}/sys/power/user/s/selectOneRolePower.jw", {user_id: treeNode.ry_id}, function (d) {
                                    for (var i = 0; i < d.length; i++) {
                                        mynode = treeObj.getNodeByParam("role_id", d[i].role_id, null);//通过id列，检出节点
                                        if (null != mynode) {//节点不为空，把节点设置为勾选状态
                                            treeObj.checkNode(mynode, true, false);
                                        }
                                    }
                                    ztree_expandNotChoonse("divID_Power")
                                }, "json");

                            }
                        }
                    }
                }
                function ajaxDataFilter(treeId, parentNode, responseData) {
                    if (responseData) {
                        for (var i = 0; i < responseData.length; i++) {
                            responseData[i].ry_name = (!responseData[i].bm_name || responseData[i].bm_name.length == 0 ? "全局" : responseData[i].bm_name) + ":" + responseData[i].ry_name;
                        }
                    }
                    return responseData;
                }
                $.fn.zTree.init($("#divID_Tree_RY"), setting2);
//======================================================================================================
//3检出所有角色
                var setting3 = {
                    treeId: "role_id", check: {enable: true},
                    async: {enable: true, type: "post", url: "${path_home}/sys/power/role/s/selectVastByJson.jw"},
                    data: {
                        simpleData: {enable: true, idKey: "role_id", rootPId: "0"},
                        key: {name: "role_name"}
                    }
                    , callback: {
                        onClick: function (event, id, treeNode) {
                            //点击角色时，刷新角色权限树
                            G_role_id = treeNode.role_id;
                            $.fn.zTree.getZTreeObj("divID_Power").reAsyncChildNodes(null, "refresh");
                        }
                    }
                }
                $.fn.zTree.init($("#divID_role_Tree"), setting3);
//======================================================================================================                
//4检出权限树                
                var setting = {
                    treeId: "power_id", check: {enable: false},
                    async: {enable: true, type: "post", url: "${path_home}/sys/admin/manager/p/showMenu/role.jw"
                        , otherParam: ["role_id", function () {
                                return G_role_id;
                            }]},
                    data: {
                        simpleData: {enable: true, idKey: "power_id", pIdKey: "power_pid", name: "power_name", rootPId: "0"},
                        key: {name: "power_name"}
                    }, view: {
                        expandSpeed: ""
                    },
                    callback: {
                        onAsyncSuccess: function () {
                            $.fn.zTree.getZTreeObj("divID_Power").expandAll(true);
                        }
                    }
                }
                $.fn.zTree.init($("#divID_Power"), setting);
            });
////-------------------------------GRID列函数-----------------------------------------------
            function toSetPower() {
                var role = ztree_getNodesValues("divID_role_Tree", "role_id", 1);
                var ry = ztree_getNodesValues("divID_Tree_RY", "ry_id", 1);
                if (ry == "") {
                    aalert('请选择将要附值的人员', '操作失误');
                    return;
                }
                ccomfire("${path_home}/sys/power/user/setpower/update/role.jw"
                        , {role_id:role , user_id: ry, power_id: ""}, '请再次确认重新设置权限操作');
            }
        </script>
    </head>
    <body>  
        <div style=" min-width: 800px">
            <table class="powertable">
                <tr style="background-color: #00b7ee">
                    <th style=" width: 250px;">部门</th>
                    <th style="width:200px;">业务员</th>
                    <th style=" width: 200px;">角色</th>
                    <th style=" width: 250px;">角色权限</th>
                    <th>管理操作</th>
                </tr>
                <tr style=" height:500px">
                    <td style=" background-color:#d4f1ff">
                        <div id="divID_Tree_BM"  class="ztree powertablediv">---</div>
                    </td>
                    <td>
                        <div id="divID_Tree_RY" class="ztree powertablediv" >业务员</div>
                    </td>
                    <td style=" background-color:#d4f1ff">
                        <div id="divID_role_Tree" class="ztree powertablediv">角色</div>
                    </td>
                    <td style=" background-color:#d4f1ff">
                        <div id="divID_Power" class="ztree powertablediv">角色权限</div>
                    </td>
                    <td>
                        <div class="tableDivH">
                            <div style="margin:10px;">
                                <div style="font-size:13px; color: red;">
                                    <a href="javascript:void(0)" onclick="toSetPower();"><div style="color: red;">设置权限</div></a>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
