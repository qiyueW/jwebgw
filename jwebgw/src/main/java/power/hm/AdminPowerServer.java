package power.hm;

import java.util.Arrays;
import power.bean.AdminUser;
import power.bean.Role;
import power.powerdata.PDConfig;
import power.service.AdminService;
import power.service.RoleService;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.PDK;
import system.web.power.ann.DL;
import system.web.power.ann.GG;
import system.web.power.session.Login;

/**
 *
 * @author jweb
 */
@DL(PDK.SESSION_ADMIN_KEY) //管理员登陆
@H("/sys/admin/manager")
public class AdminPowerServer {

    @M("/v/showMenu")//列出管理员的菜单
    public static void selectVMenu(JWeb jw) {
        jw.printOne(PDConfig.AP.getMyPowerByTrue_Or_GetMyViewByFalse(Login.getUserPower(jw, PDK.SESSION_ADMIN_KEY), false));
    }

    @M("/p/showMenu")//管理员登陆后，获得可分配给用户的权限集合
    public static void select(JWeb jw) {//P_SuperAdmin_ListJSON
        jw.printOne(PDConfig.AP.getMyPowerByTrue_Or_GetMyViewByFalse(Login.getUserPower(jw, PDK.SESSION_ADMIN_KEY), true));
    }

    @M("/p/showMenu/role")//列出角色的菜单权限
    public static void selectVMenu_role(JWeb jw) {
        String id = jw.getString("role_id");
        if (null == id || id.trim().length() != 24) {
            jw.printOne("[]");
            return;
        }
        Role obj = RoleService.selectRolePower(id);
        if (null == obj || null == obj.getRole_id()) {
            return;
        }
        String power = obj.getPower();
        if (null == power || power.isEmpty()) {
            jw.printOne("[]");
            return;
        }
        jw.printOne(PDConfig.AP.getMyPowerByTrue_Or_GetMyViewByFalse(power.split(","), true));
    }

    @GG
    @M("/login")
    public static void login(JWeb jw) {
        String account = jw.getString("account");
        String password = jw.getString("password");
        if (null == account || account.trim().isEmpty() || null == password || password.trim().isEmpty()) {
            return;
        }
        AdminUser admin = AdminService.selectOneAdmin(account, password);
        if (admin == null) {
            return;
        }
        if (null == admin.getUser_id()) {
            jw.printOne("0");//text:0//账号或密码不对
            return;
        }
//        System.out.println(admin.getPower_id());
        Login.login(jw, admin, admin.getPower_id().split(","), PDK.SESSION_ADMIN_KEY);
        jw.printOne(1);
    }

    @GG
    @M("/loginOut")
    public static void loginOut(JWeb jw) {
        Login.out(jw, PDK.SESSION_ADMIN_KEY);
        jw.sendRedirect("/loginByAdmin.jsp");
    }

}
