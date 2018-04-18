<%--<%@include file="/WEB-INF/jspf/power/userPower.jspf"%>
<%    if (!pck.checkUser("Y101_1")) {
        return;
    }
%>--%>
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
                    var queryParams = $('#dg').datagrid('options').queryParams;
                    queryParams.flzj = treeNode.yushizhifl_id;
                    $('#dg').datagrid('reload');
                }, "yushizhifl_id", "yushizhifl_pid", "yushizhifl_name");
                var i = 0;
                while (i < 80) {
                    initRow();
                    i++;
                }
            });
            function initRow() {
                $("#dg").datagrid('insertRow', {
                    index: 0,
                    row: {}
                });
            }
        </script>
    </head>
    <body>
        <table class="table" id="table1">
            <tr>
                <td>归类</td>
                <td><div id="showmyyushizhiflTree" style="position: relative; z-index: 1000"></div></td>
            </tr>
            <tr>
                <td>预设模板模板名</td>
                <td><input type="text" name="cmodel_mc" id="cmodel_mc" /></td>
            </tr>
            <tr>
                <td>模板内容</td>
                <td>
                    <table id="dg" class="easyui-datagrid" title="Cell Editing in DataGrid" style="width:1000px;height:600px"
                           data-options="
                           rownumbers:true,
                           singleSelect:true,
                           iconCls: 'icon-edit',
                           singleSelect: true,
                           method:'get',
                           toolbar:'#tb',
                           onClickCell: onClickCell
                           ">
                        <thead>
                            <tr>
                                <th data-options="field:'yushizhi2_key',width:180,editor:'text'">健</th>
                                <th data-options="field:'yushizhi2_value',width:450,editor:'text'">值</th>
                                <th data-options="field:'yushizhi2_bz',width:300,editor:'text'">备注</th>
                            </tr>
                        </thead>
                    </table>
                    <div id="tb" style="padding:2px 5px;">
                        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="save()">保存</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="dellBeanField()">删除</a>
                        ||
                        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="MoveUp()">上移</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="MoveDown()">下移</a>
                        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addRow()">添加行</a>


                        <script>
                            function getJsonByYushizhi2(obj,fh) {
                                if (!obj)
                                    return "";
                                var str =(fh?fh:"")+'{'
                                        + '"yushizhi2_bz":"' + tf(obj.yushizhi2_bz) + '"'
                                        + ',"yushizhi2_key":"' + tf(obj.yushizhi2_key) + '"'
                                        + ',"yushizhi2_value":"' + tf(obj.yushizhi2_value) + '"'
                                return str + "}";

                                function tf(v) {
                                    return v ? toFormatZT(v) : "";
                                }
                            }
                            function save() {
                                var row = $("#dg").datagrid('getSelected');
                                var index = $("#dg").datagrid('getRowIndex', row);
                                $("#dg").datagrid('endEdit', index);
                                $.messager.confirm('确认项', '请确认是否写入数据库', function (r) {
                                    if (r) {
                                        var datas = $('#dg').datagrid('getData');
                                        console.log(datas);
                                        var rs = "";
                                        for (var i = 0; i < datas.total; i++) {
                                            if (datas.rows[i].yushizhi2_key)
                                                rs = rs + getJsonByYushizhi2(datas.rows[i],i==0?null:",");
                                        }
                                        console.log(rs);
                                    }
                                });
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
                                            ids = ids + "," + rows[i]['mybeanfield_zj']
                                        }
                                        if (easyuipost('${path_home}/cc/mybean/field/d/dell.jw', {ids: ids.substring(1)})) {
                                            $('#dg').datagrid('reload');
                                        }
                                    }
                                });
                            }
                            function addRow() {
                                var row = $("#dg").datagrid('getSelected');
                                var index = $("#dg").datagrid('getRowIndex', row);
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
                        <!--                        <select onchange="$('#dg').datagrid({singleSelect: (this.value == 0)})">
                                                    <option value="0">单行选择</option>
                                                    <option value="1">多行选择</option>
                                                </select>-->
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <div style="text-align: center">
                        <input type="button" value="提交" id="myMybeanButton" onclick="postCModelFormData('myMybeanButton')">
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
                if ($('#dg').datagrid('validateRow', editIndex)) {
                    $('#dg').datagrid('endEdit', editIndex);
                    editIndex = undefined;
                    return true;
                } else {
                    return false;
                }
            }
            function onClickCell(index, field) {
                if (endEditing()) {
                    $('#dg').datagrid('selectRow', index)
                            .datagrid('editCell', {index: index, field: field});
                    editIndex = index;
                }
            }
        </script>
    </body>
</html>
