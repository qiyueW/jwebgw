package wx.web.cc.hm.bean;

import java.util.List;

//import plugins.ligerui.LigeruiKey;
//import plugins.ligerui.LigeruiService;
//import plugins.ligerui.vo.LigerUIPage;
import configuration.DBO;
import plugins.easyui.EasyuiService;
import plugins.easyui.vo.EasyuiPage;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.ann.SQ;
import wx.web.cc.bean.Mybeanfield;

@SQ("Y101_8_1")
@H("cc/mybean/field/s")
public class MybeanFieldSelect {

//    @M("/selectVast")
//    public static void selectGridByCache(JWeb jw) {
//        jw.printOne(
//                "{\"Rows\":" + wx.web.cc.hm.mybean.cache.MybeanCache.CACHE.getCacheData(wx.web.cc.hm.mybean.cache.MybeanCache.class).getJSON()
//                + ",\"" + plugins.ligerui.LigeruiConfig.record + "\":\"0\"}"
//        );
//    }

    @M("/selectAllByJson")
    public static void selectJSONByCache(JWeb jw) {
        String bean_zj = jw.getString("bean_zj");
        if (null == bean_zj || bean_zj.isEmpty()) {
            jw.printOne("[]");
            return;
        }
        String where = "WHERE bean_zj='" + bean_zj + "'";
        EasyuiPage page = EasyuiService.getPage(jw);

        List<Mybeanfield> list = DBO.service.S.selectVastByCondition(Mybeanfield.class, page.page, page.rows, where);
        jw.printOne(EasyuiService.formatGrid(list, DBO.service.S.selectCountByCondition(Mybeanfield.class, where)));
    }
}
