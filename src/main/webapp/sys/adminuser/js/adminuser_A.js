//iniEvent inieditor
//初始化事件
//绑定FORM提交事件
$(function () {
    iniEventAdminuser();
});
function iniEventAdminuser() {

    $('#myButton').on('click', function () {
        $btn = $("#myButton").button('loading');
        var data = {};
        data.bm_id = $('#bm_id').val()
        data.bm_name = $('#bm_name').val()
        data.user_name = $('#user_name').val()
        data.user_account = $('#user_account').val()
        data.user_password = $('#user_password').val()
        data.user_email = $('#user_email').val()
        data.user_sort = $('#user_sort').val()
        data.user_style = $('#user_style').val()
        $.post(path_home + 'sys/power/adminuser/a/add.jw', data, function (result) {
            if (result.statusCode == 99) {
                var msg = "";
                // alert(JSON.stringify(result.msg[0].value));
                for (var i in result.msg) {
                    msg = msg + result.msg[i] + "\n";
                }
                aalert(msg);
            } else if (result.statusCode == 0
                    || result.statusCode == -1) {
                aalert(result.msg);
            } else if (result.statusCode == 1) {
                $("#user_account").val("");
                $("#user_name").val("");
                $("#user_password").val("");
                $("#user_email").val("");
                aalert(result.msg);
            }

            setTimeout(function () {
                $btn.button('reset');
            }, 1100);
        }, "json");
    });
}