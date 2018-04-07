<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%--<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>--%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>  
        <%@include file="/WEB-INF/jspf/GG.jspf"%>
        <script type="text/javascript"src="${path_home}/cc/mybean/js/Mybean_U.js?<%=new Date()%>"></script>
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
        </style>
    </head>
    <body>
        <input type="hidden" name="mybean_zj" id="mybean_zj" value="${obj.mybean_zj}"  />
        <table border="1" cellpadding="0" cellspacing="0">
            <tr height="35">
                <td rowspan="2" height="70" width="72"  bgcolor="#9999FF"><div align="center">bean相关</div></td>
                <td height="26" colspan="2" bgcolor="#9999FF"><div align="center">bean包|类名</div></td>
                <td width="72" bgcolor="#9999FF"><div align="center">排序</div></td>
                <td width="100" bgcolor="#9999FF"><div align="center">备注</div></td>
                <td width="377" bgcolor="#9999FF"><div align="center">分类归属</div></td>
            </tr>
            <tr height="35">
                <td width="200"><input type="text" name="package_bean" id="package_bean" value="${obj.package_bean}" style=" width:198px" /></td>
                <td width="100"><input type="text" name="mybean_mc" id="mybean_mc" value="${obj.mybean_mc}" style=" width:100px" /></td>
                <td><input type="text" name="mybean_px" id="mybean_px"  value="${obj.mybean_px}" style=" width:70px" /></td>
                <td><input type="text" name="mybean_bz" id="mybean_bz" value="${obj.mybean_bz}" style=" width:98px" /></td>
                <td><div id="showmypackageTree"  style=" position: relative;z-index:1000"></div></td>
            </tr>
        </table>

        <table border="1" cellpadding="0" cellspacing="0">
            <tr height="35">
                <td rowspan="2" height="70" width="72"  bgcolor="#9999FF"><div align="center">s包|类</div></td>
                <td height="26" colspan="2" bgcolor="#9999FF"><div align="center">soo/dao包|类名</div></td>
                <td height="26" colspan="2" bgcolor="#9999FF"><div align="center">service包|类名</div></td>
                <td height="26" colspan="5" bgcolor="#9999FF"><div align="center">hm包|增 类名|删 类名|查 类名|改 类名</div></td>
            </tr>
            <tr height="35">
                <td width="200"><input type="text" name="package_soo" id="package_soo" value="${obj.package_soo}" style=" width:198px" /></td>
                <td width="100"><input type="text" name="name_soo" id="name_soo" value="${obj.name_soo}" style=" width:100px" /></td>
                <td width="200"><input type="text" name="package_service" id="package_service" value="${obj.package_service}" style=" width:198px" /></td>
                <td width="100"><input type="text" name="name_service" id="name_service" value="${obj.name_service}" style=" width:100px" /></td>  

                <td width="200"><input type="text" name="package_service" id="package_hm" value="${obj.package_hm}" style=" width:198px" /></td>
                <td><input type="text" name="name_hmA" id="name_hmA" value="${obj.name_hmA}" style=" width:80px" /></td>  
                <td><input type="text" name="name_hmD" id="name_hmD" value="${obj.name_hmD}" style=" width:80px" /></td>
                <td><input type="text" name="name_hmS" id="name_hmS" value="${obj.name_hmS}" style=" width:80px" /></td>
                <td><input type="text" name="name_hmU" id="name_hmU" value="${obj.name_hmU}" style=" width:80px" /></td>
            </tr>
        </table>

        <table border="1" cellpadding="0" cellspacing="0">
            <tr height="35">
                <td rowspan="2" height="70" width="72"  bgcolor="#9999FF"><div align="center">s2包|类</div></td>
                <td height="26" colspan="2" bgcolor="#9999FF"><div align="center">validate包|类名</div></td>
                <td height="26" colspan="2" bgcolor="#9999FF"><div align="center">cache包|类名</div></td>
                <td height="26" colspan="2" bgcolor="#9999FF"><div align="center">vo包|类名</div></td>
            </tr>
            <tr height="35">
                <td width="200"><input type="text" name="package_validate" id="package_validate" value="${obj.package_validate}" style=" width:198px" /></td>
                <td width="100"><input type="text" name="name_validate" id="name_validate" value="${obj.name_validate}" style=" width:100px" /></td>
                <td width="200"><input type="text" name="package_cache" id="package_cache" value="${obj.package_cache}" style=" width:198px" /></td>
                <td width="100"><input type="text" name="name_cache" id="name_cache" value="${obj.name_cache}" style=" width:100px" /></td> 

                <td width="200"><input type="text" name="package_vo" id="package_vo" value="${obj.package_vo}" style=" width:198px" /></td>
                <td width="100"><input type="text" name="name_vo" id="name_vo" value="${obj.name_vo}" style=" width:100px" /></td> 
            </tr>
        </table>


        <table border="1" cellpadding="0" cellspacing="0">
            <tr height="35">
                <td rowspan="2" height="70" width="72"  bgcolor="#9999FF"><div align="center">v包|类</div></td>
                <td height="26" colspan="2" bgcolor="#9999FF"><div align="center">js包|类名</div></td>
                <td height="26" colspan="2" bgcolor="#9999FF"><div align="center">css包|类名</div></td>
                <td height="26" colspan="5" bgcolor="#9999FF"><div align="center">jsp/html包|增 名|删 名|查 名|改 名</div></td>
            </tr>
            <tr height="35">
                <td width="200"><input type="text" name="vpackage_admin_js" id="vpackage_admin_js" value="${obj.vpackage_admin_js}" style=" width:198px" /></td>
                <td width="100"><input type="text" name="vname_admin_js" id="vname_admin_js" value="${obj.vname_admin_js}" style=" width:100px" /></td>
                <td width="200"><input type="text" name="vpackage_admin_css" id="vpackage_admin_css" value="${obj.vpackage_admin_css}" style=" width:198px" /></td>
                <td width="100"><input type="text" name="vname_admin_css" id="vname_admin_css" value="${obj.vname_admin_css}" style=" width:100px" /></td>  

                <td width="200"><input type="text" name="vpackage_admin" id="vpackage_admin" value="${obj.vpackage_admin}" style=" width:198px" /></td>
                <td><input type="text" name="vname_adminA" id="vname_adminA" value="${obj.vname_adminA}" style=" width:80px" /></td>  
                <td><input type="text" name="vname_adminD" id="vname_adminD" value="${obj.vname_adminD}" style=" width:80px" /></td>
                <td><input type="text" name="vname_adminS" id="vname_adminS" value="${obj.vname_adminS}" style=" width:80px" /></td>
                <td><input type="text" name="vname_adminU" id="vname_adminU" value="${obj.vname_adminU}" style=" width:80px" /></td>
            </tr>
        </table>

        <table border="1" cellpadding="0" cellspacing="0">
            <tr height="35">
                <td rowspan="2" height="70" width="72"  bgcolor="#9999FF"><div align="center">权限代码</div></td>
                <td height="26" bgcolor="#9999FF"><div align="center">模块代码 代替符[p]</div></td>
                <td height="26" bgcolor="#9999FF"><div align="center">A代码</div></td>
                <td height="26" bgcolor="#9999FF"><div align="center">D代码</div></td>
                <td height="26" bgcolor="#9999FF"><div align="center">S代码</div></td>
                <td height="26" bgcolor="#9999FF"><div align="center">U代码</div></td>
            </tr>
            <tr height="35">
                <td><input type="text" name="power_code" id="power_code" value="${obj.power_code}" style=" width:120px" /></td>  
                <td><input type="text" name="power_codeA" id="power_codeA" value="${obj.power_codeA}" style=" width:80px" /></td>
                <td><input type="text" name="power_codeD" id="power_codeD" value="${obj.power_codeD}" style=" width:80px" /></td>
                <td><input type="text" name="power_codeS" id="power_codeS" value="${obj.power_codeS}" style=" width:80px" /></td>
                <td><input type="text" name="power_codeU" id="power_codeU" value="${obj.power_codeU}" style=" width:80px" /></td>
            </tr>
        </table>        

        <div style=" margin-top: 28px;">
            <input type="button" id="myMybeanButton" data-loading-text="执行中" style=" width:99%;"
                   class="btn btn-primary"  value="修改"/>
        </div>
    </body>
</html>
