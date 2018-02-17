package wx.web.spage.hm;

import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import configuration.DBO;
import system.base.date.DateService;
import system.web.power.ann.SQ;
import system.web.power.session.Login;
import wx.web.base.bean.RY;
import wx.web.spage.bean.Spage_notice;
@SQ("Y100_0")
@H("/spage/notice")
public class NoticeAdd {

    JWeb jw;

    public NoticeAdd(JWeb jw) {
        this.jw = jw;
    }

    @system.base.annotation.Validate(wx.web.spage.hm.validate.Spage_noticeValidate.class)
    @M("/add")
    public void add() {
        Spage_notice obj = jw.getObject(Spage_notice.class);
        String now=DateService.getNowTime();
        if (null == obj.getSpage_notice_fabushijian() || obj.getSpage_notice_fabushijian().isEmpty()) {
            obj.setSpage_notice_fabushijian(now);
        }
        RY ry = Login.getUserInfo(RY.class, jw);
        obj.setSpage_notice_zhidanren(ry.getRy_name());
        obj.setSpage_notice_zhidanren_zj(ry.getRy_id());
        obj.setSpage_notice_zhidanshijian(now);
        DBO.out_add_1_0_f1(jw,DBO.service.A.addOne(obj));

    }

}
