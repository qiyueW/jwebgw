package wx.web.base.bean;

public class RY{
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
//	private String rt1;//K3(账号/密码)
//	private String rt2;//远程(瑞友或其他）
//	private String rt3;//企业QQ(账号/密码)
//	private String rt4;//腾讯通(账号/密码)
//	private String rt5;//Iwork
//	private String rt6;//公司座机
//	private String rt7;//公司邮箱
//	private String rt8;//其他8
//	private String rt9;//其他9
//	private String rt10;//其他10
//	private String rtbz;//备注
	private String ry_account;//账号
	private String ry_password;//密码
//	private String dnlx;//电脑类型
//	private String dnxh;//电脑型号(品牌)
//	private String dnpz;//电脑配置(cpu及内存)
//	private String bgnl;//办公能力
//	private String dn1;//其他1
//	private String dn2;//其他2
//	private String dn3;//其他3
//	private String dn4;//其他4
//	private String yxip;//有线IP
//	private String yxmac;//有线网卡MAC
//	private String wxip;//无线IP
//	private String wxmac;//无线网卡MAC
//	private String dnbz;//备注


	/**
	* 取 主键
	* @return String
	*/
	public String getRy_id() {
		return ry_id;
	}
	/**
	* 设置 主键
	* @param ry_id
	*/
	public void setRy_id(String ry_id) {
		this.ry_id=ry_id;
	}
	/**
	* 取 部门主键
	* @return String
	*/
	public String getBm_id() {
		return bm_id;
	}
	/**
	* 设置 部门主键
	* @param bm_id
	*/
	public void setBm_id(String bm_id) {
		this.bm_id=bm_id;
	}
	/**
	* 取 部门
	* @return String
	*/
	public String getBm_name() {
		return bm_name;
	}
	/**
	* 设置 部门
	* @param bm_name
	*/
	public void setBm_name(String bm_name) {
		this.bm_name=bm_name;
	}
	/**
	* 取 岗位主键
	* @return String
	*/
	public String getGw_id() {
		return gw_id;
	}
	/**
	* 设置 岗位主键
	* @param gw_id
	*/
	public void setGw_id(String gw_id) {
		this.gw_id=gw_id;
	}
	/**
	* 取 岗位
	* @return String
	*/
	public String getGw_name() {
		return gw_name;
	}
	/**
	* 设置 岗位
	* @param gw_name
	*/
	public void setGw_name(String gw_name) {
		this.gw_name=gw_name;
	}
	/**
	* 取 入职日期
	* @return java.util.Date
	*/
	public java.util.Date getRy_cdate() {
		return ry_cdate;
	}
	/**
	* 设置 入职日期
	* @param ry_cdate
	*/
	public void setRy_cdate(java.util.Date ry_cdate) {
		this.ry_cdate=ry_cdate;
	}
	/**
	* 取 状态
	* @return Integer
	*/
	public Integer getRy_style() {
		return ry_style;
	}
	/**
	* 设置 状态
	* @param ry_style
	*/
	public void setRy_style(Integer ry_style) {
		this.ry_style=ry_style;
	}
	/**
	* 取 人员类别
	* @return Integer
	*/
	public Integer getRy_sort() {
		return ry_sort;
	}
	/**
	* 设置 人员类别
	* @param ry_sort
	*/
	public void setRy_sort(Integer ry_sort) {
		this.ry_sort=ry_sort;
	}
	/**
	* 取 姓名
	* @return String
	*/
	public String getRy_name() {
		return ry_name;
	}
	/**
	* 设置 姓名
	* @param ry_name
	*/
	public void setRy_name(String ry_name) {
		this.ry_name=ry_name;
	}
	/**
	* 取 性别
	* @return String
	*/
	public String getRy_sex() {
		return ry_sex;
	}
	/**
	* 设置 性别
	* @param ry_sex
	*/
	public void setRy_sex(String ry_sex) {
		this.ry_sex=ry_sex;
	}
	/**
	* 取 邮箱
	* @return String
	*/
	public String getRy_email() {
		return ry_email;
	}
	/**
	* 设置 邮箱
	* @param ry_email
	*/
	public void setRy_email(String ry_email) {
		this.ry_email=ry_email;
	}
	/**
	* 取 通信
	* @return String
	*/
	public String getRy_phone() {
		return ry_phone;
	}
	/**
	* 设置 通信
	* @param ry_phone
	*/
	public void setRy_phone(String ry_phone) {
		this.ry_phone=ry_phone;
	}
	/**
	* 取 备注
	* @return String
	*/
	public String getRy_info() {
		return ry_info;
	}
	/**
	* 设置 备注
	* @param ry_info
	*/
	public void setRy_info(String ry_info) {
		this.ry_info=ry_info;
	}
//	/**
//	* 取 K3(账号/密码)
//	* @return String
//	*/
//	public String getRt1() {
//		return rt1;
//	}
//	/**
//	* 设置 K3(账号/密码)
//	* @param rt1
//	*/
//	public void setRt1(String rt1) {
//		this.rt1=rt1;
//	}
//	/**
//	* 取 远程(瑞友或其他）
//	* @return String
//	*/
//	public String getRt2() {
//		return rt2;
//	}
//	/**
//	* 设置 远程(瑞友或其他）
//	* @param rt2
//	*/
//	public void setRt2(String rt2) {
//		this.rt2=rt2;
//	}
//	/**
//	* 取 企业QQ(账号/密码)
//	* @return String
//	*/
//	public String getRt3() {
//		return rt3;
//	}
//	/**
//	* 设置 企业QQ(账号/密码)
//	* @param rt3
//	*/
//	public void setRt3(String rt3) {
//		this.rt3=rt3;
//	}
//	/**
//	* 取 腾讯通(账号/密码)
//	* @return String
//	*/
//	public String getRt4() {
//		return rt4;
//	}
//	/**
//	* 设置 腾讯通(账号/密码)
//	* @param rt4
//	*/
//	public void setRt4(String rt4) {
//		this.rt4=rt4;
//	}
//	/**
//	* 取 Iwork
//	* @return String
//	*/
//	public String getRt5() {
//		return rt5;
//	}
//	/**
//	* 设置 Iwork
//	* @param rt5
//	*/
//	public void setRt5(String rt5) {
//		this.rt5=rt5;
//	}
//	/**
//	* 取 公司座机
//	* @return String
//	*/
//	public String getRt6() {
//		return rt6;
//	}
//	/**
//	* 设置 公司座机
//	* @param rt6
//	*/
//	public void setRt6(String rt6) {
//		this.rt6=rt6;
//	}
//	/**
//	* 取 公司邮箱
//	* @return String
//	*/
//	public String getRt7() {
//		return rt7;
//	}
//	/**
//	* 设置 公司邮箱
//	* @param rt7
//	*/
//	public void setRt7(String rt7) {
//		this.rt7=rt7;
//	}
//	/**
//	* 取 其他8
//	* @return String
//	*/
//	public String getRt8() {
//		return rt8;
//	}
//	/**
//	* 设置 其他8
//	* @param rt8
//	*/
//	public void setRt8(String rt8) {
//		this.rt8=rt8;
//	}
//	/**
//	* 取 其他9
//	* @return String
//	*/
//	public String getRt9() {
//		return rt9;
//	}
//	/**
//	* 设置 其他9
//	* @param rt9
//	*/
//	public void setRt9(String rt9) {
//		this.rt9=rt9;
//	}
//	/**
//	* 取 其他10
//	* @return String
//	*/
//	public String getRt10() {
//		return rt10;
//	}
//	/**
//	* 设置 其他10
//	* @param rt10
//	*/
//	public void setRt10(String rt10) {
//		this.rt10=rt10;
//	}
//	/**
//	* 取 备注
//	* @return String
//	*/
//	public String getRtbz() {
//		return rtbz;
//	}
//	/**
//	* 设置 备注
//	* @param rtbz
//	*/
//	public void setRtbz(String rtbz) {
//		this.rtbz=rtbz;
//	}
	/**
	* 取 账号
	* @return String
	*/
	public String getRy_account() {
		return ry_account;
	}
	/**
	* 设置 账号
	* @param ry_account
	*/
	public void setRy_account(String ry_account) {
		this.ry_account=ry_account;
	}
	/**
	* 取 密码
	* @return String
	*/
	public String getRy_password() {
		return ry_password;
	}
	/**
	* 设置 密码
	* @param ry_password
	*/
	public void setRy_password(String ry_password) {
		this.ry_password=ry_password;
	}
//	/**
//	* 取 电脑类型
//	* @return String
//	*/
//	public String getDnlx() {
//		return dnlx;
//	}
//	/**
//	* 设置 电脑类型
//	* @param dnlx
//	*/
//	public void setDnlx(String dnlx) {
//		this.dnlx=dnlx;
//	}
//	/**
//	* 取 电脑型号(品牌)
//	* @return String
//	*/
//	public String getDnxh() {
//		return dnxh;
//	}
//	/**
//	* 设置 电脑型号(品牌)
//	* @param dnxh
//	*/
//	public void setDnxh(String dnxh) {
//		this.dnxh=dnxh;
//	}
//	/**
//	* 取 电脑配置(cpu及内存)
//	* @return String
//	*/
//	public String getDnpz() {
//		return dnpz;
//	}
//	/**
//	* 设置 电脑配置(cpu及内存)
//	* @param dnpz
//	*/
//	public void setDnpz(String dnpz) {
//		this.dnpz=dnpz;
//	}
//	/**
//	* 取 办公能力
//	* @return String
//	*/
//	public String getBgnl() {
//		return bgnl;
//	}
//	/**
//	* 设置 办公能力
//	* @param bgnl
//	*/
//	public void setBgnl(String bgnl) {
//		this.bgnl=bgnl;
//	}
//	/**
//	* 取 其他1
//	* @return String
//	*/
//	public String getDn1() {
//		return dn1;
//	}
//	/**
//	* 设置 其他1
//	* @param dn1
//	*/
//	public void setDn1(String dn1) {
//		this.dn1=dn1;
//	}
//	/**
//	* 取 其他2
//	* @return String
//	*/
//	public String getDn2() {
//		return dn2;
//	}
//	/**
//	* 设置 其他2
//	* @param dn2
//	*/
//	public void setDn2(String dn2) {
//		this.dn2=dn2;
//	}
//	/**
//	* 取 其他3
//	* @return String
//	*/
//	public String getDn3() {
//		return dn3;
//	}
//	/**
//	* 设置 其他3
//	* @param dn3
//	*/
//	public void setDn3(String dn3) {
//		this.dn3=dn3;
//	}
//	/**
//	* 取 其他4
//	* @return String
//	*/
//	public String getDn4() {
//		return dn4;
//	}
//	/**
//	* 设置 其他4
//	* @param dn4
//	*/
//	public void setDn4(String dn4) {
//		this.dn4=dn4;
//	}
//	/**
//	* 取 有线IP
//	* @return String
//	*/
//	public String getYxip() {
//		return yxip;
//	}
//	/**
//	* 设置 有线IP
//	* @param yxip
//	*/
//	public void setYxip(String yxip) {
//		this.yxip=yxip;
//	}
//	/**
//	* 取 有线网卡MAC
//	* @return String
//	*/
//	public String getYxmac() {
//		return yxmac;
//	}
//	/**
//	* 设置 有线网卡MAC
//	* @param yxmac
//	*/
//	public void setYxmac(String yxmac) {
//		this.yxmac=yxmac;
//	}
//	/**
//	* 取 无线IP
//	* @return String
//	*/
//	public String getWxip() {
//		return wxip;
//	}
//	/**
//	* 设置 无线IP
//	* @param wxip
//	*/
//	public void setWxip(String wxip) {
//		this.wxip=wxip;
//	}
//	/**
//	* 取 无线网卡MAC
//	* @return String
//	*/
//	public String getWxmac() {
//		return wxmac;
//	}
//	/**
//	* 设置 无线网卡MAC
//	* @param wxmac
//	*/
//	public void setWxmac(String wxmac) {
//		this.wxmac=wxmac;
//	}
//	/**
//	* 取 备注
//	* @return String
//	*/
//	public String getDnbz() {
//		return dnbz;
//	}
//	/**
//	* 设置 备注
//	* @param dnbz
//	*/
//	public void setDnbz(String dnbz) {
//		this.dnbz=dnbz;
//	}
	}