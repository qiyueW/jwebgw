<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<!--后台UI组件End-->
<script src="admin/base/bm/lookup/bmLookUp.js" type="text/javascript"></script>
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
<script src="lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="lib/jquery-validation/jquery.validate.min.js"
	type="text/javascript"></script>
<script src="lib/jquery-validation/jquery.form.js"
	type="text/javascript"></script>
<script type="text/javascript">
function f_getFormData(){
	var d={};
	d.ry_name=$("#ry_name").val();
	d.ry_account=$("#ry_account").val();
	d.ry_password=$("#ry_password").val();
	d.ry_sex=$("#ry_sex").val();
	d.bm_id=$("#bm_id").val();
	d.bm_name=$("#bm_id2").val();
	d.ry_info=$("#ry_info").val();
	d.ry_sort=$("#ry_sort").val();
	return d;
}

	$(function() {
		var cb = f_dcBaseBM("bm_id2", "bm_id", 200, 400, 100);
		$('#myButton').on( 'click', function() {
					$btn = $('#myButton').button('loading');
					$.post("${path_home}/base/ry/add.jw",f_getFormData(),function(result){
						if (result.statusCode == 99) {
							var msg = "";
							for ( var i in result.msg) {
								msg = msg + result.msg[i] + "\n";
							}
							alert(msg);
						} else if (result.statusCode == 0
								|| result.statusCode == 1
								|| result.statusCode == -1) {
							alert(result.msg);
						}
						setTimeout(function() {
							$btn.button('reset');
						}, 1100);
					},"json");
			/* 		setTimeout(function() {
						$btn.button('reset');
					}, 1100); */
				});
	});
</script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">人员添加(注：带*号的为必填项)</h3>
				</div>
				<div id="bm_divID" class="panel-body">
					<div id="bm_formID"  class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-4 control-label"  >*部门</label>
							<div class="col-sm-5">
								<input type="text"  class="form-control" name="bm_id2"id="bm_id2" required />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label" for="ry_name">*人员名称</label>
							<div class="col-sm-5">
								<input type="text"  class="form-control"  name="ry_name" id="ry_name" maxlength="50" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label"  for="ry_account">*账号(50字内)</label>
							<div class="col-sm-5">
								<input type="text" class="form-control"  name="ry_account" id="ry_account" maxlength="50" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label" >*密码(50字内)</label>
							<div class="col-sm-5">
								<input type="text"  class="form-control"  name="ry_password" id="ry_password" maxlength="50" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label" >性别</label>
							<div class="col-sm-5">
								<select  class="form-control"  name="ry_sex" id="ry_sex" >
									<option value="男">男</option>
									<option value="女">女</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label" >人员类型</label>
							<div class="col-sm-5">
								<select class="form-control"  name="ry_sort" id="ry_sort" >
									<option value="2">人员</option>
									<option value="1">系统管理员</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label" >联系方式(150字内)</label>
							<div class="col-sm-5">
								<input type="text" class="form-control"  name="ry_phone" id="ry_phone" maxlength="150" />
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-4 control-label" >备注(150字内)</label>
							<div class="col-sm-5">
								<input type="text"  class="form-control" name="ry_info" id="ry_info" maxlength="50" />
							</div>
						</div>
 						<div class="form-group">
							<div class="col-sm-9 col-sm-offset-4">
								<button type="button" id="myButton" data-loading-text="执行中"
									class="btn btn-primary" autocomplete="off">添加</button>
							</div>
						</div>
				</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
