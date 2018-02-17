package power.hm.jsdj.validate;

import java.util.Map;
import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;

//@system.base.annotation.Validate(power.hm.jsdj.validate.JSDJValidate.class)
public class JSDJValidate extends ValidateModel {

    public JSDJValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {

        super
                .put("jsdj_zj", "[1-9]{1}[0-9]{23}", "主键丢失", false)
                .put("jsdj_dm", "[0-9]{1,10}", "代码只能是正整数并且不超过10个字长", true)
                .put("jsdj_mc", "[\\w\\W]{1,50}", "名称过长", true);
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }
}
