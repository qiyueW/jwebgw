//iniEvent inieditor
//初始化事件
//绑定FORM提交事件

function iniEventAdminuserU() {
    $("#myButton").on('click', function () {
        var data = {};
        data.user_id = $('#user_id').val()
        data.user_name = $('#user_name').val()
        data.bm_id = $('#bm_id').val()
        data.bm_name = $('#bm_name').val()
//        alert(data.bm_name)
        data.user_password = $('#user_password').val()
        data.user_email = $('#user_email').val()

        $btn = $('#myButton').button('loading');
        if (post_json(path_home + 'sys/power/adminuser/u/update.jw', data, 400, 200)) {

        }
        setTimeout(function () {
            $btn.button('reset');
        }, 1100);
    });
}