package wx.web.spage.hm;

import configuration.DBO;
import configuration.KeyModel;
import system.web.JWeb;
import system.base.annotation.M;
import plugins.ligerui.LigeruiKey;
import plugins.ligerui.LigeruiService;
import plugins.ligerui.vo.LigerUIPage;
import system.base.StringTool;
import system.base.annotation.H;
import system.web.power.ann.GG;
import system.web.power.ann.SQ;
import wx.web.spage.bean.Spage_jingyanku;
import wx.web.spage.cache.JianyankuCache;
import wx.web.spage.service.JingyankuService;

@SQ("Y100_3_1")
@H("/spage/jingyanku/s")
final public class JingyankuSelect {

    @M("/selectVast")///base/wt/twt/selectOne.jw
    public static void selectVast_UIGrid(final JWeb jw) {

        String orderby = LigeruiService.getOrderBy(jw.request);//排序
        LigerUIPage page = LigeruiService.getPage(jw.request);//分页
        String id = jw.getString("jingyankufl_id");
        String where = "";
        if (null != id && id.length() > 23) {
            where = " WHERE jingyankufl_id IN(" + StringTool.replaceDToDDD(id) + ") ";
        }
        jw.request.setAttribute(LigeruiKey.ligerui_grid.key, JingyankuService.selectVast(page.page, page.pagesize, where, orderby));
        jw.request.setAttribute(LigeruiKey.ligerui_grid_count.key, DBO.service.S.selectCountByCondition(Spage_jingyanku.class, where));
    }

    @M("/selectOne")///base/wt/twt/selectOne.jw
    public static void selectOne_CheckUpdateSelect(final JWeb jw) {
        String selectUpdateID = jw.getString(KeyModel.ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);
        jw.set("obj", DBO.service.S.selectOneByID(Spage_jingyanku.class, selectUpdateID));
        jw.forward("/spage/jingyanku/jingyanku_one.jsp");
    }

    @GG
    @M("/view/selectVast")///base/wt/twt/selectOne.jw
    public static void selectVast(final JWeb jw) {
        String id = jw.getString("jingyankufl_id");
        String bt = jw.getString("bt");
        String key = jw.getString("key");
        jw.printOne(JianyankuCache.CACHE.getCacheData(JianyankuCache.class).getJSON(id, bt, key));
    }

    @GG
    @M("/view/selectOne")///base/wt/twt/selectOne.jw
    public static void selectOneView(final JWeb jw) {
        String view = jw.getString("id");
        if (null == view || view.trim().isEmpty() || view.length() != 24) {
            return;
        }
        jw.set("obj", DBO.service.S.selectOneByID(Spage_jingyanku.class, view));
        jw.forward("/viwe/jingyanku_one2.jsp");
    }

}
