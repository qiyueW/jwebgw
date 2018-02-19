package wx.web.base.hm.ry.validate;

import java.util.Map;
import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;
import wx.web.base.bean.RY;

//@system.base.annotation.Validate(wx.web.hm.validate.RYValidate.class)
public class RYValidate extends ValidateModel {

    public RYValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {

        super
                .put("ry_id", "[1-9]{1}[0-9]{23}", "主键丢失", false)
                .put("bm_id", "[1-9]{1}[0-9]{23}", "部门主键丢失", true)
                .put("bm_name", "[\\w\\W]{1,50}", "部门名长度(1-50)或格式有误", true)
                .put("gw_id", "[1-9]{1}[0-9]{23}", "岗位主键丢失", false)
                .put("gw_name", "[\\w\\W]{1,50}", "岗位名长度(1-50)或格式有误", false)
                .put("ry_cdate", "[0-9]{4}-[0-9]{2}-[0-9]{2}", "输入用1988-09-01类似格式", true)
                .put("ry_style", "0|1|2|3{1}", "人员状态有误", true)
                .put("ry_sort", "1|2|3{1}", "人员类别有误", false)
                .put("ry_name", "[\\w\\W]{1,50}", "人员名格式或长度(50字内)有误", true)
                .put("ry_sex", "[男|女]{1}", "性别格式长度有误", true)
                .put("ry_email", "[a-zA-Z0-9\\_]{1,24}@[a-zA-Z0-9]{1,14}\\.[a-zA-Z0-9]{1,10}", "邮箱格式或长度(50字内)有误", false)
                .put("ry_phone", "[\\w\\W]{1,100}", "有误格式或长度(100字内)有误", false)
                .put("ry_info", "[\\w\\W]{1,200}", "人员备注过长", false)
                .put("ry_account", "[a-zA-Z0-9]{1,50}", "账号应该是字母和数字组成并在50字内", true)
                .put("ry_password", "[a-zA-Z0-9]{1,50}", "密码应该是字母和数字组成并在50字内", true);
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        RY ry = jw.getObject(RY.class);
//        ry.setRy_style(0);
        ry.setRy_sort(3);
        jw.request.setAttribute("RY", ry);
        return vr;
    }
}
