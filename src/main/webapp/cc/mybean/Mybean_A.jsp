<%@include file="/WEB-INF/jspf/power/userPower.jspf"%>
<%
    if (!pck.checkUser("Y101_5")) {
        return;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>  
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap-theme.min.css" />
        <script src="${path_home}/lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script type="text/javascript"src="${path_home}/cc/mybean/js/Mybean_A.js"></script>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>

        <script type="text/javascript">
             var path_home = "${path_home}/";
            $(function () {
                iniMybeanEventA();
                var zcfl = new ztree_select("${path_home}/cc/mypackage/s/selectVast.jw", {}, "showmypackageTree", "mypackage_name", "mypackage_id", 220, 390);
                zcfl.init(function (treeId, treeNode) {
                    zcfl.setMyValue(treeNode)
                    zcfl.hideMenu();//$("#" +zcfl.menuContentDIV).fadeOut("fast");
                }, "mypackage_id", "mypackage_pid", "mypackage_name")
            });
        </script>
    </head>
    <body>

        <table>
            <tr>
                <td>排序</td><td> <input type="text" name="mybean_px" id="mybean_px"  /></td>
            </tr>
            <tr>
                <td>包</td><td> <div id="showmypackageTree"  style=" position: relative;z-index:1000"></div></td>
            </tr>
            <tr>
                <td>名称</td><td><input type="text" name="mybean_mc" id="mybean_mc" required /></td>
            </tr>
            <tr>
                <td>备注</td><td><input type="text" name="mybean_bz" id="mybean_bz"  /></td>
            </tr>
            <tr>
                <td colspan="2"><div class="col-sm-9 col-sm-offset-4">
                        <button id="myMybeanButton" data-loading-text="执行中"
                                class="btn btn-primary" autocomplete="off">添加</button>
                    </div></td>
            </tr>
        </table>
    </body>
</html>
