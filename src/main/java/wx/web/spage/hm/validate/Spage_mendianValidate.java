package wx.web.spage.hm.validate;

import java.util.Map;
import system.base.regex.Regex;

import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;

public class Spage_mendianValidate extends ValidateModel {

    public Spage_mendianValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super.put("spage_mendian_zj", "[0-9]{24}", "主键丢失", false)
                .put("spage_mendian_jiancheng", "[\\w\\W]{1,200}", "门店简称不能为空", true)
                .put("spage_mendian_quancheng", "[\\w\\W]{1,500}", "门店地址不能为空", true)
                .put("diliquyu_id", "[0-9]{24}", "区域主键丢失，请重新选择区域", true)
                .put("diliquyu_name", "[\\w\\W]{1,50}", "-", false)
                .put("spage_mendian_neirong", "[\\w\\W]+", "请具体描述下门店", true)
                .put("spage_mendian_neirong2", "[\\w\\W]+", "请具体描述下门店(内审)", true)
                .put("spage_mendian_feiyong", Regex.NUMBER_DECIMAL_L+"{1,11}", "门店费用-内部审批用超11长度", false)
                ;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }
}
