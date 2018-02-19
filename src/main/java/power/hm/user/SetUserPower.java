package power.hm.user;

import configuration.DBO;
import static configuration.DBO.service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import power.bean.AdminUser;
import power.bean.Role;
import power.bean.User;
import power.service.RoleService;
import power.service.UserService;
import system.base.annotation.H;
import system.web.JWeb;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.power.session.Login;

@H("/sys/power/user/setpower")
public class SetUserPower {

    JWeb jw;

    public SetUserPower(JWeb jw) {
        this.jw = jw;
    }

    @system.web.power.ann.SQ(value = "X3_2", scope = system.web.power.PDK.SESSION_ADMIN_KEY)
    @M("/select/role")//"用户权限查询" sys/user/user_S.jsp
    public void selectrole_ListJSON() {
        String id = jw.getString("user_id");
        if (null == id || id.isEmpty()) {
            return;
        }
        User u = service.S.selectOneByID(User.class, id);
        if (null == u || null == u.getRole_id() || u.getRole_id().isEmpty()) {
            jw.printOne("[]");
            return;
        }
        jw.request.setAttribute("ListJson", service.S.selectByCondition(Role.class, "WHERE role_id IN('" + u.getRole_id().replace(",", "','") + "')"));
    }

    @system.web.power.ann.SQ(value = "X3_2", scope = system.web.power.PDK.SESSION_ADMIN_KEY)
    @M("/selectOneUserAllPower")//"用户权限查询2", "sys/user/user_S.jsp"
    public static void selectOneAllPower(JWeb jw) {
        String id = jw.getString("user_id");
        if (null == id || id.trim().isEmpty()) {
            return;
        }
        String[] uap = UserService.getUserPower(id);
        if (null == uap) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (String pid : uap) {
            sb.append(",{\"power_id\":\"").append(pid).append("\"}");
        }
        jw.printOne("[" + sb.substring(1) + "]");
    }

    @system.web.power.ann.SQ(value = "X3_3", scope = system.web.power.PDK.SESSION_ADMIN_KEY)
    @M("/update/role")//修改用户的角色权限
    @Validate(power.hm.user.validate.UserPowerValidate.class)
    public void updaterole() {
        String userIDs = jw.getString("user_id");
        String roleIDs = jw.getString("role_id");

        Set<String> newRolePower = new HashSet();
        Set<String> scopePower = new HashSet();
        for (String str : roleIDs.split(",")) {
            newRolePower.add(str);
        }
        AdminUser aobj = Login.getUserInfo(AdminUser.class, jw, system.web.power.PDK.SESSION_ADMIN_KEY);
        List<Role> rlist = RoleService.selectRoleByAdminUserID(aobj.getUser_id());
        if (null == rlist || rlist.isEmpty()) {//该管理员没有角色,不存在 给用户 添加角色的权限.
            return;
        }
        for (Role robj : rlist) {
            scopePower.add(robj.getRole_id());
        }
        int i = UserService.doupdateRolePower(userIDs, scopePower, newRolePower);
        jw.printOne(i == -1
                ? DBO.getJSONModel("-1", "更新权限失败：请通知管理检查服务器或数据库是否正常运行")
                : (i == 0 ? DBO.getJSONModel("0", "更新权限失败，请检查数据是否有异常。")
                        : DBO.getJSONModel("1", roleIDs.isEmpty() ? "成功取消" + i + "个用户权限！！。" : "成功给" + i + "个用户附权！！。"))
        );
    }

    @system.web.power.ann.SQ(value = "X3_4", scope = system.web.power.PDK.SESSION_ADMIN_KEY)
    @M("/update/power")//修改用户的直接权限
    @Validate(power.hm.user.validate.UserPowerValidate.class)
    public void updatePower() {
        String userid = jw.getString("user_id");
        String powerid = jw.getString("power_id");
        String strw[] = Login.getUserPower(jw, system.web.power.PDK.SESSION_ADMIN_KEY);

        Set<String> userPower = new HashSet();
        Set<String> scopePower = new HashSet();
        for (String str : powerid.split(",")) {
            userPower.add(str);
        }
        for (String str : strw) {
            scopePower.add(str);
        }
        int i = UserService.doupdateUserPower(userid, scopePower, userPower);

        jw.printOne(i == -1
                ? DBO.getJSONModel("-1", "更新权限失败：请通知管理检查服务器或数据库是否正常运行")
                : (i == 0 ? DBO.getJSONModel("0", "更新权限失败，请检查数据是否有异常。")
                        : DBO.getJSONModel("1", powerid.isEmpty() ? "成功取消" + i + "个用户直接权限！！。" : "成功给" + i + "个用户直接权限附权！！。"))
        );
    }
}
