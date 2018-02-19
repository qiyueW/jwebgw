package power.sql;

/**
 *
 * @author jweb
 */
public class UserAdminSQL {

    public static final String TABLE = "AdminUser";


    /**
     * 给用户添加直接权限
     *
     * @param user_id
     * @param power_id
     * @return
     */
    final public static String setUserPowerSQL(final String user_id, final String power_id) {
        return " UPDATE `" + TABLE + "`"
                + " SET"
                + " `power_id`='" + power_id + "'"
                + " WHERE `user_id` IN(" + (user_id.contains(",") ? "'" + user_id.replace(",", "','") + "'" : "'"+user_id+"'")+");";
    }

    /**
     * 清空用户所有的权限
     *
     * @param user_id
     * @return
     */
    final public static String clearUserAllPowerSQL(final String user_id) {
        return " UPDATE `" + TABLE + "`"
                + " SET"
                + " `power_id`=''"
                + " WHERE `user_id` IN(" + (user_id.contains(",") ? "'" + user_id.replace(",", "','") + "'" : "'"+user_id+"'")
                + ")";
    }
}
