/*<script type="text/javascript"src="admin/base/ry/js/ry_A.js"></script>*/

function postData() {
	//$btn = $('#myButton').button('loading');
	alert(getFormData());
	$.post(path_home+'base/ry/xx/a/add.jw',getFormData(),function(result){	
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



function getFormData(){
	var data={};
	data.ry_id=$('#ry_id').val()
	data.bm_id=$('#bm_id').val()
	data.bm_name=$('#bm_id2').val()
	data.gw_id=$('#gw_id').val()
	data.gw_name=$('#gw_name').val()
	data.ry_cdate=$('#ry_cdate').val()
	data.ry_style=$('#ry_style').val()
	data.ry_sort=$('#ry_sort').val()
	data.ry_name=$('#ry_name').val()
	data.ry_sex=$('#ry_sex').val()
	data.ry_email=$('#ry_email').val()
	data.ry_phone=$('#ry_phone').val()
	data.ry_info=$('#ry_info').val()
//	data.rt1=$('#rt1').val()
//	data.rt2=$('#rt2').val()
//	data.rt3=$('#rt3').val()
//	data.rt4=$('#rt4').val()
//	data.rt5=$('#rt5').val()
//	data.rt6=$('#rt6').val()
//	data.rt7=$('#rt7').val()
//	data.rt8=$('#rt8').val()
//	data.rt9=$('#rt9').val()
//	data.rt10=$('#rt10').val()
//	data.rtbz=$('#rtbz').val()
	data.ry_account=$('#ry_account').val()
	data.ry_password=$('#ry_password').val()
//	data.dnlx=$('#dnlx').val()
//	data.dnxh=$('#dnxh').val()
//	data.dnpz=$('#dnpz').val()
//	data.bgnl=$('#bgnl').val()
//	data.dn1=$('#dn1').val()
//	data.dn2=$('#dn2').val()
//	data.dn3=$('#dn3').val()
//	data.dn4=$('#dn4').val()
//	data.yxip=$('#yxip').val()
//	data.yxmac=$('#yxmac').val()
//	data.wxip=$('#wxip').val()
//	data.wxmac=$('#wxmac').val()
//	data.dnbz=$('#dnbz').val()
return data;
}
