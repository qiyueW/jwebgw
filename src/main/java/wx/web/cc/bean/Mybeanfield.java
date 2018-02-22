package wx.web.cc.bean;

@system.base.annotation.Table
public class Mybeanfield {

	@system.base.annotation.ID
	private String mybeanfield_zj;// 主键
	private String mybean_zj;// 父主键
	private String mybean_mc;// 父名称
	private String mybeanfield_bz;// 备注
	private String mybeanfield_dateformat;// Date格式

	private String c_zyy;// 作用域
	private String c_lx;// 类型
	private String c_mc;// 属性名
	private String c_bz;// 备注
	private String c_setmethod;// set方法
	private String c_getmethod;// get方法

	private String t_mc;// t属性名 锁定等于 c属性名
	private String t_lx;// t类型
	private String t_sy;// t索引
	private String t_yxkong;// 是否为空
	private String t_cd;// 是否为空
	private String t_bz;// t备注

	private String v_zzbds;// v正则表达式
	private String v_cuowuxx;// v错误信息
	private String v_bxjiancha;// v必须检查

	private String h_lx;// h类型
	private String h_jb;// h脚本校验

	private String e_mc;// e展示名

	
	
	
	public String getT_cd() {
		return t_cd;
	}

	public void setT_cd(String t_cd) {
		this.t_cd = t_cd;
	}

	public String getMybeanfield_zj() {
		return mybeanfield_zj;
	}

	public void setMybeanfield_zj(String mybeanfield_zj) {
		this.mybeanfield_zj = mybeanfield_zj;
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

	public String getMybeanfield_bz() {
		return mybeanfield_bz;
	}

	public void setMybeanfield_bz(String mybeanfield_bz) {
		this.mybeanfield_bz = mybeanfield_bz;
	}

	public String getMybeanfield_dateformat() {
		return mybeanfield_dateformat;
	}

	public void setMybeanfield_dateformat(String mybeanfield_dateformat) {
		this.mybeanfield_dateformat = mybeanfield_dateformat;
	}

	public String getC_zyy() {
		return c_zyy;
	}

	public void setC_zyy(String c_zyy) {
		this.c_zyy = c_zyy;
	}

	public String getC_lx() {
		return c_lx;
	}

	public void setC_lx(String c_lx) {
		this.c_lx = c_lx;
	}

	public String getC_mc() {
		return c_mc;
	}

	public void setC_mc(String c_mc) {
		this.c_mc = c_mc;
	}

	public String getC_bz() {
		return c_bz;
	}

	public void setC_bz(String c_bz) {
		this.c_bz = c_bz;
	}

	public String getC_setmethod() {
		return c_setmethod;
	}

	public void setC_setmethod(String c_setmethod) {
		this.c_setmethod = c_setmethod;
	}

	public String getC_getmethod() {
		return c_getmethod;
	}

	public void setC_getmethod(String c_getmethod) {
		this.c_getmethod = c_getmethod;
	}

	public String getT_mc() {
		return t_mc;
	}

	public void setT_mc(String t_mc) {
		this.t_mc = t_mc;
	}

	public String getT_lx() {
		return t_lx;
	}

	public void setT_lx(String t_lx) {
		this.t_lx = t_lx;
	}

	public String getT_sy() {
		return t_sy;
	}

	public void setT_sy(String t_sy) {
		this.t_sy = t_sy;
	}

	public String getT_yxkong() {
		return t_yxkong;
	}

	public void setT_yxkong(String t_yxkong) {
		this.t_yxkong = t_yxkong;
	}

	public String getT_bz() {
		return t_bz;
	}

	public void setT_bz(String t_bz) {
		this.t_bz = t_bz;
	}

	public String getV_zzbds() {
		return v_zzbds;
	}

	public void setV_zzbds(String v_zzbds) {
		this.v_zzbds = v_zzbds;
	}

	public String getV_cuowuxx() {
		return v_cuowuxx;
	}

	public void setV_cuowuxx(String v_cuowuxx) {
		this.v_cuowuxx = v_cuowuxx;
	}

	public String getV_bxjiancha() {
		return v_bxjiancha;
	}

	public void setV_bxjiancha(String v_bxjiancha) {
		this.v_bxjiancha = v_bxjiancha;
	}

	public String getH_lx() {
		return h_lx;
	}

	public void setH_lx(String h_lx) {
		this.h_lx = h_lx;
	}

	public String getH_jb() {
		return h_jb;
	}

	public void setH_jb(String h_jb) {
		this.h_jb = h_jb;
	}

	public String getE_mc() {
		return e_mc;
	}

	public void setE_mc(String e_mc) {
		this.e_mc = e_mc;
	}
}
