package wx.web.base.hm.ry.validate;

import java.util.Map;
import system.web.JWeb;
import system.web.validate.model.ValidateFieldModel;
import system.web.validate.model.ValidateModel;
import system.web.validate.model.ValidateResultModel;
import wx.web.base.bean.RY;

//@system.base.annotation.Validate(wx.web.hm.validate.RYValidate.class)
public class RYXXValidate extends ValidateModel {

    public RYXXValidate() {
        super(JSON_MODEL);
    }

    @Override
    public void iniValidate() {

        super
                .put("ry_id", "[1-9]{1}[0-9]{23}", "主键丢失", false)
                .put("ry_name", "[\\w\\W]{1,50}", "人员名格式或长度(50字内)有误", true)
                .put("bm_id", "[1-9]{1}[0-9]{23}", "部门主键丢失", true)
                .put("bm_name", "[\\w\\W]{1,50}", "部门名长度(1-50)或格式有误", true)
                .put("gw_id", "[1-9]{1}[0-9]{23}", "岗位主键丢失", false)
                .put("gw_name", "[\\w\\W]{1,50}", "岗位名长度(1-50)或格式有误", false)
                .put("rt1", "[\\w\\W]{1,50}", "K3(账号/密码)长度(50字内)有误", false)
                .put("rt2", "[\\w\\W]{1,50}", "远程(瑞友或其他）长度(50字内)有误", false)
                .put("rt3", "[\\w\\W]{1,50}", "企业QQ(账号/密码)长度(50字内)有误", false)
                .put("rt4", "[\\w\\W]{1,50}", "腾讯通(账号/密码)长度(50字内)有误", false)
                .put("rt5", "[\\w\\W]{1,50}", "Iwork长度(50字内)有误", false)
                .put("rt6", "[\\w\\W]{1,50}", "公司座机长度(50字内)有误", false)
                .put("ry_email", "[a-zA-Z0-9\\_]{1,24}@[a-zA-Z0-9]{1,14}\\.[a-zA-Z0-9]{1,10}", "邮箱格式或长度(50字内)有误", false)
                .put("rt8", "[\\w\\W]{1,50}", "其他8长度(50字内)有误", false)
                .put("rt9", "[\\w\\W]{1,50}", "其他9长度(50字内)有误", false)
                .put("rt10", "[\\w\\W]{1,50}", "其他10长度(50字内)有误", false)
                .put("rtbz", "[\\w\\W]{1,200}", "软件与通信备注过长", false)
                .put("dnlx", "[\\w\\W]{1,50}", "电脑类型长度应在50字内", false)
                .put("dnxh", "[\\w\\W]{1,50}", "电脑型号(品牌)长度应在50字内", false)
                .put("dnpz", "[\\w\\W]{1,50}", "电脑配置(cpu及内存)长度应在50字内", false)
                .put("bgnl", "[\\w\\W]{1,50}", "办公能力长度应在50字内", false)
                .put("dn1", "[\\w\\W]{1,50}", "电脑其他1长度应在50字内", false)
                .put("dn2", "[\\w\\W]{1,50}", "电脑其他2长度应在50字内", false)
                .put("dn3", "[\\w\\W]{1,50}", "电脑其他3长度应在50字内", false)
                .put("dn4", "[\\w\\W]{1,50}", "电脑其他4长度应在50字内", false)
                .put("yxip", "[\\w\\W]{1,50}", "有线IP长度应在50字内", false)
                .put("yxmac", "[\\w\\W]{1,50}", "有线网卡MAC长度应在50字内", false)
                .put("wxip", "[\\w\\W]{1,50}", "无线IP长度应在50字内", false)
                .put("wxmac", "[\\w\\W]{1,50}", "无线网卡MAC长度应在50字内", false)
                .put("dnbz", "[\\w\\W]{1,200}", "电脑备注过长", false);
    }

    @Override
    public ValidateResultModel recheck(JWeb jw, Map<String, ValidateFieldModel> map, ValidateResultModel vr) {
        RY ry = jw.getObject(RY.class);
        ry.setRy_style(0);
        ry.setRy_sort(3);
        jw.request.setAttribute("RY", ry);
        return vr;
    }
}
