package wx.web.cc.hm.model;

import configuration.DBO;
import java.util.List;
import plugins.easyui.EasyuiService;
import plugins.easyui.vo.EasyuiPage;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.beanjson.JCJSON;
import system.web.power.ann.SQ;
import wx.web.cc.bean.MyModel;

@SQ("Y101_10_1")
@H("cc/mybean/modal/s")
public class MyModelSelect {

    @M("/selectOne")
    public static void selectOne(JWeb jw) {
        String mymodel_zj = jw.getString("mymodel_zj");
        if (null == mymodel_zj || mymodel_zj.isEmpty()) {
            jw.printOne("{}");
            return;
        }
        MyModel obj = DBO.service.S.selectOneByID(MyModel.class, mymodel_zj);
        obj.setMymodel_nr(obj.getMymodel_nr().replace("'", "&#39;").replace("\r", "&#39;n"));
        jw.printOne(JCJSON.toSimpleJSON(obj));
    }

    @M("/selectOne2")
    public static void selectOne2(JWeb jw) {
        String mymodel_zj = jw.getString("mymodel_zj");
        if (null == mymodel_zj || mymodel_zj.isEmpty()) {
            jw.printOne("{}");
            return;
        }
        MyModel obj = DBO.service.S.selectOneByID(MyModel.class, mymodel_zj);
        obj.setMymodel_nr(obj.getMymodel_nr().replace("'", "&#39;").replace("\r", "&#39;n"));
        jw.printOne(obj.getMymodel_nr());
    }
    @M("/selectAllByJson")
    public static void selectJSON(JWeb jw) {
        String bean_zj = jw.getString("bean_zj");
        if (null == bean_zj || bean_zj.isEmpty()) {
            jw.printOne("[]");
            return;
        }
        String where = "WHERE bean_zj='" + bean_zj + "'";
        EasyuiPage page = EasyuiService.getPage(jw);

        List<MyModel> list = null == jw.getString("page") ? DBO.service.S.selectByCondition(MyModel.class, where) : DBO.service.S.selectVastByCondition(MyModel.class, page.page, page.rows, where);
        for (MyModel obj : list) {
            obj.setMymodel_nr("");
        }
        jw.printOne(EasyuiService.formatGrid(list, DBO.service.S.selectCountByCondition(MyModel.class, where)));
    }

}
