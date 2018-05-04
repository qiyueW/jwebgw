<%--<%@include file="/WEB-INF/jspf/power/userPower.jspf"%>
<%    if (!pck.checkUser("Y101_19_1")) {
        return;
    }
%>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>数据-模板-产出</title>
        <script type="text/javascript" src="${path_home}/cc/fangan/js/fangan_A.js?<%=new Date()%>"></script>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script>
            $(function () {
                doInitSelect();
                doInitSelect(1);
                doInitSelect(2);
                doInitSelect(3);
                doInitSelect(4);
                doInitSelect(5);
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
                            var queryParams = $('#copydg').datagrid('options').queryParams;
                            queryParams.fanganfl_id = treeNode.fanganfl_id;
                            $('#copydg').datagrid('reload');
                        }
                    }
                }
                $.fn.zTree.init($("#divID_Tree_bean"), setting2);
                $('#copydg').datagrid('hideColumn', 'fangan1_zj');
                pageCN("copydg", 100);
            });

            function doInitSelect(i) {
                if (!i) {
                    i = ""
                }
                var zcfl2 = new ztree_select("${path_home}/cc/mypackage/s/selectVast.jw", {}, "bean_pak" + i, "mypackage_name" + i, "mypackage_id" + i, 250, 390);
                zcfl2.init(function (treeId, treeNode) {
                    zcfl2.setMyValue(treeNode)
                    zcfl2.hideMenu();
                    $('#bean_value' + i).combobox('reload', "${path_home}/cc/bean/s2/findHead.jw?mypackage_id=" + treeNode.mypackage_id).combobox('clear');
//                    $('#bean_id1' + i).val('');
                }, "mypackage_id", "mypackage_pid", "mypackage_name");
            }
            function copydata() {
                $('#findMyCopyData').window('open');//.window('refresh', '${path_home}/cc/yushizhi/s/selectOne.jw?yushizhi_zj=' + zj);
            }
            function f_cz(value, row, index) {
                return "<a href=\"javascript:void(0)\" onclick=\"doo('" + row.fangan1_zj + "','" + row.fangan1_mc + "','" + row.fangan1_bz + "');\">复制模板</a>";
            }
            function doo(zj, mc, bz) {
                $("#fangan1_zj").val(zj);
                $("#fangan1_mc").val(mc);
                $("#fangan1_bz").val(bz);
                $('#findMyCopyData').window('close');
            }
        </script>
        <style type="text/css">
            .STYLE1 {
                font-size: 22px;
                font-weight: bold;
            }
            table input{
                border: 0px;
            }
            .fanganForm input{
                width:300px;
                margin:3px;
            }
        </style>
    </head>
    <body>
        <div class="fanganForm" style=" margin:10px;">
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-search" plain="true" onclick="copydata()">复制现有模板</a>
            <div><input type="hidden" name="fangan1_zj" id="fangan1_zj" /></div>
            <div>方案:<input type="text" name="fangan1_mc" id="fangan1_mc" readonly="true"/></div>
            <div>备注:<input type="text" name="fangan1_bz" id="fangan1_bz" readonly="true"/></div>
        </div>

        <table  bordercolor="#0000FF" cellspacing="0" cellpadding="0" border="1" style="margin:10px;">
            <col width="60" />
            <col width="255" />
            <col width="210" />
            <tr height="28">
                <td rowspan="2" height="56" width="60"><div align="center" class="STYLE1">值</div></td>
                <td colspan="2" width="498"><div align="center" class="STYLE1">bean</div></td>
            </tr>
            <tr height="28">
                <td colspan="2" height="28">公共路径</td>
            </tr>
            <tr height="28">
                <td height="28"><div align="center">bean</div></td>
                <td><div id="bean_pak"></div></td>
                <td>
                    <input id="bean_value" class="easyui-combobox" data-options="
                           editable: true,valueField: 'bean_zj',textField: 'bean_mc',panelHeight: 'auto',width: 200,
                           onSelect: function(d){$('#bean_id').val(d.bean_zj)}"/>
                </td>
            </tr>
            <tr height="28">
                <td height="28"><div align="center">bean1</div></td>
                <td><div id="bean_pak1"></div></td>
                <td>
                    <input id="bean_value1" class="easyui-combobox" data-options="
                           editable: true,valueField: 'bean_zj',textField: 'bean_mc',panelHeight: 'auto',width: 200,
                           onSelect: function(d){$('#bean_id1').val(d.bean_zj)}"/>
                </td>
            </tr>
            <tr height="28">
                <td height="28"><div align="center">bean2</div></td>
                <td><div id="bean_pak2"></div></td>
                <td>
                    <input id="bean_value2" class="easyui-combobox" data-options="
                           editable: true,valueField: 'bean_zj',textField: 'bean_mc',panelHeight: 'auto',width: 200,
                           onSelect: function(d){$('#bean_id2').val(d.bean_zj)}"/>
                </td>
            </tr>
            <tr height="28">
                <td height="28"><div align="center">bean3</div></td>
                <td><div id="bean_pak3"></div></td>
                <td>
                    <input id="bean_value3" class="easyui-combobox" data-options="
                           editable: true,valueField: 'bean_zj',textField: 'bean_mc',panelHeight: 'auto',width: 200,
                           onSelect: function(d){$('#bean_id3').val(d.bean_zj)}"/>
                </td>
            </tr>
            <tr height="28">
                <td height="28"><div align="center">bean4</div></td>
                <td><div id="bean_pak4"></div></td>
                <td>
                    <input id="bean_value4" class="easyui-combobox" data-options="
                           editable: true,valueField: 'bean_zj',textField: 'bean_mc',panelHeight: 'auto',width: 200,
                           onSelect: function(d){$('#bean_id4').val(d.bean_zj)}"/>
                </td>
            </tr>
            <tr height="28">
                <td height="28"><div align="center">bean5</div></td>
                <td><div id="bean_pak5"></div></td>
                <td>
                    <input id="bean_value5" class="easyui-combobox" data-options="
                           editable: true,valueField: 'bean_zj',textField: 'bean_mc',panelHeight: 'auto',width: 200,
                           onSelect: function(d){$('#bean_id5').val(d.bean_zj)}"/>
                </td>
            </tr>
        </table>

        <div id="findMyCopyData" class="easyui-window" title="复制模板区" style="width:980px;min-height:450px;"
             data-options="closable:true,closed:true"
             >
            <div  class="easyui-layout"  data-options="fit:true">
                <div data-options="region:'west',split:true,title:'预设值分类'" style="width:250px;padding:10px;">
                    <div id="divID_Tree_bean" class="ztree">bean</div>
                </div>
                <div data-options="region:'center'"  id='centerMain'>
                    <table id="copydg" class="easyui-datagrid"
                           style="width:100%;height:100%"
                           data-options="rownumbers:true,singleSelect:true,url:'${path_home}/cc/fangan/s/selectAllByJson.jw',method:'post',queryParams: {fanganfl_id:''},autoRowHeight:true,
                           pagination:true,
                           pageSize:50,
                           ">
                        <thead>
                            <tr>
                                <th data-options="field:'fangan1_zj'">ID</th>
                                <th data-options="field:'a',width:80,formatter:f_cz">操作区</th>
                                <th data-options="field:'fangan1_mc',width:280">方案名</th>
                                <th data-options="field:'fangan1_bz',width:150">备注</th>
                            </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>

        <div align="center"> <input type="button" value="=====生产=====" id="myMybeanButton" onclick="postFanganAndBeanFormData('myMybeanButton')"/></div>

        <hr/>
        <div style="font-size:8px;">
            <p>注：</p>
            <p>bean行，是必定填的。取值方式如下：bean对象$&#123;bean.xxxx},xxxx为我们的属性名；bean对象的拓展值：直接$&#123;拓展键}；bean字段的取值：通过fields.是List集合，如$&#123;fields.xxxx}</p>
            <p>bean1行，是选填的。取值方式如下：bean对象$&#123;bean1.xxxx},xxxx为我们的属性名；bean对象的拓展值：直接$&#123;拓展键1}；bean字段的取值：通过fields.是List集合，如$&#123;fields1.xxxx}</p>
            <p>bean2行，是选填的。取值方式如下：bean对象$&#123;bean2.xxxx},xxxx为我们的属性名；bean对象的拓展值：直接$&#123;拓展键2}；bean字段的取值：通过fields.是List集合，如$&#123;fields2.xxxx}</p>
            <p>bean3行，是选填的。取值方式如下：bean对象$&#123;bean3.xxxx},xxxx为我们的属性名；bean对象的拓展值：直接$&#123;拓展键3}；bean字段的取值：通过fields.是List集合，如$&#123;fields3.xxxx}</p>
            <p>...</p>
            <p>发现规律了吗？1，2，3，4，5</p>
        </div>
        <script>
            function postFanganAndBeanFormData(btid) {
                var data = {};
                data.fangan1_zj = $("#fangan1_zj").val();
                data.bean = $('#bean_value').val()
                data.bean1 = $('#bean_value1').val()
                data.bean2 = $('#bean_value2').val()
                data.bean3 = $('#bean_value3').val()
                data.bean4 = $('#bean_value4').val()
                data.bean5 = $('#bean_value5').val()
                console.log(data);
                mypost('cc/fangan/use/create/userdata.jw', data, btid);
            }
        </script>
    </body>
</html>
