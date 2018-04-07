package wx.web.cc.hm.cmodelfl;

import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.DBO;
import wx.web.cc.bean.CModelFL;

@system.web.power.ann.SQ("Y101_11A")
@H("cc/cmodel/cmodelfl/a")
public class CModelFLAdd {

    JWeb jw;

    public CModelFLAdd(JWeb jw) {
        this.jw = jw;
    }

    @M("/add")
    @Validate(wx.web.cc.hm.cmodelfl.validate.CModelFLValidate.class)
    public void add() {
        CModelFL obj = jw.getObject(CModelFL.class);
        if (null == obj.getCmodelfl_pid() || obj.getCmodelfl_pid().isEmpty()) {
            obj.setCmodelfl_pid("0");
        }
        DBO.out_add_1_0_f1(jw, DBO.service.A.addOne(obj));
        wx.web.cc.hm.cmodelfl.cache.CModelFLCache.CACHE.reset();
    }
}
