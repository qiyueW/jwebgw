<%@include file="/WEB-INF/jspf/power/superAminPower.jspf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap-theme.min.css" />
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>
        <script src="${path_home}/lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <style>
            .red{
                color: red
            }

        </style>
    <div class="container">
        <table class="table table-bordered">
            <tr>
                <td height="30">部门</td>
                <td>
                    <div style=" width: 500px; overflow-x: auto">${obj.bm_name}</div>
                </td>
            </tr>
            <tr>
                <td class="red">用户名</td><td>${obj.user_name}</td>
            </tr>
            <tr>
                <td class="red">账号(需唯一)</td><td>${obj.user_account}</td>
            </tr>
            <tr>
                <td class="red">密码</td><td>${obj.user_password}</td>
            </tr>
            <tr>
                <td>邮箱</td><td>${obj.user_email}</td>
            </tr>
            <tr>
                <td>类别</td>
                <td><select name="user_sort" id="user_sort">
                        <option value="管理员">管理员</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>状态</td>
                <td>${obj.user_style}
                </td>
            </tr>
        </table>
    </div> 