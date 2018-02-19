package wx.web.base.bean.vo;

public class RYView {
	@system.base.annotation.ID
	private String ry_id;//主键
	private String bm_id;//部门主键
	private String bm_name;//部门
	private String gw_id;//岗位主键
	private String gw_name;//岗位
	@system.base.annotation.Time("yyyy-MM-dd")
	private java.util.Date ry_cdate;//入职日期
	private Integer ry_style;//状态
	private Integer ry_sort;//人员类别
	private String ry_name;//姓名
	private String ry_sex;//性别
	private String ry_email;//邮箱
	private String ry_phone;//通信
	private String ry_info;//备注
	private String ry_account;//账号
	
	
	public String getRy_id() {
		return ry_id;
	}
	public void setRy_id(String ry_id) {
		this.ry_id = ry_id;
	}
	public String getBm_id() {
		return bm_id;
	}
	public void setBm_id(String bm_id) {
		this.bm_id = bm_id;
	}
	public String getBm_name() {
		return bm_name;
	}
	public void setBm_name(String bm_name) {
		this.bm_name = bm_name;
	}
	public String getGw_id() {
		return gw_id;
	}
	public void setGw_id(String gw_id) {
		this.gw_id = gw_id;
	}
	public String getGw_name() {
		return gw_name;
	}
	public void setGw_name(String gw_name) {
		this.gw_name = gw_name;
	}
	public java.util.Date getRy_cdate() {
		return ry_cdate;
	}
	public void setRy_cdate(java.util.Date ry_cdate) {
		this.ry_cdate = ry_cdate;
	}
	public Integer getRy_style() {
		return ry_style;
	}
	public void setRy_style(Integer ry_style) {
		this.ry_style = ry_style;
	}
	public Integer getRy_sort() {
		return ry_sort;
	}
	public void setRy_sort(Integer ry_sort) {
		this.ry_sort = ry_sort;
	}
	public String getRy_name() {
		return ry_name;
	}
	public void setRy_name(String ry_name) {
		this.ry_name = ry_name;
	}
	public String getRy_sex() {
		return ry_sex;
	}
	public void setRy_sex(String ry_sex) {
		this.ry_sex = ry_sex;
	}
	public String getRy_email() {
		return ry_email;
	}
	public void setRy_email(String ry_email) {
		this.ry_email = ry_email;
	}
	public String getRy_phone() {
		return ry_phone;
	}
	public void setRy_phone(String ry_phone) {
		this.ry_phone = ry_phone;
	}
	public String getRy_info() {
		return ry_info;
	}
	public void setRy_info(String ry_info) {
		this.ry_info = ry_info;
	}
	public String getRy_account() {
		return ry_account;
	}
	public void setRy_account(String ry_account) {
		this.ry_account = ry_account;
	}
	
	
}
