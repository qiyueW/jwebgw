<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<%@include file="/WEB-INF/jspf/admin-ui.jspf"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<!--后台UI组件End-->
<script src="admin/base/bm/lookup/bmLookUp.js"
	type="text/javascript"></script>
<link rel="stylesheet" href="lib/bootstrap/css/bootstrap.min.css" />
<script src="lib/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="lib/jquery-validation/jquery.validate.min.js"
	type="text/javascript"></script>
<script src="lib/jquery-validation/jquery.form.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$()
			.ready(
					function() {
						 var cb = f_dcBaseBM("bm_pid2", "bm_pid", 200, 400, 100);
			                cb.setValue("${bm_P.bm_id}");
			                cb.setText("${bm_P.bm_name eq null?'顶级':bm_P.bm_name}");
			                
						// 绑定FORM提交事件
						$('#bm_formID')
								.submit(
										function() {
											$btn = $("#myButton").button(
													'loading');
											$(this)
													.ajaxSubmit(
															{
																dataType : "json",
																url : "${path_home}/base/bm/update.jw",
																success : function(
																		result) {
																	if (result.statusCode == 99) {
																		var msg = "";
																		//                    alert(JSON.stringify(result.msg[0].value));
																		for ( var i in result.msg) {
																			msg = msg
																					+ result.msg[i]
																					+ "\n";
																		}
																		alert(msg);
																	} else if (result.statusCode == 0
																			|| result.statusCode == 1
																			|| result.statusCode == -1) {
																		alert(result.msg);
																	}
																}
															});
											setTimeout(function() {
												$btn.button('reset');
											}, 1100);
											return false;
										});
					});
</script>
    </head>
    <body style="padding:10px">
        <div id="bm_divID">
            <form name="form" method="post"  id="bm_formID">
                <input type="hidden" name="bm_id" value="${bm.bm_id}" id="bm_id" />
                <%-- <input type="text" name="bm_pid" value="${bm.bm_pid}" id="bm_pid" maxlength="26" ltype="text"/> --%>
                
                <table cellpadding="0" cellspacing="0" class="l-table-edit" >
                    <tr>
                        <td align="right" class="l-table-edit-td">上级:</td>
                        <td align="left" class="l-table-edit-td" style="width:160px">
                            <input type="text" name="bm_pid2" value="${bm.bm_pid}" id="bm_pid2" maxlength="26" ltype="text"/>
                        </td><td align="left"></td>
                    </tr>
                    <tr>
                        <td align="right" class="l-table-edit-td">部门(50字内):</td>
                        <td align="left" class="l-table-edit-td" style="width:160px">
                            <input type="text" name="bm_name" value="${bm.bm_name}" id="bm_name" validate="{required:true,minlength:1}" maxlength="50" ltype="text"/>
                        </td><td align="left"></td>
                    </tr>

                    <tr style=" height: 100px;">
                        <td></td>
                        <td>
                            <input type="submit" value="提交" id="Button1" class="l-button l-button-submit" /> 
                        </td><td></td>
                    </tr>
                </table>
                <br />
            </form>
        </div>
    </body>
</html>
