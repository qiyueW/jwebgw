package wx.web.cc.bean;

@system.base.annotation.Table
public class CModelFL {

    @system.base.annotation.ID
    private String cmodelfl_id;//主键
    private String cmodelfl_pid;//上级主键
    private String cmodelfl_name;//名称

    public String getCmodelfl_id() {
        return cmodelfl_id;
    }
    
    public void setCmodelfl_id(String cmodelfl_id) {
        this.cmodelfl_id = cmodelfl_id;
    }
    public String getCmodelfl_pid() {
        return cmodelfl_pid;
    }
    
    public void setCmodelfl_pid(String cmodelfl_pid) {
        this.cmodelfl_pid = cmodelfl_pid;
    }
    public String getCmodelfl_name() {
        return cmodelfl_name;
    }
    
    public void setCmodelfl_name(String cmodelfl_name) {
        this.cmodelfl_name = cmodelfl_name;
    }
}