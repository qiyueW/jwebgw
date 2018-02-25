////iniEvent inieditor
////初始化事件
////绑定FORM提交事件
function postCModelFormData(btid) {
    var data = {};
    data.cmodel_zj = $('#cmodel_zj').val()
    data.cmodel_mc = toFormatZT($('#cmodel_mc').val())
    data.cmodel_nr = toFormatZT($('#cmodel_nr').val())
    mypost('cc/cmodel/a/add.jw', data, btid);
}