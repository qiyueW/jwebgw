function TreeObject(){}
TreeObject.prototype.getTreeChecked = function(divIDTree, getFieldName) {
    var td = $("#" + divIDTree).ligerGetTreeManager().getChecked();
    if (null != td) {
        var rs = "";
        for (var i = 0; i < td.length; i++) {
            rs = rs + "," + td[i].data[getFieldName];//.data.role_id;
        }
        return rs.substring(1);
    }
    return"";
}
TreeObject.prototype.setTreeNodeChecked = function(divIDTree, ids) {
    var td = $("#" + divIDTree).ligerGetTreeManager().getChecked();
    
}
TreeObject.prototype.cancelSelect = function(divIDTree) {
    var td = $("#" + divIDTree).ligerGetTreeManager().getChecked();
    td.cancelSelect("Y");
    td.refreshTree();
}

function iniDate(divID, value) {
    value = (null == value ? '' : value);
    $("#" + divID).ligerDateEditor({
        format: "yyyy-MM-dd"
//			,labelWidth:'100'
        , initValue: value
        , labelAlign: 'center'
        , cancelable: false
    });
}

function getMyNodeID(id, node) {
    var str = node[id];
    dowhile(node);
    function dowhile(node) {
        var ss = node.children;
        if (null != ss) {
            for (var i = 0; i < ss.length; i++) {
                str = str + "," + ss[i][id];
                if (ss[i].children) {
                    dowhile(ss[i]);
                }
            }
        }
    }
    return str;
}

function msg_tip(title /**String**/, msg /**String**/, w, h) {
    w = null == w ? 400 : w;
    h = null == h ? 200 : h;
    var s = $.ligerDialog.tip({
        title: "<h3>" + title + "</h3>"
        , content:  msg 
        , width: w
        , height: h
    });
    setTimeout(function () {
        s.close();
        s = null;
    }, 2000);
}
function msg_tipOK_NO(title /**String**/, msg /**String**/, okno /**ok=true,no=false**/, w, h) {
    w = null == w ? 400 : w;
    h = null == h ? 200 : h;
    var s = $.ligerDialog.tip({
        title: okno ? "<h3  style=\"color:#00F\">" + title + "</h3>" : "<h3  style=\"color:#F00\">" + title + "</h3>"
        , content: msg
        , width: w
        , height: h
    });
    setTimeout(function () {
        s.close();
        s = null;
    }, 2000);
}

//function openURL(myTitle, showVar, url, myHeight, myWidth) {
//    if (showVar)
//        showVar.show();
//    else {
//        showVar = $.ligerDialog.open({
//            height: myHeight, width: myWidth
//            , url: url
//            , title: myTitle
//            , showMin: true
//            , showMax: true
//        });
//    }
//    return showVar;
//}
function openURL_Event(myTitle, showVar, url, myHeight, myWidth, f_closeMethod) {
    if (showVar)
        showVar.show();
    else {
        showVar = $.ligerDialog.open({
            height: myHeight, width: myWidth
            , url: url
            , title: myTitle
            , showMin: true
            , showMax: true
            , isHidden: false
            , onClosed: f_closeMethod
        });
    }
    return showVar;
}

/**
 * 
 * @param {type} inputId 
 * @param {type} url 远程json数据
 * @param {type} checkbox_true_false 是否显示复选框
 * @param {type} s_boxW     选择框宽
 * @param {type} s_boxH     选择框高
 * @param {type} tfield     文本字段
 * @param {type} vfield     值字段
 * @param {type} tfieldName  文本显示字段名
 * @param {type} idfieldName id显示字段名
 * @param {type} pidfieldName pid显示字段名
 * @param {type} f_onSelected   选择事件
 * @returns {ligerComboBox}
 */
function post_ComboBox(
        inputId, url, checkbox_true_false, s_boxW, s_boxH,
        tfield, vfield,
        tfieldName, idfieldName, pidfieldName, f_onSelected
        ) {
    var cb = $("#" + inputId).ligerComboBox({
        selectBoxWidth: s_boxW,
        selectBoxHeight: s_boxH,
        type: "select",
        textField: tfield, valueField: vfield, treeLeafOnly: false,
        tree: {url: url, checkbox: checkbox_true_false,
            textFieldName: tfieldName,
            idFieldName: idfieldName,
            parentIDFieldName: pidfieldName
        },
        onSelected: f_onSelected
    });
    return cb;
}


function myajax(url, mydata) {
    var x;
    $.ajax({
        type: "post"
        , url: url
        , data: mydata
        , dataType: "json"
        , async: false //取消异步
        , success: function (d) {
            x = d;
        }
    });
    return x;
}

function post_json(url, mydata, w, h) {
    var x = false;
    $.ajax({
        type: "post"
        , url: url
        , data: mydata
        , dataType: "json"
        , async: false //取消异步
        , success: function (d) {
            switch (d.statusCode) {
                case "99":
                    var msg = "";
                    for (var i in d.msg) {
                        msg = msg + d.msg[i] + "<br/>";
                    }
                    msg_tipOK_NO("检验未通过", msg, false, w, h);
                    x = false;
                    break;
                case "0":
                    msg_tipOK_NO("后台未接受", d.msg, false, w, h);
                    x = false;
                    break;
                case "-1":
                    msg_tipOK_NO("检测未通过", d.msg, false, w, h);
                    x = false;
                    break;
                case "1":
                    msg_tipOK_NO("成功提示", d.msg, true, w, h);
                    x = true;
                    break;
            }
        }
    });
    return x;
}
function f_ajaxForm(areaID, serverURL, w, h) {
    var f_NV = $("#" + areaID + " :input[name,value]");
    var data = {};
    for (var i = 0; i < f_NV.length; i++) {
        if (null != f_NV[i].name && f_NV[i].name.length > 0) {
            data[f_NV[i].name] = f_NV[i].value;
        }
    }
    return post_json(serverURL, data, w, h);
}

//function post_json_noshow(url, mydata) {
//    var x;
//    $.ajax({
//        type: "post"
//        , url: url
//        , data: mydata
//        , dataType: "json"
//        , async: false //取消异步
//        , success: function (d) {
//            if (d.statusCode == 200) {
//                x = true;
//            } else {
//                x = false;
//            }
//        }
//    });
//    return x;
//}

function timeStamp2String(time) {
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours() < 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes() < 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds() < 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "-" + month + "-" + date + " " + hour + ":" + minute + ":" + second;
}
function dateStamp2String(vdate, fh) {
    fh = null == fh ? "-" : fh;
    var datetime = new Date();
    datetime.setTime(vdate);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    return year + fh + month + fh + date;
}
