package wx.web.cc.bean;

@system.base.annotation.Table
public class Bean2 {

    @system.base.annotation.ID
    private String bean2_zj;// 主键
    private String bean2_bz;// 备注
    private String bean2_key;// 键
    private String bean2_value;// 值
    private String bean_zj;// 领头-主键

    public String getBean2_zj() {
        return bean2_zj;
    }
    
    public void setBean2_zj(String bean2_zj) {
        this.bean2_zj = bean2_zj;
    }

    public String getBean2_bz() {
        return bean2_bz;
    }

    public void setBean2_bz(String bean2_bz) {
        this.bean2_bz = bean2_bz;
    }

    public String getBean2_key() {
        return bean2_key;
    }

    public void setBean2_key(String bean2_key) {
        this.bean2_key = bean2_key;
    }

    public String getBean2_value() {
        return bean2_value;
    }

    public void setBean2_value(String bean2_value) {
        this.bean2_value = bean2_value;
    }

    public String getBean_zj() {
        return bean_zj;
    }

    public void setBean_zj(String bean_zj) {
        this.bean_zj = bean_zj;
    }

}
