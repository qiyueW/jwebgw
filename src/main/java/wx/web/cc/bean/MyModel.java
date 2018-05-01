package wx.web.cc.bean;

@system.base.annotation.Table
public class MyModel {

    @system.base.annotation.ID
    private String mymodel_zj;// 主键
    private String bean_zj;// 父主键
    private String bean_mc;// 父名称
    private String mymodel_mc;// 备注
    private String mymodel_nr;// Date格式

    public String getMymodel_zj() {
        return mymodel_zj;
    }

    public void setMymodel_zj(String mymodel_zj) {
        this.mymodel_zj = mymodel_zj;
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

    public String getMymodel_mc() {
        return mymodel_mc;
    }

    public void setMymodel_mc(String mymodel_mc) {
        this.mymodel_mc = mymodel_mc;
    }

    public String getMymodel_nr() {
        return mymodel_nr;
    }

    public void setMymodel_nr(String mymodel_nr) {
        this.mymodel_nr = mymodel_nr;
    }

}
