package wx.web.cc.bean;

@system.base.annotation.Table
public class BeanField2 {

    @system.base.annotation.ID
    private String beanfield2_zj;// 主键
    private String beanfield2_bz;// 备注
    private String beanfield2_key;// 键
    private String beanfield2_value;// 值
    private String beanfield_zj;// 领头-主键

    public String getBeanfield2_zj() {
        return beanfield2_zj;
    }

    public void setBeanfield2_zj(String beanfield2_zj) {
        this.beanfield2_zj = beanfield2_zj;
    }

    public String getBeanfield2_bz() {
        return beanfield2_bz;
    }

    public void setBeanfield2_bz(String beanfield2_bz) {
        this.beanfield2_bz = beanfield2_bz;
    }

    public String getBeanfield2_key() {
        return beanfield2_key;
    }

    public void setBeanfield2_key(String beanfield2_key) {
        this.beanfield2_key = beanfield2_key;
    }

    public String getBeanfield2_value() {
        return beanfield2_value;
    }

    public void setBeanfield2_value(String beanfield2_value) {
        this.beanfield2_value = beanfield2_value;
    }

    public String getBeanfield_zj() {
        return beanfield_zj;
    }

    public void setBeanfield_zj(String beanfield_zj) {
        this.beanfield_zj = beanfield_zj;
    }

}
