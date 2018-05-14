package wx.web.cc.hm.cmodel;

import configuration.DBO;
import java.util.List;
import plugins.easyui.EasyuiService;
import plugins.easyui.vo.EasyuiPage;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.beanjson.JCJSON;
import system.web.power.ann.SQ;
import wx.web.cc.bean.CModel;
import wx.web.cc.service.CModelService;

@SQ("Y101_2_1")
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

    @M("/selectOne2")//用于维护界面，点击时，出现的行的模板的具体数据
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

    @M("/selectOne3")//用于维护界面，点击时，出现的行的模板的具体数据
    public static void selectOne3(JWeb jw) {
        String cmodel_zj = jw.getString("cmodel_zj");
        String bean_zj = jw.getString("bean_zj");

        if (null == cmodel_zj || cmodel_zj.isEmpty() || null == bean_zj || bean_zj.isEmpty()) {
            jw.printOne("");
            return;
        }
        jw.printOne(CModelService.getEngineData(cmodel_zj, bean_zj));

//        //bean相关信息
//        Bean bean = DBO.service.S.selectOneByID(Bean.class, bean_zj);
//        //bean属性相关信息
//        List<Mybeanfield> fields = DBO.service.S.selectByCondition(Mybeanfield.class, "WHERE bean_zj='" + bean_zj + "'");
//        //找到具体的模板
//        CModel obj = DBO.service.S.selectOneByID(CModel.class, cmodel_zj);
//        //执行模板数据绑定
//        jw.printOne(MybeanService.myVelocityEngine(obj.getCmodel_nr(), fields, bean));
    }

    @M("/selectAllByJson")
    public static void selectJSON(JWeb jw) {

        String fl = jw.getString("flzj");
        if (null == fl || fl.length() < 23) {
            jw.printOne(EasyuiService.formatGrid(null));
            return;
        }
        EasyuiPage page = EasyuiService.getPage(jw);

        String where = "WHERE cmodelfl_id IN('" + fl + "')";
        List<CModel> list = null == jw.getString("page") ? DBO.service.S.selectByCondition(CModel.class, where) : DBO.service.S.selectVastByCondition(CModel.class, page.page, page.rows, where);
        for (CModel obj : list) {
            obj.setCmodel_nr("");
        }
        jw.printOne(EasyuiService.formatGrid(list, DBO.service.S.selectCountByCondition(CModel.class, where)));
    }

    @M("/selectAllByJson2")//用作tree 生成select
    public static void selectJSON2(JWeb jw) {
        List<CModel> list = DBO.service.S.select(CModel.class);
        for (CModel obj : list) {
            obj.setCmodel_nr("");
        }
        jw.printOne(JCJSON.toSimpleJSON(list));
    }

}
