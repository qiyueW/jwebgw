package wx.web.cc.hm.mybean.validate;

import java.util.Map;
import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;

public class MybeanValidate extends ValidateModel {
     public MybeanValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {

		super
			.put("mybean_zj", "[1-9]{1}[0-9]{23}", "主键丢失", false)
			.put("mypackage_id", "[1-9]{1}[0-9]{23}", "包不能为空", true)
			.put("mybean_mc", "[\\w\\W]{1,50}", "名称过长", true)
			.put("mybean_bz", "[\\w\\W]{0,100}", "备注过长", false)
			.put("mybean_px", "[0-9]{0,3}", "排队编号应为3位数内的整数", true);
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }
}