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
               data-options="rownumbers:true,singleSelect:true,url:'${path_home}/cc/fangan/s/select2OneByJson.jw',method:'post',queryParams: {fangan_zj:'${obj.fangan1_zj}'},autoRowHeight:true
               ">
            <thead>
                <tr>
                    <th data-options="field:'fangan2_filepath',width:280">投产路径</th>
                    <th data-options="field:'fangan2_filename',width:280">生产文件名</th>
                    <th data-options="field:'cmodel_mc',width:180">投产模板</th>
                    <th data-options="field:'fangan2_bz',width:200">备注</th>
                </tr>
            </thead>
        </table>
    </body>
</html>
