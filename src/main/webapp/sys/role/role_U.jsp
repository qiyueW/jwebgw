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
        <script type="text/javascript"src="sys/role/js/role_U.js"></script>
        <script type="text/javascript" src="CJ.js"></script>

        <script type="text/javascript">
            $(function () {
                iniEventU();
                toSelect("jsdj_zj", path_home + "sys/power/jsdj/s/selectAllByJson.jw", "jsdj_zj", "jsdj_mc", "${obj.jsdj_zj}");
            });
        </script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading">

                    </div>
                    <div id="bm_divID" class="panel-body">
                        <form id="formID" method="post" class="form-horizontal" onsubmit="return false;">
                            <input type="hidden" name="role_id" id="role_id" value="${obj.role_id}"  />
                            <div class="form-group">
                                <label class="col-sm-4 control-label" for="jsdj_zj">级别</label>
                                <div class="col-sm-5">
                                    <select name="jsdj_zj" id="jsdj_zj"></select>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label" for="role_name">角色</label>
                                <div class="col-sm-5">
                                    <input type="text" name="role_name" id="role_name" required value="${obj.role_name}" />
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-4 control-label" for="role_info">备注</label>
                                <div class="col-sm-5">
                                    <input type="text" name="role_info" id="role_info" value="${obj.role_info}" />
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-9 col-sm-offset-4">
                                    <button type="button" id="myButtonU" data-loading-text="执行中"
                                            class="btn btn-primary">修改</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div> 
        </div>
    </body>
</html>
