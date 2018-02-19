<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
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
<script type="text/javascript"src="${path_home}/admin/base/ry/js/ry_A.js"></script>

<script type="text/javascript">
var path_home="${path_home}/";
	$(function() {
		var cb = f_dcBaseBM("bm_id2", "bm_id", 150);
	});
</script>
</head>
<body>
	<div class="container">
<!-- <input type="hidden" name="ry_id" id="ry_id"  /> -->
<!-- <input type="text" name="bm_id" id="bm_id" required /> -->
<!-- <input type="text" name="gw_id" id="gw_id"  /> -->
  <table border="1" cellspacing="0" cellpadding="0">
    <col width="51" />
    <col width="182" />
    <col width="176" />
    <col width="138" />
    <col width="231" />
    <tr height="35">
      <td width="51"><div align="center">职员<br />
        信息</div></td>
      <td colspan="4" width="727" >
      部门/岗位/姓名
      </td>
    </tr>
    <!-- <tr height="30">
      <td height="30">部门</td>
      <td><input type="text" name="bm_id2" id="bm_id2" required /></td>
      <td>姓名</td>
      <td><input type="text" name="ry_name" id="ry_name"  /></td>
    </tr>
    <tr height="30">
      <td height="30">岗位</td>
      <td><input type="text" name="gw_name" id="gw_name"  /></td>
      <td height="30">状态</td>
      <td>
	  <select name="ry_style" id="ry_style">
     	<option value="0">新增</option>
     	<option value="0">审核</option>
     	<option value="0">停用</option>
	  </select>
	</td> -->
    <!-- </tr>
    <tr height="30">
      <td height="30">入职日期</td>
      <td><input type="text" name="ry_cdate" id="ry_cdate"  /></td>
      <td>邮箱</td>
      <td><input type="text" name="ry_email" id="ry_email"  /></td>
    </tr>
    <tr height="30">
      <td height="30">状态</td>
      <td>
	  <select name="ry_style" id="ry_style">
     	<option value="0">新增</option>
     	<option value="0">审核</option>
     	<option value="0">停用</option>
	  </select>
	</td>
      <td>通信</td>
      <td><input type="text" name="ry_phone" id="ry_phone"  /></td>
    </tr>
    <tr height="33">
      <td height="33">备注</td>
      <td colspan="3"><input type="text" name="ry_info" id="ry_info"  size="70" /></td>
    </tr> -->
    <tr height="34">
      <td rowspan="17" height="547" width="51"><div align="center">信<br />
        息<br />
        部<br />
        提<br />
        供</div></td>
      <td colspan="4" style="background-color:#CCCCCC; font-size:16px; font-size-adjust:inherit;">软件与通信</td>
    </tr>
    <tr height="34">
      <td height="34">K3(账号/密码)</td>
      <td><input type="text" name="rt1" id="rt1"  /></td>
      <td>公司座机</td>
      <td><input type="text" name="rt6" id="rt6"  /></td>
    </tr>
    <tr height="34">
      <td height="34">远程(瑞友或其他）</td>
      <td><input type="text" name="rt2" id="rt2"  /></td>
      <td>公司邮箱</td>
      <td><input type="text" name="rt7" id="rt7"  /></td>
    </tr>
    <tr height="30">
      <td height="30">企业QQ(账号/密码)</td>
      <td><input type="text" name="rt3" id="rt3"  /></td>
      <td>其他8</td>
      <td><input type="text" name="rt8" id="rt8"  /></td>
    </tr>
    <tr height="30">
      <td height="30">腾讯通(账号/密码)</td>
      <td><input type="text" name="rt4" id="rt4"  /></td>
      <td>其他9</td>
      <td><input type="text" name="rt9" id="rt9"  /></td>
    </tr>
    <tr height="30">
      <td height="30">Iwork</td>
      <td><input type="text" name="rt5" id="rt5"  /></td>
      <td>其他10</td>
      <td><input type="text" name="rt10" id="rt10"  /></td>
    </tr>
    <tr height="30">
      <td height="30">备注</td>
      <td colspan="3"><input type="text" name="rtbz" id="rtbz" size="70" /></td>
    </tr>
    <tr height="37">
      <td colspan="4" height="37" style="background-color:#CCCCCC; font-size:16px; font-size-adjust:inherit;">OA系统账号密码</td>
    </tr>
    <tr height="37">
      <td height="37">人员账号</td>
      <td><input type="text" name="ry_account" id="ry_account" required /></td>
      <td>人员密码</td>
      <td><input type="text" name="ry_password" id="ry_password" required /></td>
    </tr>
    <tr height="38">
      <td colspan="4" height="38" class="title2">领用电脑、平板</td>
    </tr>
    <tr height="30">
      <td height="30">电脑类型</td>
      <td>
	  <select name="dnlx" id="dnlx">
     	<option value="0">台式</option>
     	<option value="0">笔记本</option>
     	<option value="0">平板</option>
	  </td>
      <td>有线IP</td>
      <td><input type="text" name="yxip" id="yxip"  /></td>
    </tr>
    <tr height="30">
      <td height="30">电脑型号(品牌)</td>
      <td><input type="text" name="dnxh" id="dnxh"  /></td>
      <td>有线网卡MAC</td>
      <td><input type="text" name="yxmac" id="yxmac"  /></td>
    </tr>
    <tr height="30">
      <td height="30">电脑配置(cpu及内存)</td>
      <td><input type="text" name="dnpz" id="dnpz"  /></td>
      <td>无线IP</td>
      <td><input type="text" name="wxip" id="wxip"  /></td>
    </tr>
    <tr height="30">
      <td height="30">办公能力</td>
      <td><input type="text" name="bgnl" id="bgnl"  /></td>
      <td>无线网卡MAC</td>
      <td><input type="text" name="wxmac" id="wxmac"  /></td>
    </tr>
    <tr height="30">
      <td height="30">其他1</td>
      <td><input type="text" name="dn1" id="dn1"  /></td>
      <td>其他3</td>
      <td><input type="text" name="dn3" id="dn3"  /></td>
    </tr>
    <tr height="30">
      <td height="30">其他2</td>
      <td><input type="text" name="dn2" id="dn2"  /></td>
      <td>其他4</td>
      <td><input type="text" name="dn4" id="dn4"  /></td>
    </tr>
    <tr height="33">
      <td height="33">备注</td>
      <td colspan="3"><input type="text" name="dnbz" id="dnbz" size="70" /></td>
    </tr>
  </table>
</div> 

<div style="float: left;">
	<button onclick="postData();">提交</button>
</div>
</body>
</html>
