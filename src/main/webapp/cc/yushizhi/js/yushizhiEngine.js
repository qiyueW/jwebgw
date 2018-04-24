function YSZEngine() {
    this.bean = "bean";
    this.fields = "fields";
    this.loadhead = function (selectID, key) {
        toSelect(selectID, path_home + "cc/yushizhi/s2/findHead.jw?key=" + key, "yushizhi_zj", "yushizhi_mc");
    };
    this.loadBody = function (zj) {
        $.post(path_home + "cc/yushizhi/s2/findBody.jw?", {zj: zj}, function (data) {
            for (var i = 0; i < data.length; i++) {
                $("#" + data[i].yushizhi2_key).val(data[i].yushizhi2_value);
            }
        }, "json");
    };
}

YSZEngine.prototype.beanOption = function (selectID) {
    this.loadhead(selectID, this.bean);
    var yy = this.loadBody;
    $("#" + selectID).change(function () {
        yy($(this).val());
    })
};

YSZEngine.prototype.fieldsOption = function (selectID) {
    this.loadhead(selectID, this.fields);
    var yy = this.loadBody;
    $("#" + selectID).on('onchange', function () {
        yy($("#" + selectID).val());
    });
};
