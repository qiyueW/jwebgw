////iniEvent inieditor
////初始化事件
////绑定FORM提交事件
function postCModelFormData(btid) {
    var row = $("#dg").datagrid('getSelected');
    var index = $("#dg").datagrid('getRowIndex', row);
    $("#dg").datagrid('endEdit', index);
    $.messager.confirm('确认项', '请确认是否写入数据库', function (r) {
        if (r) {
            var datas = $('#dg').datagrid('getData');
            var rs = "";
            for (var i = 0; i < datas.total; i++) {
                if (datas.rows[i].yushizhi2_key)
                    rs = rs + getJsonByBean2(datas.rows[i], i == 0 ? null : ",");
            }
            var data = {};
//                data.beanfield_zj = $('#beanfield_zj').val()
            data.beanfield_mc = toFormatZT($('#beanfield_mc').val())// 名称
            data.bean_zj = $('#bean_zj').val()// 外键主键
            data.bean_mc = $('#bean_mc').val()// 外键名称
            data.beanfield_bz = toFormatZT($('#beanfield_bz').val())// 备注
            data.beanfield2 = rs ? "[" + rs + "]" : "";
            mypost('cc/bean/field/adu/a/add.jw', data, btid);
        }
    });

    function getJsonByBean2(obj, fh) {
        if (!obj)
            return "";
        var str = (fh ? fh : "") + '{'
                + '"beanfield2_bz":"' + toFormatZT(obj.yushizhi2_bz) + '"'
                + ',"beanfield2_key":"' + toFormatZT(obj.yushizhi2_key) + '"'
                + ',"beanfield2_value":"' + toFormatZT(obj.yushizhi2_value) + '"'
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