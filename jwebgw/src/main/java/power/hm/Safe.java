package power.hm;

import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import configuration.DBO;
import power.bean.AdminUser;
import system.web.power.PDK;
import system.web.power.ann.DL;
import system.web.power.session.Login;
import wx.web.base.bean.RY;

@H("/power/safe")
//@system.web.filter.annotation.JWFilter(过滤是否有权限的类)
public class Safe {

    JWeb jw;

    public Safe(JWeb jw) {
        this.jw = jw;
    }

    @DL//普通人员 修改自己的密码
    @M("/base/ry/update/mypssword")/////power/safebase/ry/update/mypssword
    public void updateMyPassword() {
        String pw0 = jw.getString("pw0");
        String pw1 = jw.getString("pw1");

        if (null == pw0 || pw0.isEmpty() || null == pw1 || pw1.isEmpty()) {
            return;
        }
        
        RY ry = Login.getUserInfo(RY.class, jw);
        if (!ry.getRy_password().equals(pw0)) {
            jw.printOne("修改不成功原因：旧密码不正确");
            return;
        }
        if (pw0.equals(pw1)) {
            jw.printOne("新旧密码一样，无需修改");
            return;
        }
        
        ry.setRy_password(pw1);
        int i = DBO.service.U.updateSome_alloy(ry, "ry_password");
        if (i == 0) {
            jw.printOne("修改失败，请通知管理员检查网络或数据库。或稍后再试。");
            ry.setRy_password(pw0);
            return;
        }
        jw.printOne("修改成功,下次登陆将启用新密码");
    }
    
    @DL(PDK.SESSION_ADMIN_KEY)//管理人员 修改自己的密码
    @M("/admin/update/mypssword")/////power/safe/admin/update/mypssword
    public void updateAdminPassword() {
        String pw0 = jw.getString("pw0");
        String pw1 = jw.getString("pw1");

        if (null == pw0 || pw0.isEmpty() || null == pw1 || pw1.isEmpty()) {
            return;
        }
        
        AdminUser ry = Login.getUserInfo(AdminUser.class, jw.session,PDK.SESSION_ADMIN_KEY);
        if (!ry.getUser_password().equals(pw0)) {
            jw.printOne("修改不成功原因：旧密码不正确");
            return;
        }
        if (pw0.equals(pw1)) {
            jw.printOne("新旧密码一样，无需修改");
            return;
        }
        
        ry.setUser_password(pw1);
        int i = DBO.service.U.updateSome_alloy(ry, "user_password");
        if (i == 0) {
            jw.printOne("修改失败，请通知管理员检查网络或数据库。或稍后再试。");
            ry.setUser_password(pw0);
            return;
        }
        jw.printOne("修改成功,下次登陆将启用新密码");
    }
    @DL(PDK.SESSION_SUPER_ADMIN_KEY)//管理人员 修改自己的密码
    @M("/super/admin/update/mypssword")/////power/safe/admin/update/mypssword
    public void updateSuperAdminPassword() {
        String pw0 = jw.getString("pw0");
        String pw1 = jw.getString("pw1");

        if (null == pw0 || pw0.isEmpty() || null == pw1 || pw1.isEmpty()) {
            return;
        }
        
        AdminUser ry = Login.getUserInfo(AdminUser.class, jw.session,PDK.SESSION_SUPER_ADMIN_KEY);
        if (!ry.getUser_password().equals(pw0)) {
            jw.printOne("修改不成功原因：旧密码不正确");
            return;
        }
        if (pw0.equals(pw1)) {
            jw.printOne("新旧密码一样，无需修改");
            return;
        }
        
        ry.setUser_password(pw1);
        int i = DBO.service.U.updateSome_alloy(ry, "user_password");
        if (i == 0) {
            jw.printOne("修改失败，请通知管理员检查网络或数据库。或稍后再试。");
            ry.setUser_password(pw0);
            return;
        }
        jw.printOne("修改成功,下次登陆将启用新密码");
    }
}
