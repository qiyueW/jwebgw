<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jspf/power/adminUserPower.jspf"%>
<%  
    if (!pck.checkUserORAdmin("Y100_0")) {
        return;
    }
%>
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
        <script src="${path_home}/lib/jquery-validation/jquery.form.js" type="text/javascript"></script>
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
        <link rel="stylesheet" type="text/css" href="${path_home}/lib/webuploader/0.1.5/webuploader.css">
        <script type="text/javascript" src="${path_home}/lib/webuploader/0.1.5/webuploader.js"></script>
        <script type="text/javascript" src="${path_home}/spage/js/notice_A.js"></script>

        <script type="text/javascript">
            $(function () {
                inieditor();
                iniEvent();
            });
        </script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="panel panel-default">
                    <!-- <div class="panel-heading">
                            <h3 class="panel-title">添加</h3>
                    </div> -->
                    <div id="series_divID" class="panel-body">
                        <form id="spage_formID" method="post" class="form-horizontal"
                              method="${path_home}/spage/notice/add.jw">
                            <input type="hidden"name="twt_img" id="twt_img"/>
                            <div class="form-group">
                                <table>
                                    <tr>
                                        <td>*标题</td><td><input type="text"  name="spage_notice_biaoti" id="spage_notice_biaoti"/></td>
                                        <td>，*发布时间</td><td><input type="text" name="spage_notice_fabushijian"id="spage_notice_fabushijian"/></td>
                                    </tr>
                                </table>
                            </div >
                            <div class="form-group">
                                <div>内容明细</div>
                                <script type="text/plain" id="spage_notice_neirong"  name="spage_notice_neirong"></script>
                            </div>
                            <div class="form-group">
                                <div id="uploader">
                                    <div class="queueList">
                                        <div id="dndArea" class="placeholder">
                                            <div id="filePicker"></div>
                                        </div>
                                    </div>
                                    <div class="statusBar" style="display: none;">
                                        <div class="progress">
                                            <span class="text">0%</span> <span class="percentage"></span>
                                        </div>
                                        <div class="info"></div>
                                        <div class="btns">
                                            <div id="filePicker2"></div>
                                            <!-- <div class="uploadBtn">开始上传</div> -->
                                        </div>
                                    </div>
                                </div>
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
