package wx.web.base.hm.tree;

import configuration.KeyModel.ReturnKey;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import configuration.DBO;
import wx.web.base.bean.tree.JingyanKuFL;

@H("base/tree/jingyankufl/d")
//@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J61_3")
@system.web.power.ann.SQ("J7_2_2_3")
public class JingyanKuFLDell {

    JWeb jw;

    public JingyanKuFLDell(JWeb jw) {
        this.jw = jw;
    }
    @M("/dell")
    public void dellVast() {
        int i = DBO.service.D.deleteVastByID_CheckToDeny(
                JingyanKuFL.class
                , jw.getString("ids")
                ,null
        );
        jw.printOne(i == -1? ReturnKey.DELL_UNIQUE.statusCode
                : (i > 0 ? ReturnKey.DELL_SUCESS.statusCode : ReturnKey.DELL_ERROR.statusCode));
        wx.web.base.hm.tree.cache.JingyanKuFLCache.CACHE.reset();
    }
}
