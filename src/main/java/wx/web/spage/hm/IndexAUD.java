package wx.web.spage.hm;

import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import configuration.DBO;
import system.web.power.ann.SQ;
import wx.web.spage.bean.Spage_index;

@SQ("Y100_4_2")
@H("/spage/index/au")
public class IndexAUD {

    JWeb jw;

    public IndexAUD(JWeb jw) {
        this.jw = jw;
    }

    @M("/update")
    public void au() {
        Spage_index obj = jw.getObject(Spage_index.class);
        int i = DBO.service.U.update_all(obj);
        DBO.out_update_1_0_f1(jw, i);
    }

    @SQ("Y100_4_1")
    @M("/select")
    public void updateSelect() {

        Spage_index obj = DBO.service.S.selectOneByID(Spage_index.class, "1");
        jw.request.setAttribute("obj", obj);
        jw.forward("/spage/indexpage/indexpage.jsp");
    }
}
