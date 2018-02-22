<!--%@include file="/WEB-INF/jspf/power/userPower.jspf"%-->
<%
	//    if (!pck.checkUser("J31")) {
	//        return;
	//    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--后台UI组件Start-->
<!DOCTYPE html>
<html>
<head>
<title></title>

</head>
<body><script src="${path_home}/lib/jquery/jquery-1.11.1.js" type="text/javascript"></script>
<%@include file="/WEB-INF/jspf/zuiLocal.jspf"%>
<script type="text/javascript" src="${path_home}/cc/mybeanfield/js/Mybeanfield_A.js"></script>
<%@include file="/WEB-INF/jspf/artDialog.jspf"%>
<%@include file="/WEB-INF/jspf/ztree.jspf"%>

<script type="text/javascript">
	var path_home = "${path_home}/";
	$(function() {
		iniMybeanEventA();
		var beanfl;
		var zcfl = new ztree_select(
				"${path_home}/cc/mypackage/s/selectVast.jw", {},
				"showmypackageTree", "mypackage_name", "mypackage_id", 220, 390);
		zcfl.init(function(treeId, treeNode) {
			zcfl.setMyValue(treeNode)
			zcfl.hideMenu();//$("#" +zcfl.menuContentDIV).fadeOut("fast");
			$.fn.zTree.getZTreeObj(beanfl.treeID).reAsyncChildNodes(null,
					"refresh");
		}, "mypackage_id", "mypackage_pid", "mypackage_name")

		beanfl = new ztree_select(
				"${path_home}/cc/mybean/s/selectAllByJson.jw", {
					mypackage_id : function() {
						return $("#mypackage_id").val();//mypackage_id
					}
				}, "showmybeanTree", "mybean_mc", "mybean_zj", 220, 390);
		beanfl.init(function(treeId, treeNode) {
			beanfl.setMyValue(treeNode)
			beanfl.hideMenu();//$("#" +zcfl.menuContentDIV).fadeOut("fast");
		}, "mybean_zj", "", "mybean_mc")

		$("input").addClass("input-sm")
		$("#" + beanfl.treeID).on('click', function() {
			iniEmpty();
		})
	});
	//              class=""
</script>
<style>
table select {
	min-width: 90px;
}

.show2 {
	color: #00f
}

.show3 {
	color: #ff9933
}

.showtitle {
	font-size: 18px;
}
</style>
	<div id="root" class="container">
		<table class="table" id="table1">
			<tr>
				<td style="width: 80px;">包</td>
				<td>
					<div id="showmypackageTree"
						style="position: relative; z-index: 1000"></div>
				</td>
			</tr>
			<tr>
				<td>bean</td>
				<td>
					<div id="showmybeanTree" style="position: relative; z-index: 888"></div>
				</td>
			</tr>
			<tr>
				<td>预设方案</td>
				<td><select id="y_fanan" onchange="selectY_fanan()">
						<option value="">无</option>
						<option value="id">主键</option>
						<option value="text">文本</option>
						<option value="bigtext">文章类</option>
						<option value="int">数字-正数</option>
						<option value="double">数字-浮点</option>
						<option value="date">日期</option>
						<option value="datetime">日期时间</option>
						<option value="zhidan">制单时间</option>
						<option value="shenpi">审批时间</option>
						<option value="filepath">上传类-路径-单</option>
						<option value="filepaths">上传类-路径-集合</option>
						<option value="style">单据状态0或1或其他</option>
				</select></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input type="text" name="mybeanfield_bz"
					id="mybeanfield_bz" /></td>
			</tr>
			<tr>
				<td>Date格式</td>
				<td><select id="mybeanfield_dateformat">
						<option value=""></option>
						<option value="yyyy-MM-dd">yyyy-MM-dd</option>
						<option value="yyyy-MM-dd HH:mm:ss">yyyy-MM-dd HH:mm:ss</option>
				</select></td>
			</tr>
		</table>
		<div class="show2">
			<div class="showtitle">JAVA类</div>
			<table class="table" id="table2">
				<tr>
					<td style="width: 80px;">c作用域</td>
					<td><select id="c_zyy">
							<option value="private">private</option>
							<option value="public">public</option>
							<option value="protected">protected</option>
					</select></td>
				</tr>
				<tr>
					<td>c类型</td>
					<td><select id="c_lx">
							<option value="String">String</option>
							<option value="Integer">Integer</option>
							<option value="Date">Date</option>
							<option value="Double">Double</option>
					</select></td>
				</tr>
				<tr>
					<td>c属性名</td>
					<td><input type="text" name="c_mc" id="c_mc" /></td>
				</tr>
				<tr>
					<td>c备注</td>
					<td><input type="text" name="c_bz" id="c_bz" /></td>
				</tr>
			</table>
		</div>
		<div class="show3">
			<div class="showtitle">数据库表</div>
			<table class="table" id="table3">
				<tr>
					<td style="width: 80px;">t类型</td>
					<td><select id="t_lx">
							<option value="VARCHAR">VARCHAR</option>
							<option value="CHAR">CHAR</option>
							<option value="TEXT">TEXT</option>
							<option value="DATE">DATE</option>
							<option value="DATETIME">DATETIME</option>
							<option value="INT">INT</option>
							<option value="DOUBLE">DOUBLE</option>
					</select></td>
				</tr>
				<tr>
					<td style="width: 80px;">t索引</td>
					<td><select id="t_sy">
							<option value="f">否</option>
							<option value="s">是</option>
							<option value="wy">唯一</option>
							<option value="zj">主键</option>
							<!--<option value="wj">外键</option>-->
					</select></td>
				</tr>
				<tr>
					<td style="width: 80px;">t允许空</td>
					<td><select id="t_yxkong">
							<option value="s">是</option>
							<option value="f">否</option>
					</select></td>
				</tr>
				<tr>
					<td>t长度</td>
					<td><input type="number" name="t_cd" id="t_cd" /></td>
				</tr>
				<tr>
					<td>t备注</td>
					<td><input type="text" name="t_bz" id="t_bz" /></td>
				</tr>
			</table>
		</div>
		<div class="show2">
			<div class="showtitle">后台检验</div>
			<table class="table" id="table4">
				<tr>
					<td style="width: 80px;">v正则规则</td>
					<td><input type="text" name="v_zzbds" id="v_zzbds" /></td>
				</tr>
				<tr>
					<td style="width: 80px;">v错误信息</td>
					<td><input type="text" name="v_cuowuxx" id="v_cuowuxx" /></td>
				</tr>
				<tr>
					<td style="width: 80px;">v必须检查</td>
					<td><select id="v_bxjiancha">
							<option value="s">是</option>
							<option value="f">否</option>
							<option value="w">不存在检查</option>
					</select></td>
				</tr>
			</table>
		</div>

		<div class="show3">
			<div class="showtitle">html相关</div>
			<table class="table" id="table5">
				<tr>
					<td style="width: 80px;">h类型</td>
					<td><select id="h_lx">
							<option value="text">文本</option>
							<option value="number">数字</option>
							<option value="float">浮点</option>
							<option value="select">选择框</option>
							<option value="checkbox">复选框</option>
							<option value="radio">单选框</option>
							<option value="date">日期/时间</option>
							<option value="file">文件</option>
							<option value="ueditor">文本ueditor</option>
					</select></td>
				</tr>
				<tr>
					<td style="width: 80px;">h脚本校验</td>
					<td><select id="h_jb">
							<option value="s">是</option>
							<option value="f">否</option>
					</select></td>
				</tr>
			</table>
		</div>
		<div class="show2">
			<div class="showtitle">excel相关</div>
			<table class="table" id="table6">
				<tr>
					<td style="width: 80px;">e展示名</td>
					<td><input type="text" name="e_mc" id="e_mc" /></td>
				</tr>
				<!-- <tr>
                        <td style="width:80px;">h下载</td><td>
                            <select id="e_xz">
                                <option value="s">是</option>
                                <option value="f">否</option>
                            </select>
                        </td>
                    </tr> -->
			</table>
		</div>
	</div>
	<button type="submit" id="myMybeanButton" data-loading-text="执行中"
                                            class="btn btn-primary" >添加</button>
                                
	<!--root div end-->
</body>
</html>
