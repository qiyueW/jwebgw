////iniEvent inieditor
////初始化事件
////绑定FORM提交事件
function postCModelFormData(btid) {
    var data = {};
    data.cmodel_zj = $('#cmodel_zj').val()//主键
    data.cmodel_mc = $('#cmodel_mc').val()//模型名
    data.cmodel_nr = $('#cmodel_nr').val()//模型内容
    data.cmodelfl_id = $('#cmodelfl_id').val()//外键分类
    data.cmodelfl_name = $('#cmodelfl_name').val()//分类名
    mypost('cc/cmodel/a/add.jw', data, btid);
}