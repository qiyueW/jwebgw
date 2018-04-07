package wx.web.cc.hm.cmodelfl;

import configuration.KeyModel.ReturnKey;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import configuration.DBO;
import wx.web.cc.bean.CModelFL;

@H("cc/cmodel/cmodelfl/d")
//@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J61_3")
@system.web.power.ann.SQ("Y101_11D")
public class CModelFLDell {

    JWeb jw;

    public CModelFLDell(JWeb jw) {
        this.jw = jw;
    }
    @M("/dell")
    public void dellVast() {
        int i = DBO.service.D.deleteVastByID_CheckToDeny(
                CModelFL.class
                , jw.getString("ids")
                ,null
        );
        jw.printOne(i == -1? ReturnKey.DELL_UNIQUE.statusCode
                : (i > 0 ? ReturnKey.DELL_SUCESS.statusCode : ReturnKey.DELL_ERROR.statusCode));
        wx.web.cc.hm.cmodelfl.cache.CModelFLCache.CACHE.reset();
    }
}
