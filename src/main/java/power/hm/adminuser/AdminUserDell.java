package power.hm.adminuser;

import configuration.DBO;
import power.bean.AdminUser;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;

@H("/sys/power/adminuser/d")
@system.web.power.ann.DL(system.web.power.PDK.SESSION_SUPER_ADMIN_KEY) //超级管理员登陆
public class AdminUserDell {

    JWeb jw;

    public AdminUserDell(JWeb jw) {
        this.jw = jw;
    }

    @M("/dell")
    public void dellVast() {
        String ids = jw.getString("ids");

        int i = DBO.service.D.deleteVastByID_CheckToDeny(AdminUser.class, ids, "(user_sort!='管理员' OR user_style='启用')");
        if (i == -1) {
            jw.printOne(DBO.getJSONModel("-1", "无法执行删除。状态不符合"));
        }
        jw.printOne(i == 0 ? DBO.getJSONModel("0", "删除失败，请通知管理员检查网络或数据库。或稍后再试。")
                : DBO.getJSONModel("1", "删除成功"));
    }
}
