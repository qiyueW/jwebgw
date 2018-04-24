<%@include file="/WEB-INF/jspf/power/userPower.jspf"%>
<%    if (!pck.checkUser("Y101_12_2")) {
        return;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>
        <%@include file="/WEB-INF/jspf/zuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script type="text/javascript">
            var path_home = "${path_home}/";
            $(function () {
//                var wh = new GJS();
//                wh.setElementHeight("root", 40)
//                var beanfl;
//                var zcfl = new ztree_select(
//                        "${path_home}/cc/mypackage/s/selectVast.jw", {},
//                        "showmypackageTree", "mypackage_name", "mypackage_id", 220, 390);
//                zcfl.init(function (treeId, treeNode) {
//                    zcfl.setMyValue(treeNode)
//                    zcfl.hideMenu();//$("#" +zcfl.menuContentDIV).fadeOut("fast");
//                    $.fn.zTree.getZTreeObj(beanfl.treeID).reAsyncChildNodes(null,
//                            "refresh");
//                }, "mypackage_id", "mypackage_pid", "mypackage_name")
//
//                beanfl = new ztree_select(
//                        "${path_home}/cc/mybean/s/selectAllByJson.jw", {
//                            mypackage_id: function () {
//                                return $("#mypackage_id").val();//mypackage_id
//                            }
//                        }, "showmybeanTree", "mybean_mc", "mybean_zj", 220, 390);
//                beanfl.init(function (treeId, treeNode) {
//                    beanfl.setMyValue(treeNode)
//                    beanfl.hideMenu();//$("#" +zcfl.menuContentDIV).fadeOut("fast");
//                }, "mybean_zj", "", "mybean_mc")
//
//                $("input").addClass("input-sm")
//                $("#" + beanfl.treeID).on('click', function () {
//                    iniEmpty();
//                })
            });
            //              class=""
        </script>
        <style>
            .show2 {
                color: #00f;
                margin: 5px;
            }
            .show2 table{
                background-color: #ddddf7
            }

            .show3 {
                /*color: #ff9933;*/
                margin: 5px;
            }

            .showtitle {
                font-size: 18px;
            }
        </style>
    </head>
    <body>
        <div>
            <h3>通过 &#36;{fields} 取出对象的字段集合。</h3>
        </div>
        <div id="root" class="container" style=" overflow-y:scroll;">
            <div class="show2">
                <table cellspacing="0" cellpadding="0" border="1">
                    <td rowspan="2" height="68" width="72"><div align="center">JAVA类</div></td>
                    <td width="107" height="23"><div align="center">c作用域</div></td>
                    <td width="124"><div align="center">c类型</div></td>
                    <td width="139"><div align="center">c属性名</div></td>
                    <td width="200"><div align="center">c备注</div></td>
                    </tr>
                    <tr height="34">
                        <td height="34"><div align="center">c_zyy</div></td>
                        <td><div align="center">c_lx</div></td>
                        <td><div align="center">c_mc</div></td>
                        <td><div align="center">c_bz</div></td>
                    </tr>
                </table>
            </div>
            <div class="show3">
                <table cellspacing="0" cellpadding="0" border="1">
                    <td rowspan="2" height="68" width="72"><div align="center">数据表</div></td>
                    <td width="107" height="23"><div align="center">t类型</div></td>
                    <td width="124"><div align="center">t索引</div></td>
                    <td width="50"><div align="center">t允许空</div></td>
                    <td width="90"><div align="center">t长度</div></td>
                    <td width="200"><div align="center">t备注</div></td>
                    </tr>
                    <tr height="34">
                        <td height="34"><div align="center">t_lx</div></td>
                        <td><div align="center">t_sy</div></td>
                        <td  style="width:49px"><div align="center">t_yxkong</div></td>
                        <td><div align="center">t_cd</div></td>
                        <td><div align="center">t_bz</div></td>
                    </tr>
                </table>
            </div>
            <div class="show2">

                <table cellspacing="0" cellpadding="0" border="1">
                    <tr height="34">
                        <td rowspan="2" height="68" width="72"><div align="center"><div>后台</div>检验</div></td>
                        <td width="107"><div align="center">v必须检查</div></td>
                        <td width="300" height="23"><div align="center">v正则规则</div></td>
                        <td width="300"><div align="center">v错误信息</div></td>
                    </tr>
                    <tr height="34">
                        <td height="34"><div align="center">v_bxjiancha</div></td>
                        <td><div align="center">v_zzbds</div></td>
                        <td><div align="center">v_cuowuxx</div></td>
                    </tr>
                </table>
            </div>
            <div class="show3">
                <table cellspacing="0" cellpadding="0" border="1">
                    <tr height="34">
                        <td rowspan="2" height="68" width="72"><div align="center">html相关</div></td>
                        <td width="107"><div align="center">h类型</div></td>
                        <td width="90" height="23"><div align="center">h脚本校验</div></td>
                    </tr>
                    <tr height="34">
                        <td height="34"><div align="center">h_lx</div></td>
                        <td><div align="center">h_jb</div></td>
                    </tr>
                </table>
            </div>
            <div class="show2">
                <table cellspacing="0" cellpadding="0" border="1">
                    <tr height="34">
                        <td rowspan="2" height="68" width="72"><div align="center">excel相关</div></td>
                        <td width="107"><div align="center">e展示名</div></td>
                    </tr>
                    <tr height="34">
                        <td height="34"><div align="center">e_mc</div></td>
                    </tr>
                </table>
            </div>
        </div>
          
        <div>
            其它，预设值方案key: bean
        </div>
    </body>
</html>
