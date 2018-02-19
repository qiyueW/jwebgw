//iniEvent inieditor
//初始化事件
//绑定FORM提交事件
function aotufineOneJSDJ(divID) {
    $("#" + divID).ligerComboBox(
            {
                url: path_home + 'sys/power/jsdj/s/selectAllByJson.jw',
                valueField: 'jsdj_zj',
                textField: 'jsdj_mc',
                selectBoxWidth: 400,
                autocomplete: false,
                width: 400
            }
    );
}
