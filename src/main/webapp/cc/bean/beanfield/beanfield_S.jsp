<%@include file="/WEB-INF/jspf/power/adminUserPower.jspf"%>
<%    if (!pck.checkUserORAdmin("Y101_8_1")) {
        return;
    }
    boolean update, dell;
    update = pck.checkUserORAdmin("Y101_8_2");
    dell = pck.checkUserORAdmin("Y101_8_3");
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
        <title>属性维护</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script type="text/javascript">
            $(function () {
                var zcfl = new ztree_select(
                        "${path_home}/cc/mypackage/s/selectVast.jw", {},
                        "showmypackageTree", "mypackage_name", "mypackage_id", 220, 390);
                zcfl.init(function (treeId, treeNode) {
                    zcfl.setMyValue(treeNode)
                    zcfl.hideMenu(); //$("#" +zcfl.menuContentDIV).fadeOut("fast");
                    $.fn.zTree.getZTreeObj("divID_Tree_bean").reAsyncChildNodes(null,
                            "refresh");
                }, "mypackage_id", "mypackage_pid", "mypackage_name")
                //======================================================================================================                
                //检出包结构  /*               
                var setting0 = {
                    treeId: "mypackage_id",
                    async: {
                        enable: true,
                        type: "post",
                        url: "${path_home}/cc/mypackage/s/selectVast.jw"
                    },
                    data: {
                        simpleData: {
                            enable: true,
                            idKey: "mypackage_id",
                            pIdKey: "mypackage_pid",
                            rootPId: "0"
                        },
                        key: {
                            name: "mypackage_name"
                        }
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {//点击部门时，重新加载管理员树。参数为
                            mypackage_id = treeNode.mypackage_id; //动态上传参数
                            $.fn.zTree.getZTreeObj("divID_Tree_bean")
                                    .reAsyncChildNodes(null, "refresh");
                        },
                        onAsyncSuccess: function () {
                            $.fn.zTree.getZTreeObj("divID_Tree_BM").expandAll(true);
                        }
                    }
                };
                $.fn.zTree.init($("#divID_Tree_BM"), setting0);
                //======================================================================================================
                //检出bean
                function ajaxDataFilter(treeId, parentNode, responseData) {
                    if (responseData) {
                        for (var i = 0; i < responseData.length; i++) {
                            responseData[i].bean_mc = responseData[i].bean_bz ? responseData[i].bean_mc
                                    + "(" + responseData[i].bean_bz + ")"
                                    : responseData[i].bean_mc;
                        }
                    }
                    return responseData;
                }
                var setting2 = {
                    treeId: "bean_zj",
                    check: {
                        enable: true
                    },
                    async: {
                        enable: true,
                        type: "post",
                        url: "${path_home}/cc/bean/s2/findHead.jw",
                        otherParam: ["mypackage_id", function () {
                                return $("#mypackage_id").val(); //mypackage_id
                            }],
                        dataFilter: ajaxDataFilter
                    },
                    data: {
                        simpleData: {
                            enable: true,
                            idKey: "bean_zj",
                            rootPId: "0"
                        },
                        key: {
                            name: "bean_mc"
                        }
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {
                            var queryParams = $('#dg').datagrid('options').queryParams;
                            queryParams.bean_zj = treeNode.bean_zj;
                            $('#dg').datagrid('reload');
                        }
                    }
                }
                $.fn.zTree.init($("#divID_Tree_bean"), setting2);
                $('#dg').datagrid('hideColumn', 'beanfield_zj');
                $('#dg').datagrid('hideColumn', 'bean_zj');
                pageCN("dg", 100);
            });
            function loadHeader(divId, pageUri) {
                document.getElementById(divId).innerHTML = '<iframe scrolling="no" frameborder="0"  src="' + pageUri + '" style="width:100%;height:100%;"></iframe>';
            }

        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'west',split:true" style="width:250px;padding:10px;">
            <div id="showmypackageTree" style="position: relative; z-index: 1000"></div> <!--<div id="divID_Tree_BM"  class="ztree powertablediv">---</div>-->
            <div id="divID_Tree_bean" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'"  id='centerMain'>
            <table id="dg" class="easyui-datagrid"
                   style="width:100%;height:100%"
                   data-options="rownumbers:true,singleSelect:true,url:'${path_home}/cc/bean/field/s/selectAllByJson.jw',method:'post',queryParams: {bean_zj:''},autoRowHeight:true,
                   pagination:true,
                   pageSize:50,
                   toolbar:'#tb'
                   ">
                <thead>
                    <tr>
                        <th data-options="field:'beanfield_zj'">ID</th>
                        <th data-options="field:'bean_zj'">FLID</th>
                        <th data-options="field:'ck',checkbox:true"></th>
                        <th data-options="field:'beanfield_px',width:40"><div>排序</div>bean_px</th>
                        <th data-options="field:'beanfield_mc',width:160,formatter:f_mc"><div>名称</div>bean_mc</th>
                        <th data-options="field:'beanfield_bz',width:160,formatter:f_bz"><div>备注</div>bean_bz</th>
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
                        $('#dg').datagrid('updateRow', {index: index, row: {beanfield_bz: fzFormatZT(row.beanfield_bz)}})
                        return fzFormatZT(row.beanfield_bz);
                    }
                    function f_mc(value, row, index) {
                        $('#dg').datagrid('updateRow', {index: index, row: {beanfield_mc: fzFormatZT(row.beanfield_mc)}})
                        return fzFormatZT(row.beanfield_mc);
                    }
//查询明细-----------------------------------                    
                    function f_cz(value, row, index) {
                        return "<a href=\"javascript:void(0)\" onclick=\"doo('" + row.beanfield_mc + "','" + row.beanfield_zj + "');\">属性明细</a>";
                    }
                    function doo(mc, zj) {
                        $('#showOneObj').window({
                            title: mc + " bean属性字段 拓展【键-值】明细",
                            width: 900,
                            height: 400,
                            modal: true,
                            maximized: true,
                            href: '${path_home}/cc/bean/field/s/selectOne.jw?beanfield_zj=' + zj
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
                                    ids = ids + "," + rows[i]['beanfield_zj']
                                }
                                if (easyuipost('${path_home}/cc/bean/field/adu/d/dellOM.jw', {ids: ids.substring(1)})) {
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
                        $('#showUpdatePage').panel({title: row.bean_mc + " bean拓展【键-值】修改"});
                        $('#showUpdatePage').window('open');
                        loadHeader("showUpdatePage", '${path_home}/cc/bean/field/adu/u/update/select.jw?selectUpdateID=' + row.beanfield_zj);
                    }
//移动------------------------------------
                    function MoveSave() {
                        var datas = $('#dg').datagrid('getData');
                        var rs = "";
                        for (var i = 0; i < datas.total; i++) {
                            rs = rs + (datas.rows[i], i == 0 ? "" : ",") + datas.rows[i].beanfield_zj;
                        }
                        var data = {};
                        data.ids = rs;
                        mypost('cc/bean/field/adu/u/update/saveMove.jw', data, "saveMove");
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
                <select onchange="$('#dg').datagrid({singleSelect: (this.value == 0)});
                        pageCN('dg', 100)">
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

