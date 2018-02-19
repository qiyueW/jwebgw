//iniEvent inieditor
//初始化事件
//绑定FORM提交事件
function iniMybeanEventA() {
    $('#myMybeanButton').on('click',function () {
        addMybean(getFormData());
    });
    function getFormData() {
        var data = {};
        data.mypackage_id = $('#mypackage_id').val()
        data.mybean_px = $('#mybean_px').val()
        data.mybean_mc = $('#mybean_mc').val()
        data.mybean_bz = $('#mybean_bz').val()
        return data;
    }

    function addMybean(data) {
        $btn = $('#myMybeanButton').button('loading');
        $.post(path_home + 'cc/mybean/a/add.jw', data, function (result) {
            if (result.statusCode == 99) {
                var msg = '';
                for (var i in result.msg) {
                    msg = msg + result.msg[i] + '\n';
                }
                alert(msg);
            } else if (
                    result.statusCode == 0
                    || result.statusCode == 1
                    || result.statusCode == -1) {
                alert(result.msg);
            }
            setTimeout(function () {
                $btn.button('reset');
            }, 1100);
        }, 'json');
    }
}