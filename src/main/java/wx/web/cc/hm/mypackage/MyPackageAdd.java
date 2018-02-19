package wx.web.cc.hm.mypackage;

import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.DBO;
import wx.web.cc.bean.MyPackage;

//@system.web.power.ann.SQ("J61")
@H("cc/mypackage/a")
public class MyPackageAdd {

    JWeb jw;

    public MyPackageAdd(JWeb jw) {
        this.jw = jw;
    }

    @M("/add")
    @Validate(wx.web.cc.hm.mypackage.validate.MyPackageValidate.class)
    public void add() {
        MyPackage obj = jw.getObject(MyPackage.class);
        if (null == obj.getMypackage_pid() || obj.getMypackage_pid().isEmpty()) {
            obj.setMypackage_pid("0");
        }
        DBO.out_add_1_0_f1(jw, DBO.service.A.addOne(obj));
        wx.web.cc.hm.mypackage.cache.MyPackageCache.CACHE.reset();
    }
}
