package wx.web.cc.hm.bean.validate;


import java.util.List;
import java.util.Map;
import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;
import wx.web.cc.bean.Bean2;

public class BeanValidate extends ValidateModel {

    public BeanValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {

        super.put("bean_zj", "[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("bean_mc", "[\\w\\W]{1,200}", "文本过长", true)//名称
                .put("mypackage_id", "[1-9]{1}[0-9]{23}", "分类外键丢失", true)//分类外键
                .put("mypackage_name", "[\\w\\W]{1,50}", "分类名：为空或文本过长", true)//分类名
                .put("bean_bz", "[\\w\\W]{1,200}", "备注：文本过长", false)//备注
                .put("bean2", "[\\w\\W]{1,5000}", "表体数据异常", false)//表体json数据。
                ;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        List<Bean2> list = jw.getListBySimpleJsonData(Bean2.class, "bean2");
        for (Bean2 obj : list) {
            if (null == obj.getBean2_key() || obj.getBean2_key().isEmpty()) {
                vr.put("bean2", "表体的key不能为空");
                return vr;
            }
        }
        jw.set("obj2", list);
        return vr;
    }
}
