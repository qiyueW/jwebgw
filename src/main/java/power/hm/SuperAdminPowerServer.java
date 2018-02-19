package power.hm;

import power.bean.AdminUser;
import power.powerdata.PDConfig;
import power.service.AdminService;
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
@DL(PDK.SESSION_SUPER_ADMIN_KEY) //管理员登陆
@H("/sys/superadmin/manager")
public class SuperAdminPowerServer {

    @M("/v/showMenu")//列出管理员的菜单
    public static void selectVMenu(JWeb jw) {//_ListJSON
        jw.printOne(PDConfig.SAP.vPowerJson_all);
//        jw.request.setAttribute("ListJson", PD.getViewMenue(PDConfig.keyCode.XG.key));
    }

    @M("/p/showMenu")//超级管理员登陆后，获得可分配给管理员的权限完整集合
    public static void selectPJSON(JWeb jw) {//_SuperAdmin_List
//        jw.request.setAttribute("ListJson", PD.getPowerMenue(PDConfig.keyCode.X.key));
        jw.printOne(PDConfig.SAP.pPowerJson_all);
    }

    @GG
    @M("/login")
    public static void login(JWeb jw) {
        String account = jw.getString("account");
        String password = jw.getString("password");
        if (null == account || account.trim().isEmpty() || null == password || password.trim().isEmpty()) {
            return;
        }
        AdminUser admin = AdminService.selectOneSuperAdmin(account, password);
        if (admin == null) {
            return;
        }
        if (null == admin.getUser_id()) {
            jw.printOne("0");//text:0//账号或密码不对
            return;
        }
        Login.login(jw, admin, admin.getPower_id().split(","), PDK.SESSION_SUPER_ADMIN_KEY);
        jw.printOne(1);
    }

    @GG
    @M("/loginOut")
    public static void loginOut(JWeb jw) {
        Login.out(jw, PDK.SESSION_SUPER_ADMIN_KEY);
        jw.sendRedirect("/loginByAdminSuper.jsp");
    }
}
