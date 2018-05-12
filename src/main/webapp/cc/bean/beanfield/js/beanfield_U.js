////iniEvent inieditor
////初始化事件
////绑定FORM提交事件
function u_postFormData(btid) {
    var row = $("#u_dg").datagrid('getSelected');
    var index = $("#u_dg").datagrid('getRowIndex', row);
    $("#u_dg").datagrid('endEdit', index);
    $.messager.confirm('确认项', '请确认是否写入数据库', function (r) {
        if (r) {
            var datas = $('#u_dg').datagrid('getData');
            var rs = "";
            for (var i = 0; i < datas.total; i++) {
                if (datas.rows[i].beanfield2_key)
                    rs = rs + getJsonByYushizhi2(datas.rows[i], i == 0 ? null : ",");
            }
            var data = {};
            data.beanfield_zj = $('#beanfield_zj').val()
            data.beanfield_mc = toFormatZT($('#beanfield_mc').val())// 名称
            data.bean_zj = $('#bean_zj').val()// 外键主键
            data.bean_mc = $('#bean_mc').val()// 外键名称
            data.beanfield_bz = toFormatZT($('#beanfield_bz').val())// 备注
            data.beanfield2 = rs ? "[" + rs + "]" : "";
            mypost('cc/bean/field/adu/u/update.jw', data, btid);
        }
    });
}
function getJsonByYushizhi2(obj, fh) {
    if (!obj)
        return "";
    var str = (fh ? fh : "") + '{'
            + '"beanfield2_bz":"' + toFormatZT(obj.beanfield2_bz) + '"'
            + ',"beanfield2_key":"' + toFormatZT(obj.beanfield2_key) + '"'
            + ',"beanfield2_value":"' + toFormatZT(obj.beanfield2_value) + '"'
    return str + "}";
}
