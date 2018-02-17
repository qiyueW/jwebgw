package power.hm.jsdj;


import plugins.ligerui.LigeruiKey;
import plugins.ligerui.LigeruiService;
import plugins.ligerui.vo.LigerUIPage;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import static configuration.DBO.service;
import power.bean.JSDJ;

@H("/sys/power/jsdj/s")
@system.web.power.ann.SQ(value="X1_2_1",scope=system.web.power.PDK.SESSION_ADMIN_KEY)
public class JSDJSelect {

    @M("/selectVast")
//  @system.web.filter.annotation.JWFilter(封装分页对象。建议逻辑如下：如果没有相关参数，直接中止请求)
    public static void select_UIGridt(JWeb jw) {
        String orderby = LigeruiService.getOrderBy(jw.request);//排序
        LigerUIPage page = LigeruiService.getPage(jw.request);//分页
        String where = "";//条件
        jw.request.setAttribute(LigeruiKey.ligerui_grid.key, service.S.selectVastByCondition(JSDJ.class, page.page, page.pagesize, where, orderby));
        jw.request.setAttribute(LigeruiKey.ligerui_grid_count.key, service.S.selectCountByCondition(JSDJ.class, where));
    }

    @M("/selectAllByJson")
    public static void select_ListJSON(JWeb jw) {
        jw.request.setAttribute("ListJson", service.S.select(JSDJ.class));
    }
}
