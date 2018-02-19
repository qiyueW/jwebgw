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
        <style>
            .red{
                color: red
            }
        </style>
        <script>
            $(function () {
                $("#myButton").on('click', function () {
                    var data = {};
                    data.account = $('#account').val()
                    data.password = $('#password').val()
                    $btn = $('#myButton').button('loading');
                    $.post(path_home+"sys/superadmin/manager/login.jw", data, function (data) {
                        if (data == '0') {
                            $.ligerDialog.alert("账号不存在或密码错误，请确认你的账号密码");
                            setTimeout(function () {
                                $btn.button('reset');
                            }, 1100);
                            return;
                        } else if (data == '1') {
                           window.location.href=path_home+"admin/indexAdminSuper.jsp";
    
                        }
                    }, "text");
                });
            });
        </script>
    </head>
    <body>
        <div id="formDivID" style="margin: 45px;max-width:600px;">
            <div class="row">
                <table class="table table-bordered">
                    <tr>
                        <td class="red">账号</td><td><input type="text" name="account" id="account" autocomplete="false" required /></td>
                    </tr>
                    <tr>
                        <td class="red">密码</td><td><input type="password" name="password" id="password" required /></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <div>
                                <button type="button" id="myButton" data-loading-text="执行中"
                                        class="btn btn-primary">登陆</button>
                            </div>
                        </td>
                    </tr>
                </table>
            </div> 
        </div>
    </body>
</html>
