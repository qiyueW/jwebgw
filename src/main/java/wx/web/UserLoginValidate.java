package wx.web;

import java.util.Map;

import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;

public class UserLoginValidate extends ValidateModel {
    // "{\"statusCode\":\"99\",\"msg\":#}"
    public UserLoginValidate() {
        super(JSON_MODEL);
    }

    
    @Override
    public void iniValidate() {
        super
                .put("account", "[a-zA-Z0-9]{1,12}", "账号只能用数字与字母组成。并且不能超出12位", true)
                .put("passord", "[a-zA-Z0-9]{1,16}", "密码只能用数字与字母组成。并且不能超出16位", true);
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        //上面的校验通过后，都才进行复检
        //当vr里有值时，默认不通过复检。（传参来的vr对象是干净的。）
        return vr;
    }
}
