<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title> ${obj.spage_jingyanku_biaoti}</title>
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
                        ${obj.spage_jingyanku_biaoti}
                    </td>
                </tr>
                <tr>
                    <td>关键词</td>
                    <td>
                        ${obj.spage_jingyanku_gjc}
                    </td>
                </tr>
                <tr>
                    <td>发布人</td>
                    <td>
                        ${obj.spage_jingyanku_zhidanren}
                    </td>
                </tr>
                <tr>
                    <td>发布时间</td>
                    <td>
                        ${obj.spage_jingyanku_fabushijian}
                    </td>
                </tr>
                <tr>
                    <td>归档分类</td>
                    <td>
                        ${obj.jingyankufl_name}
                    </td>
                </tr>
            </table>
            <hr/>
            <div>${obj.spage_jingyanku_neirong}</div>
        </div>
    </body>
</html>
