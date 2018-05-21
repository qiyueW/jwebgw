<%@include file="/WEB-INF/jspf/power/userPower.jspf"%>
<%    if (!pck.checkUser("Y101_17_1U")) {
        return;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>预设模板-批量添加属性字段</title>
        <script type="text/javascript" src="${path_home}/cc/yushizhi/js/yushizhi_AU.js?<%=new Date()%>"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script>
            $(function () {
                for (var i = 0; i < 6; i++)
                    $('#dg').datagrid('appendRow', {});

            });
        </script>
    </head>
    <body class="easyui-layout">
        <table id="dg" class="easyui-datagrid" fit="true"
               data-options="
               singleSelect:true,
               iconCls: 'icon-edit',
               singleSelect: true,
               toolbar:'#tb',
               onClickCell: onClickCell
               ">
            <thead>
                <tr>
                    <th data-options="field:'yushizhi2_px',width:80,editor:'text'">插入行号</th>
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
            <!--<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="copydata()">复制现有模板</a>-->
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" id="myMybeanButton" onclick="postYushizhiAUFormData('myMybeanButton')">保存</a>

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
//查询明细-----------------------------------                    
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
