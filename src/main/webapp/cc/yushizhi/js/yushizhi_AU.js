////iniEvent inieditor
////初始化事件
////绑定FORM提交事件
function postYushizhiAUFormData(btid) {
    var row = $("#dg").datagrid('getSelected');
    var index = $("#dg").datagrid('getRowIndex', row);
    $("#dg").datagrid('endEdit', index);
    $.messager.confirm('确认项', '请确认是否写入数据库', function (r) {
        if (r) {
            var datas = $('#dg').datagrid('getData');
            var rs = "";
            for (var i = 0; i < datas.total; i++) {
                if (datas.rows[i].yushizhi2_key)
                    rs = rs + getJsonByYushizhi2(datas.rows[i], i == 0 ? null : ",");
            }
            var data = {};
            data.yushizhi2 = "[" + rs + "]";
            mypost('cc/yushizhi/adu/a/add.jw', data, btid);
        }
    });
}
function getJsonByYushizhi2(obj, fh) {
    if (!obj)
        return "";
    var str = (fh ? fh : "") + '{'
            + '"yushizhi2_bz":"' + toFormatZT(obj.yushizhi2_bz) + '"'
            + ',"yushizhi2_px":"' + toFormatZT(obj.yushizhi2_px) + '"'
            + ',"yushizhi2_key":"' + toFormatZT(obj.yushizhi2_key) + '"'
            + ',"yushizhi2_value":"' + toFormatZT(obj.yushizhi2_value) + '"'
    return str + "}";
}

function a_toClearCell(tableID, updateValues, msg) {
    $.messager.confirm('确认项', msg ? msg : '请确认是否执行清空操作', function (r) {
        var datas = $('#' + tableID).datagrid('getData');
        for (var i = 0; i < datas.total; i++) {
            $('#' + tableID).datagrid('updateRow', {index: i, row: updateValues});
        }
    });
}