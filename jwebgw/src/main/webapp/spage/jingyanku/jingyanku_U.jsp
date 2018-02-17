<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>  
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap.min.css" />
        <script src="${path_home}/lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script><!--
        <script src="${path_home}/lib/jquery-validation/jquery.form.js" type="text/javascript"></script>-->
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

        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <script type="text/javascript" src="${path_home}/spage/js/jingyanku_U.js"></script>
        <script type="text/javascript">
            $(function () {

                var zcfl = new ztree_select("${path_home}/base/tree/jingyankufl/s/selectVast.jw", {}, "showZCFLTree", "jingyankufl_name", "jingyankufl_id", 220, 390);
                zcfl.init(function (treeId, treeNode) {
                    zcfl.setMyValue(treeNode)
                    zcfl.hideMenu();//$("#" +zcfl.menuContentDIV).fadeOut("fast");
                }, "jingyankufl_id", "jingyankufl_pid", "jingyankufl_name","${obj.jingyankufl_name}","${obj.jingyankufl_id}")

                var setting0 = {
                    treeId: "jingyankufl_id",
                    async: {enable: true, type: "post", url: "${path_home}/base/tree/jingyankufl/s/selectVast.jw"},
                    data: {
                        simpleData: {enable: true, idKey: "jingyankufl_id", pIdKey: "jingyankufl_pid", rootPId: "0"},
                        key: {name: "jingyankufl_name"}
                    },
                    callback: {
                        onClick: function (event, id, treeNode) {
                            $("#jingyankufl_name").val(treeNode.jingyankufl_name);
                            $("#jingyankufl_id").val(treeNode.jingyankufl_id);
                        },
                        onAsyncSuccess: function () {
                            $.fn.zTree.getZTreeObj("divID_Tree").expandAll(true);
                        }
                    }
                };
                $.fn.zTree.init($("#divID_Tree"), setting0);

                inieditor();
                iniEvent();
            });
        </script>
    </head>
    <body>

        <div style="position: relative;">
            <input type="hidden"  name="spage_jingyanku_zj" id="spage_jingyanku_zj" value="${obj.spage_jingyanku_zj}"/>
            <table>
                <tr>
                    <td>*标题</td><td><input type="text"  name="spage_jingyanku_biaoti" id="spage_jingyanku_biaoti" value="${obj.spage_jingyanku_biaoti}"/></td>
                    <td>发布时间</td><td><input type="text" name="spage_jingyanku_fabushijian"id="spage_jingyanku_fabushijian"value="${obj.spage_jingyanku_fabushijian}"/></td>
                </tr>
                <tr>
                    <td>*关键词</td>
                    <td>
                        <input type="text"  name="spage_jingyanku_gjc" id="spage_jingyanku_gjc"value="${obj.spage_jingyanku_gjc}"/>
                    </td>
                    <td>*分类归档</td>
                    <td>
                        <div id="showZCFLTree"  style=" position: relative;z-index:1000"></div>
                    </td>
                </tr>
                <tr>
                    <td colspan="4">
                        <hr/>
                        <div class="form-group">
                            <div class="col-sm-9 col-sm-offset-4">
                                <button type="submit" id="myButton" data-loading-text="执行中"
                                        class="btn btn-primary" >提交</button>
                            </div>
                        </div>
                    </td>
                </tr>
            </table>
            <div>内容明细</div>
            <script type="text/plain" id="spage_jingyanku_neirong"  name="spage_jingyanku_neirong">${obj.spage_jingyanku_neirong}</script>
        </div>
    </body>
</html>
