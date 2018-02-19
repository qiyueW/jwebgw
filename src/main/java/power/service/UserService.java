package power.service;

import configuration.DBO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import power.bean.Role;
import power.bean.User;
import power.sql.UserSQL;

/**
 *
 * @author jweb
 */
public final class UserService {

    /**
     * 给用户添加角色权限
     *
     * @param userIDs
     * @param scopePower
     * @param  newPower 
     * @return
     */
    public static int doupdateRolePower(String userIDs, Set<String> scopePower, Set<String> newPower) {
         List<User> list = initUserData(userIDs);
        if (null == list) {
            return -1;
        }
        String[] sql = new String[list.size()];
        int i = 0;
        for (User obj : list) {
            sql[i++] = getOneUserPowerUpdate_Role(obj, scopePower, newPower);
        }
        int[] x = DBO.service.ADUS.executeBatch(sql);
        if (null == x) {
            return -1;
        }
        int resum = 0;
        for (int j = 0; j < x.length; j++) {
            resum = resum + x[j];
        }
        return resum;
    }

    public static int doupdateUserPower(String userIDs, Set<String> scopePower, Set<String> newPower) {
        List<User> list = initUserData(userIDs);
        if (null == list) {
            return -1;
        }
        String[] sql = new String[list.size()];
        int i = 0;
        for (User obj : list) {
            sql[i++] = getOneUserPowerUpdate_Power(obj, scopePower, newPower);
        }
        int[] x = DBO.service.ADUS.executeBatch(sql);
        if (null == x) {
            return -1;
        }
        int resum = 0;
        for (int j = 0; j < x.length; j++) {
            resum = resum + x[j];
        }
        return resum;
    }

    /**
     * 获得用户权限
     *
     * @param user_id
     * @return
     */
    public static String[] getUserPower(String user_id) {
        User u = DBO.service.S.selectOneByID(User.class, user_id);
        if (null == u || null == u.getUser_id()) {
            return new String[]{};
        }
        String rid = u.getRole_id();
        String pid = u.getPower_id();
        Set<String> set = new HashSet();
        //对直接的权限先装箱。
        for (String p : pid.split(",")) {
            set.add(p);//加入权限集合，自动去重复。
        }
        //对角色权限先进行判断。如果非空，进行检查角色权限。
        if (!rid.isEmpty()) {
            //列出所有相关角色的信息。
            List<Role> lr = DBO.service.S.selectByCondition(Role.class, "WHERE role_id in('" + rid.replace(",", "','") + "')");
            for (Role R : lr) {//检查每个角色
                for (String p : R.getPower().split(",")) {//检查每个角色的权限
                    set.add(p);//有权限，加入集合。
                }
            }
        }
        return set.toArray(new String[set.size()]);
    }

    /**
     * 清除1个或多个用户权限。用户ID格式："sdf,sd1,qwe2"
     *
     * @param userIDs
     * @return
     */
    public static int clearOneUserAllPower(String userIDs) {
        return DBO.service.ADUS.executeUpdate(UserSQL.clearUserAllPowerSQL(userIDs));
    }

    /**
     * 从obj提取旧权限。从旧权限中，先把管理员的权限（scopePower）清空，再从新加入管理给的权限（newPower）。
     *
     * @param obj 用户信息
     * @param scopePower 管理员的权限范围
     * @param newPower 管理员给用户的新权限
     * @return
     */
    private static String getOneUserPowerUpdate_Power(User obj, Set<String> scopePower, Set<String> newPower) {
        boolean mye = null == obj.getPower_id() || obj.getPower_id().isEmpty();
        boolean newe = null == newPower || newPower.isEmpty();
        if (mye && newe) {
            return null;//无需变更 无需理会
        }
        Set<String> objPower = new HashSet();

        if (!mye) {//格式化我的权限成 集合
            for (String str : obj.getPower_id().split(",")) {
                objPower.add(str);
            }
        }
        objPower.removeAll(scopePower);//首先把此管理员的旧权限清空
        objPower.addAll(newPower);//更新此管理员 给的新权限
        StringBuilder sb = new StringBuilder();
        for (String str : objPower) {
            sb.append(",").append(str);
        }
        return UserSQL.setUserPowerSQL("'" + obj.getUser_id() + "'", sb.length() == 0 ? "" : sb.substring(1));
    }

    
    /**
     * 从obj提取旧权限。从旧权限中，先把管理员的角色权限（scopeRoleIDs）清空，再从新加入管理给的角色权限（newRoleIDs）。
     *
     * @param obj 用户信息
     * @param scopeRoleIDs 管理员的角色权限范围
     * @param newRoleIDs 管理员给用户的新角色权限
     * @return
     */
    private static String getOneUserPowerUpdate_Role(User obj, Set<String> scopeRoleIDs, Set<String> newRoleIDs) {
        boolean mye = null == obj.getRole_id() || obj.getRole_id().isEmpty();
        boolean newe = null == newRoleIDs || newRoleIDs.isEmpty();
        if (mye && newe) {
            return null;//无需变更 无需理会
        }
        Set<String> objPower = new HashSet();

        if (!mye) {//格式化我的权限成 集合
            for (String str : obj.getRole_id().split(",")) {
                objPower.add(str);
            }
        }
        objPower.removeAll(scopeRoleIDs);//首先把此管理员的旧权限清空
        objPower.addAll(newRoleIDs);//更新此管理员 给的新权限
        StringBuilder sb = new StringBuilder();
        for (String str : objPower) {
            sb.append(",").append(str);
        }
        return UserSQL.setUserRoleSQL("'" + obj.getUser_id() + "'", sb.length() == 0 ? "" : sb.substring(1));
    }
    
    
    /**
     * 执行 修改前，先把用户基本信息填 写到User表中。确保修改时不会出现没此用户异常
     *
     * @param userIDs
     * @return List<User>|null 如果是null,表示填入用户基本信息时出错！
     */
    private static List<User> initUserData(String userIDs) {
        List<User> list = new ArrayList<>();
        User user;
        int i;
        for (String id : userIDs.split(",")) {
            user = DBO.service.S.selectOneByID(User.class, id);
            if (null == user) {//执行出错
                return null;
            } else if (null == user.getUser_id()) {//没找到数据。
                user.setUser_id(id);//设置手动ID
                user.setPower_id("");//指在查询操作时，不用进行null判断。
                user.setRole_id("");//指在查询操作时，不用进行null判断。
                i = DBO.service.A.addOneByMyID(user);//先添加一个空数据进去。
                if (i != 1) {//如果添加失败，退出更新权限操作。
                    return null;
                }
            }
            list.add(user);//可操作的人员集合
        }
        return list;
    }

}
