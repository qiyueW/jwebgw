<%@include file="/WEB-INF/jspf/power/adminUserPower.jspf"%>
<%    if (!pck.checkUserORAdmin("Y101_2_1")) {
        return;
    }
    boolean update, dell;
    update = pck.checkUserORAdmin("Y101_2_2");
    dell = pck.checkUserORAdmin("Y101_2_3");
    String showPower = pck.getStrTool()
            .put(update, "<a href='javascript:void(0)' class='easyui-linkbutton' iconCls='icon-edit' plain='true' onclick='update()'>修改</a>")
            .put(dell, "<a href='javascript:void(0)' class='easyui-linkbutton' iconCls='icon-remove' plain='true' onclick='dellBeanField()'>删除</a>")
            .getString();
%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<base href="${path_home}/">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>通用模板维护</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script type="text/javascript">
            $(function () {
                var setting2 = {
                    treeId: 'cmodelfl_id',
                    async: {enable: true, type: "post", url: '${path_home}/cc/cmodel/cmodelfl/s/selectVast.jw'},
                    data: {
                        simpleData: {enable: true, idKey: 'cmodelfl_id', pIdKey: 'cmodelfl_pid', rootPId: "0"},
                        key: {name: 'cmodelfl_name'}
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {
                            var queryParams = $('#dg').datagrid('options').queryParams;
                            queryParams.flzj = treeNode.cmodelfl_id;
                            $('#dg').datagrid('reload');
                        }
                        , onAsyncSuccess: function (event, treeId, treeNode, msg) {
                            var treeObj = $.fn.zTree.getZTreeObj(treeId);
                            treeObj.expandAll(true);
                        }
                    }
                }
                $.fn.zTree.init($("#showmycmodelflTree"), setting2);





                $('#dg').datagrid('hideColumn', 'cmodel_zj');
                pageCN('dg')
            });
            function onclickModel(rowIndex, rowData) {
                $("#showMymodel_nrTEXT").html('');
                $.post('${path_home}cc/cmodal/s/selectOne2.jw', {cmodel_zj: rowData.cmodel_zj}, function (data) {
                    $("#showMymodel_nrTEXT").html(data);
                }, "text");
            }
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
                            ids = ids + "," + rows[i]['cmodel_zj']
                        }
                        if (easyuipost('${path_home}/cc/cmodel/d/dell.jw', {ids: ids.substring(1)})) {
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
                window.open('${path_home}/cc/cmodel/u/update/select.jw?selectUpdateID=' + row.cmodel_zj);
            }
        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'west',split:true,title:'模板'" style="width:280px;">
            <table id="dg" class="easyui-datagrid"
                   style="width:100%;height:100%"
                   data-options="rownumbers:true,singleSelect:true,url:'${path_home}/cc/cmodal/s/selectAllByJson.jw'
                   ,method:'post'
                   ,queryParams: {flzj:''}
                   ,autoRowHeight:false
                   ,pagination:false
                   ,toolbar:'#tb'
                   ,onClickRow:onclickModel
                   ">
                <thead>
                    <tr>
                        <th data-options="field:'cmodel_zj'">ID</th>
                        <th data-options="field:'ck',checkbox:true"></th>
                        <th data-options="field:'cmodel_mc',width:200">模板名</th>
                    </tr>
                </thead>
            </table>
            <div id="tb" style="padding:2px 5px;">
                <%=showPower%>
                <select onchange="$('#dg').datagrid({singleSelect: (this.value == 0)})">
                    <option value="0">单行选择</option>
                    <option value="1">多行选择</option>
                </select>
            </div>
        </div>
        <div data-options="region:'east',split:true,title:'模板分类'" style="width:250px;padding:10px;">
            <!--<div id="showmycmodelflTree" style="position: relative; z-index: 1000"></div>-->
            <div id="showmycmodelflTree" class="ztree">bean</div>
        </div>

        <div data-options="region:'center'" id='centerMain'>
            <textarea style="width:100%;height:100%" id="showMymodel_nrTEXT" readonly="readonly"></textarea>
        </div>
    </body>
</html>
