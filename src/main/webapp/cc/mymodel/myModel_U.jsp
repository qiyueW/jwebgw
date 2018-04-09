<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js"
        type="text/javascript"></script>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>

        <script type="text/javascript">
            function postMyModelFormData(btid) {
                var data = {};
                data.mymodel_zj = $('#mymodel_zj').val()
                data.mymodel_mc = toFormatZT($('#mymodel_mc').val())
                data.mymodel_nr = toFormatZT($('#mymodel_nr').val())
                mypost('cc/mymodel/u/update.jw', data, btid);
            }
        </script>
    </head>
    <body>
        <input type="hidden" name="mymodel_zj" id="mymodel_zj" value="${obj.mymodel_zj}"/>
        模板名
        <input type="text" name="mymodel_mc" id="mymodel_mc" value="${obj.mymodel_mc}"/>
        <br/><br/>
        模板内容
        <textarea id="mymodel_nr" style="width:100%; height:500px;">${obj.mymodel_nr}</textarea>
        <div style="text-align: center">
            <input type="button" value="提交"  style="width:100%; height:35px;" id="myMybeanButton" onclick="postMyModelFormData('myMybeanButton')">
        </div>
    </body>
</html>
