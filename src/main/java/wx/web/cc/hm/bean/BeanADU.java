package wx.web.cc.hm.bean;

import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.DBO;
import java.util.ArrayList;
import java.util.List;
import plugins.easyui.EasyuiService;
import wx.web.cc.bean.Bean;
import wx.web.cc.bean.Bean2;
import wx.web.cc.service.BeanService;

@H("cc/bean/adu")
public class BeanADU {

    JWeb jw;

    public BeanADU(JWeb jw) {
        this.jw = jw;
    }

    @system.web.power.ann.SQ("Y101_5")
    @M("/a/add")
    @Validate(wx.web.cc.hm.bean.validate.BeanValidate.class)
    public void add() {
        Bean obj = jw.getObject(Bean.class);
        if (DBO.service.S.selectCountByCondition(Bean.class, "WHERE mypackage_id='" + obj.getMypackage_id() + "' AND bean_mc='" + obj.getBean_mc() + "'") > 0) {
            jw.printOne(DBO.getJSONModel("0", "添加异常：同个分类下，预方案重名"));
            return;
        }
        int px = DBO.service.S.selectCountByCondition(Bean.class, "WHERE mypackage_id='" + obj.getMypackage_id() + "'");
        obj.setBean_px(px);
        List<Bean2> obj2 = (List<Bean2>) jw.request.getAttribute("obj2");
        int[] i = DBO.service.A.add_OM(obj, obj2);
        DBO.out_add_1_0_f1(jw, null == i ? -1 : i[0]);
    }

    @M("/a/add/select2OneByJson")//一对多。通过表头主键，查询体表
    public static void selectOne2(JWeb jw) {
        String bean_zj = jw.getString("bean_zj");
        if (null == bean_zj || bean_zj.isEmpty()) {
            List<Bean2> obj2 = new ArrayList();
            Bean2 o = new Bean2();
            o.setBean2_bz("");
            o.setBean2_key("");
            o.setBean2_zj("");
            o.setBean_zj("");
            for (int i = 0; i < 20; i++) {
                obj2.add(o);
            }
            jw.printOne(EasyuiService.formatGrid(obj2));//添加时，默认空白。除非复制其他的模板。
            return;
        }
        jw.printOne(EasyuiService.formatGrid(BeanService.getBody(bean_zj)));
    }

    @system.web.power.ann.SQ("Y101_6_3")
    @M("/d/dellOM")//删除表头，同时删除表体
    public void dellVast() {
        int i = DBO.service.D.ooDelete(jw.getString("ids"), Bean.class, Bean2.class);
        DBO.out_dell_1_0_f1(jw, i);
    }

    @system.web.power.ann.SQ("Y101_6_2")
    @M("/u/update")
    @Validate(wx.web.cc.hm.bean.validate.BeanValidate.class)
    public void update() {
        Bean obj = jw.getObject(Bean.class);
        if (null == obj.getBean_zj() || obj.getBean_zj().length() != 24) {
            jw.printOne(DBO.getJSONModel("0", "保存异常：主键丢失"));
            return;
        }
        if (DBO.service.S.selectCountByCondition(Bean.class, "WHERE bean_zj<>'" + obj.getBean_zj() + "' AND mypackage_id='" + obj.getMypackage_id() + "' AND bean_mc='" + obj.getBean_mc() + "'") > 0) {
            jw.printOne(DBO.getJSONModel("0", "保存异常：同个分类下，预方案重名"));
            return;
        }
        List<Bean2> obj2 = (List<Bean2>) jw.request.getAttribute("obj2");
        for (Bean2 o2 : obj2) {
            o2.setBean_zj(obj.getBean_zj());//锁定表头主键
        }
        int[] i = DBO.service.ADUS.executeBatch(
                DBO.service.SQL.updateSome_reject(obj, "bean_px")//修改表头的数据,排序字段不进行修改
                ,
                 DBO.service.SQL.dellByCondition(Bean2.class, "WHERE bean_zj='" + obj.getBean_zj() + "'")//清空旧表体的值
                ,
                 DBO.service.SQL.addVast(obj2)//加入新表体的值
        );
        DBO.out_update_1_0_f1(jw, null == i ? -1 : i[0]);
    }

    @system.web.power.ann.SQ("Y101_6_2")
    @M("/u/update/saveMove")
    public void updateMove() {
        String ids = jw.getString("ids");
        if (null == ids || ids.isEmpty()) {
            return;
        }
        int[] i = BeanService.topx(ids.split(","));
        DBO.out_update_1_0_f1(jw, null == i ? -1 : i[0]);
    }

    @system.web.power.ann.SQ("Y101_6_2")
    @M("/u/update/select")
    public void updateSelect_UseFilter_CheckUpdateSelect() {
        jw.request.setAttribute("obj", DBO.service.S.selectOneByCondition(Bean.class, "WHERE bean_zj='" + jw.getString("selectUpdateID") + "'"));
        jw.forward("/cc/bean/bean_U.jsp");
    }
}
