<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>预览方案</title>
    </head>
    <body>
        <table id="so_dg" class="easyui-datagrid"
               style="width:100%;height:100%;"
               data-options="rownumbers:true,url:'${path_home}/cc/fangan/s/select2OneByJson.jw',method:'post',queryParams: {fangan_zj:'${obj.fangan_zj}'},autoRowHeight:true
               ">
            <thead>
                <tr>
                    <th data-options="field:'fangan1_zj'">ID</th>
                    <th data-options="field:'fangan1_mc',width:280">方案名</th>
                    <th data-options="field:'fangan1_bz',width:150">备注</th>
                </tr>
            </thead>
        </table>
    </body>
</html>
