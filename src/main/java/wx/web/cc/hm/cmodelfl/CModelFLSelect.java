package wx.web.cc.hm.cmodelfl;

import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
//import system.web.power.ann.GG;
//import wx.web.base.BCM;
import wx.web.cc.hm.cmodelfl.cache.CModelFLCache;

@H("cc/cmodel/cmodelfl/s")
//@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J61_1")
@system.web.power.ann.SQ("Y101_11S")
public class CModelFLSelect {

    @M("/selectVast")
    public static void select(JWeb jw) {
        jw.printOne(wx.web.cc.hm.cmodelfl.cache.CModelFLCache.CACHE.getCacheData(CModelFLCache.class).getJSON());
    }

//    @GG
    @M("/selectVast/GRID")
    public static void selectUI(JWeb jw) {//_UIGrid
        jw.printOne(wx.web.cc.hm.cmodelfl.cache.CModelFLCache.CACHE.getCacheData(CModelFLCache.class).getLigeruiJSON());
    }
}
