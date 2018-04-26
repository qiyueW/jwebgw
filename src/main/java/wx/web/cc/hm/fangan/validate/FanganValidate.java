package wx.web.cc.hm.fangan.validate;

import java.util.List;
import java.util.Map;
import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;
import wx.web.cc.bean.Fangan2;
import wx.web.cc.service.CModelService;

public class FanganValidate extends ValidateModel {

    public FanganValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {

        super.
                put("fangan1_zj", "[1-9]{1}[0-9]{23}", "主键丢失", false)//主键
                .put("fanganfl_id", "[1-9]{1}[0-9]{23}", "分类外键丢失", true)//分类外键
                .put("fanganfl_name", "[\\w\\W]{1,50}", "分类：为空或文本过长", true)//方案分类

                .put("fangan1_mc", "[\\w\\W]{1,50}", "方案名为空或文本过长", true)//方案名
                .put("fangan1_bz", "[\\w\\W]{1,50}", "备注 文本过长", false)//备注
                .put("fangan1_zt", "[0|1|2|3]{1}", ":状态异常", true)//状态
                .put("fangan2", "[\\w\\W]{1,5000}", "表体数据异常", false)//表体json数据。
                ;
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        if (isEmpty(jw.getString("fangan2"))) {
            vr.put("fangan2", "表体异常。请注意 路径 文件 方案 都为必填项");
            return vr;
        }

        List<Fangan2> list = jw.getListBySimpleJsonData(Fangan2.class, "fangan2");
        Map<String, String> cmm = CModelService.getCModelAnd_McMapZj();

        for (Fangan2 obj : list) {
            if (isEmpty(obj.getCmodel_mc()) || isEmpty(obj.getFangan2_filename()) || isEmpty(obj.getFangan2_filepath())) {
                vr.put("fangan2", "表体异常。请注意 路径 文件 方案 都为必填项");
                return vr;
            } else if (null == cmm.get(obj.getCmodel_mc())) {
                vr.put("fangan2", "表体异常。没找到关联的方案(" + obj.getCmodel_mc() + ")");
                return vr;
            }
            obj.setCmodel_zj(cmm.get(obj.getCmodel_mc()));//设置方案主键
        }
        jw.set("obj2", list);
        return vr;
    }

    private boolean isEmpty(String str) {
        return null == str || str.isEmpty();
    }
}
