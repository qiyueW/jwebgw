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
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>  
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap-theme.min.css" />
        <script src="${path_home}/lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script type="text/javascript"src="${path_home}/cc/mybean/js/Mybean_A.js"></script>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>

        <script type="text/javascript">
            var path_home = "${path_home}/";
            $(function () {
                iniMybeanEventA();
                var beanfl;
                var zcfl = new ztree_select("${path_home}/cc/mypackage/s/selectVast.jw", {}, "showmypackageTree", "mypackage_name", "mypackage_id", 220, 390);
                zcfl.init(function (treeId, treeNode) {
                    zcfl.setMyValue(treeNode)
                    zcfl.hideMenu();//$("#" +zcfl.menuContentDIV).fadeOut("fast");
                    $.fn.zTree.getZTreeObj(beanfl.treeID).reAsyncChildNodes(null, "refresh");
                }, "mypackage_id", "mypackage_pid", "mypackage_name")

                beanfl = new ztree_select("${path_home}/cc/mybean/s/selectAllByJson.jw", {
                    mypackage_id: function () {
                        return $("#mypackage_id").val();//mypackage_id
                    }
                }, "showmybeanTree", "mybean_mc", "mybean_zj", 220, 390);
                beanfl.init(function (treeId, treeNode) {
                    beanfl.setMyValue(treeNode)
                    beanfl.hideMenu();//$("#" +zcfl.menuContentDIV).fadeOut("fast");
                }, "mybean_zj", "", "mybean_mc")

                $("input").addClass("input-sm")
            });
//              class="" 
        </script>
        <style>
            table select{
                min-width: 90px;
            }
            .show2{
                color: #00f
            }
            .show3{
                color:#ff9933
            }
            .showtitle{
                font-size: 18px;
            }

        </style>
    </head>
    <body>
        <div id="root" class="container">
            <table class="table" id="table1">
                <tr>
                    <td style="width:80px;">包</td><td> <div id="showmypackageTree"  style=" position: relative;z-index:1000"></div></td>
                </tr>
                <tr>
                    <td>bean</td><td> <div id="showmybeanTree"  style=" position: relative;z-index:888"></div></td>
                </tr>
                <!--                <tr>
                                    <td>排序</td><td> <input type="text" name="mybean_px" id="mybeanfield_px"/></td>
                                </tr>-->
                <tr>
                    <td>备注</td><td><input type="text" name="mybeanfield_bz" id="mybeanfield_bz" /></td>
                </tr>
                <tr>
                    <td>Date格式</td><td>
                        <select id="mybeanfield_dateformat"  >
                            <option value="yyyy-MM-dd">yyyy-MM-dd</option>
                            <option value="yyyy-MM-dd HH:mm:ss">yyyy-MM-dd HH:mm:ss</option>
                        </select>
                    </td>
                </tr>
            </table>
            <div class="show2">
                <div class="showtitle">JAVA类</div>
                <table class="table" id="table2">
                    <tr>
                        <td style="width:80px;">c作用域</td><td>
                            <select id="c_zyy">
                                <option value="private">private</option>
                                <option value="public">public</option>
                                <option value="protected">protected</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>c类型</td><td>
                            <select id="c_lx">
                                <option value="String">String</option>
                                <option value="Integer">Integer</option>
                                <option value="Date">Date</option>
                                <option value="Double">Double</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>c属性名</td><td> <input type="text" name="c_mc" id="c_mc" /></td>
                    </tr>
                    <tr>
                        <td>c备注</td><td> <input type="text" name="c_bz" id="c_bz" /></td>
                    </tr>
                </table>
            </div>
            <div class="show3">
                <div class="showtitle">数据库表</div>
                <table class="table" id="table2">
                    <tr>
                        <td style="width:80px;">t类型</td><td>
                            <select id="t_lx">
                                <option value="VARCHAR">VARCHAR</option>
                                <option value="CHAR">CHAR</option>
                                <option value="TEXT">TEXT</option>
                                <option value="DATE">DATE</option>
                                <option value="DATETIME">DATETIME</option>
                                <option value="INT">INT</option>
                                <option value="DOUBLE">DOUBLE</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width:80px;">t索引</td><td>
                            <select id="t_sy">
                                <option value="f">否</option>
                                <option value="s">是</option>
                                <option value="wy">唯一</option>
                                <option value="zj">主键</option>
                                <!--<option value="wj">外键</option>-->
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td style="width:80px;">t允许空</td><td>
                            <select id="t_yxkong">
                                <option value="s">是</option>
                                <option value="f">否</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>t长度</td><td> <input type="number" name="t_cd" id="t_cd" /></td>
                    </tr>
                    <tr>
                        <td>t备注</td><td> <input type="text" name="t_bz" id="t_bz" /></td>
                    </tr>
                </table>
            </div>
            <div class="show2">
                <div class="showtitle">后台检验</div>
                <table class="table" id="table2">
                    <tr>
                        <td style="width:80px;">v正则规则</td><td>
                            <input type="text" name="v_zzbds" id="v_zzbds" />
                        </td>
                    </tr>
                    <tr>
                        <td style="width:80px;">v出错提醒</td><td>
                            <input type="text" name="v_cuowuxx" id="v_cuowuxx" />
                        </td>
                    </tr>
                    <tr>
                        <td style="width:80px;">v必须检查</td><td>
                            <select id="v_bxjiancha">
                                <option value="s">是</option>
                                <option value="f">否</option>
                                <option value="w">不存在检查</option>
                            </select>
                        </td>
                    </tr>
                </table>
            </div>

            <div class="show3">
                <div class="showtitle">html相关</div>
                <table class="table" id="table2">
                    <tr>
                        <td style="width:80px;">h类型</td><td>
                            <select id="h_lx">
                                <option value="text">文本</option>
                                <option value="select">选择框</option>
                                <option value="checkbox">复选框</option>
                                <option value="radio">单选框</option>
                                <option value="radio">日期/时间</option>
                                <option value="file">文件</option>
                                <option value="ueditor">文本ueditor</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>t长度</td><td> <input type="number" name="t_cd" id="t_cd" /></td>
                    </tr>
                </table>
            </div>
        </div><!--root div end-->
    </body>
</html>
