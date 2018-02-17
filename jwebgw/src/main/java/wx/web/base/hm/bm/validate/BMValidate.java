package wx.web.base.hm.bm.validate;

import java.util.Map;
import system.web.validate.model.ValidateResultModel;
import system.web.validate.model.ValidateFieldModel;
import system.web.JWeb;
import system.web.validate.model.ValidateModel;

public class BMValidate extends ValidateModel {

    public BMValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super.put("bm_id", "[0-9]{24}", "", false)
                .put("bm_pid", "[0-9]{24}|[0]{1}", "父键不正常", false)
                .put("bm_name", "[\\w\\W]{1,50}", "名称不正常", true);
    }

    /**
     * 校验失败
     *
     * @param jw
     * @param vr
     */
    @Override
    public void error(JWeb jw, ValidateResultModel vr) {
        if (returnJSON) {
            jw.printOne(vr.getMsgByJson());
            return;
        }
        jw.request.setAttribute(msg_key, vr.getMsgByMap());
        jw.forward(url);
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }

}
