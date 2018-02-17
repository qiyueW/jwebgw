var GUE;

function getFormData() {
    var data = {};
    data.spage_notice_biaoti = $("#spage_notice_biaoti").val();
//	data.spage_notice_neirong=$("#spage_notice_neirong").val();
    data.spage_notice_fabushijian = $("#spage_notice_fabushijian").val();
    data.spage_notice_neirong = GUE.getContent();
    return data;
}

//iniEvent inieditor
//初始化事件
//绑定FORM提交事件
function iniEvent() {
    $('#spage_formID').submit(
            function () {
                $btn = $("#myButton").button('loading');
                $.post(path_home + "spage/notice/add.jw", getFormData(), function (result) {
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
                         $("#spage_notice_biaoti").val("");
                        $("#spage_notice_fabushijian").val("");
                        GUE.setContent("");
                        alert(result.msg);
                    }

                    setTimeout(function () {
                        $btn.button('reset');
                    }, 1100);
                }, "json");
                return false;
            });
}
// 初始化ueditor编辑器
function inieditor() {
    GUE = UE.getEditor('spage_notice_neirong');//, {
//        autoHeight: false,
//        initialFrameHeight: 90,
//        toolbars: [[
//                'fullscreen'
//                        , 'undo', 'justifyleft', 'justifyright'
//                        , 'backcolor'
//                        , 'forecolor'
//                        , 'attachment'
//                        , 'simpleupload', 'insertimage'
//                        , 'edittip'
//                        , 'customstyle'
//                        , 'drafts'
//            ]]
//    });
}