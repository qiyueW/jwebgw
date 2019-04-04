package power.service;

import configuration.DBO;
import java.util.List;
import power.bean.AdminUser;
import power.sql.UserAdminSQL;
import system.base.date.DateService;

/**
 *
 * @author jweb
 */
public final class AdminService {
//    private String user_account;//账号
//    private String user_password;//密码

    static {
        AdminUser u = DBO.service.S.selectOneByCondition(AdminUser.class, "WHERE  user_sort='0-01'");
        if (null == u.getUser_id()) {
            u.setUser_account("superadmin#");
            u.setUser_password("superadmin#");
            u.setUser_name("超级管理员");
            u.setUser_sort("0-01");
            u.setUser_style("启用");
            u.setPower_id("");
            u.setUser_time(DateService.getNowTime());
        }
        DBO.service.A.addOne(u, "user_account");
    }

    public static AdminUser selectOneAdmin(String id) {
        return DBO.service.S.selectOneByCondition(AdminUser.class,
                "WHERE  user_sort='管理员' AND user_id='" + id + "'");
    }

    public static AdminUser selectOneAdmin(String account, String password) {
        return DBO.service.S.selectOneByCondition(AdminUser.class,
                "WHERE  user_sort='管理员' AND  user_style='启用'  AND user_account='" + account + "' AND user_password='" + password + "'");
    }

    public static AdminUser selectOneSuperAdmin(String account, String password) {
        return DBO.service.S.selectOneByCondition(AdminUser.class,
                "WHERE  user_sort='0-01'AND  user_style='启用'  AND user_account='" + account + "' AND user_password='" + password + "'");
    }
    
    public static List<AdminUser> selectAll(boolean showOK) {
        return DBO.service.S.selectByCondition(AdminUser.class, "WHERE user_sort='管理员'" + (showOK ? " AND  user_style='启用' " : ""));
    }

    public static List<AdminUser> selectAllByBMNull(boolean showOK) {
        return DBO.service.S.selectByCondition(AdminUser.class, "WHERE (bm_id IS NULL OR bm_id ='') AND user_sort='管理员'" + (showOK ? " AND  user_style='启用' " : ""));
    }

    public static List<AdminUser> selectAll(boolean showOK, String bmID) {
        return DBO.service.S.selectByCondition(AdminUser.class, "WHERE bm_id IN('" + bmID + "') AND  user_sort='管理员'" + (showOK ? " AND  user_style='启用' " : ""));
    }

    /**
     * 给用户添加直接权限
     *
     * @param userIDs
     * @param powerIDs
     * @return
     */
    public static int updateUserPower(String userIDs, String powerIDs) {
        return DBO.service.ADUS.executeUpdate(UserAdminSQL.setUserPowerSQL(userIDs, powerIDs));
    }

    public static int updateStyle(String ids) {
        List<AdminUser> la = DBO.service.S.selectByCondition(AdminUser.class,
                "WHERE user_sort='管理员' AND user_id IN(" + ids + ")"
        );
        StringBuilder ON = new StringBuilder();//启用
        StringBuilder OFF = new StringBuilder();//停用
        for (AdminUser obj : la) {
            (obj.getUser_style().equals("启用") ? ON : OFF).append(",'").append(obj.getUser_id()).append("'");
        }
        boolean notON, notOFF;
        notON = ON.length() == 0;
        notOFF = OFF.length() == 0;
        if (notON && notOFF) {
            return -1;
        }
        if (notON) {
            return DBO.service.ADUS.executeUpdate("UPDATE AdminUser SET user_style='启用' WHERE user_id IN(" + OFF.substring(1) + ")");
        }
        if (notOFF) {
            return DBO.service.ADUS.executeUpdate("UPDATE AdminUser SET user_style='停用' WHERE user_id IN(" + ON.substring(1) + ")");
        }
        int[] i = DBO.service.ADUS.executeBatch(
                "UPDATE AdminUser SET user_style='停用'  WHERE user_id IN(" + ON.substring(1) + ")",
                "UPDATE AdminUser SET user_style='启用'  WHERE user_id IN(" + OFF.substring(1) + ")"
        );
        return null == i ? -1 : i[0] + i[1];
    }

}
