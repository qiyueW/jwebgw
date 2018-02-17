package wx.web.spage.hm.validate;

import java.util.Map;

import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;

public class Spage_jingyankuValidate extends ValidateModel {

    public Spage_jingyankuValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {
        super.put("spage_jingyanku_zj", "[0-9]{24}", "主键丢失", false)
                .put("spage_jingyanku_biaoti", "[\\w\\W]{1,200}", "标题不能为空", true)
                .put("spage_jingyanku_gjc", "[\\w\\W]{1,500}", "关键词不能为空", true)
                .put("jingyankufl_id", "[0-9]{24}", "分类归档主键丢失，请重新选择分类", false)
                .put("jingyankufl_name", "[\\w\\W]{1,50}", "-", true)
                .put("spage_jingyanku_neirong", "[\\w\\W]+", "请具体描述下问题", true);
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        return vr;
    }
}
