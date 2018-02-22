package wx.web.cc.hm.mybean.mybeanfield;

import configuration.DBO;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;

@H("cc/mybean/field/a")
public class MybeanFieldAdd {

	JWeb jw;

	public MybeanFieldAdd(JWeb jw) {
		this.jw = jw;
	}

	@M("/add")
	public void add() {
		wx.web.cc.bean.Mybeanfield obj = jw.getObject(wx.web.cc.bean.Mybeanfield.class);
		System.out.println(obj.getV_zzbds());
		if (DBO.service.ADUS.executeQueryCount("SELECT COUNT(*) FROM Mybeanfield WHERE mybean_zj='" + obj.getMybean_zj()
				+ "' AND c_mc='" + obj.getC_mc() + "'")>0) {
			jw.printOne(DBO.getJSONModel("0", "同个bean，不能同时存在相关的字段"));
			return;
		}
		int i = DBO.service.A.addOne(obj);
		jw.printOne(i == -1 ? DBO.getJSONModel("-1", "添加出错")
				: (i == 0 ? DBO.getJSONModel("0", "添加失败，未知原因。请通知管理员调试系统") : DBO.getJSONModel("1", "添加成功。")));
	}

}
