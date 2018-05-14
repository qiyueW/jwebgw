<%@include file="/WEB-INF/jspf/power/userPower.jspf"%>
<%    if (!pck.checkUser("Y101_17_1A")) {
        return;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>预设模板-添加</title>
        <script type="text/javascript" src="${path_home}/cc/yushizhi/js/yushizhi_A.js?<%=new Date()%>"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script>
            $(function () {
                var zcfl = new ztree_select(
                        "${path_home}/cc/yushizhi/yushizhifl/s/selectVast.jw", {}, "showmyyushizhiflTree", "yushizhifl_name", "yushizhifl_id", 320, 390);
                zcfl.init(function (treeId, treeNode) {
                    zcfl.setMyValue(treeNode)
                    zcfl.hideMenu();
                }, "yushizhifl_id", "yushizhifl_pid", "yushizhifl_name");
                var setting2 = {
                    treeId: "yushizhifl_id",
                    check: {
                        enable: true
                    },
                    async: {
                        enable: true,
                        type: "post",
                        url: "${path_home}/cc/yushizhi/yushizhifl/s/selectVast.jw"},
                    data: {
                        simpleData: {
                            enable: true,
                            idKey: "yushizhifl_id",
                            pIdKey: "yushizhifl_pid",
                            rootPId: "0"
                        },
                        key: {
                            name: "yushizhifl_name"
                        }
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {
                            var queryParams = $('#copydg').datagrid('options').queryParams;
                            queryParams.yushizhifl_id = treeNode.yushizhifl_id;
                            $('#copydg').datagrid('reload');
                        }
                    }
                }
                $.fn.zTree.init($("#divID_Tree_bean"), setting2);
                $('#copydg').datagrid('hideColumn', 'yushizhi_zj');
//                $('#copydg').datagrid('hideColumn', 'yushizhifl_id');
                pageCN("copydg", 100);
            });
        </script>
    </head>
    <body class="easyui-layout">
        <table class="table" id="table1">
            <tr>
                <td>归类</td>
                <td><div id="showmyyushizhiflTree" style="position: relative; z-index: 1000"></div></td>
            </tr>
            <tr>
                <td>预设名</td>
                <td><input type="text" name="yushizhi_mc" id="yushizhi_mc" /></td>
            </tr>
            <tr>
                <td>备注</td>
                <td><input type="text" name="yushizhi_bz" id="yushizhi_bz" /></td>
            </tr>
            <!--            <tr>
                            <td colspan="2">
                                <div style="text-align: center">
                                    <input type="button" value="保存" id="myMybeanButton" onclick="postCModelFormData('myMybeanButton')">
                                </div>
                            </td>
                        </tr>-->
        </table>

        <table id="dg" class="easyui-datagrid" fit="true"
               data-options="
               rownumbers:true,
               singleSelect:true,
               iconCls: 'icon-edit',
               singleSelect: true,
               url:'${path_home}/cc/yushizhi/adu/a/add/select2OneByJson.jw',
               method:'post',
               queryParams: {yushizhi_zj:''},
               toolbar:'#tb',
               onClickCell: onClickCell
               ">
            <thead>
                <tr>
                    <th data-options="field:'yushizhi2_key',width:180,editor:'text',formatter:f_key">健</th>
                    <th data-options="field:'yushizhi2_value',width:450,editor:'text',formatter:f_value">值</th>
                    <th data-options="field:'yushizhi2_bz',width:300,editor:'text',formatter:f_bz">备注</th>
                </tr>
            </thead>
        </table>
        <div id="tb" style="padding:2px 5px;">
            <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="dellRow()">移除行</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="addRow()">添加行</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="MoveUp()">上移</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="MoveDown()">下移</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="clearValue()">清空值</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="clearBz()">清空备注</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="copydata()">复制现有模板</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" id="myMybeanButton" onclick="postCModelFormData('myMybeanButton')">保存</a>

            <script>
                function f_bz(value, row, index) {
                    $('#dg').datagrid('updateRow', {index: index, row: {yushizhi2_bz: fzFormatZT(row.yushizhi2_bz)}})
                    return toFormatZT(row.yushizhi2_bz);
                }
                function f_key(value, row, index) {
                    $('#dg').datagrid('updateRow', {index: index, row: {yushizhi2_key: fzFormatZT(row.yushizhi2_key)}})
                    return toFormatZT(row.yushizhi2_key);
                }
                function f_value(value, row, index) {
                    $('#dg').datagrid('updateRow', {index: index, row: {yushizhi2_value: fzFormatZT(row.yushizhi2_value)}})
                    return toFormatZT(row.yushizhi2_value);
                }
//clearValue 清空值
//clearBz   清空备注
                function clearValue() {
                    a_toClearCell('dg', {yushizhi2_value: ''}, "请确认是否执行清空列【值】操作");
                }
                function clearBz() {
                    a_toClearCell('dg', {yushizhi2_bz: ''}, "请确认是否执行清空列【备注】操作");
                }
//查询明细-----------------------------------                    
                function f_cz(value, row, index) {
                    return "<a href=\"javascript:void(0)\" onclick=\"doo('" + row.yushizhi_zj + "');\">复制模板</a>";
                }
                function doo(zj) {
                    var queryParams = $('#dg').datagrid('options').queryParams;
                    queryParams.yushizhi_zj = zj;
                    $('#dg').datagrid('reload');
                    $('#findMyCopyData').window('close');
                }

                function copydata() {
                    $('#findMyCopyData').window('open');//.window('refresh', '${path_home}/cc/yushizhi/s/selectOne.jw?yushizhi_zj=' + zj);
                }

                function dellRow() {
                    var row = $("#dg").datagrid('getSelected');
                    var index = $("#dg").datagrid('getRowIndex', row);
                    $("#dg").datagrid('deleteRow', index)
                    if (editIndex) {
                        $('#dg').datagrid('endEdit', editIndex);
                        editIndex = undefined;
                    }
                }
                function addRow() {
                    var row = $("#dg").datagrid('getSelected');
                    var index = row ? $("#dg").datagrid('getRowIndex', row) : 0;

                    $("#dg").datagrid('insertRow', {
                        index: (++index),
                        row: {}
                    });

                }
                function MoveUp() {
                    var row = $("#dg").datagrid('getSelected');
                    var index = $("#dg").datagrid('getRowIndex', row);
                    mysort(index, 'up', 'dg');

                }
                //下移
                function MoveDown() {
                    var row = $("#dg").datagrid('getSelected');
                    var index = $("#dg").datagrid('getRowIndex', row);
                    mysort(index, 'down', 'dg');

                }
                function mysort(index, type, gridname) {
                    $("#dg").datagrid('endEdit', index);
                    if ("up" == type) {
                        if (index != 0) {
                            var toup = $('#' + gridname).datagrid('getData').rows[index];
                            var todown = $('#' + gridname).datagrid('getData').rows[index - 1];
                            $('#' + gridname).datagrid('getData').rows[index] = todown;
                            $('#' + gridname).datagrid('getData').rows[index - 1] = toup;
                            $('#' + gridname).datagrid('refreshRow', index);
                            $('#' + gridname).datagrid('refreshRow', index - 1);
                            $('#' + gridname).datagrid('selectRow', index - 1);
                        }
                    } else if ("down" == type) {
                        var rows = $('#' + gridname).datagrid('getRows').length;
                        if (index != rows - 1) {
                            var todown = $('#' + gridname).datagrid('getData').rows[index];
                            var toup = $('#' + gridname).datagrid('getData').rows[index + 1];
                            $('#' + gridname).datagrid('getData').rows[index + 1] = todown;
                            $('#' + gridname).datagrid('getData').rows[index] = toup;
                            $('#' + gridname).datagrid('refreshRow', index);
                            $('#' + gridname).datagrid('refreshRow', index + 1);
                            $('#' + gridname).datagrid('selectRow', index + 1);
                        }
                    }

                }
            </script>
        </div>
        <div id="findMyCopyData" class="easyui-window" title="明细" fit="true"
             data-options="closable:true,closed:true,maximized:true"
             >
            <div  class="easyui-layout"  data-options="fit:true">
                <div data-options="region:'west',split:true,title:'预设值分类'" style="width:250px;padding:10px;">
                    <div id="divID_Tree_bean" class="ztree">bean</div>
                </div>
                <div data-options="region:'center'"  id='centerMain'>
                    <table id="copydg" class="easyui-datagrid"
                           style="width:100%;height:100%"
                           data-options="rownumbers:true,singleSelect:true,url:'${path_home}/cc/yushizhi/s/selectAllByJson.jw',method:'post',queryParams: {yushizhifl_id:''},autoRowHeight:true,
                           pagination:true,
                           pageSize:50,
                           ">
                        <thead>
                            <tr>
                                <th data-options="field:'yushizhi_zj'">ID</th>
                                <th data-options="field:'a',width:80,formatter:f_cz">操作区</th>
                                <th data-options="field:'yushizhi_mc',width:200"><div>名称</div>yushizhi_mc</th>
                                <th data-options="field:'yushizhi_bz',width:350"><div>备注</div>yushizhi_bz</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>

        <script type="text/javascript">
            $.extend($.fn.datagrid.methods, {
                editCell: function (jq, param) {
                    return jq.each(function () {
                        var opts = $(this).datagrid('options');
                        var fields = $(this).datagrid('getColumnFields', true).concat($(this).datagrid('getColumnFields'));
                        for (var i = 0; i < fields.length; i++) {
                            var col = $(this).datagrid('getColumnOption', fields[i]);
                            col.editor1 = col.editor;
                            if (fields[i] != param.field) {
                                col.editor = null;
                            }
                        }
                        $(this).datagrid('beginEdit', param.index);
                        for (var i = 0; i < fields.length; i++) {
                            var col = $(this).datagrid('getColumnOption', fields[i]);
                            col.editor = col.editor1;
                        }
                    });
                }
            });

            var editIndex = undefined;
            function endEditing() {
                if (editIndex == undefined) {
                    return true
                }
                if ($('#dg').datagrid('validateRow', editIndex)) {
                    $('#dg').datagrid('endEdit', editIndex);
                    editIndex = undefined;
                    return true;
                } else {
                    return false;
                }
            }
            var i = 1;
            function onClickCell(index, field) {
                $('#dg').datagrid('endEdit', editIndex);
                $("#dg").datagrid('beginEdit', index);//{index:index, field: field}
                var ed = $("#dg").datagrid('getEditor', {index: index, field: field});//获取当前编辑器
                $(ed.target).focus();//获取焦点
                //
//                if (endEditing()) {
//                    console.log("doing endEditing()"+(++i))
//                    $('#dg').datagrid('selectRow', index)
//                            .datagrid('editCell', {index: index, field: field});
                editIndex = index;
//                }
            }
        </script>
    </body>
</html>
