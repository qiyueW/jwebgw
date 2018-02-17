package wx.web.base.hm.tree.validate;

import java.util.Map;
import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;

public class JingyanKuFLValidate extends ValidateModel {
     public JingyanKuFLValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {

        super.put("jingyankufl_id", "[0-9]{24}", "", false)
                .put("jingyankufl_pid", "[0-9]{24}|[0]{1}", "父键不正常", false)
                .put("jingyankufl_name", "[\\w\\W]{1,50}", "名称不正常", true);    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }
}