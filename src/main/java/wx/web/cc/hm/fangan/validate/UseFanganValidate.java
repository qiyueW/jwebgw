package wx.web.cc.hm.fangan.validate;

import java.util.Map;
import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;

public class UseFanganValidate extends ValidateModel {

    public UseFanganValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {

        super.
                put("fangan1_zj", "[1-9]{1}[0-9]{23}", "方案异常：主键丢失", true)//主键
                .put("bean", "[1-9]{1}[0-9]{23}", "主bean异常：主键丢失", true)//bean
                .put("bean1", "[1-9]{1}[0-9]{23}", "辅bean1异常：主键不合法", false)//bean
                .put("bean2", "[1-9]{1}[0-9]{23}", "辅bean2异常：主键不合法", false)//bean
                .put("bean3", "[1-9]{1}[0-9]{23}", "辅bean3异常：主键不合法", false)//bean
                .put("bean4", "[1-9]{1}[0-9]{23}", "辅bean4异常：主键不合法", false)//bean
                .put("bean5", "[1-9]{1}[0-9]{23}", "辅bean5异常：主键不合法", false)//bean
                ;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }
}
