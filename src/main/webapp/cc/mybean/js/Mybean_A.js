//iniEvent inieditor
//初始化事件
//绑定FORM提交事件
function iniMybeanEventA() {
    $('#myMybeanButton').on('click', function () {
        addMybean(getFormData());
    });
    function getFormData() {
        var data = {};
        data.mybean_zj = $('#mybean_zj').val()//主键
        data.mybean_px = $('#mybean_px').val()//排序
        data.mypackage_id = $('#mypackage_id').val()//外键（归属包）
        data.mybean_mc = $('#mybean_mc').val()//类名
        data.mybean_bz = $('#mybean_bz').val()//备注
        data.package_bean = $('#package_bean').val()//bean类包
        data.package_soo = $('#package_soo').val()//soo/dao 类包
        data.name_soo = $('#name_soo').val()//soo/dao 类
        data.package_service = $('#package_service').val()//service类包
        data.name_service = $('#name_service').val()//service类
        data.package_hm = $('#package_hm').val()//hm类包
        data.name_hmA = $('#name_hmA').val()//hmA类
        data.name_hmD = $('#name_hmD').val()//hmD类
        data.name_hmU = $('#name_hmU').val()//hmU类
        data.name_hmS = $('#name_hmS').val()//hmS类
        data.package_validate = $('#package_validate').val()//validate类包
        data.name_validate = $('#name_validate').val()//validate类
        data.package_cache = $('#package_cache').val()//cache类包
        data.name_cache = $('#name_cache').val()//cache类
        data.package_vo = $('#package_vo').val()//vo类包
        data.name_vo = $('#name_vo').val()//vo类
        data.vpackage_admin = $('#vpackage_admin').val()//jsp/html包
        data.vname_admin = $('#vname_admin').val()//jsp/html包
        data.vname_adminA = $('#vname_adminA').val()//jsp/html_A
        data.vname_adminD = $('#vname_adminD').val()//jsp/html_D
        data.vname_adminS = $('#vname_adminS').val()//jsp/html_S
        data.vname_adminU = $('#vname_adminU').val()//jsp/html_U
        data.vpackage_admin_js = $('#vpackage_admin_js').val()//js包
        data.vname_admin_js = $('#vname_admin_js').val()//js
        data.vpackage_admin_css = $('#vpackage_admin_css').val()//css包
        data.vname_admin_css = $('#vname_admin_css').val()//css
        data.power_code = $('#power_code').val()//模块权限代码
        data.power_codeA = $('#power_codeA').val()//权限代码A
        data.power_codeD = $('#power_codeD').val()//权限代码D
        data.power_codeS = $('#power_codeS').val()//权限代码S
        data.power_codeU = $('#power_codeU').val()//权限代码U
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

function setMyBeanToEmpty() {
//    $('#mybean_zj').val('')
    $('#mybean_px').val('')
//    $('#mypackage_id').val('')
    $('#mybean_mc').val('')
    $('#mybean_bz').val('')
    $('#package_bean').val('')
    $('#package_soo').val('')
    $('#name_soo').val('')
    $('#package_service').val('')
    $('#name_service').val('')
    $('#package_hm').val('')
    $('#name_hmA').val('')
    $('#name_hmD').val('')
    $('#name_hmU').val('')
    $('#name_hmS').val('')
    $('#package_validate').val('')
    $('#name_validate').val('')
    $('#package_cache').val('')
    $('#name_cache').val('')
    $('#package_vo').val('')
    $('#name_vo').val('')
    $('#vpackage_admin').val('')
    $('#vname_adminA').val('')
    $('#vname_adminD').val('')
    $('#vname_adminS').val('')
    $('#vname_adminU').val('')
    $('#vpackage_admin_js').val('')
    $('#vname_admin_js').val('')
    $('#vpackage_admin_css').val('')
    $('#vname_admin_css').val('')
//    $('#power_code').val('')
    $('#power_codeA').val('')
    $('#power_codeD').val('')
    $('#power_codeS').val('')
    $('#power_codeU').val('')
}