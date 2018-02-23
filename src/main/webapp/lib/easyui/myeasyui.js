
function easyuipost(url, mydata) {
    var x = false;
    $.ajax({
        type: "post"
        , url: url
        , data: mydata
        , dataType: "json"
        , async: false //取消异步
        , success: function (d) {
            switch (d.statusCode) {
                case "99":
                    var msg = "";
                    for (var i in d.msg) {
                        msg = msg + d.msg[i] + "<br/>";
                    }
                    ealert(d.msg,"检验未通过")
                    x = false;
                    break;
                case "0":
                    ealert(d.msg)
                    x = false;
                    break;
                case "-1":
                    ealert(d.msg,"异常")
                    x = false;
                    break;
                case "1":
                    ealert(d.msg, "操作成功")
                    x = true;
                    break;
            }
        }
    });
    return x;
}

function ealert(msg, title, showType) {
    $.messager.show({
        title: title ? title : "提示",
        msg: msg,
        showType: showType ? showType : 'slide',
        style: {
            right: '',
            top: '',
            bottom: -document.body.scrollTop - document.documentElement.scrollTop
        }
    });
}