package power.bean;

public class AdminUser {

    @system.base.annotation.ID
    private String user_id;//主键
    private String user_name;//用户名
    private String bm_id;//主键
    private String bm_name;//用户名
    private String user_account;//账号
    private String user_password;//密码
    private String user_uptimelogin;//上次登陆时间
    private String user_email;//邮箱
    private String power_id;//权限集合
    private String user_sort;//类别
    private String user_style;//状态
    private String user_time;//创建时间

    /**
     * 取 主键
     *
     * @return String
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     * 设置 主键
     *
     * @param user_id
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getBm_id() {
        return bm_id;
    }

    public void setBm_id(String bm_id) {
        this.bm_id = bm_id;
    }

    public String getBm_name() {
        return bm_name;
    }

    public void setBm_name(String bm_name) {
        this.bm_name = bm_name;
    }

    /**
     * 取 用户名
     *
     * @return String
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * 设置 用户名
     *
     * @param user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * 取 账号
     *
     * @return String
     */
    public String getUser_account() {
        return user_account;
    }

    /**
     * 设置 账号
     *
     * @param user_account
     */
    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    /**
     * 取 密码
     *
     * @return String
     */
    public String getUser_password() {
        return user_password;
    }

    /**
     * 设置 密码
     *
     * @param user_password
     */
    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    /**
     * 取 上次登陆时间
     *
     * @return String
     */
    public String getUser_uptimelogin() {
        return user_uptimelogin;
    }

    /**
     * 设置 上次登陆时间
     *
     * @param user_uptimelogin
     */
    public void setUser_uptimelogin(String user_uptimelogin) {
        this.user_uptimelogin = user_uptimelogin;
    }

    /**
     * 取 邮箱
     *
     * @return String
     */
    public String getUser_email() {
        return user_email;
    }

    /**
     * 设置 邮箱
     *
     * @param user_email
     */
    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    /**
     * 取 权限集合
     *
     * @return String
     */
    public String getPower_id() {
        return power_id;
    }

    /**
     * 设置 权限集合
     *
     * @param power_id
     */
    public void setPower_id(String power_id) {
        this.power_id = power_id;
    }

    /**
     * 取 类别
     *
     * @return String
     */
    public String getUser_sort() {
        return user_sort;
    }

    /**
     * 设置 类别
     *
     * @param user_sort
     */
    public void setUser_sort(String user_sort) {
        this.user_sort = user_sort;
    }

    /**
     * 取 状态
     *
     * @return String
     */
    public String getUser_style() {
        return user_style;
    }

    /**
     * 设置 状态
     *
     * @param user_style
     */
    public void setUser_style(String user_style) {
        this.user_style = user_style;
    }

    /**
     * 取 创建时间
     *
     * @return String
     */
    public String getUser_time() {
        return user_time;
    }

    /**
     * 设置 创建时间
     *
     * @param user_time
     */
    public void setUser_time(String user_time) {
        this.user_time = user_time;
    }
}
