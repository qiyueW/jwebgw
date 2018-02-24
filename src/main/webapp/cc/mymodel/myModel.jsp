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
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script type="text/javascript">
            $(function () {
                var mypackage = new ztree_select(
                        "${path_home}/cc/mypackage/s/selectVast.jw", {},
                        "showmypackageTree", "mypackage_name", "mypackage_id", 220, 390);
                mypackage.init(function (treeId, treeNode) {
                    mypackage.setMyValue(treeNode)
                    mypackage.hideMenu();
                    $.fn.zTree.getZTreeObj("divID_Tree_bean").reAsyncChildNodes(null, "refresh");
                }, "mypackage_id", "mypackage_pid", "mypackage_name")
                
                ztree_Menue('divID_Tree_bean', 'mybean_zj', '', 'mybean_mc'
                        , '${path_home}/cc/mybean/s/selectAllByJson.jw',
                        ["mypackage_id", function () {return $("#mypackage_id").val();}]
                        , function (event, id, treeNode) {
                            var queryParams = $('#dg').datagrid('options').queryParams;
                            queryParams.mybean_zj = treeNode.mybean_zj;
                            $('#dg').datagrid('reload');
                        }
                )
                $('#dg').datagrid('hideColumn', 'mymodel_zj');
            });
        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'west',split:true,title:'bean'" style="width:250px;padding:10px;">
            <div id="showmypackageTree" style="position: relative; z-index: 1000"></div> <!--<div id="divID_Tree_BM"  class="ztree powertablediv">---</div>-->
            <div id="showmybeanTree" style="position: relative; z-index: 888"></div>
            <div id="divID_Tree_bean" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'"  class="easyui-tabs" id='centerMain'>
            <div title="添加beanModel">
                <iframe width="100%" height="100%" src="${path_home}/cc/mymodel/myModel_A.jsp"></iframe>
            </div>
            <div title="bean模型" selected>
                <table id="dg" class="easyui-datagrid"
                       style="width:97%;height:97%"
                       data-options="rownumbers:true,singleSelect:true,url:'${path_home}/cc/mybean/modal/s/selectAllByJson.jw',method:'post',queryParams: {mybean_zj:''},autoRowHeight:false,
                       pagination:true,
                       pageSize:50,
                       toolbar:'#tb'
                       ">
                    <thead>
                        <tr>
                            <th data-options="field:'mymodel_zj'">ID</th>
                            <th data-options="field:'ck',checkbox:true"></th>
                            <th data-options="field:'mymodel_mc',width:260">模板名</th>
                        </tr>
                    </thead>
                </table>
                <div id="tb" style="padding:2px 5px;">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="dellBeanField()">删除</a>
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="update()">修改</a>
                    <script>
                        function dellBeanField() {
                            var rows = $('#dg').datagrid('getSelections');
                            if (!rows[0]) {
                                $.messager.alert('Info', '请选择行');
                                return;
                            }
                            $.messager.confirm('删除操作', '请确认是否执行删除操作', function (r) {
                                if (r) {
                                    var ids = "";
                                    for (var i = 0; i < rows.length; i++) {
                                        ids = ids + "," + rows[i]['mybeanfield_zj']
                                    }
                                    if (easyuipost('${path_home}/cc/mybean/field/d/dell.jw', {ids: ids.substring(1)})) {
                                        $('#dg').datagrid('reload');
                                    }
                                }
                            });
                        }
                        function update() {
                            var row = $('#dg').datagrid('getSelected');
                            if (!row) {
                                $.messager.alert('Info', '请选择行');
                                return;
                            }
                            addPanel('修改' + row.mymodel_mc + '模型(' + row.mybean_mc + ')', row.mymodel_zj);
                        }
                        function addPanel(title, mymodel_zj) {
                            $('#centerMain').tabs('add', {
                                title: title
                                , content: '<iframe width="100%" height="100%" src="${path_home}/cc/mymodel/u/update/select.jw?selectUpdateID=' + mymodel_zj + '"></iframe>'
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
</html>
