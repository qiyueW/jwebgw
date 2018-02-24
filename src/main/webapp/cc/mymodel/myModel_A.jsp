<!--%@include file="/WEB-INF/jspf/power/userPower.jspf"%-->
<%
    //    if (!pck.checkUser("J31")) {
    //        return;
    //    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js"
        type="text/javascript"></script>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <%@include file="/WEB-INF/jspf/zuiLocal.jspf"%>
        <script type="text/javascript"
        src="${path_home}/cc/mymodel/js/myModel_A.js"></script>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>

        <script type="text/javascript">
           
            $(function () {
//                iniMybeanEventA();
                var beanfl;
                var zcfl = new ztree_select(
                        "${path_home}/cc/mypackage/s/selectVast.jw", {},
                        "showmypackageTree", "mypackage_name", "mypackage_id", 220, 390);
                zcfl.init(function (treeId, treeNode) {
                    zcfl.setMyValue(treeNode)
                    zcfl.hideMenu();//$("#" +zcfl.menuContentDIV).fadeOut("fast");
                    $.fn.zTree.getZTreeObj(beanfl.treeID).reAsyncChildNodes(null,
                            "refresh");
                }, "mypackage_id", "mypackage_pid", "mypackage_name")

                beanfl = new ztree_select(
                        "${path_home}/cc/mybean/s/selectAllByJson.jw", {
                            mypackage_id: function () {
                                return $("#mypackage_id").val();
                            }
                        }, "showmybeanTree", "mybean_mc", "mybean_zj", 220, 390);
                beanfl.init(function (treeId, treeNode) {
                    beanfl.setMyValue(treeNode)
                    beanfl.hideMenu();
                }, "mybean_zj", "", "mybean_mc")

                $("#" + beanfl.treeID).on('click', function () {
                    $("#showModelText").html("");
                })
            });

            function selectM_Sort() {
                var userchoose = $("#m_fanan").val();
                var qj = $("#mybean_mc").val();
                if (qj == "") {
                    aalert("请先确认bean！");
                    return;
                }
                if (userchoose == "") {
                    $("#showModelText").html("");
                    return;
                }
                $.post("${path_home}/cc/mybean/modal/s/base/selectVast.jw", {
                    mybean_zj: $("#mybean_zj").val(),
                    "sort": userchoose
                }, function (data) {
                    $("#showModelText").html(data);
                }, "text")
            }
        </script>
    </head>
    <body>
        <div id="root" class="container">
            <table class="table" id="table1">
                <tr>
                    <td style="width: 80px;">包</td>
                    <td>
                        <div id="showmypackageTree"
                             style="position: relative; z-index: 1000"></div>
                    </td>
                </tr>
                <tr>
                    <td>bean</td>
                    <td>
                        <div id="showmybeanTree" style="position: relative; z-index: 888"></div>
                    </td>
                </tr>
                <tr>
                    <td>常用模型</td>
                    <td><select id="m_fanan" onchange="selectM_Sort()">
                            <option value="">无</option>
                            <option value="bean">bean</option>
                            <option value="sql">sql</option>
                            <option value="jsgetset">jsgetset</option>

                        </select></td>
                </tr>
                <tr>
                    <td>模板名</td>
                    <td><input type="text" name="mymodel_mc" id="mymodel_mc" /></td>
                </tr>
                <tr>
                    <td>模板内容</td>
                    <td><textarea id="mymodel_nr"
                                  style="width: 800px; height: 500px;"></textarea></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div style="text-align: center">
                        <input type="button" value="提交" id="myMybeanButton" onclick="postMyModelFormData('myMybeanButton')">
                        </div>
                    </td>
                </tr>
            </table>
        </div>
</body>
</html>
