package power.hm.adminuser.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
//@system.base.annotation.Validate(power.hm.validate.AdminUserValidate.class)

public class AdminUserValidate_U extends ValidateModel {

    public AdminUserValidate_U() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {

        super
                .put("user_id", "[1-9]{1}[0-9]{23}", "主键丢失", true)
                .put("user_name", "[\\w\\W]{1,50}", "用户名称过长或不符合", true)
                .put("user_password", "[\\w\\W]{1,50}", "用户密码过长或不符合要求", true)
//                .put("bm_id", "[1-9]{1}[0-9]{23}", "部门主键丢失", false)
//                .put("bm_name", "[\\w\\W]{1,50}", "部门异常或超50字符", false)
                .put("user_email", "[a-zA-Z0-9\\_]{1,27}@[a-zA-Z0-9]{1,5}\\.[a-zA-Z0-9]{1,6}", "邮箱格式或长度(50字内)有误", false);
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }
}
