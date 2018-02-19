package power.hm.role.validate;

import java.util.Map;
import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;

//@system.base.annotation.Validate(power.hm.validate.RoleValidate.class)
public class RoleValidate extends ValidateModel {
     public RoleValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {

		super
			.put("role_id", "[1-9]{1}[0-9]{23}", "主键丢失", false)
			.put("jsdj_zj", "[1-9]{1}[0-9]{23}", "外键不能为空", true)
			.put("role_name","[\\w\\W]{1,50}", "角色名称过长或不符合", true)
			.put("role_info","[\\w\\W]{0,50}", "备注超50字", false);   
 }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }
}