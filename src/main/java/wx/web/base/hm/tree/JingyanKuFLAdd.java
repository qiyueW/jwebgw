package wx.web.base.hm.tree;

import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.DBO;
import wx.web.base.bean.tree.JingyanKuFL;

@system.web.power.ann.SQ("J7_2_1")
@H("base/tree/jingyankufl/a")
public class JingyanKuFLAdd {

    JWeb jw;

    public JingyanKuFLAdd(JWeb jw) {
        this.jw = jw;
    }

    @M("/add")
    @Validate(wx.web.base.hm.tree.validate.JingyanKuFLValidate.class)
    public void add() {
        JingyanKuFL obj = jw.getObject(JingyanKuFL.class);
        if (null == obj.getJingyankufl_pid() || obj.getJingyankufl_pid().isEmpty()) {
            obj.setJingyankufl_pid("0");
        }
        DBO.out_add_1_0_f1(jw, DBO.service.A.addOne(obj));
        wx.web.base.hm.tree.cache.JingyanKuFLCache.CACHE.reset();
    }
}
