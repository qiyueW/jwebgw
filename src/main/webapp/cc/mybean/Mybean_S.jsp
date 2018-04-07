<%@include file="/WEB-INF/jspf/power/adminUserPower.jspf"%>
<%    if (!pck.checkUserORAdmin("Y101_6_1")) {
        return;
    }
    boolean update, dell;
    update = pck.checkUserORAdmin("Y101_6_2");
    dell = pck.checkUserORAdmin("Y101_6_3");
    String showPower = pck.getStrTool()
            .put(update, "<a href='javascript:void(0)' class='easyui-linkbutton' iconCls='icon-edit' plain='true' onclick='update()'>修改</a>")
            .put(dell, "<a href='javascript:void(0)' class='easyui-linkbutton' iconCls='icon-remove' plain='true' onclick='dellBeanField()'>删除</a>")
            .getString();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
<%@include file="/WEB-INF/jspf/artDialog.jspf"%>
<%@include file="/WEB-INF/jspf/ztree.jspf"%>
<%@include file="/WEB-INF/jspf/GG.jspf"%>
<!--后台UI组件End-->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script type="text/javascript">
//-------------------------------全局变量-------------------------------------------------
            var UPDATE;
            var GRID;
            var ADD;
            $(function () {
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
                            var queryParams = $('#dg').datagrid('options').queryParams;
                            queryParams.mypackage_id = treeNode.mypackage_id;
                            $('#dg').datagrid('reload');
                        },
                        onAsyncSuccess: function () {
                            $.fn.zTree.getZTreeObj("divID_Tree_BM").expandAll(true);
                        }
                    }
                };
                $.fn.zTree.init($("#divID_Tree_BM"), setting0);
//                $('#dg').datagrid('hideColumn', 'mybean_zj');
            });
        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'west',split:true,title:'bean'" style="width:250px;padding:10px;">
            <!--<div id="showmypackageTree" style="position: relative; z-index: 1000"></div> <div id="divID_Tree_BM"  class="ztree powertablediv">---</div>-->
            <div id="divID_Tree_BM" class="ztree">bean</div>
        </div>
        <div data-options="region:'center'" id='centerMain'>
            <!--            <div title="添加bean的属性">
                            <iframe width="100%" height="100%" src="${path_home}/cc/mybeanfield/Mybeanfield_A.jsp"></iframe>
                        </div>
                        <div title="bean明细" selected>-->
            <table id="dg" class="easyui-datagrid"
                   style="width:97%;height:100%"
                   data-options="rownumbers:true,singleSelect:true,url:'${path_home}/cc/mybean/s/selectVast.jw',method:'post',queryParams: {mypackage_id:''},autoRowHeight:true,
                   pagination:true,
                   pageSize:50,
                   toolbar:'#tb'
                   ">
                <thead>
                    <tr>
                        <th data-options="field:'mybean_zj',width:130"><div>主键</div>mybean_zj</th>
                        <th data-options="field:'ck',checkbox:true"></th>
                        <th data-options="field:'mybean_px',width:40"><div>排序</div>mybean_px</th>
                        <!--<th data-options="field:'mypackage_id',width:130"><div>外键（归属包）</div>mypackage_id</th>-->
                        <th data-options="field:'mybean_mc',width:130"><div>类名</div>mybean_mc</th>
                        <th data-options="field:'mybean_bz',width:70"><div>备注</div>mybean_bz</th>
                        <th data-options="field:'package_bean',width:260"><div>bean类包</div>package_bean</th>
                        <th data-options="field:'package_soo',width:260"><div>soo/dao 类包</div>package_soo</th>
                        <th data-options="field:'name_soo',width:160"><div>soo/dao 类</div>name_soo</th>
                        <th data-options="field:'package_service',width:260"><div>service类包</div>package_service</th>
                        <th data-options="field:'name_service',width:160"><div>service类</div>name_service</th>
                        <th data-options="field:'package_hm',width:260"><div>hm类包</div>package_hm</th>
                        <th data-options="field:'name_hmA',width:110"><div>hmA类</div>name_hmA</th>
                        <th data-options="field:'name_hmD',width:110"><div>hmD类</div>name_hmD</th>
                        <th data-options="field:'name_hmU',width:110"><div>hmU类</div>name_hmU</th>
                        <th data-options="field:'name_hmS',width:110"><div>hmS类</div>name_hmS</th>
                        <th data-options="field:'package_validate',width:160"><div>validate类包</div>package_validate</th>
                        <th data-options="field:'name_validate',width:110"><div>validate类</div>name_validate</th>
                        <th data-options="field:'package_cache',width:160"><div>cache类包</div>package_cache</th>
                        <th data-options="field:'name_cache',width:110"><div>cache类</div>name_cache</th>
                        <th data-options="field:'package_vo',width:160"><div>vo类包</div>package_vo</th>
                        <th data-options="field:'name_vo',width:110"><div>vo类</div>name_vo</th>
                        <th data-options="field:'vpackage_admin',width:160"><div>jsp/html包</div>vpackage_admin</th>
                        <th data-options="field:'vname_adminA',width:110"><div>jsp/html_A</div>vname_adminA</th>
                        <th data-options="field:'vname_adminD',width:110"><div>jsp/html_D</div>vname_adminD</th>
                        <th data-options="field:'vname_adminS',width:110"><div>jsp/html_S</div>vname_adminS</th>
                        <th data-options="field:'vname_adminU',width:110"><div>jsp/html_U</div>vname_adminU</th>
                        <th data-options="field:'vpackage_admin_js',width:60"><div>js包</div>vpackage_admin_js</th>
                        <th data-options="field:'vname_admin_js',width:160"><div>js</div>vname_admin_js</th>
                        <th data-options="field:'vpackage_admin_css',width:160"><div>css包</div>vpackage_admin_css</th>
                        <th data-options="field:'vname_admin_css',width:110"><div>css</div>vname_admin_css</th>
                        <th data-options="field:'power_code',width:110"><div>模块权限代码</div>power_code</th>
                        <th data-options="field:'power_codeA',width:110"><div>权限代码A</div>power_codeA</th>
                        <th data-options="field:'power_codeD',width:110"><div>权限代码D</div>power_codeD</th>
                        <th data-options="field:'power_codeS',width:110"><div>权限代码S</div>power_codeS</th>
                        <th data-options="field:'power_codeU',width:110"><div>权限代码U</div>power_codeU</th>
                    </tr>
                </thead>
            </table>
            <div id="tb" style="padding:2px 5px;">
                <%=showPower%>
                &nbsp;&nbsp;|
                 <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="selectOne()">明细</a>
                <script>
                    function dellBeanField() {
                        var rows = $('#dg').datagrid('getSelections');
                        if (!rows[0]) {
                            $.messager.alert('操作提示', '请选择行');
                            return;
                        }
                        $.messager.confirm('删除操作', '请确认是否执行删除操作', function (r) {
                            if (r) {
                                var ids = "";
                                for (var i = 0; i < rows.length; i++) {
                                    ids = ids + "," + rows[i]['mybean_zj']
                                }
                                if (easyuipost('${path_home}/cc/mybean/d/dell.jw', {ids: ids.substring(1)})) {
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
                        window.open('${path_home}/cc/mybean/u/update/select.jw?selectUpdateID=' + row.mybean_zj);
                    }
                    function selectOne() {
                        var row = $('#dg').datagrid('getSelected');
                        if (!row) {
                            $.messager.alert('明细', '请选择要查看的行');
                            return;
                        }
                        window.open('${path_home}/cc/mybean/s/selectOne.jw?id=' + row.mybean_zj);
                    }
                </script>
                <select onchange="$('#dg').datagrid({singleSelect: (this.value == 0)})">
                    <option value="0">单行选择</option>
                    <option value="1">多行选择</option>
                </select>
            </div>

            <!--</div>-->
        </div>
    </body>
</html>
