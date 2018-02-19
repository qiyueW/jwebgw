<%@page import="java.util.Date"%>
<%@include file="/WEB-INF/jspf/power/superAminPower.jspf"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap-theme.min.css" />
        <!--<script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>-->
        <script src="${path_home}/lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script>
            if (typeof module === 'object') {
                window.jQuery = window.$ = module.exports;
            }
            var path_home = "${path_home}/";
        </script>
        <script type="text/javascript"src="${path_home}/sys/adminuser/js/adminuser_U.js?iisf=<%=new Date()%>"></script>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>     
        <style>
            .red{
                color: red
            }

        </style>
        <script>
            $(function () {
                iniEventAdminuserU();
//                var cb = f_dcBaseBM("bm_id2", "bm_id", 150);
//                cb.setValue("${obj.bm_id}");
//                cb.setText("${obj.bm_name eq null?'':obj.bm_name}");
                var zcfl = new ztree_select2("${path_home}/base/bm/selectVast.jw", {}, "showZCFLTree", "bm_name", "bm_id", 220, 390);
                zcfl.init(function (event, treeId, treeNode) {
                    zcfl.setMyValue(event, treeId, treeNode)
                    return false;
                }, 0, "bm_id", "bm_pid", "bm_name","${obj.bm_name}","${obj.bm_id}")
            });
        </script>
    </head>
    <body>
        <div id="formDivID" style="margin: 45px;max-width:600px;">
            <input type="hidden" name="user_id" id="user_id" value="${obj.user_id}"  />
            <div class="row">
                <table class="table table-bordered">
                    <tr>
                        <td height="30">部门</td>
                        <td>
                            <div id="showZCFLTree"></div>
                            <!--<input type="text" name="bm_id2" id="bm_id2" required />-->
                        </td>
                    </tr>
                    <tr>
                        <td class="red">用户名</td><td><input type="text" name="user_name" id="user_name" value="${obj.user_name}" required /></td>
                    </tr>
                    <tr>
                        <td class="red">账号(需唯一)</td><td><input type="text" name="user_account" id="user_account" value="${obj.user_account}" disabled="true" /></td>
                    </tr>
                    <tr>
                        <td class="red">密码</td><td><input type="password" name="user_password" id="user_password" value="${obj.user_password}" required /></td>
                    </tr>
                    <tr>
                        <td>邮箱</td><td><input type="text" name="user_email" id="user_email"  value="${obj.user_email}"/></td>
                    </tr>
                    <tr>
                        <td>类别</td>
                        <td><select name="user_sort" id="user_sort" disabled="true" >
                                <option value="管理员">管理员</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>状态</td>
                        <td>
                            <input type="text" name="user_style" id="user_style"  value="${obj.user_style}"disabled="true" />
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <div>
                                <button type="button" id="myButton" data-loading-text="执行中"
                                        class="btn btn-primary">修改</button>
                            </div>
                        </td>
                    </tr>
                </table>
            </div> 
        </div>
    </body>
</html>
