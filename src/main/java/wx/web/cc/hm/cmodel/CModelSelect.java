package wx.web.cc.hm.cmodel;

import configuration.DBO;
import java.util.List;
import plugins.easyui.EasyuiService;
import plugins.easyui.vo.EasyuiPage;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.beanjson.JCJSON;
import wx.web.cc.bean.CModel;
import wx.web.cc.bean.Mybean;
import wx.web.cc.bean.Mybeanfield;
import wx.web.cc.service.MybeanService;

@H("cc/cmodal/s")
public class CModelSelect {

    @M("/selectOne")
    public static void selectOne(JWeb jw) {
        String cmodel_zj = jw.getString("cmodel_zj");
        if (null == cmodel_zj || cmodel_zj.isEmpty()) {
            jw.printOne("{}");
            return;
        }
        CModel obj = DBO.service.S.selectOneByID(CModel.class, cmodel_zj);
        obj.setCmodel_nr(obj.getCmodel_nr().replace("'", "&#39;").replace("\r", "&#39;n"));
        jw.printOne(JCJSON.toSimpleJSON(obj));
    }

    @M("/selectOne2")
    public static void selectOne2(JWeb jw) {
        String cmodel_zj = jw.getString("cmodel_zj");
        if (null == cmodel_zj || cmodel_zj.isEmpty()) {
            jw.printOne("{}");
            return;
        }
        CModel obj = DBO.service.S.selectOneByID(CModel.class, cmodel_zj);
        obj.setCmodel_nr(obj.getCmodel_nr().replace("'", "&#39;").replace("\r", "&#39;n"));
        jw.printOne(obj.getCmodel_nr());
    }
    
    @M("/selectAllByJson")
    public static void selectJSON(JWeb jw) {

        EasyuiPage page = EasyuiService.getPage(jw);

        List<CModel> list = DBO.service.S.selectVast(CModel.class, page.page, page.rows);
        for (CModel obj : list) {
            obj.setCmodel_nr("");
        }
        jw.printOne(EasyuiService.formatGrid(list));
    }

    @M("/base/selectVast") // cc/mybean/modal/s/selectVast.jw
    public static void select(JWeb jw) {
        String mybean_zj = jw.getString("mybean_zj");
        if (null == mybean_zj || mybean_zj.isEmpty()) {
            jw.printOne("[]");
            return;
        }
        Mybean bean = DBO.service.S.selectOneByID(Mybean.class, mybean_zj);
        if (null == bean.getMybean_zj()) {
            jw.printOne("[]");
            return;
        }

        String sort = jw.getString("sort", "bean");
        String where = "WHERE mybean_zj='" + mybean_zj + "'";
        List<Mybeanfield> listBF = DBO.service.S.selectByCondition(Mybeanfield.class, where);
        switch (sort) {
            case "bean": {
                jw.printOne(MybeanService.toBeanData(listBF, bean.getMybean_mc()));
                return;
            }
            case "sql": {
                jw.printOne(MybeanService.toSQLData(listBF, bean.getMybean_mc()));
                return;
            }
            case "jsgetset": {
                String js = MybeanService.toJSGet(listBF, bean.getMybean_mc());
                js = js + "\n\n" + MybeanService.toJSSet(listBF, bean.getMybean_mc());
                jw.printOne(js);
            }
        }

    }

}
