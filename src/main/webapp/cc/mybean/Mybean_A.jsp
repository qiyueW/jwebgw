<%@include file="/WEB-INF/jspf/power/userPower.jspf"%>
<%    if (!pck.checkUser("Y101_5")) {
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
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap.min.css" />
        <link rel="stylesheet" href="${path_home}/lib/bootstrap/css/bootstrap-theme.min.css" />
        <script src="${path_home}/lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script type="text/javascript"src="${path_home}/cc/mybean/js/Mybean_A.js?<%=new Date()%>"></script>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>

        <script type="text/javascript">
            var path_home = "${path_home}/";
            $(function () {
                iniMybeanEventA();
                var zcfl = new ztree_select("${path_home}/cc/mypackage/s/selectVast.jw", {}, "showmypackageTree", "mypackage_name", "mypackage_id", 375, 390);
                zcfl.init(function (treeId, treeNode) {
                    zcfl.setMyValue(treeNode)
                    zcfl.hideMenu();//$("#" +zcfl.menuContentDIV).fadeOut("fast");
                }, "mypackage_id", "mypackage_pid", "mypackage_name")
            });
            function ysfaSelect() {
                var v = $("#ysfaSelectID").val();
                $.get("${path_home}/cc/mybean/modeldata/" + v + ".json?ss=<%=new Date()%>", {}, function (data) {
//                    $("#mybean_zj").val(data.mybean_zj)//主键
//                    $("#mybean_px").val(data.mybean_px)//排序
//                    $("#mypackage_id").val(data.mypackage_id)//外键（归属包）
                    $("#mybean_mc").val(data.mybean_mc)//类名
                    $("#mybean_bz").val(data.mybean_bz)//备注
                    $("#package_bean").val(data.package_bean)//bean类包
                    $("#package_soo").val(data.package_soo)//soo/dao 类包
                    $("#name_soo").val(data.name_soo)//soo/dao 类
                    $("#package_service").val(data.package_service)//service类包
                    $("#name_service").val(data.name_service)//service类
                    $("#package_hm").val(data.package_hm)//hm类包
                    $("#name_hmA").val(data.name_hmA)//hmA类
                    $("#name_hmD").val(data.name_hmD)//hmD类
                    $("#name_hmU").val(data.name_hmU)//hmU类
                    $("#name_hmS").val(data.name_hmS)//hmS类
                    $("#package_validate").val(data.package_validate)//validate类包
                    $("#name_validate").val(data.name_validate)//validate类
                    $("#package_cache").val(data.package_cache)//cache类包
                    $("#name_cache").val(data.name_cache)//cache类
                    $("#package_vo").val(data.package_vo)//vo类包
                    $("#name_vo").val(data.name_vo)//vo类
                    $("#vpackage_admin").val(data.vpackage_admin)//jsp/html包
                    $("#vname_adminA").val(data.vname_adminA)//jsp/html_A
                    $("#vname_adminD").val(data.vname_adminD)//jsp/html_D
                    $("#vname_adminS").val(data.vname_adminS)//jsp/html_S
                    $("#vname_adminU").val(data.vname_adminU)//jsp/html_U
                    $("#vpackage_admin_js").val(data.vpackage_admin_js)//js包
                    $("#vname_admin_js").val(data.vname_admin_js)//js
                    $("#vpackage_admin_css").val(data.vpackage_admin_css)//css包
                    $("#vname_admin_css").val(data.vname_admin_css)//css
                    $("#power_code").val(data.power_code)//模块权限代码
                    $("#power_codeA").val(data.power_codeA)//权限代码A
                    $("#power_codeD").val(data.power_codeD)//权限代码D
                    $("#power_codeS").val(data.power_codeS)//权限代码S
                    $("#power_codeU").val(data.power_codeU)//权限代码U

                }, "json");
            }
        </script>
        <style>
            table{
                margin: 5px;
            }
            table input{
                border:0; 
                height: 35px;
                font-size: 8px;
            }
        </style>
    </head>
    <body>
        <div>
            <select id="ysfaSelectID" onchange="ysfaSelect()">
                <option value="empty">无</option>
                <option value="jwebBase">JWEB 基础模板 相关预设方案</option>
                <option value="jwebService">JWEB 业务模板 相关预设方案</option>
                
                <option value="jwebBase_tree">JWEB 基础模板_tree 相关预设方案</option>
                <option value="jwebBase_select">JWEB 基础模板_select 相关预设方案</option>
            </select>
        </div>
        <table border="1" cellpadding="0" cellspacing="0">
            <tr height="35">
                <td rowspan="2" height="70" width="72"  bgcolor="#ddddf7"><div align="center">bean相关</div></td>
                <td height="26" colspan="2" bgcolor="#ddddf7"><div align="center">bean包|类名</div></td>
                <td width="72" bgcolor="#ddddf7"><div align="center">排序</div></td>
                <td width="100" bgcolor="#ddddf7"><div align="center">备注</div></td>
                <td width="377" bgcolor="#ddddf7"><div align="center">分类归属</div></td>
            </tr>
            <tr height="35">
                <td width="200"><input type="text" name="package_bean" id="package_bean" style=" width:198px" /></td>
                <td width="100"><input type="text" name="mybean_mc" id="mybean_mc" style=" width:100px" /></td>
                <td><input type="text" name="mybean_px" id="mybean_px"  style=" width:70px" /></td>
                <td><input type="text" name="mybean_bz" id="mybean_bz" style=" width:98px" /></td>
                <td><div id="showmypackageTree"  style=" position: relative;z-index:1000"></div></td>
            </tr>
        </table>

        <table border="1" cellpadding="0" cellspacing="0">
            <tr height="35">
                <td rowspan="2" height="70" width="72"  bgcolor="#ddddf7"><div align="center">s包|类</div></td>
                <td height="26" colspan="2" bgcolor="#ddddf7"><div align="center">soo/dao包|类名</div></td>
                <td height="26" colspan="2" bgcolor="#ddddf7"><div align="center">service包|类名</div></td>
                <td height="26" colspan="5" bgcolor="#ddddf7"><div align="center">hm包|增 类名|删 类名|查 类名|改 类名</div></td>
            </tr>
            <tr height="35">
                <td width="200"><input type="text" name="package_soo" id="package_soo" style=" width:198px" /></td>
                <td width="100"><input type="text" name="name_soo" id="name_soo" style=" width:100px" /></td>
                <td width="200"><input type="text" name="package_service" id="package_service" style=" width:198px" /></td>
                <td width="100"><input type="text" name="name_service" id="name_service" style=" width:100px" /></td>  

                <td width="200"><input type="text" name="package_service" id="package_hm" style=" width:198px" /></td>
                <td><input type="text" name="name_hmA" id="name_hmA" style=" width:80px" /></td>  
                <td><input type="text" name="name_hmD" id="name_hmD" style=" width:80px" /></td>
                <td><input type="text" name="name_hmS" id="name_hmS" style=" width:80px" /></td>
                <td><input type="text" name="name_hmU" id="name_hmU" style=" width:80px" /></td>
            </tr>
        </table>

        <table border="1" cellpadding="0" cellspacing="0">
            <tr height="35">
                <td rowspan="2" height="70" width="72"  bgcolor="#ddddf7"><div align="center">s2包|类</div></td>
                <td height="26" colspan="2" bgcolor="#ddddf7"><div align="center">validate包|类名</div></td>
                <td height="26" colspan="2" bgcolor="#ddddf7"><div align="center">cache包|类名</div></td>
                <td height="26" colspan="2" bgcolor="#ddddf7"><div align="center">vo包|类名</div></td>
            </tr>
            <tr height="35">
                <td width="200"><input type="text" name="package_validate" id="package_validate" style=" width:198px" /></td>
                <td width="100"><input type="text" name="name_validate" id="name_validate" style=" width:100px" /></td>
                <td width="200"><input type="text" name="package_cache" id="package_cache" style=" width:198px" /></td>
                <td width="100"><input type="text" name="name_cache" id="name_cache" style=" width:100px" /></td> 

                <td width="200"><input type="text" name="package_vo" id="package_vo" style=" width:198px" /></td>
                <td width="100"><input type="text" name="name_vo" id="name_vo" style=" width:100px" /></td> 
            </tr>
        </table>


        <table border="1" cellpadding="0" cellspacing="0">
            <tr height="35">
                <td rowspan="2" height="70" width="72"  bgcolor="#ddddf7"><div align="center">v包|类</div></td>
                <td height="26" colspan="2" bgcolor="#ddddf7"><div align="center">js包|类名</div></td>
                <td height="26" colspan="2" bgcolor="#ddddf7"><div align="center">css包|类名</div></td>
                <td height="26" colspan="5" bgcolor="#ddddf7"><div align="center">jsp/html包|增 名|删 名|查 名|改 名</div></td>
            </tr>
            <tr height="35">
                <td width="200"><input type="text" name="vpackage_admin_js" id="vpackage_admin_js" style=" width:198px" /></td>
                <td width="100"><input type="text" name="vname_admin_js" id="vname_admin_js" style=" width:100px" /></td>
                <td width="200"><input type="text" name="vpackage_admin_css" id="vpackage_admin_css" style=" width:198px" /></td>
                <td width="100"><input type="text" name="vname_admin_css" id="vname_admin_css" style=" width:100px" /></td>  

                <td width="200"><input type="text" name="vpackage_admin" id="vpackage_admin" style=" width:198px" /></td>
                <td><input type="text" name="vname_adminA" id="vname_adminA" style=" width:80px" /></td>  
                <td><input type="text" name="vname_adminD" id="vname_adminD" style=" width:80px" /></td>
                <td><input type="text" name="vname_adminS" id="vname_adminS" style=" width:80px" /></td>
                <td><input type="text" name="vname_adminU" id="vname_adminU" style=" width:80px" /></td>
            </tr>
        </table>

        <table border="1" cellpadding="0" cellspacing="0">
            <tr height="35">
                <td rowspan="2" height="70" width="72"  bgcolor="#ddddf7"><div align="center">权限代码</div></td>
                <td height="26" bgcolor="#ddddf7"><div align="center">模块代码 代替符&lt;?p></div></td>
                <td height="26" bgcolor="#ddddf7"><div align="center">A代码</div></td>
                <td height="26" bgcolor="#ddddf7"><div align="center">D代码</div></td>
                <td height="26" bgcolor="#ddddf7"><div align="center">S代码</div></td>
                <td height="26" bgcolor="#ddddf7"><div align="center">U代码</div></td>
            </tr>
            <tr height="35">
                <td><input type="text" name="power_code" id="power_code" value="" style=" width:120px" /></td>  
                <td><input type="text" name="power_codeA" id="power_codeA" value="<?p>A" style=" width:80px" /></td>
                <td><input type="text" name="power_codeD" id="power_codeD" value="<?p>D" style=" width:80px" /></td>
                <td><input type="text" name="power_codeS" id="power_codeS" value="<?p>S" style=" width:80px" /></td>
                <td><input type="text" name="power_codeU" id="power_codeU" value="<?p>U" style=" width:80px" /></td>
            </tr>
        </table>
        <div style="margin: 10px;">
            <p>&lt;?c>表示 类名</p>
            <p>&lt;?c1>表示 小写类名</p>
            <p>&lt;?p>表示 模块权限代码</p>
        </div>

        <div style=" margin-top: 28px;">
            <button id="myMybeanButton" data-loading-text="执行中" style=" width:99%;"
                    class="btn btn-primary" autocomplete="off">创建</button>
        </div>


        <!--        <table>
                    <tr>
                        <td>排序</td><td> <input type="text" name="mybean_px" id="mybean_px"  /></td>
                    </tr>
                    <tr>
                        <td>包</td><td> </td>
                    </tr>
                    <tr>
                        <td>名称</td><td><input type="text" name="mybean_mc" id="mybean_mc" required /></td>
                    </tr>
                    <tr>
                        <td>备注</td><td><input type="text" name="mybean_bz" id="mybean_bz"  /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><div class="col-sm-9 col-sm-offset-4">
                                <button id="myMybeanButton" data-loading-text="执行中"
                                        class="btn btn-primary" autocomplete="off">添加</button>
                            </div></td>
                    </tr>
                </table>-->
    </body>
</html>
