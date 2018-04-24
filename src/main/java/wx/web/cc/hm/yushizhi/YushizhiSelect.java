package wx.web.cc.hm.yushizhi;

import configuration.DBO;
import java.util.List;
import plugins.easyui.EasyuiService;
import plugins.easyui.vo.EasyuiPage;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import wx.web.cc.bean.Yushizhi;
import wx.web.cc.hm.yushizhi.service.YushizhiService;

@system.web.power.ann.SQ("Y101_17_1S")
@H("cc/yushizhi/s")
public class YushizhiSelect {

    @M("/selectOne")
    public static void selectOne(JWeb jw) {
        String yushizhi_zj = jw.getString("yushizhi_zj");
        if (null == yushizhi_zj || yushizhi_zj.isEmpty()) {
            return;
        }
        Yushizhi obj = DBO.service.S.selectOneByID(Yushizhi.class, yushizhi_zj);
//        jw.printOne(JCJSON.toSimpleJSON(obj).replace("'", "&#39;").replace("\r", "&#39;n"));
        jw.set("obj", obj);
        jw.forward("/cc/yushizhi/yushizhi_one.jsp");
    }

    @M("/select2OneByJson")//一对多。通过表头主键，查询体表
    public static void selectOne2(JWeb jw) {
        String yushizhi_zj = jw.getString("yushizhi_zj");
        if (null == yushizhi_zj || yushizhi_zj.isEmpty()) {
            jw.printOne("{}");
            return;
        }
        jw.printOne(EasyuiService.formatGrid(YushizhiService.getBody(yushizhi_zj)));
    }
    
    @M("/selectAllByJson")
    public static void selectJSON(JWeb jw) {
        String yushizhifl_id = jw.getString("yushizhifl_id");
        if (null == yushizhifl_id || yushizhifl_id.isEmpty()) {
            jw.printOne("[]");
            return;
        }
        String where = "WHERE yushizhifl_id='" + yushizhifl_id + "'";
        EasyuiPage page = EasyuiService.getPage(jw);

        List<Yushizhi> list = null == jw.getString("page") ? DBO.service.S.selectByCondition(Yushizhi.class, where) : DBO.service.S.selectVastByCondition(Yushizhi.class, page.page, page.rows, where);
        jw.printOne(EasyuiService.formatGrid(list, DBO.service.S.selectCountByCondition(Yushizhi.class, where)));
    }

}
