package wx.web.spage.hm;

import configuration.DBO;
import system.web.JWeb;
import system.base.annotation.M;
import system.base.annotation.H;
import wx.web.spage.bean.Spage_index;

@H("/spage/index/s")
final public class IndexSelect {

    @M("/selectOne")///base/wt/twt/selectOne.jw
    public static void selectOne(final JWeb jw) {
        Spage_index obj = DBO.service.S.selectOneByID(Spage_index.class, "1");
        jw.set("obj", obj);
        jw.forward("/index.jsp");
    }
}
