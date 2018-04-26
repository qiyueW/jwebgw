package wx.web.cc.hm.fangan;

import configuration.DBO;
import java.util.List;
import plugins.easyui.EasyuiService;
import plugins.easyui.vo.EasyuiPage;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import wx.web.cc.bean.Fangan1;
import wx.web.cc.service.FanganService;

@system.web.power.ann.SQ("Y101_18_1S")
@H("cc/fangan/s")
public class FanganS {

    @M("/selectOne")
    public static void selectOne(JWeb jw) {
        String fangan_zj = jw.getString("fangan_zj");
        if (null == fangan_zj || fangan_zj.isEmpty()) {
            return;
        }
        Fangan1 obj = DBO.service.S.selectOneByID(Fangan1.class, fangan_zj);
//        jw.printOne(JCJSON.toSimpleJSON(obj).replace("'", "&#39;").replace("\r", "&#39;n"));
        jw.set("obj", obj);
        jw.forward("/cc/fangan/fangan_one.jsp");
    }

    @M("/select2OneByJson")//一对多。通过表头主键，查询体表
    public static void selectOne2(JWeb jw) {
        String fangan1_zj = jw.getString("fangan_zj");
        if (null == fangan1_zj || fangan1_zj.isEmpty()) {
            jw.printOne("{}");
            return;
        }
        jw.printOne(EasyuiService.formatGrid(FanganService.getBody(fangan1_zj)));
    }

    @M("/selectAllByJson")
    public static void selectJSON(JWeb jw) {
        String fanganfl_id = jw.getString("fanganfl_id");
        if (null == fanganfl_id || fanganfl_id.isEmpty()) {
            jw.printOne("[]");
            return;
        }
        String where = "WHERE fanganfl_id='" + fanganfl_id + "'";
        EasyuiPage page = EasyuiService.getPage(jw);

        List<Fangan1> list = null == jw.getString("page") ? DBO.service.S.selectByCondition(Fangan1.class, where, "ORDER BY fangan1_px  ASC") : DBO.service.S.selectVastByCondition(Fangan1.class, page.page, page.rows, where, "ORDER BY fangan1_px ASC");
        jw.printOne(EasyuiService.formatGrid(list, DBO.service.S.selectCountByCondition(Fangan1.class, where)));
    }

}
