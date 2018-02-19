<%@page import="java.util.Date"%>
<%--<%@include file="/WEB-INF/jspf/power/superAminPower.jspf"%>--%>
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
            var mypackage_id = "";
            var user_id2 = "";
            $(function () {
                var zcfl = new ztree_select("${path_home}/cc/mypackage/s/selectVast.jw", {}, "showmypackageTree", "mypackage_name", "mypackage_id", 220, 390);
                zcfl.init(function (treeId, treeNode) {
                    zcfl.setMyValue(treeNode)
                    zcfl.hideMenu();//$("#" +zcfl.menuContentDIV).fadeOut("fast");
                    $.fn.zTree.getZTreeObj("divID_Tree_bean").reAsyncChildNodes(null, "refresh");
                }, "mypackage_id", "mypackage_pid", "mypackage_name")
//======================================================================================================                
//检出包结构                
                var setting0 = {
                    treeId: "mypackage_id",
                    async: {enable: true, type: "post", url: "${path_home}/cc/mypackage/s/selectVast.jw",
                        otherParam: ["user_id", function () {
                                return user_id2;
                            }]
                    },
                    data: {
                        simpleData: {enable: true, idKey: "mypackage_id", pIdKey: "mypackage_pid", rootPId: "0"},
                        key: {name: "mypackage_name"}
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {//点击部门时，重新加载管理员树。参数为
                            mypackage_id = treeNode.mypackage_id; //动态上传参数
                            $.fn.zTree.getZTreeObj("divID_Tree_bean").reAsyncChildNodes(null, "refresh");
                        },
                        onAsyncSuccess: function () {
                            $.fn.zTree.getZTreeObj("divID_Tree_BM").expandAll(true);
                        }
                    }
                };
                $.fn.zTree.init($("#divID_Tree_BM"), setting0);
//======================================================================================================  

//======================================================================================================
//检出bean
                function ajaxDataFilter(treeId, parentNode, responseData) {
                    if (responseData) {
                        for (var i = 0; i < responseData.length; i++) {
                            responseData[i].mybean_mc = responseData[i].mybean_bz ? responseData[i].mybean_mc + "(" + responseData[i].mybean_bz + ")" : responseData[i].mybean_mc;
                        }
                    }
                    return responseData;
                }
                var setting2 = {
                    treeId: "mybean_zj", check: {enable: true},
                    async: {enable: true, type: "post", url: "${path_home}/cc/mybean/s/selectAllByJson.jw",
                        otherParam: ["mypackage_id", function () {
                                return $("#mypackage_id").val();//mypackage_id
                            }],
                        dataFilter: ajaxDataFilter
                    },
                    data: {
                        simpleData: {enable: true, idKey: "mybean_zj", rootPId: "0"},
                        key: {name: "mybean_mc"}
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {
                        }
                    }
                }
                $.fn.zTree.init($("#divID_Tree_bean"), setting2);
            });
//                                    function loadNotBMAdmin() {
//                                        mypackage_id = "no";
//                                        $.fn.zTree.getZTreeObj("divID_Tree_bean").reAsyncChildNodes(null, "refresh");
//                                    }
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
                    <th style=" width: 250px;">bean</th>
                    <th style=" width: 250px;">bean</th>
                    <th style=" width: 300px;">bean相关</th>
                    <!--<th>管理操作</th>-->
                </tr>
                <tr style=" height:500px">
                    <td>
                        <div id="showmypackageTree"  style=" position: relative;z-index:1000"></div>
                        <!--<div id="divID_Tree_BM"  class="ztree powertablediv">---</div>-->
                        <div id="divID_Tree_bean" class="ztree powertablediv">bean</div>
                    </td>
                    <td style=" background-color:#d4f1ff">
                        
                    </td>
                    <td style=" background-color:#d4f1ff">

                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
