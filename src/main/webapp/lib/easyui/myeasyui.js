function pageCN(tableID, pagesize, pageList) {
    var p = $('#' + tableID).datagrid('getPager');
    var mpage = pagesize ? pagesize : 50;
    var mpageList = pageList ? pageList : [50, 100, 200, 300, 500]
    $(p).pagination({
        pageSize: mpage, //每页显示的记录条数，默认为10  
        pageList: mpageList, //可以设置每页记录条数的列表  
        beforePageText: '第', //页数文本框前显示的汉字  
        afterPageText: '页,共{pages}页',
        displayMsg: '当前显示 {from} - {to} 条记录 共{total}条记录'
    });
}
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
                    ealert(d.msg, "检验未通过")
                    x = false;
                    break;
                case "0":
                    ealert(d.msg)
                    x = false;
                    break;
                case "-1":
                    ealert(d.msg, "异常")
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