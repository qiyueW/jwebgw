package wx.web.cc.hm._validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class CModelValidate extends ValidateModel {

    public CModelValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super.put("cmodel_zj", "[0-9]{24}", "主键", false)
                .put("cmodel_mc", "[\\w\\W]{1,50}", "模型名不正常", true)
                .put("cmodel_nr", "[\\w\\W]+", "模型内容不能为空", true);
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}
