package power.bean;

import system.base.annotation.Table;

@Table
public class Role {

    @system.base.annotation.ID
    private String role_id;//主键
    private String jsdj_zj;//外键
    private String role_name;//角色
    private String role_info;//备注
    @system.base.annotation.Time("yyyy-MM-dd HH:mm:ss")
    private java.util.Date role_create;//
    private String power;
    private String user_id;//主键
    private String user_name;//用户名
    
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

    
    
    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    /**
     * 取 主键
     *
     * @return String
     */
    public String getRole_id() {
        return role_id;
    }

    /**
     * 设置 主键
     *
     * @param role_id
     */
    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    /**
     * 取 外键
     *
     * @return String
     */
    public String getJsdj_zj() {
        return jsdj_zj;
    }

    /**
     * 设置 外键
     *
     * @param jsdj_zj
     */
    public void setJsdj_zj(String jsdj_zj) {
        this.jsdj_zj = jsdj_zj;
    }

    /**
     * 取 角色
     *
     * @return String
     */
    public String getRole_name() {
        return role_name;
    }

    /**
     * 设置 角色
     *
     * @param role_name
     */
    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    /**
     * 取 备注
     *
     * @return String
     */
    public String getRole_info() {
        return role_info;
    }

    /**
     * 设置 备注
     *
     * @param role_info
     */
    public void setRole_info(String role_info) {
        this.role_info = role_info;
    }

    /**
     * 取
     *
     * @return java.util.Date
     */
    public java.util.Date getRole_create() {
        return role_create;
    }

    /**
     * 设置
     *
     * @param role_create
     */
    public void setRole_create(java.util.Date role_create) {
        this.role_create = role_create;
    }
}
