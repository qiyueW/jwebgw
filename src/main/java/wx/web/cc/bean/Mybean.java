package wx.web.cc.bean;

@system.base.annotation.Table
public class Mybean {

    @system.base.annotation.ID
    private String mybean_zj;//主键
    private Integer mybean_px;//排序
    private String mypackage_id;//代号
    private String mybean_mc;//名称
    private String mybean_bz;//备注

    public String getMybean_zj() {
        return mybean_zj;
    }

    public void setMybean_zj(String mybean_zj) {
        this.mybean_zj = mybean_zj;
    }

    public Integer getMybean_px() {
        return mybean_px;
    }

    public void setMybean_px(Integer mybean_px) {
        this.mybean_px = mybean_px;
    }

    public String getMypackage_id() {
        return mypackage_id;
    }

    public void setMypackage_id(String mypackage_id) {
        this.mypackage_id = mypackage_id;
    }
    public String getMybean_mc() {
        return mybean_mc;
    }

    public void setMybean_mc(String mybean_mc) {
        this.mybean_mc = mybean_mc;
    }

    public String getMybean_bz() {
        return mybean_bz;
    }

    public void setMybean_bz(String mybean_bz) {
        this.mybean_bz = mybean_bz;
    }
        
    
}
