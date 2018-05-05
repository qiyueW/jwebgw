<%@include file="/WEB-INF/jspf/power/userPower.jspf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="height:32px; line-height:32px; text-align:center;">
            <%=hyy%> 
            <a href="javascript:void(0)" onclick="return updateMypassword()">修改密码</a>
            &nbsp;&nbsp;&nbsp;
            <a href="${path_home}/sys/user/manager/loginOut.jw">退出登陆</a>
        </div>

        <script>
            function updateMypassword() {
                        $.ligerDialog.open({title: '修改密码', url: '${path_home}/admin/usersafe/userSelf.jsp', height: 500, width: 600, isResize: true});
            }
        </script>
    </body>
</html>
