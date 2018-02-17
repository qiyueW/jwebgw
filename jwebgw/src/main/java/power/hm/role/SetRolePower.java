package power.hm.role;

import configuration.DBO;
import static configuration.DBO.service;
import power.bean.AdminUser;
import power.bean.Role;
import power.service.RoleService;
import system.base.annotation.H;
import system.web.JWeb;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.power.PDK;
import system.web.power.session.Login;

@system.web.power.ann.SQ(value = "X2_3", scope = system.web.power.PDK.SESSION_ADMIN_KEY)
@H("/sys/power/role/setpower")
public class SetRolePower {

    JWeb jw;

    public SetRolePower(JWeb jw) {
        this.jw = jw;
    }

    @M("/update")
    @Validate(power.hm.role.validate.RolePowerValidate.class)
    public void update() {
        String roleid1 = jw.getString("role_id");
        String powerid = jw.getString("power_id");

        //将roleid1 的"x1,x2,x3..."格式转成"'x1','x2','x3'..."格式
        String roleid = "";
        String[] rd = roleid1.split(",");
        for (int i = 0; i < rd.length; i++) {
            roleid = roleid + ",'" + rd[i] + "'";
        }

        int i = RoleService.updateRolePower(powerid, roleid.substring(1));
        jw.printOne(i == -1
                ? DBO.getJSONModel("-1", "更新权限失败：请通知管理检查服务器或数据库是否正常运行")
                : (i == 0 ? DBO.getJSONModel("0", "更新权限失败，请检查数据是否有异常。")
                        : DBO.getJSONModel("1", powerid.isEmpty() ? "成功取消" + rd.length + "个角色权限！！。" : "成功给" + rd.length + "个角色附权！！。"))
        );
    }

    @M("/selectAllByJson")
    public static void select_ListJSON(JWeb jw) {
        String id = jw.getString("jsdj_zj");
        AdminUser aobj = Login.getUserInfo(AdminUser.class, jw, PDK.SESSION_ADMIN_KEY);
        String where;
        //假设不是全局管理员（即有部门归属的管理员）只能查看自己建的角色
        if (null != aobj.getBm_id() && aobj.getBm_id().length() == 24) {
            where = "WHERE user_id IN('" + aobj.getUser_id() + "') "
                    + (null == id || id.isEmpty() ? "" : "AND jsdj_zj IN('" + id + "')");//条件
        } else {//假设是全局管理员，可以查看其他部门管理员的
            where = null == id || id.isEmpty() ? "" : "WHERE jsdj_zj IN('" + id + "')";//条件
        }
        jw.request.setAttribute("ListJson", service.S.selectByCondition(Role.class, where));
    }
}
