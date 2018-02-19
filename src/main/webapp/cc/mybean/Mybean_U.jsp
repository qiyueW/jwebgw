<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%--<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>  
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap-theme.min.css" />
        <script src="${path_home}/lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script type="text/javascript"src="${path_home}/cc/mybean/js/Mybean_U.js"></script>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>

        <script type="text/javascript">
             var path_home = "${path_home}/";
            $(function () {
                iniEvent();
                var zcfl = new ztree_select("${path_home}/cc/mypackage/s/selectVast.jw", {}, "showmypackageTree", "mypackage_name", "mypackage_id", 220, 390);
                zcfl.init(function (treeId, treeNode) {
                    zcfl.setMyValue(treeNode)
                    zcfl.hideMenu();//$("#" +zcfl.menuContentDIV).fadeOut("fast");
                }, "mypackage_id", "mypackage_pid", "mypackage_name","不选默认不变",'${obj.mypackage_id}')
            });
        </script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="panel panel-default">
                    <div id="mybean_divID" class="panel-body">
                        <form id="mybean_formID" method="post" class="form-horizontal" onsubmit="return false;">
                            <input type="hidden" name="mybean_zj" id="mybean_zj" value="${obj.mybean_zj}"  />
                            <div class="form-group">
                                <label class="col-sm-4 control-label" for="mybean_px" >排序</label>
                                <div class="col-sm-5">
                                    <input type="text" name="mybean_px" id="mybean_px"   value="${obj.mybean_px}" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label" for="mypackage_id" >包（不选默认不变）</label>
                                <div class="col-sm-5">
                                     <div id="showmypackageTree"  style=" position: relative;z-index:1000"></div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label" for="mybean_mc">名称</label>
                                <div class="col-sm-5"><input type="text" name="mybean_mc" id="mybean_mc"  value="${obj.mybean_mc}" required /></div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label" for="mybean_bz">备注</label>
                                <div class="col-sm-5"><input type="text" name="mybean_bz" id="mybean_bz"   value="${obj.mybean_bz}" /></div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-9 col-sm-offset-4">
                                    <button type="submit" id="myMybeanButton" data-loading-text="执行中"
                                            class="btn btn-primary" autocomplete="off">修改</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>
