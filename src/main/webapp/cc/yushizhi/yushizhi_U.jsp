<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>预设模板-添加</title>
    </head>
    <body class="easyui-layout">
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script type="text/javascript" src="${path_home}/cc/yushizhi/js/yushizhi_U.js"></script>
        <script>
            $(function () {
                var u_fl = new ztree_select(
                        "${path_home}/cc/yushizhi/yushizhifl/s/selectVast.jw", {}, "u_showmyyushizhiflTree", "yushizhifl_name", "yushizhifl_id", 320, 390);
                u_fl.init(function (treeId, treeNode) {
                    u_fl.setMyValue(treeNode)
                    u_fl.hideMenu();
                }, "yushizhifl_id", "yushizhifl_pid", "yushizhifl_name", "${obj.yushizhifl_name}", "${obj.yushizhifl_id}");
                $('#myMybeanButton').on('click', function () {
                    close = true;
                })
            });
            var close = false;
            function closeMySelf() {
                if (!close) {
                    $.messager.confirm('请确认', "单据还没保存，是否关闭此页面?", function (r) {
                        if (r) {
                            window.parent.closethisWindow();//调取aa函数
                        }
                    });
                } else {
                    window.parent.closethisWindow();//调取aa函数
                }
            }
        </script>

        <input type="hidden" name="yushizhi_zj" id="yushizhi_zj" value="${obj.yushizhi_zj}" />
        <table id="u_dg" class="easyui-datagrid"  fit="true"
               data-options="
               rownumbers:true,
               singleSelect:true,
               url:'${path_home}/cc/yushizhi/s/select2OneByJson.jw',
               method:'post',
               queryParams: {yushizhi_zj:'${obj.yushizhi_zj}'},
               iconCls: 'icon-edit',
               toolbar:'#u_tb',
               onClickCell: u_onClickCell
               ">
            <thead>
                <tr>
                    <th data-options="field:'yushizhi2_key',width:180,editor:'text',formatter:f_key">健</th>
                    <th data-options="field:'yushizhi2_value',width:450,editor:'text',formatter:f_value">值</th>
                    <th data-options="field:'yushizhi2_bz',width:300,editor:'text',formatter:f_bz">备注</th>
                </tr>
            </thead>
        </table>
        <div id="u_tb" style="padding:1px 1px;">
            <div>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="MoveUp()">上移</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="MoveDown()">下移</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="dellRow()">移除行</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addRow()">添加行</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="myMybeanButton"  onclick="u_postFormData('myMybeanButton')">保存</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" onclick="closeMySelf()">关闭</a>
            </div>
            <div>
                <table class="table" id="table1">
                    <tr>
                        <td>归类</td>
                        <td><div id="u_showmyyushizhiflTree" style="position: relative; z-index: 1000"></div></td>
                    </tr>
                    <tr>
                        <td>预设模板模板名</td>
                        <td><input type="text" name="yushizhi_mc" id="yushizhi_mc" value="${obj.yushizhi_mc}" /></td>
                    </tr>
                    <tr>
                        <td>备注</td>
                        <td><input type="text" name="yushizhi_bz" id="yushizhi_bz"value="${obj.yushizhi_bz}" /></td>
                    </tr>
                </table>
            </div>
            <script>
                function f_bz(value, row, index) {
                    $('#u_dg').datagrid('updateRow', {index: index, row: {yushizhi2_bz: fzFormatZT(row.yushizhi2_bz)}})
                    return toFormatZT(row.yushizhi2_bz);
                }
                function f_key(value, row, index) {
                    $('#u_dg').datagrid('updateRow', {index: index, row: {yushizhi2_key: fzFormatZT(row.yushizhi2_key)}})
                    return toFormatZT(row.yushizhi2_key);
                }
                function f_value(value, row, index) {
                    $('#u_dg').datagrid('updateRow', {index: index, row: {yushizhi2_value: fzFormatZT(row.yushizhi2_value)}})
                    return toFormatZT(row.yushizhi2_value);
                }
                function dellRow() {
                    var row = $("#u_dg").datagrid('getSelected');
                    var index = $("#u_dg").datagrid('getRowIndex', row);
                    $("#u_dg").datagrid('deleteRow', index)
                    if (editIndex) {
                        $('#u_dg').datagrid('endEdit', editIndex);
                        editIndex = undefined;
                    }
                }
                function addRow() {
                    var row = $("#u_dg").datagrid('getSelected');
                    var index = $("#u_dg").datagrid('getRowIndex', row);
                    $("#u_dg").datagrid('insertRow', {
                        index: (++index),
                        row: {}
                    });
                }
                function MoveUp() {
                    var row = $("#u_dg").datagrid('getSelected');
                    var index = $("#u_dg").datagrid('getRowIndex', row);
                    mysort(index, 'up', 'u_dg');

                }
                //下移
                function MoveDown() {
                    var row = $("#u_dg").datagrid('getSelected');
                    var index = $("#u_dg").datagrid('getRowIndex', row);
                    mysort(index, 'down', 'u_dg');

                }
                function mysort(index, type, gridname) {
                    $("#u_dg").datagrid('endEdit', index);
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
        <!--        <div style="text-align: center">
                    <input type="button" value="保存" id="myMybeanButton" onclick="u_postFormData('myMybeanButton')">
                </div>-->
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
                if ($('#u_dg').datagrid('validateRow', editIndex)) {
                    $('#u_dg').datagrid('endEdit', editIndex);
                    editIndex = undefined;
                    return true;
                } else {
                    return false;
                }
            }
            var i = 1;
            function u_onClickCell(index, field) {
                $('#u_dg').datagrid('endEdit', editIndex);
                $("#u_dg").datagrid('beginEdit', index);//{index:index, field: field}
                var ed = $("#u_dg").datagrid('getEditor', {index: index, field: field});//获取当前编辑器
                $(ed.target).focus();//获取焦点
                editIndex = index;
            }
        </script>
    </body>
</html>
