package wx.web.cc.hm.model;

//import plugins.ligerui.LigeruiKey;
//import plugins.ligerui.LigeruiService;
//import plugins.ligerui.vo.LigerUIPage;
import configuration.DBO;
import java.util.List;
import plugins.easyui.EasyuiService;
import plugins.easyui.vo.EasyuiPage;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.beanjson.JCJSON;
import wx.web.cc.bean.MyModel;
import wx.web.cc.bean.Mybean;
import wx.web.cc.bean.Mybeanfield;
import wx.web.cc.service.MybeanService;
//import static configuration.DBO.service;
//import wx.web.cc.bean.Mybean;

@H("cc/mybean/modal/s")
public class MyModelSelect {

    @M("/selectOne")
    public static void selectOne(JWeb jw) {
        String mymodel_zj = jw.getString("mymodel_zj");
        if (null == mymodel_zj || mymodel_zj.isEmpty()) {
            jw.printOne("[]");
            return;
        }
        jw.printOne(JCJSON.toSimpleJSON(DBO.service.S.selectOneByID(MyModel.class, mymodel_zj)));
    }

//    @M("/selectAllByTree")
//    public static void selectJSONByTree(JWeb jw) {
//        String mybean_zj = jw.getString("mybean_zj");
//        if (null == mybean_zj || mybean_zj.isEmpty()) {
//            jw.printOne("[]");
//            return;
//        }
//        List<MyModel> list = DBO.service.S.selectByCondition(MyModel.class, "WHERE mybean_zj='" + mybean_zj + "'");
//        for (MyModel obj : list) {
//            obj.setMymodel_nr("");
//        }
//        //代码生成器不考虑性能。
//        jw.printOne(JCJSON.toSimpleJSON(list));
//    }

    @M("/selectAllByJson")
    public static void selectJSON(JWeb jw) {
        String mybean_zj = jw.getString("mybean_zj");
        if (null == mybean_zj || mybean_zj.isEmpty()) {
            jw.printOne("[]");
            return;
        }
        String where = "WHERE mybean_zj='" + mybean_zj + "'";
        EasyuiPage page = EasyuiService.getPage(jw);

        List<MyModel> list = DBO.service.S.selectVastByCondition(MyModel.class, page.page, page.rows, where);
        for (MyModel obj : list) {
            obj.setMymodel_nr("");
        }
        jw.printOne(EasyuiService.formatGrid(list, DBO.service.S.selectCountByCondition(MyModel.class, where)));
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
