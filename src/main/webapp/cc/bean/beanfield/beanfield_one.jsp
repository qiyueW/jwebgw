<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>属性字段明细</title>
    </head>
    <body>
        <table id="so_dg" class="easyui-datagrid"
               style="width:100%;height:100%;"
               data-options="rownumbers:true,singleSelect:true,url:'${path_home}/cc/bean/field/s/select2OneByJson.jw',method:'post',queryParams:{beanfield_zj:'${obj.beanfield_zj}'},autoRowHeight:true
               ">
            <thead>
                <tr>
                    <th data-options="field:'beanfield2_key',width:200,editor:'text'">健</th>
                    <th data-options="field:'beanfield2_value',width:350,editor:'text'">值</th>
                    <th data-options="field:'beanfield2_bz',width:300,editor:'text'">备注</th>
                </tr>
            </thead>
        </table>
    </body>
</html>
