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
        <script type="text/javascript"src="sys/role/jsdj/js/jsdj_U.js"></script>
        
        <script type="text/javascript">
            $(function () {
                iniEvent();
            });
        </script>
    </head>
    <body>
    <div class="container">
        <div class="row">
            <div class="panel panel-default">
                <div id="bm_divID" class="panel-body">
                    <form id="jsdj_formID" method="post" class="form-horizontal" onsubmit="return false;">
                        <input type="hidden" name="jsdj_zj" id="jsdj_zj" value="${obj.jsdj_zj}"  />
                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="jsdj_dm" >代号</label>
                            <div class="col-sm-5">
                                <input type="text" name="jsdj_dm" id="jsdj_dm"   value="${obj.jsdj_dm}" />
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-4 control-label" for="jsdj_mc">名称</label>
                            <div class="col-sm-5"><input type="text" name="jsdj_mc" id="jsdj_mc"  value="${obj.jsdj_mc}" required /></div>
                        </div>
                          <div class="form-group">
                            <label class="col-sm-4 control-label" for="jsdj_bz">备注</label>
                            <div class="col-sm-5"><input type="text" name="jsdj_bz" id="jsdj_bz"   value="${obj.jsdj_bz}" /></div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-9 col-sm-offset-4">
                                <button type="submit" id="myButton" data-loading-text="执行中"
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
