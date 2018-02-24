/**
 * 
 * @param {type} url 远程请求的url
 * @param {type} param 远程请求的参数
 * @param {type} idName id   字段名
 * @param {type} pidName pid 字段名
 * @param {type} name    树的name字段名
 * @param {type} divID   产生树的容器
 * @param {type} showNameID 
 * @param {type} hideValueID
 * @param {type} w
 * @param {type} h
 * @returns {ztree_select}
 */
function ztree_select(url, param, divID, showNameID, hideValueID, w, h) {
    this.with = null == w ? 120 : w;
    this.height = null == h ? 180 : h;
    this.url = url;
    this.param = param;
    this.showNameID = showNameID;//citySel
    this.hideValueID = hideValueID;//选择值的隐藏式id
    this.treeID = showNameID + "_treeID";//成树的id
    this.menuContentDIV = showNameID + "_menuContent";
    this.idName;
    this.pidName;
    this.name;
    this.ztreesetting;
    var div =
            "<input id=\"" + this.showNameID + "\" type=\"text\"  value=\"\" readonly style=\"width:" + this.with + "px;\" />" +
            "    <input id=\"" + this.hideValueID + "\" type=\"hidden\" />" + //放用户选择的值
            "<div id=\"" + this.menuContentDIV + "\" style=\"display:none; position: absolute; background-color:#FFFAFA \">" + //
            "    <ul id=\"" + this.treeID + "\" class=\"ztree\" style=\"margin-top:0;width:" + this.with + "px; height:" + this.height + "px; overflow-y: scroll\"></ul>" + //下拉面板的树
            "</div>";
    $("#" + divID).html(div);
    var cc = this.menuContentDIV;
    var cc1 = this.showNameID;
    $('#' + this.showNameID).on('click', function () {
        ztree_showMyMenu(cc, cc1)
    })
}
ztree_select.prototype.init = function (f_check, idName, pidName, name, initName, initValue) {
    this.idName = idName;
    this.pidName = pidName;
    this.name = name;
    var as;
    if (this.param == {}) {
        as = {enable: true, type: "post", url: this.url}
    } else {
        as = {enable: true, type: "post", url: this.url, otherParam: this.param}
    }
    this.ztreesetting = {
        async: as, //{enable: true, type: "post", url: this.url,otherParam:param},
//        radio: {enable: true},
        view: {dblClickExpand: false},
        data: {simpleData: {enable: true, idKey: idName, pIdKey: pidName, rootPId: "0"}, key: {name: name}},
        callback: {
            beforeClick: f_check,
//            onCheck: f_check,
            onAsyncSuccess: onAsyncSuccess
        }
    };
    var id = this.treeID;

    if (initName)
        $("#" + this.showNameID).val(initName)
    if (initValue)
        $("#" + this.hideValueID).val(initValue)

    function onAsyncSuccess() {
        $.fn.zTree.getZTreeObj(id).expandAll(true);
    }
    $.fn.zTree.init($("#" + this.treeID), this.ztreesetting);
}

ztree_select.prototype.beforeClick = function (treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj(treeId);
    zTree.checkNode(treeNode, !treeNode.checked, false, true);
    return false;
}

ztree_select.prototype.setMyValue = function (n, v) {
    $("#" + this.showNameID).val(n);
    $("#" + this.hideValueID).val(v);
}

ztree_select.prototype.hideMenu = function () {
    $("#" + this.menuContentDIV).fadeOut("fast");
}

ztree_select.prototype.setMyValue = function (treeNode, f) {
    if (f) {
        f
    } else {
        $("#" + this.showNameID).val(treeNode[this.getName()]);
        $("#" + this.hideValueID).val(treeNode[this.getIdName()]);
    }
}


ztree_select.prototype.getIdName = function () {
    return this.idName;
}
ztree_select.prototype.getPidName = function () {
    return this.pidName;
}
ztree_select.prototype.getName = function () {
    return this.name;
}

ztree_select.prototype.onCheck = function (treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj(treeId);
    var nodes = zTree.getCheckedNodes(true);
    var v = "";
    for (var i = 0, l = nodes.length; i < l; i++) {
        v += nodes[i][this.getIdName()] + ",";
    }
    if (v.length > 0)
        v = v.substring(0, v.length - 1);
    return v;
}
//============多选择=============================
/**
 * 
 * @param {type} url 远程请求的url
 * @param {type} param 远程请求的参数
 * @param {type} idName id   字段名
 * @param {type} pidName pid 字段名
 * @param {type} name    树的name字段名
 * @param {type} divID   产生树的容器
 * @param {type} showNameID 
 * @param {type} hideValueID
 * @param {type} w
 * @param {type} h
 * @returns {ztree_select2}
 */
function ztree_select2(url, param, divID, showNameID, hideValueID, w, h) {
    this.with = null == w ? 120 : w;
    this.height = null == h ? 180 : h;
    this.url = url;
    this.param = param;
    this.showNameID = showNameID;//citySel
    this.hideValueID = hideValueID;//选择值的隐藏式id
    this.treeID = showNameID + "_treeID";//成树的id
    this.menuContentDIV = showNameID + "_menuContent";
    this.idName;
    this.pidName;
    this.name;
    this.chkboxType = 1;
    this.ztreesetting;
    var div =
            "<input id=\"" + this.showNameID + "\" type=\"text\"  value=\"\" readonly style=\"width:" + this.with + "px;\" />" +
            "    <input id=\"" + this.hideValueID + "\" type=\"hidden\" />" + //放用户选择的值
            "<div id=\"" + this.menuContentDIV + "\" style=\"display:none; position: absolute; background-color:#FFFAFA \">" + //
            "    <ul id=\"" + this.treeID + "\" class=\"ztree\" style=\"margin-top:0;width:" + this.with + "px; height:" + this.height + "px; overflow-y: scroll\"></ul>" + //下拉面板的树
            "</div>";
    $("#" + divID).html(div);
    var cc = this.menuContentDIV;
    var cc1 = this.showNameID;
    $('#' + this.showNameID).on('click', function () {
        ztree_showMyMenu(cc, cc1)
    })
}
ztree_select2.prototype.init = function (f_check, chkboxType, idName, pidName, name, initName, initValue) {
    this.idName = idName;
    this.pidName = pidName;
    this.name = name;
    var x = {"Y": "ps", "N": "ps"};
    if (chkboxType == 0) {
        x = {"Y": "", "N": ""};
        this.chkboxType = 0;
    }

    this.ztreesetting = {
        async: {enable: true, type: "post", url: this.url},
        check: {enable: true,
            chkStyle: "checkbox",
            chkboxType: x
        },
        view: {dblClickExpand: false},
        data: {simpleData: {enable: true, idKey: idName, pIdKey: pidName, rootPId: "0"}, key: {name: name}},
        callback: {
            beforeClick: this.beforeClick,
            onCheck: f_check,
            onAsyncSuccess: onAsyncSuccess
        }
    };
    var id = this.treeID;



    function onAsyncSuccess(event, treeId, treeNode, msg) {
        var tree = $.fn.zTree.getZTreeObj(treeId);
        tree.expandAll(true);
        if (initValue) {
            var myID = initValue.split("|");
            var node;
            for (var i = 0; i < myID.length; i++) {
                node = tree.getNodeByParam(idName, myID[i], null);
                tree.checkNode(node, !node.checked, this.chkboxType == 0 ? false : true, true);
            }
        }
        if (initName)
            $("#" + this.showNameID).val(initName)
        if (initValue)
            $("#" + this.hideValueID).val(initValue)

    }
    $.fn.zTree.init($("#" + this.treeID), this.ztreesetting);

}

ztree_select2.prototype.beforeClick = function (treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj(treeId);
    zTree.checkNode(treeNode, !treeNode.checked, this.chkboxType == 0 ? false : true, true);
    return false;
}
ztree_select2.prototype.setMyValue = function (event, treeId, treeNode) {
    var tree = $.fn.zTree.getZTreeObj(treeId);
    var nodes = tree.getCheckedNodes(true);
    var rs_name = "";
    var rs_id = "";
    for (var i = 0; i < nodes.length; i++) {
        rs_name = rs_name + "|" + nodes[i][this.name];
        rs_id = rs_id + "|" + nodes[i][this.idName];
    }
    $("#" + this.showNameID).val(rs_name.substring(1));
    $("#" + this.hideValueID).val(rs_id.substring(1));
}

ztree_select2.prototype.hideMenu = function () {
    $("#" + this.menuContentDIV).fadeOut("fast");
}

//ztree_select2.prototype.setMyValue = function (treeNode, f) {
//    if (f) {
//        f
//    } else {
//        $("#" + this.showNameID).val(treeNode[this.getName()]);
//        $("#" + this.hideValueID).val(treeNode[this.getIdName()]);
//    }
//}


ztree_select2.prototype.getIdName = function () {
    return this.idName;
}
ztree_select2.prototype.getPidName = function () {
    return this.pidName;
}
ztree_select2.prototype.getName = function () {
    return this.name;
}

ztree_select2.prototype.onCheck = function (treeId, treeNode) {
    var zTree = $.fn.zTree.getZTreeObj(treeId);
    var nodes = zTree.getCheckedNodes(true);
    var v = "";
    for (var i = 0, l = nodes.length; i < l; i++) {
        v += nodes[i][this.getIdName()] + ",";
    }
    if (v.length > 0)
        v = v.substring(0, v.length - 1);
    return v;
}




//===========公共===============================
function ztree_showMyMenu(menuContentDIV, showNameID) {
    var cityObj = $("#" + showNameID);
    var cityOffset = $("#" + showNameID).offset
    $("#" + menuContentDIV).css({left: cityOffset.left + "px", top: cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
    $("body").bind("mousedown", onBodyDown);
    function onBodyDown(event) {
        if (!(event.target.id == showNameID || event.target.id == menuContentDIV || $(event.target).parents("#" + menuContentDIV).length > 0)) {
            hideMenu();
        }
    }
    function hideMenu() {
        $("#" + menuContentDIV).fadeOut("fast");
        $("body").unbind("mousedown", onBodyDown);
    }
}

function ztree_Menue(divID, id, pid, name, url, otherParam, clickfunction) {
    //检出bean模型
    var setting2 = {
        treeId: id,
        check: { enable: true },
        async: { enable: true, type: "post", url: url, otherParam: otherParam },
        data: {
            simpleData: { enable: true, idKey: id, pIdKey: pid,  rootPId: "0" },
            key: {name: name}
        },
        callback: { onClick: clickfunction  }
    }
    $.fn.zTree.init($("#" + divID), setting2);
}
