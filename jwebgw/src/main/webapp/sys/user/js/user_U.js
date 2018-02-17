////iniEvent inieditor
////初始化事件
////绑定FORM提交事件
//function iniEventU() {
//    $('#myButtonU').on('click', function () {
//        update(getFormData());
//    });
//    function getFormData() {
//        var data = {};
//        data.role_id=$('#role_id').val()
//        data.jsdj_zj = $('#jsdj_zj').val()
//        data.role_name = $('#role_name').val()
//        data.role_info = $('#role_info').val()
//        return data;
//    }
//
//    function update(data) {
//        $btn = $('#myButton').button('loading');
//        $.post(path_home + 'sys/power/role/u/update.jw', data, function (result) {
//            if (result.statusCode == 99) {
//                var msg = '';
//                for (var i in result.msg) {
//                    msg = msg + result.msg[i] + '\n';
//                }
//                alert(msg);
//            } else if (
//                    result.statusCode == 0
//                    || result.statusCode == 1
//                    || result.statusCode == -1) {
//                alert(result.msg);
//            }
//            setTimeout(function () {
//                $btn.button('reset');
//            }, 1100);
//        }, 'json');
//    }
//}
//
//
