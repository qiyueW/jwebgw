<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<!--后台UI组件End-->
<script type="text/javascript"
	src="admin/base/wt/bm/js/bm_treeMenu.js"></script>
	
	<script type="text/javascript">
	$(function(){
		wt_bm_menu("ss",function(data){
			alert(JSON2.stringify(data)+"//"+data.data['bm_id']);
		});
	});
	</script>
</head>
<body>
	<div id="ss">s</div>
</body>
</html>