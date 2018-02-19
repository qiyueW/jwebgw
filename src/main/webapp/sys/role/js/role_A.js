//iniEvent inieditor
//初始化事件
//绑定FORM提交事件
function iniEvent() {
    $("#myButton").on('click', function () {
        addOneRole(getFormData());
    });

    function getFormData() {
        var data = {};
        //data.role_id=$('#role_id').val()
        data.jsdj_zj = $('#jsdj_zj').val()
        data.role_name = $('#role_name').val()
        data.role_info = $('#role_info').val()
        return data;
    }
    
    function addOneRole(data) {
        $btn = $('#myButton').button('loading');
        if (post_json(path_home + 'sys/power/role/a/add.jw', data, 400, 200)) {
            $("#role_name").val("");
            $("#role_info").val("");
        }
        setTimeout(function () {
            $btn.button('reset');
        }, 1100);
    }
}