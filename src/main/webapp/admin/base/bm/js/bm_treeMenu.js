
function wt_bm_menu(divId, f_onClick) {
    var tree = $("#" + divId).ligerTree({
        url: "base/bm/selectVast.jw"
        , checkbox: false
        , textFieldName: "bm_name"
        , idFieldName: "bm_id"
        , parentIDFieldName: "bm_pid"
        , onClick: f_onClick
       ,nodeWidth:175
    });
    return tree;
}