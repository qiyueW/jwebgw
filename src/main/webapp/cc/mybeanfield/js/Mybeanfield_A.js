//iniEvent inieditor
//初始化事件
//绑定FORM提交事件
function iniMybeanEventA() {
	$('#myMybeanButton').on('click', function() {
		addMybean(getFormData());
	});

	function getFormData() {
		var data = {};
		data.mybeanfield_zj = $('#mybeanfield_zj').val()
		data.mybean_zj = $('#mybean_zj').val()
		data.mybean_mc = $('#mybean_mc').val()
		data.mybeanfield_bz = $('#mybeanfield_bz').val()
		data.mybeanfield_dateformat = $('#mybeanfield_dateformat').val()

		data.c_zyy = $('#c_zyy').val()
		data.c_lx = $('#c_lx').val()
		data.c_mc = toFormatZT($('#c_mc').val())
		data.c_bz = toFormatZT($('#c_bz').val() ? $('#c_bz').val() : $('#mybeanfield_bz')
				.val());

		data.c_setmethod =toFormatZT(doGetOrSetMethod('set', $('#c_mc').val()))
		data.c_getmethod =toFormatZT(doGetOrSetMethod('get', $('#c_mc').val()))

		data.t_mc = toFormatZT($('#c_mc').val())// 锁定，默认等于对象字段名
		data.t_lx = toFormatZT($('#t_lx').val())
		data.t_sy = toFormatZT($('#t_sy').val())
		data.t_yxkong = toFormatZT($('#t_yxkong').val())
		data.t_cd = toFormatZT($('#t_cd').val())
		data.t_bz = toFormatZT($('#t_bz').val() ? $('#t_bz').val() : $('#mybeanfield_bz').val());

		data.v_zzbds = toFormatZT($('#v_zzbds').val())
		data.v_cuowuxx = toFormatZT($('#v_cuowuxx').val())
		data.v_bxjiancha = toFormatZT($('#v_bxjiancha').val())

		data.h_lx = toFormatZT($('#h_lx').val())
		data.h_jb = toFormatZT($('#h_jb').val())

		data.e_mc = toFormatZT($('#e_mc').val())
		return data;
	}

	function addMybean(data) {
		$btn = $('#myMybeanButton').button('loading');
		$.post(path_home + 'cc/mybean/field/a/add.jw', data, function(result) {
			if (result.statusCode == 99) {
				var msg = '';
				for ( var i in result.msg) {
					msg = msg + result.msg[i] + '\n';
				}
				aalert(msg);
			} else if (result.statusCode == 0 || result.statusCode == 1
					|| result.statusCode == -1) {
				aalert(result.msg);
			}
			setTimeout(function() {
				$btn.button('reset');
			}, 1100);
		}, 'json');
	}
}
function selectY_fanan() {
	console.log($("#y_fanan").val());
	var userchoose = $("#y_fanan").val();
	var qj = $("#mybean_mc").val();
	if (qj == "") {
		aalert("请先确认bean！");
		return;
	}
	qj = qj.toLowerCase();
	qj = qj + "_";// 前缀，默认类小写加_ 加其他
	switch (userchoose) {
	case "id": {
		setHead("主键", "");
		setC("private", "String", qj + "zj", "");
		setT("CHAR", "zj", "f", "24", "")// 类型 索引 是否为空 长度 t备注
		setV('"[1-9]{1}[0-9]{23}"', '"主键丢失"', 'f')// v_zzbds, v_cuowuxx,
		// v_bxjiancha
		setH('text', 'f');
		break;
	}
	case "text": {
		setHead("", "");
		setC("private", "String", qj, "");
		setT("VARCHAR", "f", "s", "50", "")// 类型 索引 是否为空 长度 t备注
		setV('"[\\\\w\\\\W]{1,50}"', '"文本过长"', 's')
		setH('text', 's');
		setE('');
		break;
	}
	case "bigtext": {
		setHead("", "");
		setC("private", "String", qj, "");
		setT("TEXT", "f", "s", "", "")// 类型 索引 是否为空 长度 t备注
		setV('"[\\\\w\\\\W]+"', '"-"', 'w')
		setH('ueditor', 'f');
		break;
	}
	case "int": {
		setHead("", "");
		setC("private", "Integer", qj, "");
		setT("TEXT", "f", "s", "", "")// 类型 索引 是否为空 长度 t备注
		setV('"-?[0-9]+"', '":请输入正数"', 's')
		setH('number', 's');
		break;
	}
	case "double": {
		setHead("", "");
		setC("private", "Double", qj, "");
		setT("DOUBLE", "f", "s", "", "")// 类型 索引 是否为空 长度 t备注
		setV('"-?[0-9]+.?[0-9]+"', '":请输入数字"', 's')
		setH('float', 's');
		break;
	}
	case "date": {
		setHead("", "yyyy-MM-dd");
		setC("private", "Date", qj, "");
		setT("DATE", "f", "s", "10", "")// 类型 索引 是否为空 长度 t备注
		setV('"[0-9]{4}-[0-9]{2}-[0-9]{2}"', '":请输入日期。例1988-08-21"', 's')
		setH('date', 's');
		break;
	}
	case "datetime": {
		setHead("", "yyyy-MM-dd HH:mm:ss");
		setC("private", "Date", qj, "");
		setT("DATETIME", "f", "s", "19", "")// 类型 索引 是否为空 长度 t备注
		setV('"[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}"',
				'":请输入日期时间。例1988-08-21 12:30:59"', 's')
		setH('date', 's');
		break;
	}
	case "zhidan": {
		setHead("制单时间", "yyyy-MM-dd HH:mm:ss");
		setC("private", "Date", qj + "zhidanshijian", "");
		setT("DATETIME", "s", "f", "19", "")// 类型 索引 是否为空 长度 t备注
		setV('"[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}"',
				'":请输入日期。例1988-08-21 12:30:59"', 'w')
		setH('date', 'f');
		setE("制单时间");
		break;
	}
	case "shenpi": {
		setHead("审批时间", "yyyy-MM-dd HH:mm:ss");
		setC("private", "Date", qj + "shenpishijian", "");
		setT("DATETIME", "s", "f", "19", "")// 类型 索引 是否为空 长度 t备注
		setV('"[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}"',
				'":请输入日期。例1988-08-21 12:30:59"', 'w')
		setH('date', 'f');
		setE("审批时间");
		break;
	}

	case "filepath": {
		setHead("", "");
		setC("private", "String", qj, "");
		setT("VARCHAR", "f", "s", "500", "")// 类型 索引 是否为空 长度 t备注
		setV('"[\\\\w\\\\W]{0,500}"', '"上传的路径过长，请重命名简短的"', 'f')
		setH('file', 'f');
		setE('');
		break;
	}
	case "filepaths": {
		setHead("", "");
		setC("private", "String", qj, "");
		setT("TEXT", "f", "s", "", "")// 类型 索引 是否为空 长度 t备注
		setV('"[\\\\w\\\\W]+"', '"-"', 'w')
		setH('file', 'f');
		break;
	}

	case "style": {
		setHead("状态", "");
		setC("private", "String", qj + "zt", "");
		setT("CHAR", "s", "f", "1", "")// 类型 索引 是否为空 长度 t备注
		setV('"[0|1|2|3]{1}"', '":状态异常"', 's')
		setH('select', 's');
		setE("状态");
		break;
	}
	}
}
function iniEmpty() {
	setHead("", "");
	$("#y_fanan").val("");// 预设方案
	setC("private", "String", "", "");
	setT("VARCHAR", "f", "f", "", "")
	setV('', '', 's')
	setH('text', 's');
	setE("");
}

function setHead(mybeanfield_bz, mybeanfield_dateformat) {
	$("#mybeanfield_bz").val(mybeanfield_bz);
	$("#mybeanfield_dateformat").val(mybeanfield_dateformat);
}

// 设置类相关信息
function setC(zyy, lx, mc, bz) {
	$("#c_zyy").val(zyy);
	$("#c_lx").val(lx);
	$("#c_mc").val(mc);
	$("#c_bz").val(bz);
}
// 设置数据库表相关信息 类型 索引 是否为空 长度 t备注
function setT(t_lx, t_sy, t_yxkong, t_cd, t_bz) {
	$("#t_lx").val(t_lx);
	$("#t_sy").val(t_sy);
	$("#t_yxkong").val(t_yxkong);
	$("#t_cd").val(t_cd)
	$("#t_bz").val(t_bz);
}
// 设置后台校验相关信息 v_zzbds, v_cuowuxx, v_bxjiancha
function setV(v_zzbds, v_cuowuxx, v_bxjiancha) {
	$("#v_zzbds").val(v_zzbds);
	$("#v_cuowuxx").val(v_cuowuxx);
	$("#v_bxjiancha").val(v_bxjiancha);
}
// 设置html相关信息
function setH(h_lx, h_jb) {
	$("#h_lx").val(h_lx);
	$("#h_jb").val(h_jb);
}
// 设置html相关信息
function setE(e_mc) {
	$("#e_mc").val(e_mc);
}
function doGetOrSetMethod(qz, name) {
	name = name.slice(0, 1).toUpperCase() + name.slice(1);
	return qz ? (qz + name) : name;
}
