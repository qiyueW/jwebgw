package wx.web.cc.bean;

@system.base.annotation.Table
public class Fangan2 {

    private String fangan1_zj;// 父键
    @system.base.annotation.ID
    private String fangan2_zj;// 主键
//    private Integer fangan2_px;// 排序
    private String fangan2_filepath;// 文件路径
    private String fangan2_filename;// 文件名
    private String cmodel_zj;// 模型主键
    private String cmodel_mc;// 模型名
    private String fangan2_bz;// 备注

    /**
     * 设置 父键
     *
     * @param fangan1_zj String
     */
    public void setFangan1_zj(String fangan1_zj) {
        this.fangan1_zj = fangan1_zj;
    }

    /**
     * 取得 父键
     *
     * @return String
     */
    public String getFangan1_zj() {
        return this.fangan1_zj;
    }

    /**
     * 设置 主键
     *
     * @param fangan2_zj String
     */
    public void setFangan2_zj(String fangan2_zj) {
        this.fangan2_zj = fangan2_zj;
    }

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getFangan2_zj() {
        return this.fangan2_zj;
    }

    public String getFangan2_bz() {
        return fangan2_bz;
    }

    public void setFangan2_bz(String fangan2_bz) {
        this.fangan2_bz = fangan2_bz;
    }

    /**
     * 设置 文件路径
     *
     * @param fangan2_filepath String
     */
    public void setFangan2_filepath(String fangan2_filepath) {
        this.fangan2_filepath = fangan2_filepath;
    }

    /**
     * 取得 文件路径
     *
     * @return String
     */
    public String getFangan2_filepath() {
        return this.fangan2_filepath;
    }

    /**
     * 设置 文件名
     *
     * @param fangan2_filename String
     */
    public void setFangan2_filename(String fangan2_filename) {
        this.fangan2_filename = fangan2_filename;
    }

    /**
     * 取得 文件名
     *
     * @return String
     */
    public String getFangan2_filename() {
        return this.fangan2_filename;
    }

    /**
     * 设置 模型主键
     *
     * @param cmodel_zj String
     */
    public void setCmodel_zj(String cmodel_zj) {
        this.cmodel_zj = cmodel_zj;
    }

    /**
     * 取得 模型主键
     *
     * @return String
     */
    public String getCmodel_zj() {
        return this.cmodel_zj;
    }

    /**
     * 设置 模型名
     *
     * @param cmodel_mc String
     */
    public void setCmodel_mc(String cmodel_mc) {
        this.cmodel_mc = cmodel_mc;
    }

    /**
     * 取得 模型名
     *
     * @return String
     */
    public String getCmodel_mc() {
        return this.cmodel_mc;
    }
}
