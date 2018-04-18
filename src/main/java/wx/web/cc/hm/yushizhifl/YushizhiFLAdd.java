package wx.web.cc.hm.yushizhifl;

import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.DBO;
import wx.web.cc.bean.YushizhiFL;

@system.web.power.ann.SQ("Y101_16_1A")
@H("cc/yushizhi/yushizhifl/a")
public class YushizhiFLAdd {

    JWeb jw;

    public YushizhiFLAdd(JWeb jw) {
        this.jw = jw;
    }

    @M("/add")
    @Validate(wx.web.cc.hm.yushizhifl.validate.YushizhiFLValidate.class)
    public void add() {
        YushizhiFL obj = jw.getObject(YushizhiFL.class);
        if (null == obj.getYushizhifl_pid() || obj.getYushizhifl_pid().isEmpty()) {
            obj.setYushizhifl_pid("0");
        }
        DBO.out_add_1_0_f1(jw, DBO.service.A.addOne(obj));
        wx.web.cc.hm.yushizhifl.cache.YushizhiFLCache.CACHE.reset();
    }
}
