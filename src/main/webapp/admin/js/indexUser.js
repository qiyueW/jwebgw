function loadUserMainTree(divID) {
    //检出包结构  /*               
    var setting0 = {
        treeId: "mypackage_id",
        async: {enable: true, type: "post", url: path_home + "sys/user/manager/v/showMenu.jw"},
        data: {simpleData: {enable: true, idKey: "power_id", pIdKey: "power_pid", rootPId: "0"}, key: {name: "power_name"}},
        callback: {
            onClick: function (event, id, treeNode) {//点击部门时，重新加载管理员树。参数为
                if (treeNode.view_url) {
                    addTab(treeNode.power_name, treeNode.view_url);
                }
            },
            onAsyncSuccess: function () {
                $.fn.zTree.getZTreeObj(divID).expandAll(true);
            }
        }
    };
    $.fn.zTree.init($("#" + divID), setting0);
}
function addTab(title, url) {
    if ($('#tt').tabs('exists', title)) {
        $('#tt').tabs('select', title);
    } else {
        var content = '<iframe scrolling="auto" frameborder="0"  src="' + path_home + url + '" style="width:99.4%;height:99.4%;"></iframe>';
        $('#tt').tabs('add', {
            title: title,
            content: content,
            closable: true
        });
    }
}