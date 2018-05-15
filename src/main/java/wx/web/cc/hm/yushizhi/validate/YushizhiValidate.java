package wx.web.cc.hm.yushizhi.validate;

import java.util.List;
import java.util.Map;
import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;
import wx.web.cc.bean.Yushizhi2;

public class YushizhiValidate extends ValidateModel {

    public YushizhiValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {

        super.put("yushizhi_zj", "[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("yushizhi_mc", "[\\w\\W]{1,200}", "文本过长", true)//名称
                .put("yushizhifl_id", "[1-9]{1}[0-9]{23}", "分类外键丢失", true)//分类外键
                .put("yushizhifl_name", "[\\w\\W]{1,50}", "分类名：为空或文本过长", true)//分类名
                .put("yushizhi_bz", "[\\w\\W]{1,200}", "备注：文本过长", false)//备注
                .put("yushizhi2", "[\\w\\W]+", "表体数据异常", true)//表体json数据。
                ;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        List<Yushizhi2> list = jw.getListBySimpleJsonData(Yushizhi2.class, "yushizhi2");
        for (Yushizhi2 obj : list) {
            if (null == obj.getYushizhi2_key() || obj.getYushizhi2_key().isEmpty()) {
                vr.put("yushizhi2", "表体的key不能为空");
                System.err.println(jw.getString("yushizhi2"));
                return vr;
            }
        }
        jw.set("obj2", list);
        return vr;
    }
}
