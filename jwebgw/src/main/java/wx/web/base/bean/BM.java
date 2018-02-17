package wx.web.base.bean;

import system.base.annotation.ID;

/**
 *
 * @author WangChunZi
 */
public class BM {
    @ID
    private String bm_id;
//    @C(l = 26, type = "char")
    private String bm_pid;
//    @C(l = 50, type = "char")
    private String bm_name;
    
	public String getBm_id() {
		return bm_id;
	}
	public void setBm_id(String bm_id) {
		this.bm_id = bm_id;
	}
	public String getBm_pid() {
		return bm_pid;
	}
	public void setBm_pid(String bm_pid) {
		this.bm_pid = bm_pid;
	}
	public String getBm_name() {
		return bm_name;
	}
	public void setBm_name(String bm_name) {
		this.bm_name = bm_name;
	} 
    
    
}
