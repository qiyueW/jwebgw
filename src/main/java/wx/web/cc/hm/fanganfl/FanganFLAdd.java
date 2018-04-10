package wx.web.cc.hm.fanganfl;

import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.DBO;
import wx.web.cc.bean.FanganFL;

@system.web.power.ann.SQ("Y101_15_1A")
@H("cc/fangan/fanganfl/a")
public class FanganFLAdd {

    JWeb jw;

    public FanganFLAdd(JWeb jw) {
        this.jw = jw;
    }

    @M("/add")
    @Validate(wx.web.cc.hm.fanganfl.validate.FanganFLValidate.class)
    public void add() {
        FanganFL obj = jw.getObject(FanganFL.class);
        if (null == obj.getFanganfl_pid() || obj.getFanganfl_pid().isEmpty()) {
            obj.setFanganfl_pid("0");
        }
        DBO.out_add_1_0_f1(jw, DBO.service.A.addOne(obj));
        wx.web.cc.hm.fanganfl.cache.FanganFLCache.CACHE.reset();
    }
}
