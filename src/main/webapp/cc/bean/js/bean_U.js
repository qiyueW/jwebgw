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
                if (datas.rows[i].bean2_key)
                    rs = rs + getJsonByYushizhi2(datas.rows[i], i == 0 ? null : ",");
            }
            var data = {};
            data.bean_zj = $('#bean_zj').val()
            data.bean_mc = toFormatZT($('#bean_mc').val())
            data.mypackage_id = $('#mypackage_id').val()
            data.mypackage_name = $('#mypackage_name').val()
            data.bean_bz =toFormatZT($('#bean_bz').val())
            data.bean2 = "[" + rs + "]";
            mypost('cc/bean/adu/u/update.jw', data, btid);
        }
    });
}
function getJsonByYushizhi2(obj, fh) {
    if (!obj)
        return "";
    var str = (fh ? fh : "") + '{'
            + '"bean2_bz":"' + toFormatZT(obj.bean2_bz) + '"'
            + ',"bean2_key":"' + toFormatZT(obj.bean2_key) + '"'
            + ',"bean2_value":"' + toFormatZT(obj.bean2_value) + '"'
    return str + "}";
}
