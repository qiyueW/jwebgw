package power.hm;

import power.powerdata.PDConfig;
import power.service.UserService;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.ann.DL;
import system.web.power.ann.GG;
import system.web.power.session.Login;
import wx.web.base.bean.RY;
import wx.web.base.dao.RYDao;

/**
 *
 * @author jweb
 */
@DL //管理员登陆
@H("/sys/user/manager")
public class UserPowerServer {

    @M("/v/showMenu")//列出管理员的菜单
    public static void selectVMenu(JWeb jw) {
        jw.printOne(PDConfig.UP.getMyPowerByTrue_Or_GetMyViewByFalse(Login.getUserPower(jw), false));
    }

    @GG
    @M("/login/user")
    public static void login_user(JWeb jw) {
        String account = jw.getString("account");
        String password = jw.getString("password");
        if (null == account || account.trim().isEmpty() || null == password || password.trim().isEmpty()) {
            return;
        }
        RY ry = RYDao.selectOneByAccountAndName(account, password);
        if (ry == null) {
            return;
        }
        if (null == ry.getRy_id()) {
            jw.printOne("0");//text:0//账号或密码不对
            return;
        }
        Login.login(jw, ry, UserService.getUserPower(ry.getRy_id()));
        jw.printOne(1);
    }

    @GG
    @M("/loginOut")
    public static void loginOut(JWeb jw) {
        Login.out(jw);
        jw.sendRedirect("/loginUser.jsp");
    }

}
