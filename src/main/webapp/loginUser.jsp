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
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <style>
            .red{
                color: red
            }
        </style>
        <script>
            $(function () {
                $("#myButton").on('click', function () {
                    var data = {};
//                    data.account = $('#account').val()
//                    data.password = $('#password').val()
                    data.account = $.trim($('#account').val());
                    data.password = $.trim($('#password').val());//$('#password').val()
                    if (data.account.length == 0 || data.password.length == 0) {
                        aalert("账号或密码不能为空");
                        return;
                    }
                    $btn = $('#myButton').button('loading');
                    $.post(path_home + "sys/user/manager/login/user.jw", data, function (data) {
                        if (data == '0') {
                            $.ligerDialog.alert("账号不存在或密码错误，请确认你的账号密码");
                            setTimeout(function () {
                                $btn.button('reset');
                            }, 1100);
                            return;
                        } else if (data == '1') {
                            window.location.href = path_home + "admin/indexUser.jsp";

                        }
                    }, "text");
                });
            });
        </script>
    </head>
    <body>
        <div>
            <a href="${path_home}/viwe/ryzhuce.jsp">还没有账号？去申请一个吧</a>
        </div>
        <div id="formDivID" style="margin: 45px;max-width:600px;">
            <div class="row">
                <table class="table table-bordered">
                    <tr>
                        <td class="red">账号</td><td><input type="text" name="account" autocomplete="false" id="account" required /></td>
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
