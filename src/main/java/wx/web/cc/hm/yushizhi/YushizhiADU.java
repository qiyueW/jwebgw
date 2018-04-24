package wx.web.cc.hm.yushizhi;

import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.DBO;
import java.util.ArrayList;
import java.util.List;
import plugins.easyui.EasyuiService;
import wx.web.cc.bean.Yushizhi;
import wx.web.cc.bean.Yushizhi2;
import wx.web.cc.hm.yushizhi.service.YushizhiService;

@H("cc/yushizhi/adu")
public class YushizhiADU {

    JWeb jw;

    public YushizhiADU(JWeb jw) {
        this.jw = jw;
    }

    @system.web.power.ann.SQ("Y101_17_1A")
    @M("/a/add")
    @Validate(wx.web.cc.hm.yushizhi.validate.YushizhiValidate.class)
    public void add() {
        Yushizhi obj = jw.getObject(Yushizhi.class);
        if (DBO.service.S.selectCountByCondition(Yushizhi.class, "WHERE yushizhifl_id='" + obj.getYushizhifl_id() + "' AND yushizhi_mc='" + obj.getYushizhi_mc() + "'") > 0) {
            jw.printOne(DBO.getJSONModel("0", "添加异常：同个分类下，预方案重名"));
            return;
        }
        List<Yushizhi2> obj2 = (List<Yushizhi2>) jw.request.getAttribute("obj2");
        int[] i = DBO.service.A.add_OM(obj, obj2);
        DBO.out_add_1_0_f1(jw, null == i ? -1 : i[0]);
    }

    @M("/a/add/select2OneByJson")//一对多。通过表头主键，查询体表
    public static void selectOne2(JWeb jw) {
        String yushizhi_zj = jw.getString("yushizhi_zj");
        if (null == yushizhi_zj || yushizhi_zj.isEmpty()) {
            List<Yushizhi2> obj2 = new ArrayList();
            Yushizhi2 o = new Yushizhi2();
            o.setYushizhi2_bz("");
            o.setYushizhi2_key("");
            o.setYushizhi2_zj("");
            o.setYushizhi_zj("");
            for (int i = 0; i < 20; i++) {
                obj2.add(o);
            }
            jw.printOne(EasyuiService.formatGrid(obj2));//添加时，默认空白。除非复制其他的模板。
            return;
        }
        jw.printOne(EasyuiService.formatGrid(YushizhiService.getBody(yushizhi_zj)));
    }

    @system.web.power.ann.SQ("Y101_17_1D")
    @M("/d/dellOM")//删除表头，同时删除表体
    public void dellVast() {
        int i = DBO.service.D.ooDelete(jw.getString("ids"), Yushizhi.class, Yushizhi2.class);
        DBO.out_dell_1_0_f1(jw, i);
    }

    @system.web.power.ann.SQ("Y101_17_1U")
    @M("/u/update")
    @Validate(wx.web.cc.hm.yushizhi.validate.YushizhiValidate.class)
    public void update() {
        Yushizhi obj = jw.getObject(Yushizhi.class);
        if (null == obj.getYushizhi_zj() || obj.getYushizhi_zj().length() != 24) {
            jw.printOne(DBO.getJSONModel("0", "保存异常：主键丢失"));
            return;
        }
        if (DBO.service.S.selectCountByCondition(Yushizhi.class, "WHERE yushizhi_zj<>'" + obj.getYushizhi_zj() + "' AND yushizhifl_id='" + obj.getYushizhifl_id() + "' AND yushizhi_mc='" + obj.getYushizhi_mc() + "'") > 0) {
            jw.printOne(DBO.getJSONModel("0", "保存异常：同个分类下，预方案重名"));
            return;
        }
        List<Yushizhi2> obj2 = (List<Yushizhi2>) jw.request.getAttribute("obj2");
        for (Yushizhi2 o2 : obj2) {
            o2.setYushizhi_zj(obj.getYushizhi_zj());//锁定表头主键
        }
        int[] i = DBO.service.ADUS.executeBatch(
                DBO.service.SQL.update_all(obj)//修改表头的数据
                ,
                 DBO.service.SQL.dellByCondition(Yushizhi2.class, "WHERE yushizhi_zj='" + obj.getYushizhi_zj() + "'")//清空旧表体的值
                ,
                 DBO.service.SQL.addVast(obj2)//加入新表体的值
        );
        DBO.out_update_1_0_f1(jw, null == i ? -1 : i[0]);
    }

    @system.web.power.ann.SQ("Y101_17_1U")
    @M("/u/update/select")
    public void updateSelect_UseFilter_CheckUpdateSelect() {
        jw.request.setAttribute("obj", DBO.service.S.selectOneByCondition(Yushizhi.class, "WHERE yushizhi_zj='" + jw.getString("selectUpdateID") + "'"));
        jw.forward("/cc/yushizhi/yushizhi_U.jsp");
    }
}
