package wx.web.base.hm.ry.vo;

import system.web.JWeb;

public class SelectConditionVo {
	public final String bm_ids;
	public final String nameOrAccount;
	public final int ry_style;
	
	public SelectConditionVo(final String bm_ids,final String nameOrAccount,final int ry_style){
		this.bm_ids=bm_ids;
		this.nameOrAccount=nameOrAccount;
		this.ry_style=ry_style;
	}
	public final static SelectConditionVo getSelectConditionVo(JWeb jw){
		return new SelectConditionVo(jw.getString("bm_id"),jw.getString("nameOrAccount"),jw.getInt("ry_style", 99));
	}
}
