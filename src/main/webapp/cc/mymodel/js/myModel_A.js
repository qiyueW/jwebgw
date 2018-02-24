//iniEvent inieditor
//初始化事件
//绑定FORM提交事件
function iniMybeanEventA() {
    $('#myMybeanButton').on('click', function () {
        addMybean(getFormData());
    });

    function getFormData() {
        var data = {};
        data.mymodel_zj = $('#mymodel_zj').val()
        data.mybean_zj = $('#mybean_zj').val()
        data.mybean_mc = $('#mybean_mc').val()
        data.mymodel_mc = toFormatZT($('#mymodel_mc').val())
        data.mymodel_nr = toFormatZT($('#mymodel_nr').val())
        return data;
    }

    function addMybean(data) {
        $btn = $('#myMybeanButton').button('loading');
        $.post(path_home + 'cc/mymodel/a/add.jw', data, function (result) {
            if (result.statusCode == 99) {
                var msg = '';
                for (var i in result.msg) {
                    msg = msg + result.msg[i] + '\n';
                }
                aalert(msg);
            } else if (result.statusCode == 0 || result.statusCode == 1
                    || result.statusCode == -1) {
                aalert(result.msg);
            }
            setTimeout(function () {
                $btn.button('reset');
            }, 1100);
        }, 'json');
    }
}
