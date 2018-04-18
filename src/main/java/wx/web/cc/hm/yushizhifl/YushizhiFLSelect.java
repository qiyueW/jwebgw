package wx.web.cc.hm.yushizhifl;

import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
//import system.web.power.ann.GG;
//import wx.web.base.BCM;
import wx.web.cc.hm.yushizhifl.cache.YushizhiFLCache;

@H("cc/yushizhi/yushizhifl/s")
//@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J61_1")
@system.web.power.ann.SQ("Y101_16_1S")
public class YushizhiFLSelect {

    @M("/selectVast")
    public static void select(JWeb jw) {
        jw.printOne(wx.web.cc.hm.yushizhifl.cache.YushizhiFLCache.CACHE.getCacheData(YushizhiFLCache.class).getJSON());
    }

//    @GG
    @M("/selectVast/GRID")
    public static void selectUI(JWeb jw) {//_UIGrid
        jw.printOne(wx.web.cc.hm.yushizhifl.cache.YushizhiFLCache.CACHE.getCacheData(YushizhiFLCache.class).getLigeruiJSON());
    }
}
