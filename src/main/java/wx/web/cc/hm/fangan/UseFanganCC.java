package wx.web.cc.hm.fangan;

import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.ann.DL;
import system.web.power.session.Login;
import wx.web.base.bean.RY;
import wx.web.cc.hm.fangan.cache.CCDataCache;

@H("cc/fangan/use")
public class UseFanganCC {

    JWeb jw;

    public UseFanganCC(JWeb jw) {
        this.jw = jw;
    }


    @DL
    @M("/create/cc")
    public void use() {
        RY ry = Login.getUserInfo(RY.class, jw);
        String data = CCDataCache.getValue(ry.getRy_account());
        jw.printOne(null == data ? "[]" : data);
    }

    @DL
    @M("/create/dell")
    public void dell() {
        RY ry = Login.getUserInfo(RY.class, jw);
        CCDataCache.put(ry.getRy_account(), "");
        jw.printOne(1);
    }
}
