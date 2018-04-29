<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>预设模板-添加</title>
    </head>
    <body>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script type="text/javascript" src="${path_home}/cc/fangan/js/fangan_U.js"></script>
        <script>
            $(function () {
                var u_fl = new ztree_select("${path_home}/cc/fangan/fanganfl/s/selectVast.jw", {}, "u_showmyfanganflTree", "fanganfl_name", "fanganfl_id", 320, 390);
                u_fl.init(function (treeId, treeNode) {
                    u_fl.setMyValue(treeNode)
                    u_fl.hideMenu();
                }, "fanganfl_id", "fanganfl_pid", "fanganfl_name", "${obj.fanganfl_name}", "${obj.fanganfl_id}");
            });
        </script>
        <input type="hidden" name="fangan1_zt" id="fangan1_zt" value="0" />
        <input type="hidden" name="fangan1_zj" id="fangan1_zj" value="${obj.fangan1_zj}" />
        <table class="table" id="table1">
            <tr>
                <td>归类</td>
                <td><div id="u_showmyfanganflTree" style="position: relative; z-index: 1000"></div></td>
            </tr>
            <tr>
                <td>预设模板模板名</td>
                <td><input type="text" name="fangan1_mc" id="fangan1_mc" value="${obj.fangan1_mc}" /></td>
            </tr>
            <tr>
                <td>备注</td>
                <td><input type="text" name="fangan1_bz" id="fangan1_bz"value="${obj.fangan1_bz}" /></td>
            </tr>
            <tr>
                <td>模板内容</td>
                <td>
                    <table id="u_dg" class="easyui-datagrid"  style="width:980px;height:400px"
                           data-options="
                           rownumbers:true,
                           singleSelect:true,
                           url:'${path_home}/cc/fangan/s/select2OneByJson.jw',
                           method:'post',
                           queryParams: {fangan_zj:'${obj.fangan1_zj}'},
                           iconCls: 'icon-edit',
                           toolbar:'#u_tb',
                           onClickCell: u_onClickCell
                           ">
                        <thead>
                            <tr>
                                <th data-options="field:'fangan2_filepath',width:280,editor:'text',formatter:f_flj">投产路径</th>
                                <th data-options="field:'fangan2_filename',width:280,editor:'text',formatter:f_fmc">生产文件名</th>
                                <th data-options="field:'cmodel_mc',width:180,editor:{type:'combobox',options:{url:'${path_home}/cc/cmodal/s/selectAllByJson2.jw',editable:true,panelHeight:170,valueField:'cmodel_mc',textField:'cmodel_mc'}}">投产模板</th>
                                <th data-options="field:'fangan2_bz',width:200,formatter:f_bz,editor:'text'">备注</th>
                            </tr>
                        </thead>
                    </table>
                    <div id="u_tb" style="padding:1px 1px;">
                        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="MoveUp()">上移</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="MoveDown()">下移</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="dellRow()">移除行</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addRow()">添加行</a>


                        <script>
                            function f_bz(value, row, index) {
                                $('#u_dg').datagrid('updateRow', {index: index, row: {fangan2_bz: fzFormatZT(row.fangan2_bz)}})
                                return toFormatZT(row.fangan2_bz);
                            }
                            function f_flj(value, row, index) {
                                $('#u_dg').datagrid('updateRow', {index: index, row: {fangan2_filepath: fzFormatZT(row.fangan2_filepath)}})
                                return toFormatZT(row.fangan2_filepath);
                            }
                            function f_fmc(value, row, index) {
                                $('#u_dg').datagrid('updateRow', {index: index, row: {fangan2_filename: fzFormatZT(row.fangan2_filename)}})
                                return toFormatZT(row.fangan2_filename);
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
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div style="text-align: center">
                        <input type="button" value="保存" id="myMybeanButton" onclick="u_postFanganFormData('myMybeanButton')">
                    </div>
                </td>
            </tr>
        </table>
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
