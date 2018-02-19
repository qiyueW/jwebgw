 <!--%@include file="/WEB-INF/jspf/power/userPower.jspf"%-->
<%    
//    if (!pck.checkUser("J31")) {
//        return;
//    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="lib/bootstrap/css/bootstrap-theme.min.css" />
        <script src="lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script type="text/javascript"src="cc/mybean/js/Mybean_A.js"></script>
        
        <script type="text/javascript">
            $(function () {
                iniMybeanEventA();
            });
        </script>
    </head>
    <body>
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div id="mybean_divID" class="panel-body">
                    <form id="mybean_formID" method="post" class="form-horizontal" onsubmit="return false;">
                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="mybean_px">排序</label>
                            <div class="col-sm-5">
                                <input type="text" name="mybean_px" id="mybean_px"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="mybean_dm">代号</label>
                            <div class="col-sm-5">
                                <input type="text" name="mybean_dm" id="mybean_dm"  />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="mybean_mc">名称</label>
                            <div class="col-sm-5"><input type="text" name="mybean_mc" id="mybean_mc" required /></div>
                        </div>
                          <div class="form-group">
                            <label class="col-sm-4 control-label" for="mybean_bz">备注</label>
                            <div class="col-sm-5"><input type="text" name="mybean_bz" id="mybean_bz"  /></div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-9 col-sm-offset-4">
                                <button type="submit" id="myMybeanButton" data-loading-text="执行中"
                                        class="btn btn-primary" autocomplete="off">添加</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    </body>
</html>
