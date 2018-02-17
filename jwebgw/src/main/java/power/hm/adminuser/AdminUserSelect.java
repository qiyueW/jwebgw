package power.hm.adminuser;

import configuration.DBO;
import java.util.List;
import plugins.ligerui.LigeruiKey;
import power.bean.AdminUser;
import power.service.AdminService;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.beanjson.JCJSON;
import system.web.JWeb;
import wx.web.base.bean.BM;

@system.web.power.ann.DL(system.web.power.PDK.SESSION_SUPER_ADMIN_KEY) //超级管理员登陆
@H("/sys/power/adminuser/s")
public class AdminUserSelect {

    JWeb jw;

    public AdminUserSelect(JWeb jw) {
        this.jw = jw;
    }

    @M("/selectVast")//AdminService
    public void select_UIGridt() {
        List<AdminUser> selectAll = AdminService.selectAll(false);
        jw.request.setAttribute(LigeruiKey.ligerui_grid.key, selectAll);
        jw.request.setAttribute(LigeruiKey.ligerui_grid_count.key, selectAll.size());
    }

    @M("/selectOne")//AdminService
    public void selectOne() {
        String id = jw.getString("id");
        AdminUser obj = AdminService.selectOneAdmin(id);
        obj.setUser_password("密码只能更改，不能查看");
        jw.set("obj", obj);
        jw.forward("/sys/adminuser/adminuser_one.jsp");
    }

    @M("/selectOneAdminBm")//AdminService
    public void selectOneAdminBM() {
        String id = jw.getString("user_id");
        AdminUser obj = AdminService.selectOneAdmin(id);
        if (null == obj.getBm_id() || obj.getBm_id().isEmpty()) {
            jw.printOne("[]");
            return;
        }
        String where="WHERE bm_id IN('"+obj.getBm_id().replace("|", "','")+"')";
        List<BM> bms=DBO.service.S.selectByCondition(BM.class, where);
        jw.printOne(JCJSON.toSimpleJSON(bms));
    }

    @M("/v/showMenu")//列出管理员的菜单
    public static void selectVMenu_ListJSON(JWeb jw) {
        String bm = jw.getString("bm_id");
        if (null == bm || bm.isEmpty()) {
            jw.request.setAttribute("ListJson", AdminService.selectAll(true));
            return;
        }
        if (bm.equals("no")) {
            jw.request.setAttribute("ListJson", AdminService.selectAllByBMNull(true));
            return;
        }
        jw.request.setAttribute("ListJson", AdminService.selectAll(true, bm.replace(",", "','")));
    }

    @M("/selectOneUserPower")//取得用户权限
    public static void selectOne(JWeb jw) {
        String id = jw.getString("user_id");
        if (null == id || id.trim().isEmpty()) {
            return;
        }
        AdminUser obj = DBO.service.S.selectOneByID(AdminUser.class, id);

        if (null == obj.getPower_id() || obj.getPower_id().isEmpty()) {
            jw.printOne("[{}]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String pid : obj.getPower_id().split(",")) {
            sb.append(",{\"power_id\":\"").append(pid).append("\"}");
        }
        jw.printOne("[" + sb.substring(1) + "]");
        System.out.println(sb.substring(1));
    }
}
