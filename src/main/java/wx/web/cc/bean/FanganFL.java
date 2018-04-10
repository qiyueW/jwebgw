package wx.web.cc.bean;

@system.base.annotation.Table
public class FanganFL {

    @system.base.annotation.ID
    private String fanganfl_id;//主键
    private String fanganfl_pid;//上级主键
    private String fanganfl_name;//名称

    public String getFanganfl_id() {
        return fanganfl_id;
    }
    
    public void setFanganfl_id(String fanganfl_id) {
        this.fanganfl_id = fanganfl_id;
    }
    public String getFanganfl_pid() {
        return fanganfl_pid;
    }
    
    public void setFanganfl_pid(String fanganfl_pid) {
        this.fanganfl_pid = fanganfl_pid;
    }
    public String getFanganfl_name() {
        return fanganfl_name;
    }
    
    public void setFanganfl_name(String fanganfl_name) {
        this.fanganfl_name = fanganfl_name;
    }
}