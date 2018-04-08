<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>MyBean明细</title>
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>  
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>

        <script type="text/javascript">
            var path_home = "${path_home}/";
            $(function () {
                iniEvent();
                var zcfl = new ztree_select("${path_home}/cc/mypackage/s/selectVast.jw", {}, "showmypackageTree", "mypackage_name", "mypackage_id", 220, 390);
                zcfl.init(function (treeId, treeNode) {
                    zcfl.setMyValue(treeNode)
                    zcfl.hideMenu();//$("#" +zcfl.menuContentDIV).fadeOut("fast");
                }, "mypackage_id", "mypackage_pid", "mypackage_name", "不选默认不变", '${obj.mypackage_id}')
            });
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
            body{
                font-size:12px;
            }
        </style>
    </head>
    <body>
        <input type="hidden" name="mybean_zj" id="mybean_zj" value="${obj.mybean_zj}"  />
        <table border="1" cellpadding="0" cellspacing="0">
            <tr height="35">
                <td rowspan="2" height="70" width="72"  bgcolor="#ddddf7"><div align="center">bean相关</div></td>
                <td height="26" colspan="2" bgcolor="#ddddf7"><div align="center">bean包|类名</div></td>
                <td width="72" bgcolor="#ddddf7"><div align="center">排序</div></td>
                <td width="100" bgcolor="#ddddf7"><div align="center">备注</div></td>
                <td width="377" bgcolor="#ddddf7"><div align="center">分类归属</div></td>
            </tr>
            <tr height="35">
                <td style="min-width:180px;">${obj.package_bean}</td>
                <td style="min-width:135px;">${obj.mybean_mc}</td>
                <td style="min-width:135px;">${obj.mybean_px}</td>
                <td style="min-width:180px;">${obj.mybean_bz}</td>
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
                <td style="min-width:180px;">${obj.package_soo}</td>
                <td style="min-width:135px;">${obj.name_soo}</td>
                <td style="min-width:180px;">${obj.package_service}</td>
                <td style="min-width:135px;">${obj.name_service}</td>
                <td style="min-width:180px;">${obj.package_hm}</td>
                <td style="min-width:135px;">${obj.name_hmA}</td>
                <td style="min-width:135px;">${obj.name_hmD}</td>
                <td style="min-width:135px;">${obj.name_hmS}</td>
                <td style="min-width:135px;">${obj.name_hmU}</td>
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
                <td style="min-width:180px;">${obj.package_validate}</td>
                <td style="min-width:135px;">${obj.name_validate}</td>
                <td style="min-width:180px;">${obj.package_cache}</td>
                <td style="min-width:135px;">${obj.name_cache}</td>
                <td style="min-width:180px;">${obj.package_vo}</td>
                <td style="min-width:135px;">${obj.name_vo}</td>
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
                <td style="min-width:180px;">${obj.vpackage_admin_js}</td>
                <td style="min-width:135px;">${obj.vname_admin_js}</td>
                <td style="min-width:180px;">${obj.vpackage_admin_css}</td>
                <td style="min-width:135px;">${obj.vname_admin_css}</td>

                <td style="min-width:180px;">${obj.vpackage_admin}</td>
                <td style="min-width:135px;">${obj.vname_adminA}</td>
                <td style="min-width:135px;">${obj.vname_adminD}</td>
                <td style="min-width:135px;">${obj.vname_adminS}</td>
                <td style="min-width:135px;">${obj.vname_adminU}</td>
            </tr>
        </table>

        <table border="1" cellpadding="0" cellspacing="0">
            <tr height="35">
                <td rowspan="2" height="70" width="72"  bgcolor="#ddddf7"><div align="center">权限代码</div></td>
                <td height="26" bgcolor="#ddddf7"><div align="center"style="min-width:135px;">模块代码 代替符[p]</div></td>
                <td height="26" bgcolor="#ddddf7"><div align="center"style="min-width:80px;">A代码</div></td>
                <td height="26" bgcolor="#ddddf7"><div align="center"style="min-width:80px;">D代码</div></td>
                <td height="26" bgcolor="#ddddf7"><div align="center"style="min-width:80px;">S代码</div></td>
                <td height="26" bgcolor="#ddddf7"><div align="center" style="min-width:80px;">U代码</div></td>
            </tr>
            <tr height="35">
                <td>${obj.power_code}</td>  
                <td>${obj.power_codeA}</td>
                <td>${obj.power_codeD}</td>
                <td>${obj.power_codeS}</td>
                <td>${obj.power_codeU}</td>
            </tr>
        </table>        

        <!--        <div style=" margin-top: 28px;">
                    <input type="button" id="myMybeanButton" data-loading-text="执行中" style=" width:99%;"
                            class="btn btn-primary"  value="修改"/>
                </div>-->
    </body>
</html>
