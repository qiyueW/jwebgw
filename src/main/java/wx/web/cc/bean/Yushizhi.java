package wx.web.cc.bean;

@system.base.annotation.Table
public class Yushizhi {

    @system.base.annotation.ID
    private String yushizhi_zj;// 主键
    private String yushizhi_mc;// 名称
    private String yushizhifl_id;// 分类外键
    private String yushizhifl_name;// 分类名
    private String yushizhi_bz;// 备注
    private Integer yushizhi_px;//排序

    public Integer getYushizhi_px() {
        return yushizhi_px;
    }

    public void setYushizhi_px(Integer yushizhi_px) {
        this.yushizhi_px = yushizhi_px;
    }
    
    /**
     * 设置 主键
     *
     * @param yushizhi_zj String
     */
    public void setYushizhi_zj(String yushizhi_zj) {
        this.yushizhi_zj = yushizhi_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getYushizhi_zj() {
        return this.yushizhi_zj;
    }

    /**
     * 设置 名称
     *
     * @param yushizhi_mc String
     */
    public void setYushizhi_mc(String yushizhi_mc) {
        this.yushizhi_mc = yushizhi_mc;
    }

    /**
     * 取得 名称
     *
     * @return String
     */
    public String getYushizhi_mc() {
        return this.yushizhi_mc;
    }

    /**
     * 设置 分类外键
     *
     * @param yushizhifl_id String
     */
    public void setYushizhifl_id(String yushizhifl_id) {
        this.yushizhifl_id = yushizhifl_id;
    }

    /**
     * 取得 分类外键
     *
     * @return String
     */
    public String getYushizhifl_id() {
        return this.yushizhifl_id;
    }

    /**
     * 设置 分类名
     *
     * @param yushizhifl_name String
     */
    public void setYushizhifl_name(String yushizhifl_name) {
        this.yushizhifl_name = yushizhifl_name;
    }

    /**
     * 取得 分类名
     *
     * @return String
     */
    public String getYushizhifl_name() {
        return this.yushizhifl_name;
    }

    /**
     * 设置 备注
     *
     * @param yushizhi_bz String
     */
    public void setYushizhi_bz(String yushizhi_bz) {
        this.yushizhi_bz = yushizhi_bz;
    }

    /**
     * 取得 备注
     *
     * @return String
     */
    public String getYushizhi_bz() {
        return this.yushizhi_bz;
    }
}
