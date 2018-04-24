<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>预设模板-添加</title>
    </head>
    <body>
        <table id="so_dg" class="easyui-datagrid"
               style="width:100%;height:100%;"
               data-options="rownumbers:true,url:'${path_home}/cc/yushizhi/s/select2OneByJson.jw',method:'post',queryParams: {yushizhi_zj:'${obj.yushizhi_zj}'},autoRowHeight:true
               ">
            <thead>
                <tr>
                    <th data-options="field:'yushizhi2_key',width:200,editor:'text'">健</th>
                    <th data-options="field:'yushizhi2_value',width:350,editor:'text'">值</th>
                    <th data-options="field:'yushizhi2_bz',width:300,editor:'text'">备注</th>
                </tr>
            </thead>
        </table>
    </body>
</html>
