package wx.web.cc.hm.mybean;

//import plugins.ligerui.LigeruiKey;
//import plugins.ligerui.LigeruiService;
//import plugins.ligerui.vo.LigerUIPage;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
//import static configuration.DBO.service;
//import wx.web.cc.bean.Mybean;

@H("cc/mybean/s")
public class MybeanSelect {

    @M("/selectVast")
    public static void selectGridByCache(JWeb jw) {
         jw.printOne(
                 "{\"Rows\":" +wx.web.cc.hm.mybean.cache.MybeanCache.CACHE.getCacheData(wx.web.cc.hm.mybean.cache.MybeanCache.class).getJSON()
                         + ",\"" + plugins.ligerui.LigeruiConfig.record + "\":\"0\"}"
         );        
    }
    @M("/selectAllByJson")
    public static void selectJSONByCache(JWeb jw) {
        jw.printOne(wx.web.cc.hm.mybean.cache.MybeanCache.CACHE.getCacheData(wx.web.cc.hm.mybean.cache.MybeanCache.class).getJSON());
    }
}
