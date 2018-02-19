//iniEvent inieditor
//初始化事件
//绑定FORM提交事件
function iniEvent() {
    $('#jsdj_formID').submit(
        function(){
	updateJSDJ(getFormData());
    });
    function getFormData(){
	var data={};
	data.jsdj_zj=$('#jsdj_zj').val()
	data.jsdj_dm=$('#jsdj_dm').val()
	data.jsdj_mc=$('#jsdj_mc').val()
	data.jsdj_bz=$('#jsdj_bz').val()
return data;
}

function updateJSDJ(data) {
	$btn = $('#myButton').button('loading');
	$.post(path_home+'sys/power/jsdj/u/update.jw',data,function(result){	
		if (result.statusCode == 99) {	
		var msg ='';	
		for ( var i in result.msg) {	
			msg = msg + result.msg[i] + '\n';	
		}	
		alert(msg);
		} else if (
			result.statusCode == 0	
			|| result.statusCode == 1	
			|| result.statusCode == -1) {	
			alert(result.msg);	
		}
	setTimeout(function() {
	$btn.button('reset');
	}, 1100);
	},'json');
}
}


