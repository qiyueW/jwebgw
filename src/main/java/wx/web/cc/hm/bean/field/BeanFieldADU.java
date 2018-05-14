package wx.web.cc.hm.bean.field;

import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.DBO;
import java.util.ArrayList;
import java.util.List;
import plugins.easyui.EasyuiService;
import wx.web.cc.bean.BeanField;
import wx.web.cc.bean.BeanField2;
import wx.web.cc.service.BeanFieldService;
import wx.web.cc.service.BeanService;
import wx.web.cc.service.svo.BeanFieldSVO;
import wx.web.cc.service.svo.BeanSVO;

@H("cc/bean/field/adu")
public class BeanFieldADU {

    JWeb jw;

    public BeanFieldADU(JWeb jw) {
        this.jw = jw;
    }

    @system.web.power.ann.SQ("Y101_7")
    @M("/a/add")
    @Validate(wx.web.cc.hm._validate.BeanFieldValidate.class)
    public void add() {
        BeanField obj = jw.getObject(BeanField.class);
        if (DBO.service.S.selectCountByCondition(BeanField.class, "WHERE bean_zj='" + obj.getBean_zj() + "' AND beanfield_mc='" + obj.getBeanfield_mc() + "'") > 0) {
            jw.printOne(DBO.getJSONModel("0", "添加异常：同个类下，属性重名"));
            return;
        }
        BeanSVO svo = BeanSVO.selectByBeanID(obj.getBean_zj());
        if (null == svo) {
            jw.printOne(DBO.getJSONModel("-1", "添加异常：没找到关联的bean"));
            return;
        }
        int px = DBO.service.S.selectCountByCondition(BeanField.class, "WHERE bean_zj='" + obj.getBean_zj() + "'");
        obj.setBeanfield_px(px);
        obj.setBean_mc(svo.bean.getBean_mc());
        List<BeanField2> obj2 = (List<BeanField2>) jw.request.getAttribute("obj2");
        BeanFieldSVO esvo = BeanFieldService.engineToAdd(svo, obj, obj2); //对obj与obj2进行行自我翻译1
        esvo = BeanFieldService.engineToAdd(svo, esvo.beanField, esvo.beanField2List); //对obj与obj2进行行自我翻译2
        esvo = BeanFieldService.engineToAdd(svo, esvo.beanField, esvo.beanField2List); //对obj与obj2进行行自我翻译3

        int[] i = DBO.service.A.add_OM(esvo.beanField, esvo.beanField2List);
        DBO.out_add_1_0_f1(jw, null == i ? -1 : i[0]);
    }

    @system.web.power.ann.SQ("Y101_7")
    @M("/a/add/select2OneByJson")//一对多。通过表头主键，查询体表
    public static void selectOne2(JWeb jw) {
        String bean_zj = jw.getString("beanfield_zj");
        if (null == bean_zj || bean_zj.isEmpty()) {
            List<BeanField2> obj2 = new ArrayList();
            BeanField2 o = new BeanField2();
            o.setBeanfield2_bz("");
            o.setBeanfield2_key("");
            o.setBeanfield2_zj("");
            o.setBeanfield_zj("");
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
        int i = DBO.service.D.ooDelete(jw.getString("ids"), BeanField.class, BeanField2.class);
        DBO.out_dell_1_0_f1(jw, i);
    }

    @system.web.power.ann.SQ("Y101_8_3")
    @M("/u/update")
    @Validate(wx.web.cc.hm._validate.BeanFieldValidate.class)
    public void update() {
        BeanField obj = jw.getObject(BeanField.class);
        if (null == obj.getBeanfield_zj() || obj.getBeanfield_zj().length() != 24) {
            jw.printOne(DBO.getJSONModel("0", "保存异常：主键丢失"));
            return;
        }
        if (DBO.service.S.selectCountByCondition(BeanField.class, "WHERE beanfield_zj<>'" + obj.getBeanfield_zj() + "' AND bean_zj='" + obj.getBean_zj() + "' AND beanfield_mc='" + obj.getBeanfield_mc() + "'") > 0) {
            jw.printOne(DBO.getJSONModel("0", "保存异常：同个类下，属性重名"));
            return;
        }
        List<BeanField2> obj2 = (List<BeanField2>) jw.request.getAttribute("obj2");
        for (BeanField2 o2 : obj2) {
            o2.setBeanfield_zj(obj.getBeanfield_zj());//锁定表头主键
        }
        int[] i = DBO.service.ADUS.executeBatch(
                DBO.service.SQL.updateSome_reject(obj, "beanfield_px")//修改表头的数据,排序字段不进行修改
                ,
                 DBO.service.SQL.dellByCondition(BeanField2.class, "WHERE beanfield_zj='" + obj.getBeanfield_zj() + "'")//清空旧表体的值
                ,
                 DBO.service.SQL.addVast(obj2)//加入新表体的值
        );
        DBO.out_update_1_0_f1(jw, null == i ? -1 : i[0]);
    }

    @system.web.power.ann.SQ("Y101_8_2")
    @M("/u/update/saveMove")
    public void updateMove() {
        String ids = jw.getString("ids");
        if (null == ids || ids.isEmpty()) {
            return;
        }
        int[] i = BeanFieldService.topx(ids.split(","));
        DBO.out_update_1_0_f1(jw, null == i ? -1 : i[0]);
    }

    @system.web.power.ann.SQ("Y101_8_2")
    @M("/u/update/select")
    public void updateSelect_UseFilter_CheckUpdateSelect() {
        jw.request.setAttribute("obj", DBO.service.S.selectOneByCondition(BeanField.class, "WHERE beanfield_zj='" + jw.getString("selectUpdateID") + "'"));
        jw.forward("/cc/bean/beanfield/beanfield_U.jsp");
    }
}
