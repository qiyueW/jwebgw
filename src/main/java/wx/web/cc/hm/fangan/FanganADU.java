package wx.web.cc.hm.fangan;

import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.DBO;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import plugins.easyui.EasyuiService;
import system.web.power.session.Login;
import wx.web.base.bean.RY;
import wx.web.cc.bean.Fangan1;
import wx.web.cc.bean.Fangan2;
import wx.web.cc.service.FanganService;

@H("cc/fangan/adu")
public class FanganADU {

    JWeb jw;

    public FanganADU(JWeb jw) {
        this.jw = jw;
    }

    @system.web.power.ann.SQ("Y101_18_1A")
    @M("/a/add")
    @Validate(wx.web.cc.hm.fangan.validate.FanganValidate.class)
    public void add() {
        Fangan1 obj = jw.getObject(Fangan1.class);
        if (DBO.service.S.selectCountByCondition(Fangan1.class, "WHERE fangan1_mc='" + obj.getFangan1_mc() + "'") > 0) {
            jw.printOne(DBO.getJSONModel("0", "添加异常：方案重名"));
            return;
        }
        int px = DBO.service.S.selectCountByCondition(Fangan1.class, "WHERE fanganfl_id='" + obj.getFanganfl_id() + "'");
        obj.setFangan1_px(px);
        
        Date date = new Date();
        obj.setFangan1_shenpishijian(date);//假设审批时间 预留功能
        obj.setFangan1_zhidanshijian(date);//制定单
        obj.setFangan1_zt("0");//锁定状
        //从会话中获取人员信息
        RY ry = Login.getUserInfo(RY.class, jw);
        obj.setRy_id(ry.getRy_id());
        obj.setRy_name(ry.getRy_name());
        
        List<Fangan2> obj2 = (List<Fangan2>) jw.request.getAttribute("obj2");
        int[] i = DBO.service.A.add_OM(obj, obj2);
        DBO.out_add_1_0_f1(jw, null == i ? -1 : i[0]);
    }

    @system.web.power.ann.SQ("Y101_18_1A")
    @M("/a/add/select2OneByJson")//一对多。通过表头主键，查询体表
    public static void selectOne2(JWeb jw) {
        String fangan_zj = jw.getString("fangan_zj");
        if (null == fangan_zj || fangan_zj.isEmpty()) {
            List<Fangan2> obj2 = new ArrayList();
            Fangan2 o = new Fangan2();
            o.setCmodel_zj("");
            o.setCmodel_mc("");
            o.setFangan2_bz("");
            o.setFangan2_filename("");
            o.setFangan2_filepath("");
            for (int i = 0; i < 20; i++) {
                obj2.add(o);
            }
            jw.printOne(EasyuiService.formatGrid(obj2));//添加时，默认空白。除非复制其他的模板。
            return;
        }
        jw.printOne(EasyuiService.formatGrid(FanganService.getBody(fangan_zj)));
    }

    @system.web.power.ann.SQ("Y101_18_1D")
    @M("/d/dellOM")//删除表头，同时删除表体
    public void dellVast() {
        int i = DBO.service.D.ooDelete(jw.getString("ids"), Fangan1.class, Fangan2.class);
        DBO.out_dell_1_0_f1(jw, i);
    }

    @system.web.power.ann.SQ("Y101_18_1U")
    @M("/u/update")
    @Validate(wx.web.cc.hm.fangan.validate.FanganValidate.class)
    public void update() {
        Fangan1 obj = jw.getObject(Fangan1.class);
        if (null == obj.getFangan1_zj() || obj.getFangan1_zj().length() != 24) {
            jw.printOne(DBO.getJSONModel("0", "保存异常：主键丢失"));
            return;
        }
        if (DBO.service.S.selectCountByCondition(Fangan1.class, "WHERE fangan1_zj<>'" + obj.getFangan1_zj() + "' AND  fangan1_mc='" + obj.getFangan1_mc() + "'") > 0) {
            jw.printOne(DBO.getJSONModel("0", "保存异常：同个分类下，预方案重名"));
            return;
        }
        List<Fangan2> obj2 = (List<Fangan2>) jw.request.getAttribute("obj2");
        for (Fangan2 o2 : obj2) {
            o2.setFangan1_zj(obj.getFangan1_zj());//锁定表头主键
        }
        int[] i = DBO.service.ADUS.executeBatch(
                DBO.service.SQL.updateSome_reject(obj, "fangan1_px")//修改表头的数据,排序字段不进行修改
                ,
                 DBO.service.SQL.dellByCondition(Fangan2.class, "WHERE fangan1_zj='" + obj.getFangan1_zj() + "'")//清空旧表体的值
                ,
                 DBO.service.SQL.addVast(obj2)//加入新表体的值
        );
        DBO.out_update_1_0_f1(jw, null == i ? -1 : i[0]);
    }

    @system.web.power.ann.SQ("Y101_18_1U")
    @M("/u/update/saveMove")
    public void updateMove() {
        String ids = jw.getString("ids");
        if (null == ids || ids.isEmpty()) {
            return;
        }
        int[] i = FanganService.topx(ids.split(","));
        DBO.out_update_1_0_f1(jw, null == i ? -1 : i[0]);
    }

    @system.web.power.ann.SQ("Y101_18_1U")
    @M("/u/update/select")
    public void updateSelect_UseFilter_CheckUpdateSelect() {
        jw.request.setAttribute("obj", DBO.service.S.selectOneByCondition(Fangan1.class, "WHERE fangan1_zj='" + jw.getString("selectUpdateID") + "'"));
        jw.forward("/cc/fangan/fangan_U.jsp");
    }
}
