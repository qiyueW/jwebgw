package wx.web.cc.hm._validate;

import com.alibaba.fastjson.JSON;
import java.util.List;
import java.util.Map;
import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;
import wx.web.cc.bean.BeanField2;

public class BeanFieldValidate extends ValidateModel {

    public BeanFieldValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {

        super.put("beanfield_zj", "[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("beanfield_mc", "[\\w\\W]{1,200}", "字段：为空或文本过长", true)//名称
                .put("bean_zj", "[1-9]{1}[0-9]{23}", "bean主键丢失", true)//分类外键
                //                .put("bean_mc", "[\\w\\W]{1,50}", "分类名：为空或文本过长", true)//分类名
                .put("beanfield_bz", "[\\w\\W]{1,200}", "备注：文本过长", false)//备注
                .put("beanfield2", "[\\w\\W]{1,5000}", "表体数据异常", false)//表体json数据。
                ;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {

        String data = jw.getString("beanfield2");
        if (null == data || data.isEmpty()) {
            return vr.put("beanfield2", "表体数据异常");
        }
        List<BeanField2> list = JSON.parseArray(data.replace("&#34;", "\"").replace("&#92;", "\\"), BeanField2.class);//jw.getListBySimpleJsonData(Bean2.class, "bean2");.replace("&#34;", "\"")
        for (BeanField2 obj : list) {
            if (null == obj.getBeanfield2_key() || obj.getBeanfield2_key().isEmpty()) {
                vr.put("beanfield2", "表体的key不能为空");
                return vr;
            }
        }
        jw.set("obj2", list);
        return vr;
    }
}
