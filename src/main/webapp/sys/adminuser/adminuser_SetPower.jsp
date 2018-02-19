<%@page import="java.util.Date"%>
<%@include file="/WEB-INF/jspf/power/superAminPower.jspf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%--<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>--%>
<!--后台UI组件End-->
<base href="${path_home}/">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script> 
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>

        <script type="text/javascript">
            var bm_id = "";
            var user_id2 = "";
            $(function () {
//======================================================================================================                
//检出部门树                  
                var setting0 = {
                    treeId: "bm_id",
                    async: {enable: true, type: "post", url: "${path_home}/sys/power/adminuser/s/selectOneAdminBm.jw",
                        otherParam: ["user_id", function () {
                                return user_id2;
                            }]},
                    data: {
                        simpleData: {enable: true, idKey: "bm_id", pIdKey: "bm_pid", rootPId: "0"},
                        key: {name: "bm_name"}
                    },
                    callback: {
//                        onClick: function (event, id, treeNode) {//点击部门时，重新加载管理员树。参数为
//                            bm_id = ztree_getNodeSonValue(treeNode, "bm_id"); //动态上传参数
//                            $.fn.zTree.getZTreeObj("divID_Tree_Admin").reAsyncChildNodes(null, "refresh");
//                        },
                        onAsyncSuccess: function () {
                            $.fn.zTree.getZTreeObj("divID_Tree_BM").expandAll(true);
                        }
                    }
                };
                $.fn.zTree.init($("#divID_Tree_BM"), setting0);
//======================================================================================================                
//检出权限树                
                var setting = {
                    treeId: "power_id", check: {enable: true},
                    async: {enable: true, type: "post", url: "${path_home}/sys/superadmin/manager/p/showMenu.jw"},
                    data: {
                        simpleData: {enable: true, idKey: "power_id", pIdKey: "power_pid", name: "power_name", rootPId: "0"},
                        key: {name: "power_name"}
                    }
                };
                $.fn.zTree.init($("#divID_Power"), setting);
//======================================================================================================
//检出管理员 
                var setting2 = {
                    treeId: "user_id", check: {enable: true},
                    async: {enable: true, type: "post", url: "${path_home}/sys/power/adminuser/s/v/showMenu.jw",
                        otherParam: ["bm_id", function () {
                                return bm_id
                            }],
                        dataFilter: ajaxDataFilter
                    },
                    data: {
                        simpleData: {enable: true, idKey: "user_id", rootPId: "0"},
                        key: {name: "user_name"}
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {
                            user_id2 = treeNode.user_id; //动态上传参数
                            $.fn.zTree.getZTreeObj("divID_Tree_BM").reAsyncChildNodes(null, "refresh");//刷新管理员涉及的管理部门
                            //点击管理员时，取消权限树所有原有选择。
                            var treeObj = $.fn.zTree.getZTreeObj("divID_Power");
                            treeObj.checkAllNodes(false);
                            treeObj.expandAll(false);
                            //重装上权限
                            if (null != treeNode.user_id && treeNode.user_id.length > 0) {
                                $.post("${path_home}/sys/power/adminuser/s/selectOneUserPower.jw?t=<%=new Date()%>", {user_id: treeNode.user_id}, function (d) {
                                                            var mynode;
                                                            for (var i = 0; i < d.length; i++) {
                                                                mynode = treeObj.getNodeByParam("power_id", d[i].power_id, null); //通过id列，检出节点
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
                                                    if (responseData[i].bm_id.length > 30) {
                                                        responseData[i].user_name = "[多部门]" + ":" + responseData[i].user_name;
                                                    } else {
                                                        responseData[i].user_name = (!responseData[i].bm_name || responseData[i].bm_name.length == 0 ? "[管全局]" : responseData[i].bm_name) + ":" + responseData[i].user_name;
                                                    }
                                                }
                                            }
                                            return responseData;
                                        }
                                        $.fn.zTree.init($("#divID_Tree_Admin"), setting2);
                                    });
//                                    function loadNotBMAdmin() {
//                                        bm_id = "no";
//                                        $.fn.zTree.getZTreeObj("divID_Tree_Admin").reAsyncChildNodes(null, "refresh");
//                                    }
                                    function toSetPower() {
                                        var userID = ztree_getNodesValues("divID_Tree_Admin", "user_id", 1);
                                        var pp = ztree_getNodesValues("divID_Power", "power_id", 1);
                                        if (userID == "") {
                                            aalert('请选择将要附值的权限', '操作失误');
//                    alert("请选择将要附值的权限")
                                            return;
                                        }
                                        ccomfire("${path_home}/sys/power/adminuser/setpower/update/power.jw"
                                                , {user_id: userID, power_id: pp}, '请再次确认重新设置权限操作');
                                    }
        </script>
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
    </head>
    <body>  

        <div style=" min-width: 800px">
            <table class="powertable">
                <tr style="background-color: #00b7ee">
                    <th style=" width: 250px;">管理员</th>
                    <th style=" width: 300px;">拥有的权限</th>
                    <th style=" width: 250px;">管理涉及到的部门</th>
                    <th>管理操作</th>
                </tr>
                <tr style=" height:500px">
                    <td>
                        <div id="divID_Tree_Admin" class="ztree powertablediv">管理员</div>
                    </td>
                    <td style=" background-color:#d4f1ff">
                        <div id="divID_Power" class="ztree powertablediv">权限</div>
                    </td>
                    <td style=" background-color:#d4f1ff">
                        <div id="divID_Tree_BM"  class="ztree powertablediv">---</div>
                    </td>
                    <td>
                        <div class="tableDivH">
                            <div style="margin:10px;">
                                <div style="font-size:13px; color: red;">
                                    <a href="javascript:void(0)" onclick="toSetPower();"><div style="color: red;">设置权限</div></a>
                                </div>
                            </div>
<!--                            <div style="margin:10px;">
                                <div style="font-size:12px">
                                    <a href="javascript:void(0)" onclick="loadNotBMAdmin();">加载<br/>全局管理员</a>
                                </div>
                            </div>-->
                        </div>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
