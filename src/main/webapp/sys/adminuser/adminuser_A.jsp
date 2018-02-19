<%@include file="/WEB-INF/jspf/power/superAminPower.jspf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%--<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap-theme.min.css" />
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>
        <script src="${path_home}/lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script>
            if (typeof module === 'object') {
                window.jQuery = window.$ = module.exports;
            }
            var path_home = "${path_home}/";
        </script>
        <script type="text/javascript"src="${path_home}/sys/adminuser/js/adminuser_A.js"></script>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <style>
            .red{
                color: red
            }
        </style>
        <script>
            $(function () {
                var zcfl = new ztree_select2("${path_home}/base/bm/selectVast.jw", {}, "showZCFLTree", "bm_name", "bm_id", 220, 390);
                zcfl.init(function (event, treeId, treeNode) {
                    zcfl.setMyValue(event, treeId, treeNode)
                    return false;
                }, 0, "bm_id", "bm_pid", "bm_name")
            })
        </script>
    </head>
    <body>
        <div id="formDivID" style="margin: 45px;max-width:600px;">
            <div class="row">
                <table class="table table-bordered">
                    <tr>
                        <td height="30">部门</td>
                        <td>
                            <!--<input type="text" name="bm_id2" id="bm_id2" required />-->
                            <div id="showZCFLTree"></div>
                        </td>
                    </tr>
                    <tr>
                        <td class="red">用户名</td><td><input type="text" name="user_name" id="user_name" required /></td>
                    </tr>
                    <tr>
                        <td class="red">账号(需唯一)</td><td><input type="text" name="user_account" id="user_account" required /></td>
                    </tr>
                    <tr>
                        <td class="red">密码</td><td><input type="text" name="user_password" id="user_password" required /></td>
                    </tr>
                    <tr>
                        <td>邮箱</td><td><input type="text" name="user_email" id="user_email"  /></td>
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
                        <td><select name="user_style" id="user_style">
                                <option value="启用">启用</option>
                                <option value="停用">停用</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <div>
                                <button type="button" id="myButton" data-loading-text="执行中"
                                        class="btn btn-primary">添加</button>
                            </div>
                        </td>
                    </tr>
                </table>
            </div> 
        </div>
    </body>
</html>
