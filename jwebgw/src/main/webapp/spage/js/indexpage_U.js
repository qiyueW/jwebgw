
function getFormData() {
    var data = {};
    data.spage_indexpage_zj = $("#spage_indexpage_zj").val();
    data.spage_indexpage_neirong = GUE.getContent();
    return data;
}

//iniEvent inieditor
//初始化事件
//绑定FORM提交事件
function iniEvent() {
    $('#spage_formID').submit(
            function () {
                $btn = $("#myButton").button('loading');
                $.post(path_home + "spage/index/au/update.jw", getFormData(), function (result) {
                    if (result.statusCode == 99) {
                        var msg = "";
                        // alert(JSON.stringify(result.msg[0].value));
                        for (var i in result.msg) {
                            msg = msg + result.msg[i] + "\n";
                        }
                        alert(msg);
                    } else if (result.statusCode == 0
                            || result.statusCode == -1) {
                        alert(result.msg);
                    } else if (result.statusCode == 1) {
                        alert(result.msg);
                    }
                    setTimeout(function () {
                        $btn.button('reset');
                    }, 1100);
                }, "json");
                return false;
            });
}