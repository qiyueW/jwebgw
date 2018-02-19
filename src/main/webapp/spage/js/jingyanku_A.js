var GUE;

function getFormData() {
    var data = {};
//    data.spage_jingyanku_zj = $("#spage_jingyanku_zj").val();
    data.spage_jingyanku_biaoti = $("#spage_jingyanku_biaoti").val();//标题
    data.spage_jingyanku_gjc = $("#spage_jingyanku_gjc").val();//关键词
    data.spage_jingyanku_fabushijian = $("#spage_jingyanku_fabushijian").val();//发布时间
    data.jingyankufl_id = $("#jingyankufl_id").val();//分类主键
    data.jingyankufl_name = $("#jingyankufl_name").val();//分类名称
    data.spage_jingyanku_neirong = GUE.getContent();
    return data;
}

//iniEvent inieditor
//初始化事件
//绑定FORM提交事件
function iniEvent() {
    $('#myButton').on('click', function () {
        $btn = $("#myButton").button('loading');
        $.post(path_home + "spage/jingyanku/add.jw", getFormData(), function (result) {
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
                $("#spage_jingyanku_biaoti").val("");
                $("#spage_jingyanku_fabushijian").val("");
                $("#spage_jingyanku_gjc").val("");//关键词
                GUE.setContent("");
                aalert(result.msg);
            }

            setTimeout(function () {
                $btn.button('reset');
            }, 1100);
        }, "json");
    });
//    (
//            function () {
//                
//                return false;
//            });
}
// 初始化ueditor编辑器
function inieditor() {
    GUE = UE.getEditor('spage_jingyanku_neirong', {
        autoHeight: false,
        initialFrameHeight: 300,
        initialFrameWidth: 600
    });
}