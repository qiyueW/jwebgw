package wx.web.cc.bean;

@system.base.annotation.Table
public class BeanField {

    @system.base.annotation.ID
    private String beanfield_zj;// 主键
    private String beanfield_mc;// 名称
    private String beanfield_bz;// 备注
    private Integer beanfield_px;//排序
    private String bean_zj;// 外键主键
    private String bean_mc;// 外键名称

    public String getBeanfield_zj() {
        return beanfield_zj;
    }

    public void setBeanfield_zj(String beanfield_zj) {
        this.beanfield_zj = beanfield_zj;
    }

    public String getBeanfield_mc() {
        return beanfield_mc;
    }

    public void setBeanfield_mc(String beanfield_mc) {
        this.beanfield_mc = beanfield_mc;
    }

    public String getBeanfield_bz() {
        return beanfield_bz;
    }

    public void setBeanfield_bz(String beanfield_bz) {
        this.beanfield_bz = beanfield_bz;
    }

    public Integer getBeanfield_px() {
        return beanfield_px;
    }

    public void setBeanfield_px(Integer beanfield_px) {
        this.beanfield_px = beanfield_px;
    }

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

}
