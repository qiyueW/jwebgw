package power.bean;

/**
 *
 * @author jweb
 */
public class SuperAdmin {

    @system.base.annotation.ID
    private String user_id;//主键
    private String user_name;//权限主键
    private String user_account;//账号
    private String user_password;//密码
    private String user_uptimelogin;//上次登陆时间
    private String user_email;//邮箱
    private String power_id;//权限主键集合

    public String getUser_uptimelogin() {
        return user_uptimelogin;
    }

    public void setUser_uptimelogin(String user_uptimelogin) {
        this.user_uptimelogin = user_uptimelogin;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getPower_id() {
        return power_id;
    }

    public void setPower_id(String power_id) {
        this.power_id = power_id;
    }
}
