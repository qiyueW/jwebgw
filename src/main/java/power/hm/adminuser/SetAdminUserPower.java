package power.hm.adminuser;

import configuration.DBO;
import static configuration.DBO.service;
import power.bean.Role;
import power.service.AdminService;
import system.base.annotation.H;
import system.web.JWeb;
import system.base.annotation.M;
@system.web.power.ann.DL(system.web.power.PDK.SESSION_SUPER_ADMIN_KEY) //超级管理员登陆
@H("/sys/power/adminuser/setpower")
public class SetAdminUserPower {

    JWeb jw;

    public SetAdminUserPower(JWeb jw) {
        this.jw = jw;
    }
    
    @M("/update/power")
//    @Validate(power.hm.user.validate.UserPowerValidate.class)
    public void updatePower() {
        String userid = jw.getString("user_id");
        String powerid = jw.getString("power_id");
        int i = AdminService.updateUserPower(userid, powerid);
        jw.printOne(i == -1
                ? DBO.getJSONModel("-1", "更新权限失败：请通知管理检查服务器或数据库是否正常运行")
                : (i == 0 ? DBO.getJSONModel("0", "更新权限失败，请检查数据是否有异常。")
                        : DBO.getJSONModel("1", powerid.isEmpty() ? "成功取消" + i + "个用户直接权限！！。" : "成功给" + i + "个用户直接权限附权！！。"))
        );
    }

    @M("/selectAllByJson")
    public static void select_ListJSON(JWeb jw) {
        String id = jw.getString("jsdj_zj");
        String where = null == id || id.isEmpty() ? "" : "WHERE jsdj_zj IN('" + id + "')";//条件
        if (where.isEmpty()) {
            jw.request.setAttribute("ListJson", service.S.select(Role.class));
            return;
        }
        jw.request.setAttribute("ListJson", service.S.selectByCondition(Role.class, where));
    }
}
