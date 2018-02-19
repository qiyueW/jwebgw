<%@include file="/WEB-INF/jspf/power/adminUserPower.jspf"%>
<%
    if(!pck.checkUserORAdmin("J44_2"))return;
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
<head>
<title></title>
<link href="${path_home}/lib/ligerUI/skins/Aqua/css/ligerui-all.css" rel="stylesheet" type="text/css" />  
<script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>  
<script src="${path_home}/lib/ligerUI/js/ligerui.all.js" type="text/javascript"></script> 
<script src="${path_home}/lib/ligerUI/myligerui.js" type="text/javascript"></script> 
<script src="${path_home}/lib/jquery.cookie.js"></script>
<script src="${path_home}/lib/json2.js"></script>

<!--后台UI组件End-->
<style type="text/css">
	.title2{
	background-color:#CCCCCC;
	 font-size:16px; 
	 font-size-adjust:inherit;
	}
	body{
		font-size: 15px;	
	}
</style>
<script type="text/javascript"src="${path_home}/admin/base/bm/lookup/bmLookUp.js" ></script>
<script type="text/javascript"src="${path_home}/admin/base/ry/js/ry_U.js" ></script>

<script type="text/javascript">
var GRID;
var path_home="${path_home}/";
	$(function(){
		var cb = f_dcBaseBM("bm_id2", "bm_id", 150);
		 cb.setValue("${obj.bm_id}");
         cb.setText("${obj.bm_name eq null?'顶级':obj.bm_name}");
         
		iniDate("ry_cdate","${ry_cdate}");
	});
</script>
</head>
<body>
	<div class="container">
		
<input type="hidden" name="ry_id" id="ry_id"  value="${obj.ry_id}"  />
<%-- <input type="hidden" name="bm_id" id="bm_id"  value="${obj.bm_id}"  /> --%>
<input type="hidden" name="gw_id" id="gw_id"  value="${obj.gw_id}"  />


  <table border="1" cellspacing="0" cellpadding="0">
    <col width="51" />
    <col width="182" />
    <col width="176" />
    <col width="138" />
    <col width="231" />
    <tr height="35">
      <td rowspan="6" height="188" width="51"><div align="center">个<br />
        人<br />
        信<br />
        息</div></td>
      <td colspan="4" width="727" 	style="background-color:#CCCCCC; font-size:16px; font-size-adjust:inherit;">基础信息</td>
    </tr>
    <tr height="30">
      <td height="30">部门</td>
      <td><input type="text" name="bm_id2" id="bm_id2"  value="${obj.bm_name}" /></td>
      <td>姓名</td>
      <td><input type="text" name="ry_name" id="ry_name"  value="${obj.ry_name}" /></td>
    </tr>
    <tr height="30">
      <td height="30">岗位</td>
      <td><input type="text" name="gw_name" id="gw_name"  value="${obj.gw_name}" /></td>
      <td>性别</td>
      <td>
	  <select name="ry_sex" id="ry_sex">
     	<option value="男"  ${obj.ry_sex eq "男"?"selected":""}>男</option>
     	<option value="女"  ${obj.ry_sex eq "女"?"selected":""}>女</option>		
		</select>
</td>
    </tr>
    <tr height="30">
      <td height="30">入职日期</td>
      <td><input type="text" name="ry_cdate" id="ry_cdate"  ,initValue="${ry_cdate}"  /></td>
      <td>邮箱</td>
      <td><input type="text" name="ry_email" id="ry_email"  value="${obj.ry_email}" /></td>
    </tr>
    <tr height="30">
      <td height="30">状态</td>
      <td>
	  <select name="ry_style" id="ry_style"  disabled="disabled">
     	<option value="0"  ${obj.ry_style eq "0" ?"selected":""}>新增</option>
     	<option value="1"  ${obj.ry_style eq "1" ?"selected":""}>启用</option>
     	<option value="2"  ${obj.ry_style eq "2"? "selected":""}>停用</option>
	  </select>
	</td>
      <td>通信</td>
      <td><input type="text" name="ry_phone" id="ry_phone" value="${obj.ry_phone}" /></td>
    </tr>
    <tr height="33">
      <td height="33">备注</td>
      <td colspan="3"><input type="text" name="ry_info" id="ry_info"  size="70" value="${obj.ry_info}" /></td>
    </tr>
    <tr height="34">
      <td rowspan="2" width="51"><div align="center">信息部<br />
        提供</div>
      </td>
      <td colspan="4" height="37" style="background-color:#CCCCCC; font-size:16px; font-size-adjust:inherit;">OA系统账号密码</td>
    </tr>
        <tr height="37">
      <td height="37" >人员账号</td>
      <td><input type="text" name="ry_account" id="ry_account"  disabled="disabled"  value="${obj.ry_account}"/></td>
      <td>人员密码</td>
      <td><input type="password" name="ry_password" id="ry_password" value="${obj.ry_password}"/></td>
    </tr>
    <tr>
      <td colspan="5" height="40"><div align="center">	<button onclick="postData();" style="width: 200px; height:30px;"  >修改信息</button></div></td>
    </tr>
  </table>
</div>
</body>
</html>
