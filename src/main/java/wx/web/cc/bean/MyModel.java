package wx.web.cc.bean;

@system.base.annotation.Table
public class MyModel {

    @system.base.annotation.ID
    private String mymodel_zj;// 主键
    private String mybean_zj;// 父主键
    private String mybean_mc;// 父名称
    private String mymodel_mc;// 备注
    private String mymodel_nr;// Date格式

    public String getMymodel_zj() {
        return mymodel_zj;
    }

    public void setMymodel_zj(String mymodel_zj) {
        this.mymodel_zj = mymodel_zj;
    }

    public String getMybean_zj() {
        return mybean_zj;
    }

    public void setMybean_zj(String mybean_zj) {
        this.mybean_zj = mybean_zj;
    }

    public String getMybean_mc() {
        return mybean_mc;
    }

    public void setMybean_mc(String mybean_mc) {
        this.mybean_mc = mybean_mc;
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
