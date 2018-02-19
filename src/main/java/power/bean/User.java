package power.bean;

/**
 *
 * @author jweb
 */
public class User {

    @system.base.annotation.ID
    private String user_id;//主键
    private String role_id;//主键
    private String power_id;//权限主键

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getPower_id() {
        return power_id;
    }

    public void setPower_id(String power_id) {
        this.power_id = power_id;
    }
    
    
}
