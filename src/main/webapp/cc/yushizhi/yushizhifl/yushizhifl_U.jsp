<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <!--后台UI组件End-->
        <script src="cc/yushizhi/yushizhifl/lookup/yushizhiflLookUp.js" type="text/javascript"></script>
        <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
        <script src="lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="lib/jquery-validation/jquery.validate.min.js"
        type="text/javascript"></script>
        <script src="lib/jquery-validation/jquery.form.js"
        type="text/javascript"></script>
        <script type="text/javascript">
            $().ready(function () {
                var cb = f_dcBaseYushizhiFL("yushizhifl_pid2", "yushizhifl_pid", 200, 400, 100);
                cb.setValue("${fl_P.yushizhifl_id}");
                cb.setText("${fl_P.yushizhifl_name eq null?'顶级':fl_P.yushizhifl_name}");
                // 绑定FORM提交事件
                $('#yushizhifl_formID').submit(
                        function () {
                            $btn = $("#myButton").button('loading');
                            $(this).ajaxSubmit({dataType: "json", url: "${path_home}/cc/yushizhi/yushizhifl/u/update.jw", success: function (result) {
                                    if (result.statusCode == 99) {
                                        var msg = "";
                                        for (var i in result.msg) {
                                            msg = msg
                                                    + result.msg[i]
                                                    + "\n";
                                        }
                                        alert(msg);
                                    } else if (result.statusCode == 0
                                            || result.statusCode == 1
                                            || result.statusCode == -1) {
                                        alert(result.msg);
                                    }
                                }
                            });
                            setTimeout(function () {
                                $btn.button('reset');
                            }, 1100);
                            return false;
                        });
            });
        </script>
    </head>
    <body style="padding:10px">
        <div id="yushizhifl_divID">
            <form name="form" method="post"  id="yushizhifl_formID">
                <input type="hidden" name="yushizhifl_id" value="${yushizhifl.yushizhifl_id}" id="yushizhifl_id" />
                <table cellpadding="0" cellspacing="0" class="l-table-edit" >
                    <tr>
                        <td align="right" class="l-table-edit-td">上级:</td>
                        <td align="left" class="l-table-edit-td" style="width:160px">
                            <input type="text" name="yushizhifl_pid2" value="${yushizhifl.yushizhifl_pid}" id="yushizhifl_pid2" maxlength="26" ltype="text"/>
                        </td><td align="left"></td>
                    </tr>
                    <tr>
                        <td align="right" class="l-table-edit-td">名称(50字内):</td>
                        <td align="left" class="l-table-edit-td" style="width:160px">
                            <input type="text" name="yushizhifl_name" value="${yushizhifl.yushizhifl_name}" id="yushizhifl_name" validate="{required:true,minlength:1}" maxlength="50" ltype="text"/>
                        </td><td align="left"></td>
                    </tr>
                    <tr style=" height: 100px;">
                        <td></td>
                        <td>
                            <input type="submit" value="提交" id="Button1" class="l-button l-button-submit" /> 
                        </td><td></td>
                    </tr>
                </table>
                <br />
            </form>
        </div>
    </body>
</html>
