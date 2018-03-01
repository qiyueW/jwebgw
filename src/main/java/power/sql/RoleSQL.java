package power.sql;

/**
 *
 * @author jweb
 */
public class RoleSQL {

    public static final String TABLE = "Role";

    final public static String getUpdatePowerSQL(final String power_id, final String role_id) {
        return " UPDATE `" + TABLE + "`"
                + " SET"
                + " `power`='" + power_id+"'"
                + " WHERE `role_id` IN(" + role_id + ")";
    }
}
