<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>  
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap.min.css" />
        <script src="${path_home}/lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script type="text/javascript">
            var path_home = '${path_home}/';
            window.UEDITOR_HOME_URL = path_home + "lib/ueditor/";
            // 添加全局站点信息
            var BASE_URL = path_home + 'lib/webuploader/0.1.5';

        </script>
        <!-- 配置文件 -->
        <script type="text/javascript" src="${path_home}/lib/ueditor/ueditor.config.js"></script>
        <!-- 实例化编辑器 -->
        <script type="text/javascript" src="${path_home}/lib/ueditor/ueditor.all.min.js"></script>
<!--        <link rel="stylesheet" type="text/css" href="${path_home}/lib/webuploader/0.1.5/webuploader.css">
        <script type="text/javascript" src="${path_home}/lib/webuploader/0.1.5/webuploader.js"></script>-->
        <script type="text/javascript" src="${path_home}/spage/js/indexpage_U.js"></script>

        <script type="text/javascript">
            var GUE;
            $(function () {
                GUE = UE.getEditor('spage_indexpage_neirong');
                iniEvent();
            });
        </script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="panel panel-default">
                    <div id="series_divID" class="panel-body">
                        <form id="spage_formID" method="post" class="form-horizontal">
                            <input type="hidden"name="spage_indexpage_zj" id="spage_indexpage_zj" value="${obj.spage_indexpage_zj}"/>
                            <div class="form-group">
                                <script type="text/plain" id="spage_indexpage_neirong"  name="spage_indexpage_neirong">${obj.spage_indexpage_neirong}</script>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-9 col-sm-offset-4">
                                    <button type="submit" id="myButton" data-loading-text="执行中"
                                            class="btn btn-primary" >提交</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
