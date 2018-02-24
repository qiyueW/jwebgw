////iniEvent inieditor
////初始化事件
////绑定FORM提交事件
function postMyModelFormData(btid) {
    var data = {};
    data.mymodel_zj = $('#mymodel_zj').val()
    data.mybean_zj = $('#mybean_zj').val()
    data.mybean_mc = $('#mybean_mc').val()
    data.mymodel_mc = toFormatZT($('#mymodel_mc').val())
    data.mymodel_nr = toFormatZT($('#mymodel_nr').val())
    mypost('cc/mymodel/a/add.jw',data,btid);
}