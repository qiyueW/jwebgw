<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/power/superAminPower.jspf"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link href="${path_home}/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />  
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>  
        <script src="${path_home}/lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script> 

        <!--后台UI组件End-->
        <style type="text/css">
            .tr{
                height: 30px;
            }
            .tr input{
                height: 29px;
                width:195px;
                border:none;
                outline:medium;
            }
            body{
                font-size: 15px;	
            }
        </style>
        <script type="text/javascript">
            $(function () {
                $("#updateMyPassword").on('click', function () {
                    var p0 = jQuery.trim($("#ry_account0").val());
                    var p1 = jQuery.trim($("#ry_account1").val());
                    var p2 = jQuery.trim($("#ry_account2").val());
                    if (p0 == "" || p1 == "" || p2 == "") {
                        $.ligerDialog.alert("请确保所有的密码不为空");
                        return;
                    }
                    if (p1 != p2) {
                        $.ligerDialog.alert("两次密码不一致");
                        return;
                    }
                    $.ligerDialog.confirm('确定提交?', function (yes) {
                        if (yes) {
                            $.post("${path_home}/power/safe/super/admin/update/mypssword.jw", {pw0: p0, pw1: p1}, function (data) {
                                $.ligerDialog.alert(data);
                            }, "text");
                        }
                    });
                });
            });
        </script>
    </head>
    <body>
        <div class="container">
            <table border="1" cellspacing="0" cellpadding="0">
                <tr class="tr">
                    <td height="37" >人员旧密码：</td>
                    <td><input type="password" name="ry_account" id="ry_account0" height="36px"/></td>
                </tr>
                <tr class="tr">
                    <td height="37" >人员新密码：</td>
                    <td><input type="password" name="ry_account" id="ry_account1"/></td>
                </tr>
                <tr class="tr">
                    <td height="37" >确认新密码：</td>
                    <td><input type="password" name="ry_account" id="ry_account2"/></td>
                </tr>
                <tr class="tr">
                    <td colspan="2" style="text-align: center">
                        <button id="updateMyPassword">修改密码</button>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
