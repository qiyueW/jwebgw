package power.hm.user;

import configuration.DBO;
import java.util.List;
import power.bean.AdminUser;
import power.bean.Role;
import power.bean.User;
import power.powerdata.PDConfig;
import power.service.UserService;
import system.base.annotation.H;
import system.web.JWeb;
import system.base.annotation.M;
import system.web.power.PDK;
import system.web.power.session.Login;
import wx.web.base.BCM;
import wx.web.base.bean.BM;
import wx.web.base.hm.bm.cache.BMCache;

@H("/sys/power/user/s")
public class UserSelect {

    @system.web.power.ann.DL(system.web.power.PDK.SESSION_ADMIN_KEY) //管理员登陆
    @M("/selectVast/myBM")///base/bm//selectVast/adminpower
    public static void selecAdminpower_ListJSON(JWeb jw) {
        AdminUser aobj = Login.getUserInfo(AdminUser.class, jw, PDK.SESSION_ADMIN_KEY);
        //全局管理员
        if (null == aobj.getBm_id() || aobj.getBm_id().isEmpty()) {
            jw.request.setAttribute("ListJson", BCM.RY_CACHE.getCacheData(BMCache.class).getList());
            return;
        }
        //非全局管理
        String where = "WHERE bm_id IN('" + aobj.getBm_id().replace("|", "','") + "')";
        List<BM> bms = DBO.service.S.selectByCondition(BM.class, where);
        jw.request.setAttribute("ListJson", bms);
    }

    @system.web.power.ann.DL(system.web.power.PDK.SESSION_ADMIN_KEY) //管理员登陆
    @M("/selectOneUserAndRolePower")///sys/power/user/s/selectOneUserAndRolePower
    public static void selecViewRoleAndPower(JWeb jw) {
        String user_id = jw.getString("user_id");
        String role_id = jw.getString("role_id");
        String checkAll = jw.getString("checkAll");

        boolean buser = null == user_id || user_id.length() != 24,
                brole = null == role_id || role_id.length() != 24;
        
        if ((buser && brole) || null == checkAll) {
            jw.printOne("[]");
            return;
        }

        switch (checkAll) {
            case "3": //仅角色权限
                if (brole) {//当查询角色时,角色主键不可能为ID
                    return;
                }
                Role robj = DBO.service.S.selectOneByID(Role.class, role_id);
                //如果角色不存在(可能刚刚被人删除了),或者此角色还没分配权限,直接返回空集
                if (null == robj || null == robj.getRole_id() || null == robj.getPower() || robj.getPower().isEmpty()) {
                    jw.printOne("[]");
                    return;
                }
                jw.printOne(PDConfig.UP.getMyPowerByTrue_Or_GetMyViewByFalse(robj.getPower().split(","), false));
                break;
            case "1"://查询用户的直接权限与角色权限
                jw.printOne(PDConfig.UP.getMyPowerByTrue_Or_GetMyViewByFalse(UserService.getUserPower(user_id), false));
                break;
            case "0":
                User uobj = DBO.service.S.selectOneByID(User.class, user_id);
                //如果用户不存在(可能刚刚被人删除了),或者此用户还没分配权限,直接返回空集
                if (null == uobj || null == uobj.getUser_id() || null == uobj.getUser_id() || uobj.getPower_id().isEmpty()) {
                    jw.printOne("[]");
                    return;
                }
                jw.printOne(PDConfig.UP.getMyPowerByTrue_Or_GetMyViewByFalse(uobj.getPower_id().split(","), false));
                break;
            default:
                break;
        }
    }

    @M("/selectOneUserPower")//取得用户权限
    public static void selectOne(JWeb jw) {
        String id = jw.getString("user_id");
        if (null == id || id.trim().isEmpty()) {
            return;
        }
        User obj = DBO.service.S.selectOneByID(User.class, id);
        if (null == obj || null == obj.getRole_id()) {
            return;
        }
        if (null == obj.getPower_id() || obj.getPower_id().isEmpty()) {
            jw.printOne("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String pid : obj.getPower_id().split(",")) {
            sb.append(",{\"power_id\":\"").append(pid).append("\"}");
        }
        jw.printOne("[" + sb.substring(1) + "]");
    }

    @M("/selectOneRolePower")//取得用户权限
    public static void selectOneRole(JWeb jw) {
        String id = jw.getString("user_id");
        if (null == id || id.trim().isEmpty()) {
            return;
        }
        User obj = DBO.service.S.selectOneByID(User.class, id);
        if (null == obj || null == obj.getRole_id()) {
            return;
        }
        if (null == obj.getRole_id() || obj.getRole_id().isEmpty()) {
            jw.printOne("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String pid : obj.getRole_id().split(",")) {
            sb.append(",{\"role_id\":\"").append(pid).append("\"}");
        }
        jw.printOne("[" + sb.substring(1) + "]");
    }

}
