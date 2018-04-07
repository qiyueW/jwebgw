package wx.web.cc.hm.cmodelfl;

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
import wx.web.cc.bean.CModelFL;

@H("cc/cmodel/cmodelfl/u")
//@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J61_2")
@system.web.power.ann.SQ("Y101_11U")
public class CModelFLUpdate {

	JWeb jw;

	public CModelFLUpdate(JWeb jw) {
		this.jw = jw;
	}

	@M("/update")
	@Validate(wx.web.cc.hm.cmodelfl.validate.CModelFLValidate.class)
	public void update() {
		CModelFL obj = jw.getObject(CModelFL.class);
		if (null == obj.getCmodelfl_id() || obj.getCmodelfl_id().length() != 24)
			return;
		if (null == obj.getCmodelfl_pid() || obj.getCmodelfl_pid().isEmpty())
			obj.setCmodelfl_pid("0");

		List<CModelFL> list = DBO.service.S.select(CModelFL.class);
		int tkey=TreeService.CHECK.getError_FatherIsSon(list, "cmodelfl_id", "cmodelfl_pid", obj.getCmodelfl_id(),obj.getCmodelfl_pid()).key;
		
		if(tkey==IdPidEnum.ERROR_FatherIsYourSelft.key){
			jw.printOne(KeyModel.getJSONModel("-1", "修改失败:自己是自己的上级"));
			return;
		}if(tkey==IdPidEnum.ERROR_FatherIsYourSon.key){
			jw.printOne(KeyModel.getJSONModel("-1", "修改失败:自己的子级是自己的上级!"));
			return;
		}
		DBO.out_update_1_0_f1(jw, DBO.service.U.update_all(obj));
        wx.web.cc.hm.cmodelfl.cache.CModelFLCache.CACHE.reset();
	}

	@M("/update/select")
	public void updateSelect_UseFilter_CheckUpdateSelect() {
		// 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
		String selectUpdateID = jw.getString(ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);

		CModelFL obj = DBO.service.S.selectOneByID(CModelFL.class, selectUpdateID);
		if (null == obj.getCmodelfl_id())
			return;
		jw.request.setAttribute("cmodelfl", obj);
		jw.request.setAttribute("fl_P", DBO.service.S.selectOneByCondition(CModelFL.class, "WHERE cmodelfl_id='" + obj.getCmodelfl_pid()+ "'"));
		jw.forward("/cc/cmodel/cmodelfl/cmodelfl_U.jsp");
	}
}
