package power.hm.role.validate;

import java.util.Map;
import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;

//@system.base.annotation.Validate(power.hm.validate.RoleValidate.class)
public class RolePowerValidate extends ValidateModel {
     public RolePowerValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {

		super
			.put("role_id", "(,?[1-9]{1}[0-9]{23})*", "主键丢失", true)
                        .put("power_id", "(,?[0-9a-zA-Z\\_.]){0,9000}", "角色权限格式或长度不对", true)
                        ;   //(,?[0-9a-zA-Z\\_.]){0,9000}
 }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }
}