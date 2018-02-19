package wx.web.cc.hm.mypackage;

import java.util.List;

import configuration.KeyModel;
import configuration.KeyModel.ParamKey;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.base.tree.TreeService;
import system.base.tree.vo.IdPidEnum;
import system.web.JWeb;
import configuration.DBO;
import wx.web.cc.bean.MyPackage;

@H("cc/mypackage/u")
//@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J61_2")
//@system.web.power.ann.SQ("J61_2")
public class MyPackageUpdate {

	JWeb jw;

	public MyPackageUpdate(JWeb jw) {
		this.jw = jw;
	}

	@M("/update")
	@Validate(wx.web.cc.hm.mypackage.validate.MyPackageValidate.class)
	public void update() {
		MyPackage obj = jw.getObject(MyPackage.class);
		if (null == obj.getMypackage_id() || obj.getMypackage_id().length() != 24)
			return;
		if (null == obj.getMypackage_pid() || obj.getMypackage_pid().isEmpty())
			obj.setMypackage_pid("0");

		List<MyPackage> list = DBO.service.S.select(MyPackage.class);
		int tkey=TreeService.CHECK.getError_FatherIsSon(list, "mypackage_id", "mypackage_pid", obj.getMypackage_id(),obj.getMypackage_pid()).key;
		
		if(tkey==IdPidEnum.ERROR_FatherIsYourSelft.key){
			jw.printOne(KeyModel.getJSONModel("-1", "修改失败:自己是自己的上级"));
			return;
		}if(tkey==IdPidEnum.ERROR_FatherIsYourSon.key){
			jw.printOne(KeyModel.getJSONModel("-1", "修改失败:自己的子级是自己的上级!"));
			return;
		}
		DBO.out_update_1_0_f1(jw, DBO.service.U.update_all(obj));
        wx.web.cc.hm.mypackage.cache.MyPackageCache.CACHE.reset();
	}

	@M("/update/select")
	public void updateSelect_UseFilter_CheckUpdateSelect() {
		// 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
		String selectUpdateID = jw.getString(ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);

		MyPackage obj = DBO.service.S.selectOneByID(MyPackage.class, selectUpdateID);
		if (null == obj.getMypackage_id())
			return;
		jw.request.setAttribute("mypackage", obj);
		jw.request.setAttribute("fl_P", DBO.service.S.selectOneByCondition(MyPackage.class, "WHERE mypackage_id='" + obj.getMypackage_pid()+ "'"));
		jw.forward("/cc/mypackage/mypackage_U.jsp");
	}
}
