<%@include file="/WEB-INF/jspf/power/userPower.jspf"%>
<%    if (!pck.checkUser("Y101_9")) {
        return;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<base href="${path_home}/">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>bean模板维护</title>
        <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script type="text/javascript" src="${path_home}/cc/mymodel/js/myModel_A.js"></script>
        <script type="text/javascript">
            $(function () {
                var mybean;
                var beanfl = new ztree_select("${path_home}/cc/mypackage/s/selectVast.jw", {}, "showmypackageTree", "mypackage_name", "mypackage_id", 220, 390);
                beanfl.init(function (treeId, treeNode) {
                    beanfl.setMyValue(treeNode)
                    beanfl.hideMenu();//$("#" +beanfl.menuContentDIV).fadeOut("fast");
                    $.fn.zTree.getZTreeObj(mybean.treeID).reAsyncChildNodes(null, "refresh");
                }, "mypackage_id", "mypackage_pid", "mypackage_name")

                mybean = new ztree_select("${path_home}/cc/mybean/s/selectAllByJson.jw", {
                    mypackage_id: function () {
                        return $("#mypackage_id").val();
                    }
                }, "showmybeanTree", "mybean_mc", "mybean_zj", 220, 390);
                mybean.init(function (treeId, treeNode) {
                    mybean.setMyValue(treeNode)
                    mybean.hideMenu();
                }, "mybean_zj", "", "mybean_mc");

                $("#" + mybean.treeID).on('click', function () {
                    $("#mymodel_nr").html("");
                })

                var cmodelfl = new ztree_select(
                        "${path_home}/cc/cmodel/cmodelfl/s/selectVast.jw", {},
                        "showmycmodelflTree", "cmodelfl_name", "cmodelfl_id", 320, 390);
                cmodelfl.init(function (treeId, treeNode) {
                    cmodelfl.setMyValue(treeNode)
                    cmodelfl.hideMenu();
                    var queryParams = $('#dg').datagrid('options').queryParams;
                    queryParams.flzj = treeNode.cmodelfl_id;
                    $('#dg').datagrid('reload');
                }, "cmodelfl_id", "cmodelfl_pid", "cmodelfl_name");
                $('#dg').datagrid('hideColumn', 'cmodel_zj');
                pageCN('dg',20,[20,50,100]);
            });
            function onclickModel(rowIndex, rowData) {
                var mybean = $("#mybean_zj").val();
                if (!mybean) {
                    aalert("请先选择bean分类，再选择具体的bean");
                    return;
                }
                $("#mymodel_nr").html('');
                $.post('${path_home}/cc/cmodal/s/selectOne3.jw', {cmodel_zj: rowData.cmodel_zj, mybean_zj: mybean}, function (data) {
                    $("#mymodel_mc").val(rowData.cmodel_mc);
                    $("#mymodel_nr").html(data);
                    console.log(data)
                }, "text");
            }
        </script>
    </head>
    <body class="easyui-layout">
        <div data-options="region:'west',split:true" style="width:350px;padding:1px;">
            <div id="showmycmodelflTree" style="position: relative; z-index: 1000"></div>
            <table id="dg" class="easyui-datagrid"
                   style="width:320px;height:95%"
                   data-options="rownumbers:true,singleSelect:true,url:'${path_home}/cc/cmodal/s/selectAllByJson.jw'
                   ,method:'post'
                   ,queryParams: {flzj:''}
                   ,autoRowHeight:false
                   ,pagination:true
                   ,pageSize:50
                   ,onClickRow:onclickModel
                   ">
                <thead>
                    <tr>
                        <th data-options="field:'cmodel_zj'">ID</th>
                        <!--<th data-options="field:'ck',checkbox:true"></th>-->
                        <th data-options="field:'cmodel_mc',width:200">模板名</th>
                    </tr>
                </thead>
            </table>
        </div>


        <div data-options="region:'center'"  id='centerMain'>
            <div style="width:100%; height:90px;margin-top:8px;">
                <table border="1" cellpadding="0" cellspacing="0">
                    <tr height="35">
                        <td width="100" bgcolor="#ddddf7"><div align="center">bean分类</div></td>
                        <td width="100" bgcolor="#ddddf7"><div align="center" style="color:red">*bean</div></td>
                        <td bgcolor="#ddddf7"><div align="center">模板名</div></td>
                        <td width="110" bgcolor="#ddddf7"><div align="center">操作</div></td>
                    </tr>
                    <tr height="35">
                        <td width="100"><div id="showmypackageTree" style="position: relative; z-index: 1000"></div></td>
                        <td width="100"><div id="showmybeanTree" style="position: relative; z-index: 888"></div></td>
                        <td bgcolor="#ddddf7"><div align="center"> <input type="text" value="" id="mymodel_mc"/></div></td>
                        <td bgcolor="#ddddf7"><div align="center"> <input type="button" value="结果私有化" id="myMybeanButton" onclick="postMyModelFormData('myMybeanButton')"/></div></td>
                    </tr>
                </table>

            </div>
            <textarea style="width:100%;height:80%;overflow:scroll" id="mymodel_nr"></textarea>
        </div>
    </body>
</html>
