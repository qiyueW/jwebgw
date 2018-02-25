<%-- 
    Document   : test
    Created on : 2018-2-25, 14:50:18
    Author     : adm.wangchunzi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table id="dg" class="easyui-datagrid"
               style="width:300px;height:100%"
               data-options="rownumbers:true,singleSelect:true,url:'${path_home}/cc/mybean/modal/s/selectAllByJson.jw'
               ,method:'post'
               ,queryParams: {mybean_zj:''}
               ,autoRowHeight:false
               ,pagination:true
               ,pageSize:50
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
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="dellBeanField()">删除</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="update()">修改</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
            <select onchange="$('#dg').datagrid({singleSelect: (this.value == 0)})">
                <option value="0">单行选择</option>
                <option value="1">多行选择</option>
            </select>
        </div>
    </body>
</html>
