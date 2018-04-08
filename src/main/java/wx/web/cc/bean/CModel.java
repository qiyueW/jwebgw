package wx.web.cc.bean;

@system.base.annotation.Table
public class CModel {

    @system.base.annotation.ID
    private String cmodel_zj;// 主键
    private String cmodel_mc;// 模型名
    private String cmodel_nr;// 模型内容
    private String cmodelfl_id;// 外键分类
    private String cmodelfl_name;// 分类名

    /**
     * 设置 主键
     *
     * @param cmodel_zj String
     */
    public void setCmodel_zj(String cmodel_zj) {
        this.cmodel_zj = cmodel_zj;
    }

    /**
     * 取得 主键
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

    /**
     * 设置 模型内容
     *
     * @param cmodel_nr String
     */
    public void setCmodel_nr(String cmodel_nr) {
        this.cmodel_nr = cmodel_nr;
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
     * 设置 外键分类
     *
     * @param cmodelfl_id String
     */
    public void setCmodelfl_id(String cmodelfl_id) {
        this.cmodelfl_id = cmodelfl_id;
    }

    /**
     * 取得 外键分类
     *
     * @return String
     */
    public String getCmodelfl_id() {
        return this.cmodelfl_id;
    }

    /**
     * 设置 分类名
     *
     * @param cmodelfl_name String
     */
    public void setCmodelfl_name(String cmodelfl_name) {
        this.cmodelfl_name = cmodelfl_name;
    }

    /**
     * 取得 分类名
     *
     * @return String
     */
    public String getCmodelfl_name() {
        return this.cmodelfl_name;
    }
}
