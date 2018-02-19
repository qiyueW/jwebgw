function toSelect(selectID, url, value, name, selectedValue) {
    $.post(url, function (data) {
        var str = "";
        for (var i = 0; i < data.length; i++) {
            str = str + getOption(data[i][value], data[i][name]);
        }
        $("#" + selectID).append(str);
        if (null != selectedValue && selectedValue.length > 0) {
            $("#" + selectID).val(selectedValue);
        }
    }, "json");

    function getOption(v, n) {
        return "<option value='" + v + "'>" + n + "</option>";
    }
}

function getSelectOption(url, value, name, selectedValue) {
    var x;
    $.ajax({
        type: "post"
        , url: url
//        , data: mydata
        , dataType: "json"
        , async: false //取消异步
        , success: function (data) {
            var str = "";
            for (var i = 0; i < data.length; i++) {
                str = str + getOption(data[i][value], data[i][name], selectedValue);
            }
           x=str;
        }
    });
    return x;
    function getOption(v, n, sv) {
        if (sv == v) {
            return "<option value='" + v + "' selected>" + n + "</option>";
        }
        return "<option value='" + v + "'>" + n + "</option>";
    }
}


function ObSelectOption(selectID, url, value, name, selectedValue) {
    this.selectID = "#" + selectID;
    this.url = url;
    this.value = value;
    this.name = name;
    this.selectedValue = selectedValue;
    this.allOption = "";
    this.initData = function (ajaxData) {
        ajaxData = null == ajaxData ? {} : ajaxData;
        $.post(this.url, ajaxData, function (data) {
            var str = "";
            for (var i = 0; i < data.length; i++) {
                str = str + "<option value='" + data[i][value] + "'>" + data[i][name] + "</option>";
            }
            this.allOption = str;
//           
        }, "json");
    };
    this.addOption = function (selectedValue) {
        $(this.selectID).append(this.allOption);
        selectedValue = null == selectedValue ? this.selectedValue : selectedValue;
        if (null != selectedValue && selectedValue.length > 0) {
            $(this.selectID).val(selectedValue);
        }
    };
    /**
     * 给select元素写入选项时，重新选定select元素的id进行写入
     * @param {type} selectID 必须
     * @param {type} selectedValue 如果没有，则采用系统的。如果系统的也没有。则不进行初始选择。
     * @returns {undefined}
     */
    this.addOptionByMyID = function (selectID, selectedValue) {
        $("#" + selectID).append(this.allOption);
        selectedValue = (null == selectedValue ? this.selectedValue : selectedValue);
        if (null != selectedValue && selectedValue.length > 0) {
            $("#" + selectID).val(selectedValue);
        }
    };
}