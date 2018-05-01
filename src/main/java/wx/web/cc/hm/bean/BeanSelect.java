package wx.web.cc.hm.bean;

import configuration.DBO;
import java.util.List;
import plugins.easyui.EasyuiService;
import plugins.easyui.vo.EasyuiPage;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import wx.web.cc.bean.Bean;
import wx.web.cc.service.BeanService;

@system.web.power.ann.SQ("Y101_6_1")
@H("cc/bean/s")
public class BeanSelect {

    @M("/selectOne")
    public static void selectOne(JWeb jw) {
        String bean_zj = jw.getString("bean_zj");
        if (null == bean_zj || bean_zj.isEmpty()) {
            return;
        }
        Bean obj = DBO.service.S.selectOneByID(Bean.class, bean_zj);
//        jw.printOne(JCJSON.toSimpleJSON(obj).replace("'", "&#39;").replace("\r", "&#39;n"));
        jw.set("obj", obj);
        jw.forward("/cc/bean/bean_one.jsp");
    }

    @M("/select2OneByJson")//一对多。通过表头主键，查询体表
    public static void selectOne2(JWeb jw) {
        String bean_zj = jw.getString("bean_zj");
        if (null == bean_zj || bean_zj.isEmpty()) {
            jw.printOne("{}");
            return;
        }
        jw.printOne(EasyuiService.formatGrid(BeanService.getBody(bean_zj)));
    }

    @M("/selectAllByJson")
    public static void selectJSON(JWeb jw) {
        String mypackage_id = jw.getString("mypackage_id");
        if (null == mypackage_id || mypackage_id.isEmpty()) {
            jw.printOne("[]");
            return;
        }
        String where = "WHERE mypackage_id='" + mypackage_id + "'";
        EasyuiPage page = EasyuiService.getPage(jw);

        List<Bean> list = null == jw.getString("page") ? DBO.service.S.selectByCondition(Bean.class, where, "ORDER BY bean_px  ASC") : DBO.service.S.selectVastByCondition(Bean.class, page.page, page.rows, where, "ORDER BY bean_px ASC");
        jw.printOne(EasyuiService.formatGrid(list, DBO.service.S.selectCountByCondition(Bean.class, where)));
    }

}
