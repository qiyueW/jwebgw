package wx.web.cc.hm.model;

//import plugins.ligerui.LigeruiKey;
//import plugins.ligerui.LigeruiService;
//import plugins.ligerui.vo.LigerUIPage;
import configuration.DBO;
import java.util.List;
import plugins.easyui.EasyuiService;
import plugins.easyui.vo.EasyuiPage;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import wx.web.cc.bean.Mybean;
import wx.web.cc.bean.Mybeanfield;
import wx.web.cc.service.MybeanService;
//import static configuration.DBO.service;
//import wx.web.cc.bean.Mybean;

@H("cc/mybean/modal/s")
public class MyModelSelect {

	@M("/base/selectVast") // cc/mybean/modal/s/selectVast.jw
	public static void select(JWeb jw) {
		String mybean_zj = jw.getString("mybean_zj");
		if (null == mybean_zj || mybean_zj.isEmpty()) {
			jw.printOne("[]");
			return;
		}
		Mybean bean = DBO.service.S.selectOneByID(Mybean.class, mybean_zj);
		if (null == bean.getMybean_zj()) {
			jw.printOne("[]");
			return;
		}

		String sort = jw.getString("sort", "bean");
		String where = "WHERE mybean_zj='" + mybean_zj + "'";

		switch (sort) {
		case "bean": {
			jw.printOne(MybeanService.toBeanData(DBO.service.S.selectByCondition(Mybeanfield.class, where)));
			return;
		}
		case "sql": {
			jw.printOne(MybeanService.toSQLData(DBO.service.S.selectByCondition(Mybeanfield.class, where),bean.getMybean_mc()));
			return;
		}
		}

	}

	@M("/selectAllByJson")
	public static void selectJSONByCache(JWeb jw) {
		String mybean_zj = jw.getString("mybean_zj");
		if (null == mybean_zj || mybean_zj.isEmpty()) {
			jw.printOne("[]");
			return;
		}
		String where = "WHERE mybean_zj='" + mybean_zj + "'";
		EasyuiPage page = EasyuiService.getPage(jw);

		List<Mybeanfield> list = DBO.service.S.selectVastByCondition(Mybeanfield.class, page.page, page.rows, where);
		jw.printOne(EasyuiService.formatGrid(list, DBO.service.S.selectCountByCondition(Mybeanfield.class, where)));
	}
}
