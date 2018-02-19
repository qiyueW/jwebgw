package wx.web.base.hm.tree;

import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.ann.GG;
//import system.web.power.ann.GG;
//import wx.web.base.BCM;
import wx.web.base.hm.tree.cache.JingyanKuFLCache;

@H("base/tree/jingyankufl/s")
//@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J61_1")
@system.web.power.ann.SQ("J7_2_2_1")
public class JingyanKuFLSelect {

    @GG
    @M("/selectVast")
    public static void select(JWeb jw) {
        jw.printOne(wx.web.base.hm.tree.cache.JingyanKuFLCache.CACHE.getCacheData(JingyanKuFLCache.class).getJSON());
    }

//    @GG
    @M("/selectVast/GRID")
    public static void selectUI(JWeb jw) {//_UIGrid
        jw.printOne(wx.web.base.hm.tree.cache.JingyanKuFLCache.CACHE.getCacheData(JingyanKuFLCache.class).getLigeruiJSON());
    }
}
