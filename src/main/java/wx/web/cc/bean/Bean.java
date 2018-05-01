package wx.web.cc.bean;

@system.base.annotation.Table
public class Bean {

    @system.base.annotation.ID
    private String bean_zj;// 主键
    private String bean_mc;// 名称
    private String mypackage_id;//主键
    private String mypackage_name;//名称
    private String bean_bz;// 备注
    private Integer bean_px;//排序

    public String getBean_zj() {
        return bean_zj;
    }

    public void setBean_zj(String bean_zj) {
        this.bean_zj = bean_zj;
    }

    public String getBean_mc() {
        return bean_mc;
    }

    public void setBean_mc(String bean_mc) {
        this.bean_mc = bean_mc;
    }

    public String getMypackage_id() {
        return mypackage_id;
    }

    public void setMypackage_id(String mypackage_id) {
        this.mypackage_id = mypackage_id;
    }

    public String getMypackage_name() {
        return mypackage_name;
    }

    public void setMypackage_name(String mypackage_name) {
        this.mypackage_name = mypackage_name;
    }

    public String getBean_bz() {
        return bean_bz;
    }

    public void setBean_bz(String bean_bz) {
        this.bean_bz = bean_bz;
    }

    public Integer getBean_px() {
        return bean_px;
    }

    public void setBean_px(Integer bean_px) {
        this.bean_px = bean_px;
    }

}
