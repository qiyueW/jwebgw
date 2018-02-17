package power.hm.adminuser.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
//@system.base.annotation.Validate(power.hm.validate.AdminUserValidate.class)

public class AdminUserValidate extends ValidateModel {

    public AdminUserValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {

        super
                .put("user_id", "[1-9]{1}[0-9]{23}", "主键丢失", false)
                .put("user_name", "[\\w\\W]{1,50}", "用户名称过长或不符合", true)
//                .put("bm_id", "(,{0,1}[1-9]{1}[0-9]{23})+", "部门主键丢失", false)
//                .put("bm_name", "[\\w\\W]{1,50000}", "部门异常或超50字符", false)
                .put("user_account", "[\\w\\W]{1,50}", "用户账号过长或不符合要求", true)
                .put("user_password", "[\\w\\W]{1,50}", "用户密码过长或不符合要求", true)
                .put("user_email", "[a-zA-Z0-9\\_]{1,27}@[a-zA-Z0-9]{1,5}\\.[a-zA-Z0-9]{1,6}", "邮箱格式或长度(50字内)有误", false)
                .put("power_id", "(,?[0-9a-zA-Z\\_]){0,5000}", "权限不正确或长度不对", false)
                .put("user_sort", "(管理员){1}", "请先登陆", true)
                .put("user_style", "(停用|启用){1}", "请先登陆", true);
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }
}
