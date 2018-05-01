<%@include file="/WEB-INF/jspf/power/adminUserPower.jspf"%>
<%    if (!pck.checkUserORAdmin("Y101_10_1")) {
        return;
    }
    boolean update, dell;
    update = pck.checkUserORAdmin("Y101_10_2");
    dell = pck.checkUserORAdmin("Y101_10_3");
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
        <title>bean模板维护</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script type="text/javascript">
            $(function () {
                var mypackage = new ztree_select(
                        "${path_home}/cc/mypackage/s/selectVast.jw", {},
                        "showmypackageTree", "mypackage_name", "mypackage_id", 190, 390);
                mypackage.init(function (treeId, treeNode) {
                    mypackage.setMyValue(treeNode)
                    mypackage.hideMenu();
                    $.fn.zTree.getZTreeObj("divID_Tree_bean").reAsyncChildNodes(null, "refresh");
                }, "mypackage_id", "mypackage_pid", "mypackage_name")

                ztree_Menue('divID_Tree_bean', 'bean_zj', '', 'bean_mc'
                        , '${path_home}/cc/bean/s2/findHead.jw',
                        ["mypackage_id", function () {
                                return $("#mypackage_id").val();
                            }]
                        , function (event, id, treeNode) {
                            var queryParams = $('#dg').datagrid('options').queryParams;
                            queryParams.bean_zj = treeNode.bean_zj;
                            $('#dg').datagrid('reload');
                        }
                )
                $('#dg').datagrid('hideColumn', 'mymodel_zj');
                pageCN('dg', 20, [20, 50, 100]);
            });
        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'west',title:'模板',split:true" style="width:280px;">
            <!--<div style="width:300px;height: 97%; float: left">-->
            <table id="dg" class="easyui-datagrid"
                   style="width:100%;height:100%"
                   data-options="rownumbers:true,singleSelect:true,url:'${path_home}/cc/mybean/modal/s/selectAllByJson.jw'
                   ,method:'post'
                   ,queryParams: {bean_zj:''}
                   ,autoRowHeight:false
                   ,pagination:false
                   ,toolbar:'#tb'
                   ,onClickRow:onclickModel
                   ">
                <thead>
                    <tr>
                        <th data-options="field:'mymodel_zj'">ID</th>
                        <th data-options="field:'ck',checkbox:true"></th>
                        <th data-options="field:'mymodel_mc',width:200">模板名</th>
                    </tr>
                </thead>
            </table>
            <div id="tb" style="padding:2px 5px;">
                <%=showPower%>
                <script>
                    function onclickModel(rowIndex, rowData) {
                        $("#showMymodel_nrTEXT").html('');
                        $.post('${path_home}cc/mybean/modal/s/selectOne2.jw', {mymodel_zj: rowData.mymodel_zj}, function (data) {
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
                                    ids = ids + "," + rows[i]['mymodel_zj']
                                }
                                if (easyuipost('${path_home}/cc/mymodel/d/dell.jw', {ids: ids.substring(1)})) {
                                    $('#dg').datagrid('reload');
                                }
                            }
                        });
                    }
                    function openAdd() {
                        addPanel('添加通用模型', '${path_home}/cc/mymodel/myModel_A.jsp');
                    }
                    function update() {
                        var row = $('#dg').datagrid('getSelected');
                        if (!row) {
                            $.messager.alert('Info', '请选择行');
                            return;
                        }
                         window.open('${path_home}/cc/mymodel/u/update/select.jw?selectUpdateID=' + row.mymodel_zj);
//                        addPanel('修改' + row.mymodel_mc + '模型(' + row.bean_mc + ')', '${path_home}/cc/mymodel/u/update/select.jw?selectUpdateID=' + row.mymodel_zj);
                    }
                    function addPanel(title, url) {
                        $('#centerMain').tabs('add', {
                            title: title
                            , content: '<iframe width="100%" height="100%" src=' + url + '></iframe>'
                            , closable: true
                        });
                    }
                </script>
                <!--<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="openAdd();">添加</a>-->
                <select onchange="$('#dg').datagrid({singleSelect: (this.value == 0)})">
                    <option value="0">单行选择</option>
                    <option value="1">多行选择</option>
                </select>
            </div>
            <!--</div>-->
        </div>
        <div data-options="region:'east',split:true,title:'bean'" style="width:200px;padding:1px;">
            <div id="showmypackageTree" style="position: relative; z-index: 1000"></div>
            <div id="showmybeanTree" style="position: relative; z-index: 888"></div>
            <div id="divID_Tree_bean" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'" class="easyui-tabs" id='centerMain'>
            <textarea style="width:100%;height:100%;overflow:scroll" id="showMymodel_nrTEXT" readonly="readonly"></textarea>
        </div>
    </body>
</html>
