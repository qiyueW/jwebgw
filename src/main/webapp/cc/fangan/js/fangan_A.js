////iniEvent inieditor
////初始化事件
////绑定FORM提交事件
function postFanganFormData(btid) {
    var row = $("#dg").datagrid('getSelected');
    var index = $("#dg").datagrid('getRowIndex', row);
    $("#dg").datagrid('endEdit', index);
    $.messager.confirm('确认项', '请确认是否写入数据库', function (r) {
        if (r) {
            var datas = $('#dg').datagrid('getData');
            var rs = "";
            for (var i = 0; i < datas.total; i++) {
                if (datas.rows[i].fangan2_filename)
                    rs = rs + getJsonByFangan2(datas.rows[i], i == 0 ? null : ",");
            }
            var data = {};
            data.fanganfl_id = $('#fanganfl_id').val()
            data.fanganfl_name = $('#fanganfl_name').val()
            data.fangan1_mc = $('#fangan1_mc').val()
            data.fangan1_bz = $('#fangan1_bz').val()
            data.fangan1_zt = $('#fangan1_zt').val()
            data.fangan2 = "[" + rs + "]";
            mypost('cc/fangan/adu/a/add.jw', data, btid);
        }
    });
    function getJsonByFangan2(obj, fh) {
        if (!obj)
            return "";
        var str = (fh ? fh : "") + '{'
                + '"fangan2_px":"' + toFormatZT(obj.fangan2_px) + '"'
                + ',"fangan2_filepath":"' + toFormatZT(obj.fangan2_filepath) + '"'
                + ',"fangan2_filename":"' + toFormatZT(obj.fangan2_filename) + '"'
                + ',"cmodel_mc":"' + toFormatZT(obj.cmodel_mc) + '"';
        return str + "}";
    }
}


function a_toClearCell(tableID, updateValues, msg) {
    $.messager.confirm('确认项', msg ? msg : '请确认是否执行清空操作', function (r) {
        var datas = $('#' + tableID).datagrid('getData');
        for (var i = 0; i < datas.total; i++) {
            $('#' + tableID).datagrid('updateRow', {index: i, row: updateValues});
        }
    });
}