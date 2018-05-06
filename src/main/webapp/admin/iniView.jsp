<%-- <%@include file="/WEB-INF/jspf/power/userPower.jspf"%> --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<%-- <%@include file="/WEB-INF/jspf/easyuiLocal.jspf"%>
<%@include file="/WEB-INF/jspf/GG.jspf"%>
<%@include file="/WEB-INF/jspf/artDialog.jspf"%> --%>
</head>
<body>
	<div style="height: 32px; line-height: 32px; text-align: center;">
		<%-- 		<%=hyy%> --%>
		<a href="javascript:void(0)" class="easyui-linkbutton"
			onclick="$('#w').window('open')">修改密码</a>
		&nbsp;&nbsp;&nbsp; <a href="${path_home}/sys/user/manager/loginOut.jw">退出登陆</a>
	</div>


	<div id="w" class="easyui-window" title="修改密码"
		data-options="closed:true"
		style="width: 450px; height: 400px; padding: 5px;">
		<iframe scrolling="auto" frameborder="0"  src="${path_home}/admin/usersafe/userSelf.jsp" style="width:99.4%;height:99.4%;"></iframe>
	</div>

</body>
</html>
