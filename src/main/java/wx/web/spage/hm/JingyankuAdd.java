package wx.web.spage.hm;

import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import configuration.DBO;
import system.base.date.DateService;
import system.web.power.ann.SQ;
import system.web.power.session.Login;
import wx.web.base.bean.RY;
import wx.web.spage.bean.Spage_jingyanku;

@SQ("Y100_2")
@H("/spage/jingyanku")
public class JingyankuAdd {

    JWeb jw;

    public JingyankuAdd(JWeb jw) {
        this.jw = jw;
    }

    @system.base.annotation.Validate(wx.web.spage.hm.validate.Spage_jingyankuValidate.class)
    @M("/add")
    public void add() {
        Spage_jingyanku obj = jw.getObject(Spage_jingyanku.class);
        String now = DateService.getNowTime();
        if (null == obj.getSpage_jingyanku_fabushijian() || obj.getSpage_jingyanku_fabushijian().isEmpty()) {
            obj.setSpage_jingyanku_fabushijian(now);
        }
        RY ry = Login.getUserInfo(RY.class, jw);
        obj.setSpage_jingyanku_zhidanren(ry.getRy_name());
        obj.setSpage_jingyanku_zhidanren_zj(ry.getRy_id());
        obj.setSpage_jingyanku_zhidanshijian(now);
        int i = DBO.service.A.addOne(obj);
        DBO.out_add_1_0_f1(jw, i);
        if (i == 1) {
            wx.web.spage.cache.JianyankuCache.CACHE.reset();
        }
    }

}
