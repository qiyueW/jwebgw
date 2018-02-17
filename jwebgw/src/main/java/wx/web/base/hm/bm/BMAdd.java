package wx.web.base.hm.bm;


import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.DBO;
import wx.web.base.bean.BM;
@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J51")
@H("/base/bm")
public class BMAdd{

    JWeb jw;

    public BMAdd(JWeb jw) {
        this.jw = jw;
    }
    
    @M("/add")
    @Validate(wx.web.base.hm.bm.validate.BMValidate.class)
    public void add() {
    	 BM obj=jw.getObject(BM.class);
    	 if(null==obj.getBm_pid()||obj.getBm_pid().isEmpty()){
    		 obj.setBm_pid("0");
    	 }
    	 DBO.out_add_1_0_f1(jw, DBO.service.A.addOne(obj));
         wx.web.base.BCM.RY_CACHE.reset();
    }
    
}
