<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <!--后台UI组件End-->
        <script src="cc/cmodelfl/cmodelfl/lookup/cmodelflLookUp.js" type="text/javascript"></script>
        <link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
        <script src="lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="lib/jquery-validation/jquery.validate.min.js"
        type="text/javascript"></script>
        <script src="lib/jquery-validation/jquery.form.js"
        type="text/javascript"></script>
        <script type="text/javascript">
            $().ready(function () {
                var cb = f_dcBaseCModelFL("cmodelfl_pid2", "cmodelfl_pid", 200, 400, 100);
                cb.setValue("${fl_P.cmodelfl_id}");
                cb.setText("${fl_P.cmodelfl_name eq null?'顶级':fl_P.cmodelfl_name}");
                // 绑定FORM提交事件
                $('#cmodelfl_formID').submit(
                        function () {
                            $btn = $("#myButton").button('loading');
                            $(this).ajaxSubmit({dataType: "json", url: "${path_home}/cc/cmodel/cmodelfl/u/update.jw", success: function (result) {
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
        <div id="cmodelfl_divID">
            <form name="form" method="post"  id="cmodelfl_formID">
                <input type="hidden" name="cmodelfl_id" value="${cmodelfl.cmodelfl_id}" id="cmodelfl_id" />
                <table cellpadding="0" cellspacing="0" class="l-table-edit" >
                    <tr>
                        <td align="right" class="l-table-edit-td">上级:</td>
                        <td align="left" class="l-table-edit-td" style="width:160px">
                            <input type="text" name="cmodelfl_pid2" value="${cmodelfl.cmodelfl_pid}" id="cmodelfl_pid2" maxlength="26" ltype="text"/>
                        </td><td align="left"></td>
                    </tr>
                    <tr>
                        <td align="right" class="l-table-edit-td">名称(50字内):</td>
                        <td align="left" class="l-table-edit-td" style="width:160px">
                            <input type="text" name="cmodelfl_name" value="${cmodelfl.cmodelfl_name}" id="cmodelfl_name" validate="{required:true,minlength:1}" maxlength="50" ltype="text"/>
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
