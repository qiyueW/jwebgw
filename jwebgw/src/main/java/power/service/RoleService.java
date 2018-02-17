package power.service;

import configuration.DBO;
import java.util.List;
import power.bean.Role;
import power.sql.RoleSQL;

/**
 *
 * @author jweb
 */
public class RoleService {

    public static int updateRolePower(String power_id, String role_id) {
        return DBO.service.ADUS.executeUpdate(RoleSQL.getUpdatePowerSQL(power_id, role_id));
    }

    public static Role selectRolePower(String role_id) {
        return DBO.service.S.selectOneByID(Role.class, role_id);
    }

    /**
     * 检出该管理员创建的所有角色
     *
     * @param adminuser_id
     * @return
     */
    public static List<Role> selectRoleByAdminUserID(String adminuser_id) {
        return DBO.service.S.selectByCondition(Role.class, "WHERE user_id='" + adminuser_id + "'");
    }
}
