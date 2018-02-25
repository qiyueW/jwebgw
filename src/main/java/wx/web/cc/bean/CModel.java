package wx.web.cc.bean;

/**
 *
 * @author adm.wangchunzi
 */
public class CModel {

    @system.base.annotation.ID
    private String cmodel_zj;//主键
    private String cmodel_mc;//模型名
    private String cmodel_nr;//模型内容

    /**
     * 取得 主键
     *
     * @return String
     */
    public String getCmodel_zj() {
        return this.cmodel_zj;
    }

    /**
     * 设置 主键
     *
     * @param cmodel_zj String
     */
    public void setCmodel_zj(String cmodel_zj) {
        this.cmodel_zj = cmodel_zj;
    }

    /**
     * 取得 模型名
     *
     * @return String
     */
    public String getCmodel_mc() {
        return this.cmodel_mc;
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
     * 取得 模型内容
     *
     * @return String
     */
    public String getCmodel_nr() {
        return this.cmodel_nr;
    }

    /**
     * 设置 模型内容
     *
     * @param cmodel_nr String
     */
    public void setCmodel_nr(String cmodel_nr) {
        this.cmodel_nr = cmodel_nr;
    }

}
