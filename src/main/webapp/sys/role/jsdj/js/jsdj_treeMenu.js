
function role_jsdj_menu(divId, f_onClick) {
    var tree = $("#" + divId).ligerTree({
        url: path_home + "sys/power/jsdj/s/selectAllByJson.jw"
        , checkbox: false
        , textFieldName: "jsdj_mc"
        , idFieldName: "jsdj_id"
        , onClick: f_onClick
       ,nodeWidth:155
    });
    return tree;
}