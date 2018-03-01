package wx.web.cc.hm.mybean;

//import plugins.ligerui.LigeruiKey;
//import plugins.ligerui.LigeruiService;
//import plugins.ligerui.vo.LigerUIPage;
import configuration.DBO;
import system.base.annotation.H;
import system.web.JWeb;
import system.base.annotation.M;
import system.base.beanjson.JCJSON;
import system.web.power.ann.SQ;
import wx.web.cc.bean.Mybean;
//import static configuration.DBO.service;
//import wx.web.cc.bean.Mybean;

@H("cc/mybean/s")
@SQ("Y101_6_1")
public class MybeanSelect {

    @M("/selectVast")
    public static void selectGridByCache(JWeb jw) {
        jw.printOne(
                "{\"Rows\":" + wx.web.cc.hm.mybean.cache.MybeanCache.CACHE.getCacheData(wx.web.cc.hm.mybean.cache.MybeanCache.class).getJSON()
                + ",\"" + plugins.ligerui.LigeruiConfig.record + "\":\"0\"}"
        );
    }

    @M("/selectAllByJson")
    public static void selectJSONByCache(JWeb jw) {
        String mypackage_id = jw.getString("mypackage_id");
        if (null == mypackage_id || mypackage_id.isEmpty()) {
            jw.printOne("[]");return;
        }
        jw.printOne(JCJSON.toSimpleJSON(DBO.service.S.selectByCondition(Mybean.class, "WHERE mypackage_id='" + mypackage_id + "'", "ORDER BY mybean_px ASC")));
    }
}
