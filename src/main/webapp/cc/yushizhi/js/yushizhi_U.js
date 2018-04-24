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
                if (datas.rows[i].yushizhi2_key)
                    rs = rs + getJsonByYushizhi2(datas.rows[i], i == 0 ? null : ",");
            }
            var data = {};
            data.yushizhi_zj = $('#yushizhi_zj').val()
            data.yushizhi_mc = toFormatZT($('#yushizhi_mc').val())
            data.yushizhifl_id = $('#yushizhifl_id').val()
            data.yushizhifl_name = $('#yushizhifl_name').val()
            data.yushizhi_bz = toFormatZT($('#yushizhi_bz').val())
            data.yushizhi2 = "[" + rs + "]";
            mypost('cc/yushizhi/adu/u/update.jw', data, btid);
        }
    });
}
function getJsonByYushizhi2(obj, fh) {
    if (!obj)
        return "";
    var str = (fh ? fh : "") + '{'
            + '"yushizhi2_bz":"' + toFormatZT(obj.yushizhi2_bz) + '"'
            + ',"yushizhi2_key":"' + toFormatZT(obj.yushizhi2_key) + '"'
            + ',"yushizhi2_value":"' + toFormatZT(obj.yushizhi2_value) + '"'
    return str + "}";
}
