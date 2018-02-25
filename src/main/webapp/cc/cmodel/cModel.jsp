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
                $('#dg').datagrid('hideColumn', 'cmodel_zj');
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
                addPanel('修改' + row.cmodel_mc + '模型', row.cmodel_zj);
            }
            function addPanel(title, cmodel_zj) {
                $('#centerMain').tabs('add', {
                    title: title
                    , content: '<iframe width="100%" height="100%" src="${path_home}/cc/cmodel/u/update/select.jw?selectUpdateID=' + cmodel_zj + '"></iframe>'
                            //                                ,href: '${path_home}/cc/mybean/field/u/update/select.jw?selectUpdateID=' + mybeanfield_zj
                    , closable: true
                });
            }
        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'west',split:true,title:'bean'" style="width:330px;padding:10px;">
            <table id="dg" class="easyui-datagrid"
                   style="width:300px;height:100%"
                   data-options="rownumbers:true,singleSelect:true,url:'${path_home}/cc/cmodal/s/selectAllByJson.jw'
                   ,method:'post'
                   ,queryParams: {cbean_zj:''}
                   ,autoRowHeight:false
                   ,pagination:true
                   ,pageSize:50
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
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="dellBeanField()">删除</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="update()">修改</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
                <select onchange="$('#dg').datagrid({singleSelect: (this.value == 0)})">
                    <option value="0">单行选择</option>
                    <option value="1">多行选择</option>
                </select>
            </div>
        </div>
        <div data-options="region:'center'"  class="easyui-tabs" id='centerMain'>
            <div title="添加通用模板">
                <iframe width="100%" height="100%" src="${path_home}/cc/cmodel/cModel_A.jsp"></iframe>
            </div>
            <div title="模板展示区" selected>
                <div>
                    <textarea style="width:700px;height:97%" id="showMymodel_nrTEXT"></textarea>
                </div>
            </div>
        </div>
    </body>
</html>
