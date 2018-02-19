package wx.web.spage.hm;

import configuration.DBO;
import configuration.KeyModel;
import system.web.JWeb;
import system.base.annotation.M;
import plugins.ligerui.LigeruiKey;
import plugins.ligerui.LigeruiService;
import plugins.ligerui.vo.LigerUIPage;
import system.base.annotation.H;
import system.web.power.ann.GG;
import system.web.power.ann.SQ;
import wx.web.spage.bean.Spage_notice;
import wx.web.spage.service.NoticeService;
@SQ("Y100_1_1")
@H("/spage/notice")
final public class NoticeSelect {

    @M("/selectVast")///base/wt/twt/selectOne.jw
    public static void selectVast_UIGrid(final JWeb jw) {

        String orderby = LigeruiService.getOrderBy(jw.request);//排序
        LigerUIPage page = LigeruiService.getPage(jw.request);//分页
        jw.request.setAttribute(LigeruiKey.ligerui_grid.key, NoticeService.selectVast(page.page, page.pagesize, orderby));
        jw.request.setAttribute(LigeruiKey.ligerui_grid_count.key, DBO.service.S.selectCount(Spage_notice.class));

    }

    @M("/selectOne")///base/wt/twt/selectOne.jw
    public static void selectOne_CheckUpdateSelect(final JWeb jw) {
        String selectUpdateID = jw.getString(KeyModel.ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);
        jw.set("obj", DBO.service.S.selectOneByID(Spage_notice.class, selectUpdateID));
        jw.forward("/spage/notice/notice_one.jsp");
    }

    @GG
    @M("/view/selectVast")///base/wt/twt/selectOne.jw
    public static void selectVast(final JWeb jw) {
        jw.request.setAttribute("obj", NoticeService.selectVast(1,300, null));
        jw.forward("/viwe/ggtz.jsp");
    }

    @GG
    @M("/view/selectOne")///base/wt/twt/selectOne.jw
    public static void selectOneView(final JWeb jw) {
        String view = jw.getString("id");
        if (null == view || view.trim().isEmpty() || view.length() != 24) {
            return;
        }
        jw.set("obj", DBO.service.S.selectOneByID(Spage_notice.class, view));
        jw.forward("/viwe/ggtz_one.jsp");
    }

}
