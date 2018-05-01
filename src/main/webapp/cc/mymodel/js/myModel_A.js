////iniEvent inieditor
////初始化事件
////绑定FORM提交事件
function postMyModelFormData(btid) {
    var data = {};
    data.mymodel_zj = $('#mymodel_zj').val()
    data.bean_zj = $('#bean_zj').val()
    data.bean_mc = $('#bean_mc').val()
    data.mymodel_mc = toFormatZT($('#mymodel_mc').val())
    data.mymodel_nr = toFormatZT($('#mymodel_nr').val())
    mypost('cc/mymodel/a/add.jw',data,btid);
}