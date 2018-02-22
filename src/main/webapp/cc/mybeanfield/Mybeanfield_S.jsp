<%@page import="java.util.Date"%>
<%--<%@include file="/WEB-INF/jspf/power/superAminPower.jspf"%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<base href="${path_home}/">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>

        <script type="text/javascript">
            $(function () {
//                var gjs = new GJS();
//                gjs.setElementWidthPX("table1", 17)
//                gjs.setElementHeight("table1", 34)
//                gjs.setElementHeight("divID_Tree_bean", 70)
//                gjs.setElementHeight("tabletr2", 60)
//                gjs.setElementHeight("tabletr2td2", 60)
//                gjs.setElementHeight("dg", 100)
//                gjs.setElementWidthPX("dg", 300)


                var zcfl = new ztree_select(
                        "${path_home}/cc/mypackage/s/selectVast.jw", {},
                        "showmypackageTree", "mypackage_name", "mypackage_id", 220, 390);
                zcfl.init(function (treeId, treeNode) {
                    zcfl.setMyValue(treeNode)
                    zcfl.hideMenu(); //$("#" +zcfl.menuContentDIV).fadeOut("fast");
                    $.fn.zTree.getZTreeObj("divID_Tree_bean").reAsyncChildNodes(null,
                            "refresh");
                }, "mypackage_id", "mypackage_pid", "mypackage_name")
                //======================================================================================================                
                //检出包结构  /*               
                var setting0 = {
                    treeId: "mypackage_id",
                    async: {
                        enable: true,
                        type: "post",
                        url: "${path_home}/cc/mypackage/s/selectVast.jw"
                    },
                    data: {
                        simpleData: {
                            enable: true,
                            idKey: "mypackage_id",
                            pIdKey: "mypackage_pid",
                            rootPId: "0"
                        },
                        key: {
                            name: "mypackage_name"
                        }
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {//点击部门时，重新加载管理员树。参数为
                            mypackage_id = treeNode.mypackage_id; //动态上传参数
                            $.fn.zTree.getZTreeObj("divID_Tree_bean")
                                    .reAsyncChildNodes(null, "refresh");
                        },
                        onAsyncSuccess: function () {
                            $.fn.zTree.getZTreeObj("divID_Tree_BM").expandAll(true);
                        }
                    }
                };
                $.fn.zTree.init($("#divID_Tree_BM"), setting0);
                //======================================================================================================
                //检出bean
                function ajaxDataFilter(treeId, parentNode, responseData) {
                    if (responseData) {
                        for (var i = 0; i < responseData.length; i++) {
                            responseData[i].mybean_mc = responseData[i].mybean_bz ? responseData[i].mybean_mc
                                    + "(" + responseData[i].mybean_bz + ")"
                                    : responseData[i].mybean_mc;
                        }
                    }
                    return responseData;
                }
                var setting2 = {
                    treeId: "mybean_zj",
                    check: {
                        enable: true
                    },
                    async: {
                        enable: true,
                        type: "post",
                        url: "${path_home}/cc/mybean/s/selectAllByJson.jw",
                        otherParam: ["mypackage_id", function () {
                                return $("#mypackage_id").val(); //mypackage_id
                            }],
                        dataFilter: ajaxDataFilter
                    },
                    data: {
                        simpleData: {
                            enable: true,
                            idKey: "mybean_zj",
                            rootPId: "0"
                        },
                        key: {
                            name: "mybean_mc"
                        }
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {
                            var queryParams = $('#dg').datagrid('options').queryParams;
                            queryParams.mybean_zj = treeNode.mybean_zj;
                            $('#dg').datagrid('reload');
                        }
                    }
                }
                $.fn.zTree.init($("#divID_Tree_bean"), setting2);
            });
        </script>
    </head>
    <body>
    <body class="easyui-layout">
        <div data-options="region:'west',split:true,title:'bean'" style="width:250px;padding:10px;">
            <div id="showmypackageTree" style="position: relative; z-index: 1000"></div> <!--<div id="divID_Tree_BM"  class="ztree powertablediv">---</div>-->
            <div id="divID_Tree_bean" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'"  class="easyui-tabs" id='centerMain'>
            <div title="添加bean的属性">
                <iframe width="100%" height="100%" src="${path_home}/cc/mybeanfield/Mybeanfield_A.jsp"></iframe>
            </div>
            <div title="bean明细" selected>
                <table id="dg" class="easyui-datagrid"
                       style="width:97%;height:90%"
                       data-options="rownumbers:true,singleSelect:true,url:'${path_home}/cc/mybean/field/s/selectAllByJson.jw',method:'post',queryParams: {mybean_zj:''},autoRowHeight:true,
                       pagination:true,
                       pageSize:50,
                       toolbar:'#tb'
                       ">
                    <thead>
                        <tr>
                            <th data-options="field:'ck',checkbox:true"></th>
                            <th data-options="field:'c_zyy',width:60">c作用域</th>
                            <th data-options="field:'c_lx',width:50">c类型</th>
                            <th data-options="field:'c_mc',width:120">c属性名</th>
                            <th data-options="field:'c_bz',width:80">c备注</th>

                            <th data-options="field:'t_lx',width:40">t类型</th>
                            <th data-options="field:'t_sy',width:50">t索引</th>
                            <th data-options="field:'t_yxkong',width:40">是否为空</th>
                            <th data-options="field:'t_cd',width:80">t长度</th>
                            <th data-options="field:'t_bz',width:40">t备注</th>

                            <th data-options="field:'v_zzbds',width:250">v正则表达式</th>
                            <th data-options="field:'v_cuowuxx',width:220">v错误信息</th>
                            <th data-options="field:'v_bxjiancha',width:40">v必须检查</th>

                            <th data-options="field:'h_lx',width:70">h类型</th>
                            <th data-options="field:'h_jb',width:40">h脚本校验</th>
                            <th data-options="field:'e_mc',width:80">e展示名</th>
                        </tr>
                    </thead>
                </table>
                <div id="tb" style="padding:2px 5px;">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="update()">修改</a>
                    <script>
                        function update() {
                            var row = $('#dg').datagrid('getSelected');
                            if (!row) {
                                $.messager.alert('Info', '请选择行');
                                return;
                            }
                            addPanel('修改'+row.c_mc+'('+row.c_bz+')',row.mybeanfield_zj);
                        }
                        function addPanel(title,mybeanfield_zj) {
                            $('#centerMain').tabs('add', {
                                title:title
                                ,content: '<iframe width="100%" height="100%" src="${path_home}/cc/mybean/field/u/update/select.jw?selectUpdateID='+ mybeanfield_zj+'"></iframe>'
//                                ,href: '${path_home}/cc/mybean/field/u/update/select.jw?selectUpdateID=' + mybeanfield_zj
                                , closable: true
                            });
                        }
                    </script>
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
                    <select onchange="$('#dg').datagrid({singleSelect: (this.value == 0)})">
                        <option value="0">单行选择</option>
                        <option value="1">多行选择</option>
                    </select>
                </div>
                                
            </div>
        </div>
    </body>
</body>
</html>
