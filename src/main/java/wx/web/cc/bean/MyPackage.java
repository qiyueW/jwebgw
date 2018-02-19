package wx.web.cc.bean;

@system.base.annotation.Table
public class MyPackage {

    @system.base.annotation.ID
    private String mypackage_id;//主键
    private String mypackage_pid;//上级主键
    private String mypackage_name;//名称

    public String getMypackage_id() {
        return mypackage_id;
    }
    
    public void setMypackage_id(String mypackage_id) {
        this.mypackage_id = mypackage_id;
    }
    public String getMypackage_pid() {
        return mypackage_pid;
    }
    
    public void setMypackage_pid(String mypackage_pid) {
        this.mypackage_pid = mypackage_pid;
    }
    public String getMypackage_name() {
        return mypackage_name;
    }
    
    public void setMypackage_name(String mypackage_name) {
        this.mypackage_name = mypackage_name;
    }
}