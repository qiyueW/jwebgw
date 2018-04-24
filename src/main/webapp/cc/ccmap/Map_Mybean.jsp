<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
    <head>
        <title>MyBean明细</title>
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>
        <%@include file="/WEB-INF/jspf/zuiLocal.jspf"%>
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <%@include file="/WEB-INF/jspf/artDialog.jspf"%>
        <%@include file="/WEB-INF/jspf/ztree.jspf"%>

        <script type="text/javascript">
            var path_home = "${path_home}/";
            $(function () {
            });
        </script>
        <style>
            table{
                margin: 5px;
            }
            .ccfield{
                font-size:14px;
                width: 130px;
                text-align: center;
            }
        </style>
    </head>
    <body>
        <div style=" width:1300px;">
            <div>
                <h3>通过 &#36;{bean.xxx} 取值。</h3>
                <h3>xxx是点位符。例如 取bean类名称 操作：&#36;{bean.mybean_mc}</h3>
            </div>
            <table border="1" cellpadding="0" cellspacing="0">
                <tr height="35">
                    <td rowspan="2" height="70" width="72"  bgcolor="#ddddf7"><div align="center">bean相关</div></td>
                    <td bgcolor="#ddddf7"><div align="center">bean包</div></td>
                    <td bgcolor="#ddddf7"><div align="center">主键</div></td>
                    <td bgcolor="#ddddf7"><div align="center">类名</div></td>
                    <td bgcolor="#ddddf7"><div align="center">备注</div></td>
                </tr>
                <tr height="35">
                    <td><div class="ccfield">package_bean</div></td>
                    <td><div class="ccfield">mybean_zj</div></td>
                    <td><div class="ccfield">mybean_mc</div></td>
                    <td><div class="ccfield">mybean_bz</div></td>
                </tr>
            </table>

            <table border="1" cellpadding="0" cellspacing="0">
                <tr height="35">
                    <td rowspan="2" height="70" width="72"  bgcolor="#ddddf7"><div align="center">s包|类</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">soo/dao 包</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">soo/dao 类名</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">service 包</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">service 类名</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">hm包</div></td>
                    <td height="26"  bgcolor="#ddddf7"><div align="center">hm增|类名</div></td>
                    <td height="26"  bgcolor="#ddddf7"><div align="center">hm删|类名</div></td>
                    <td height="26"  bgcolor="#ddddf7"><div align="center">hm查|类名</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">hm改|类名</div></td>
                </tr>
                <tr height="35">
                    <td><div class="ccfield">package_soo</div></td>
                    <td><div class="ccfield">name_soo</div></td>
                    <td><div class="ccfield">package_service</div></td>
                    <td><div class="ccfield">name_service</div></td>
                    <td><div class="ccfield">package_hm</div></td>
                    <td><div class="ccfield">name_hmA</div></td>
                    <td><div class="ccfield">name_hmD</div></td>
                    <td><div class="ccfield">name_hmS</div></td>
                    <td><div class="ccfield">name_hmU</div></td>
                </tr>
            </table>

            <table border="1" cellpadding="0" cellspacing="0">
                <tr height="35">
                    <td rowspan="2" height="70" width="72"  bgcolor="#ddddf7"><div align="center">s2包|类</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">validate 包</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">validate 类名</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">cache 包</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">cache 类名</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">vo 包</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">vo 类名</div></td>
                </tr>
                <tr height="35">
                    <td><div class="ccfield">package_validate</div></td>
                    <td><div class="ccfield">name_validate</div></td>
                    <td><div class="ccfield">package_cache</div></td>
                    <td><div class="ccfield">name_cache</div></td>
                    <td><div class="ccfield">package_vo</div></td>
                    <td><div class="ccfield">name_vo</div></td>
                </tr>
            </table>


            <table border="1" cellpadding="0" cellspacing="0">
                <tr height="35">
                    <td rowspan="2" height="70" width="72"  bgcolor="#ddddf7"><div align="center">v包|类</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">js 包</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">js 名</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">css包</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">css 名</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">jsp包</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">jsp增|名</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">jsp删|名</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">jsp查|名</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">jsp改|名</div></td>
                </tr>
                <tr height="35">
                    <td><div class="ccfield">vpackage_admin_js</div></td>
                    <td><div class="ccfield">vname_admin_js</div></td>
                    <td><div class="ccfield">vpackage_admin_css</div></td>
                    <td><div class="ccfield">vname_admin_css</div></td>
                    <td><div class="ccfield">vpackage_admin</div></td>
                    <td><div class="ccfield">vname_adminA</div></td>
                    <td><div class="ccfield">vname_adminD</div></td>
                    <td><div class="ccfield">vname_adminS</div></td>
                    <td><div class="ccfield">vname_adminU</div></td>
                </tr>
            </table>

            <table border="1" cellpadding="0" cellspacing="0">
                <tr height="35">
                    <td rowspan="2" height="70" width="72"  bgcolor="#ddddf7"><div align="center">权限代码</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">模块代码</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">A代码</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">D代码</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">S代码</div></td>
                    <td height="26" bgcolor="#ddddf7"><div align="center">U代码</div></td>
                </tr>
                <tr height="35">
                    <td><div class="ccfield">power_code</div></td>  
                    <td><div class="ccfield">power_codeA</div></td>
                    <td><div class="ccfield">power_codeD</div></td>
                    <td><div class="ccfield">power_codeS</div></td>
                    <td><div class="ccfield">power_codeU</div></td>
                </tr>
            </table>        
        </div>
        
        
        <div>
            其它，预设值方案key: fields
        </div>
    </body>
</html>
