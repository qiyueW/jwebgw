package wx.web.cc.hm.fanganfl;

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
import wx.web.cc.bean.FanganFL;

@H("cc/fangan/fanganfl/u")
//@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J61_2")
@system.web.power.ann.SQ("Y101_15_1U")
public class FanganFLUpdate {

	JWeb jw;

	public FanganFLUpdate(JWeb jw) {
		this.jw = jw;
	}

	@M("/update")
	@Validate(wx.web.cc.hm.fanganfl.validate.FanganFLValidate.class)
	public void update() {
		FanganFL obj = jw.getObject(FanganFL.class);
		if (null == obj.getFanganfl_id() || obj.getFanganfl_id().length() != 24)
			return;
		if (null == obj.getFanganfl_pid() || obj.getFanganfl_pid().isEmpty())
			obj.setFanganfl_pid("0");

		List<FanganFL> list = DBO.service.S.select(FanganFL.class);
		int tkey=TreeService.CHECK.getError_FatherIsSon(list, "fanganfl_id", "fanganfl_pid", obj.getFanganfl_id(),obj.getFanganfl_pid()).key;
		
		if(tkey==IdPidEnum.ERROR_FatherIsYourSelft.key){
			jw.printOne(KeyModel.getJSONModel("-1", "修改失败:自己是自己的上级"));
			return;
		}if(tkey==IdPidEnum.ERROR_FatherIsYourSon.key){
			jw.printOne(KeyModel.getJSONModel("-1", "修改失败:自己的子级是自己的上级!"));
			return;
		}
		DBO.out_update_1_0_f1(jw, DBO.service.U.update_all(obj));
        wx.web.cc.hm.fanganfl.cache.FanganFLCache.CACHE.reset();
	}

	@M("/update/select")
	public void updateSelect_UseFilter_CheckUpdateSelect() {
		// 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
		String selectUpdateID = jw.getString(ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);

		FanganFL obj = DBO.service.S.selectOneByID(FanganFL.class, selectUpdateID);
		if (null == obj.getFanganfl_id())
			return;
		jw.request.setAttribute("fanganfl", obj);
		jw.request.setAttribute("fl_P", DBO.service.S.selectOneByCondition(FanganFL.class, "WHERE fanganfl_id='" + obj.getFanganfl_pid()+ "'"));
		jw.forward("/cc/fangan/fanganfl/fanganfl_U.jsp");
	}
}
