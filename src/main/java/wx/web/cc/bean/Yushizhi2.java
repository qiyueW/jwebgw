package wx.web.cc.bean;

@system.base.annotation.Table
public class Yushizhi2 {

    @system.base.annotation.ID
    private String yushizhi2_zj;// 主键
    private String yushizhi2_bz;// 备注
    private String yushizhi2_key;// 键
    private String yushizhi2_value;// 值
    private String yushizhi_zj;// 领头-主键

    /**
     * 设置 主键
     *
     * @param yushizhi2_zj String
     */
    public void setYushizhi2_zj(String yushizhi2_zj) {
        this.yushizhi2_zj = yushizhi2_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getYushizhi2_zj() {
        return this.yushizhi2_zj;
    }

    /**
     * 设置 备注
     *
     * @param yushizhi2_bz String
     */
    public void setYushizhi2_bz(String yushizhi2_bz) {
        this.yushizhi2_bz = yushizhi2_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getYushizhi2_bz() {
        return this.yushizhi2_bz;
    }

    /**
     * 设置 键
     *
     * @param yushizhi2_key String
     */
    public void setYushizhi2_key(String yushizhi2_key) {
        this.yushizhi2_key = yushizhi2_key;
    }

    /**
     * 取得 键
     *
     * @return String
     */
    public String getYushizhi2_key() {
        return this.yushizhi2_key;
    }

    /**
     * 设置 值
     *
     * @param yushizhi2_value String
     */
    public void setYushizhi2_value(String yushizhi2_value) {
        this.yushizhi2_value = yushizhi2_value;
    }

    /**
     * 取得 值
     *
     * @return String
     */
    public String getYushizhi2_value() {
        return this.yushizhi2_value;
    }

    /**
     * 设置 领头-主键
     *
     * @param yushizhi_zj String
     */
    public void setYushizhi_zj(String yushizhi_zj) {
        this.yushizhi_zj = yushizhi_zj;
    }

    /**
     * 取得 领头-主键
     *
     * @return String
     */
    public String getYushizhi_zj() {
        return this.yushizhi_zj;
    }
}
