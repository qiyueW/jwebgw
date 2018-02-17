package wx.web.base.hm.ry;

import configuration.DBO;
import static configuration.DBO.service;
import java.util.ArrayList;
import java.util.List;

import plugins.ligerui.LigeruiKey;
import plugins.ligerui.LigeruiService;
import plugins.ligerui.vo.LigerUIPage;
import power.bean.AdminUser;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.PDK;
import system.web.power.session.Login;
import wx.web.base.bean.BM;
import wx.web.base.bean.RY;
import wx.web.base.dao.RYDao;
import wx.web.base.hm.ry.vo.SelectConditionVo;

@H("/base/ry")
public class RYSelect {

    @M("/selectVast")///base/ry/selectVast
    public static void selec_UIGridt(JWeb jw) {

        SelectConditionVo vo = SelectConditionVo.getSelectConditionVo(jw);
        String orderby = LigeruiService.getOrderBy(jw.request);//排序
        LigerUIPage page = LigeruiService.getPage(jw.request);//分页
        String where = RYDao.formatParam(vo.bm_ids, vo.nameOrAccount, vo.ry_style);//条件

        jw.request.setAttribute(LigeruiKey.ligerui_grid.key, RYDao.selectVast(where, page.page, page.pagesize, orderby));
        jw.request.setAttribute(LigeruiKey.ligerui_grid_count.key, service.S.selectCountByCondition(RY.class, where));

    }

    @M("/selectVast0")///base/ry/selectVast0
    public static void selec0_UIGridt(JWeb jw) {

        SelectConditionVo vo = SelectConditionVo.getSelectConditionVo(jw);
        String orderby = LigeruiService.getOrderBy(jw.request);//排序
        LigerUIPage page = LigeruiService.getPage(jw.request);//分页
        String where = RYDao.formatParam0(vo.bm_ids, vo.nameOrAccount);//条件
        jw.request.setAttribute(LigeruiKey.ligerui_grid.key, RYDao.selectVast(where, page.page, page.pagesize, orderby));
        jw.request.setAttribute(LigeruiKey.ligerui_grid_count.key, service.S.selectCountByCondition(RY.class, where));

    }

    @M("/selectVast/json")///base/ry/selectVast/json
    public static void selec1_ListJSON(JWeb jw) {
        String bm_ids = jw.getString("bm_ids");
        if (null == bm_ids || bm_ids.trim().length() < 24) {
            return;
        }
        jw.request.setAttribute("ListJson", RYDao.selectVastByBmID(bm_ids));
    }

    @system.web.power.ann.DL(system.web.power.PDK.SESSION_ADMIN_KEY) //管理员登陆
    @M("/selectVast/adminpower/json")///base/ry/selectVast/json
    public static void selecAdminpower_ListJSON(JWeb jw) {
        String bm_ids = jw.getString("bm_ids");
        if (null == bm_ids || bm_ids.trim().length() < 24) {
            return;
        }
        jw.request.setAttribute("ListJson", RYDao.selectVastByBmID(bm_ids));
//        AdminUser aobj = Login.getUserInfo(AdminUser.class, jw, PDK.SESSION_ADMIN_KEY);
//        String bmid = jw.getString("bm_ids");
//        //全局管理员
//        if (null == aobj.getBm_id() || aobj.getBm_id().isEmpty()) {
//            jw.request.setAttribute("ListJson", RYDao.selectVastByBmID(bmid));
//            return;
//        }
//        //非全局管理
//        List<BM> bm = DBO.service.S.select(BM.class);
//        StringBuilder bmids = new StringBuilder();
//        BM fbm = new BM();
//        fbm.setBm_id(aobj.getBm_id());
//        fbm.setBm_pid("0");
//        fiandBMSon(bmids, bm, fbm);
//        System.out.println(bmids);
//        jw.request.setAttribute("ListJson", RYDao.selectVastByBmID(bmids.length() > 0 ? bmids.substring(1) : null));
    }

    @M("/selectOne")
    public static void selectOne(JWeb jw) {
        //查询一个          //        jw.forward("/xx/xx.jsp");//跳转
    }
}
