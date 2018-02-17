package wx.web.base.bean.tree;

@system.base.annotation.Table
public class JingyanKuFL {

    @system.base.annotation.ID
    private String jingyankufl_id;//主键
    private String jingyankufl_pid;//上级主键
    private String jingyankufl_name;//名称

    public String getJingyankufl_id() {
        return jingyankufl_id;
    }
    
    public void setJingyankufl_id(String jingyankufl_id) {
        this.jingyankufl_id = jingyankufl_id;
    }
    public String getJingyankufl_pid() {
        return jingyankufl_pid;
    }
    
    public void setJingyankufl_pid(String jingyankufl_pid) {
        this.jingyankufl_pid = jingyankufl_pid;
    }
    public String getJingyankufl_name() {
        return jingyankufl_name;
    }
    
    public void setJingyankufl_name(String jingyankufl_name) {
        this.jingyankufl_name = jingyankufl_name;
    }
}