<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <!--后台UI组件Start-->
        <%-- <%@include file="/WEB-INF/jspf/admin-ui.jspf"%> --%>
        <!--后台UI组件End-->
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>  
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap.min.css" />
        <script src="${path_home}/lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <table class="table table-bordered">
                <tr>
                    <td>标题</td>
                    <td>
                        ${obj.spage_notice_biaoti}
                    </td>
                </tr>
                <tr>
                    <td>发布人</td>
                    <td>
                        ${obj.spage_notice_fabushijian}
                    </td>
                </tr>
                <tr>
                    <td>发布时间</td>
                    <td>
                        ${obj.spage_notice_zhidanren}
                    </td>
                </tr>
            </table>
            <hr/>
            <div>${obj.spage_notice_neirong}</div>
        </div>
    </body>
</html>
