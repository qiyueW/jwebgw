package wx.web.cc.bean;

@system.base.annotation.Table
public class YushizhiFL {

    @system.base.annotation.ID
    private String yushizhifl_id;//主键
    private String yushizhifl_pid;//上级主键
    private String yushizhifl_name;//名称

    public String getYushizhifl_id() {
        return yushizhifl_id;
    }
    
    public void setYushizhifl_id(String yushizhifl_id) {
        this.yushizhifl_id = yushizhifl_id;
    }
    public String getYushizhifl_pid() {
        return yushizhifl_pid;
    }
    
    public void setYushizhifl_pid(String yushizhifl_pid) {
        this.yushizhifl_pid = yushizhifl_pid;
    }
    public String getYushizhifl_name() {
        return yushizhifl_name;
    }
    
    public void setYushizhifl_name(String yushizhifl_name) {
        this.yushizhifl_name = yushizhifl_name;
    }
}