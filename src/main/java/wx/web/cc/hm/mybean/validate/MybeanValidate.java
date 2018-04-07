package wx.web.cc.hm.mybean.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class MybeanValidate extends ValidateModel {

    public MybeanValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super
                .put("mybean_zj", "[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("mybean_px", "-?[0-9]+", ":请输入正数", true)//排序
                .put("mypackage_id", "[1-9]{1}[0-9]{23}", "外键（归属包）主键丢失", false)//外键（归属包）
                .put("mybean_mc", "[\\w\\W]{1,50}", "类名 文本过长", true)//类名
                .put("mybean_bz", "[\\w\\W]{1,50}", "备注 文本过长", true)//备注
                .put("package_bean", "[\\w\\W]{1,50}", "bean类包 文本过长", true)//bean类包
                .put("package_soo", "[\\w\\W]{1,100}", "soo/dao 类包 文本过长", true)//soo/dao 类包
                .put("name_soo", "[\\w\\W]{1,100}", "soo/dao 类 文本过长", true)//soo/dao 类
                .put("package_service", "[\\w\\W]{1,100}", "service类包文本过长", true)//service类包
                .put("name_service", "[\\w\\W]{1,100}", "service类 文本过长", true)//service类
                .put("package_hm", "[\\w\\W]{1,100}", "hm类包 文本过长", true)//hm类包
                .put("name_hmA", "[\\w\\W]{1,100}", "hmA类文本过长", true)//hmA类
                .put("name_hmD", "[\\w\\W]{1,100}", "hmD类文本过长", true)//hmD类
                .put("name_hmU", "[\\w\\W]{1,100}", "hmU类文本过长", true)//hmU类
                .put("name_hmS", "[\\w\\W]{1,100}", "hmS类文本过长", true)//hmS类
                .put("package_validate", "[\\w\\W]{1,100}", "validate类包文本过长", true)//validate类包
                .put("name_validate", "[\\w\\W]{1,100}", "validate类 文本过长", true)//validate类
                .put("package_cache", "[\\w\\W]{1,100}", "cache类包 文本过长", true)//cache类包
                .put("name_cache", "[\\w\\W]{1,100}", "cache类 文本过长", true)//cache类
                .put("package_vo", "[\\w\\W]{1,100}", "vo类包 文本过长", true)//vo类包
                .put("name_vo", "[\\w\\W]{1,100}", "vo类 文本过长", true)//vo类
                .put("vpackage_admin", "[\\w\\W]{1,100}", "jsp/html包 文本过长", true)//jsp/html包
                .put("vname_adminA", "[\\w\\W]{1,100}", "jsp/html_A 文本过长", true)//jsp/html_A
                .put("vname_adminD", "[\\w\\W]{1,100}", "jsp/html_D 文本过长", true)//jsp/html_D
                .put("vname_adminS", "[\\w\\W]{1,100}", "jsp/html_S 文本过长", true)//jsp/html_S
                .put("vname_adminU", "[\\w\\W]{1,100}", "jsp/html_U 文本过长", true)//jsp/html_U
                .put("vpackage_admin_js", "[\\w\\W]{1,100}", "js包 文本过长", true)//js包
                .put("vname_admin_js", "[\\w\\W]{1,100}", "js 文本过长", true)//js
                .put("vpackage_admin_css", "[\\w\\W]{1,100}", "css包 文本过长", true)//css包
                .put("vname_admin_css", "[\\w\\W]{1,100}", "css 文本过长", true)//css
                .put("power_code", "[\\w\\W]{1,100}", "模块权限代码 文本过长", true)//模块权限代码
                .put("power_codeA", "[\\w\\W]{1,100}", "权限代码A 文本过长", true)//权限代码A
                .put("power_codeD", "[\\w\\W]{1,100}", "权限代码D 文本过长", true)//权限代码D
                .put("power_codeS", "[\\w\\W]{1,100}", "权限代码S 文本过长", true)//权限代码S
                .put("power_codeU", "[\\w\\W]{1,100}", "权限代码U 文本过长", true)//权限代码U
                ;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}
