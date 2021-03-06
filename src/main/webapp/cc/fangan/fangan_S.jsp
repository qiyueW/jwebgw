<%@include file="/WEB-INF/jspf/power/adminUserPower.jspf"%>
<%    if (!pck.checkUserORAdmin("Y101_18_1S")) {
        return;
    }
    boolean update, dell;
    update = pck.checkUserORAdmin("Y101_18_1U");
    dell = pck.checkUserORAdmin("Y101_18_1D");
    String showPower = pck.getStrTool()
            .put(dell, "<a href='javascript:void(0)' class='easyui-linkbutton' iconCls='icon-remove' plain='true' onclick='dellBeanField()'>删除</a>")
            .put(update, "<a href='javascript:void(0)' class='easyui-linkbutton' iconCls='icon-edit' plain='true' onclick='update()'>修改</a>")
            .getString();
%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<base href="${path_home}/">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>bean字段管理</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script type="text/javascript">
            $(function () {
                var setting2 = {
                    treeId: "fanganfl_id",
                    check: {
                        enable: true
                    },
                    async: {
                        enable: true,
                        type: "post",
                        url: "${path_home}/cc/fangan/fanganfl/s/selectVast.jw"},
                    data: {
                        simpleData: {
                            enable: true,
                            idKey: "fanganfl_id",
                            pIdKey: "fanganfl_pid",
                            rootPId: "0"
                        },
                        key: {
                            name: "fanganfl_name"
                        }
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {
                            var queryParams = $('#dg').datagrid('options').queryParams;
                            queryParams.fanganfl_id = treeNode.fanganfl_id;
                            $('#dg').datagrid('reload');
                        }
                    }
                }
                $.fn.zTree.init($("#divID_Tree_bean"), setting2);
                $('#dg').datagrid('hideColumn', 'fangan1_zj');
                $('#dg').datagrid('hideColumn', 'fanganfl_id');
                pageCN("dg", 100);
            });
            function loadHeader(divId, pageUri) {
                document.getElementById(divId).innerHTML = '<iframe scrolling="no" frameborder="0"  src="' + pageUri + '" style="width:100%;height:100%;"></iframe>';
            }

        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'west',split:true,title:'预设值分类'" style="width:250px;padding:10px;">
            <div id="divID_Tree_bean" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'"  id='centerMain'>
            <table id="dg" class="easyui-datagrid"
                   style="width:100%;height:100%"
                   data-options="rownumbers:true,singleSelect:true,url:'${path_home}/cc/fangan/s/selectAllByJson.jw',method:'post',queryParams: {fanganfl_id:''},autoRowHeight:true,
                   pagination:true,
                   pageSize:50,
                   toolbar:'#tb'
                   ">
                <thead>
                    <tr>
                        <th data-options="field:'fangan1_zj'">ID</th>
                        <th data-options="field:'fanganfl_id'">FLID</th>
                        <th data-options="field:'ck',checkbox:true"></th>
                        <th data-options="field:'fangan1_px',width:40"><div>排序</div>fangan1_px</th>
                        <th data-options="field:'fangan1_mc',width:280">方案名</th>
                        <th data-options="field:'fangan1_bz',width:150">备注</th>
                        <th data-options="field:'a',width:200,formatter:f_cz">操作区</th>
                    </tr>
                </thead>
            </table>
            <div id="tb" style="padding:2px 5px;">
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="saveMove"onclick="MoveSave()">生效移动位置</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="MoveUp()">上移</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" plain="true" onclick="MoveDown()">下移</a>
                <%=showPower%>
                <script>
                    function f_bz(value, row, index) {
                        $('#dg').datagrid('updateRow', {index: index, row: {fangan1_bz: fzFormatZT(row.fangan1_bz)}})
                        return fzFormatZT(row.fangan1_bz);
                    }
                    function f_mc(value, row, index) {
                        $('#dg').datagrid('updateRow', {index: index, row: {fangan1_mc: fzFormatZT(row.fangan1_mc)}})
                        return fzFormatZT(row.fangan1_mc);
                    }
//查询明细-----------------------------------                    
                    function f_cz(value, row, index) {
                        return "<a href=\"javascript:void(0)\" onclick=\"doo('" + row.fangan1_mc + "','" + row.fangan1_zj + "');\">明细</a>";
                    }
                    function doo(mc, zj) {
                        $('#showOneObj').window({
                            title: mc + " 方案预设值明细",
                            width: 1000,
                            height: 400,
                            modal: true,
                            maximized: true,
                            href: '${path_home}/cc/fangan/s/selectOne.jw?fangan_zj=' + zj
                        });
                    }
//批量删除-----------------------------------                    
                    function dellBeanField() {
                        var rows = $('#dg').datagrid('getSelections');
                        if (!rows[0]) {
                            $.messager.alert('提示', '请选择行');
                            return;
                        }
                        $.messager.confirm('删除操作', '请确认是否执行删除操作', function (r) {
                            if (r) {
                                var ids = "";
                                for (var i = 0; i < rows.length; i++) {
                                    ids = ids + "," + rows[i]['fangan1_zj']
                                }
                                if (easyuipost('${path_home}/cc/fangan/adu/d/dellOM.jw', {ids: ids.substring(1)})) {
                                    $('#dg').datagrid('reload');
                                }
                            }
                        });
                    }
//修改记录-----------------------------------                    
                    function update() {
                        var row = $('#dg').datagrid('getSelected');
                        if (!row) {
                            $.messager.alert('提示', '请选择行');
                            return;
                        }
                        $('#showUpdatePage').panel({title: row.fangan1_mc + " 预设值修改"});
                        $('#showUpdatePage').window('open');
                        loadHeader("showUpdatePage", '${path_home}/cc/fangan/adu/u/update/select.jw?selectUpdateID=' + row.fangan1_zj);
                    }
//移动------------------------------------
                    function MoveSave() {
                        var datas = $('#dg').datagrid('getData');
                        var rs = "";
                        for (var i = 0; i < datas.total; i++) {
                            rs = rs + (datas.rows[i], i == 0 ? "" : ",") + datas.rows[i].fangan1_zj;
                        }
                        var data = {};
                        data.ids = rs;
                        mypost('cc/fangan/adu/u/update/saveMove.jw', data, "saveMove");
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
//-------------------------子页面调用方法-------------------------                
                    function closethisWindow() {
                        $('#showUpdatePage').panel('close');
                    }
                </script>
                <select onchange="$('#dg').datagrid({singleSelect: (this.value == 0)});pageCN('dg', 100)">
                    <option value="0">单行选择</option>
                    <option value="1">多行选择</option>
                </select>

            </div>
        </div>
        <div id="showOneObj"></div>

        <div id="showUpdatePage" class="easyui-window" title="明细"
             style="width:90%;height:90%"
             data-options="closable:true,closed:true,modal:true,maximized:true">
        </div>                      
    </body>
</body>
</html>
