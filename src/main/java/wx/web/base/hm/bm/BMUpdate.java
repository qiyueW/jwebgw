package wx.web.base.hm.bm;

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
import wx.web.base.bean.BM;

@H("/base/bm")
@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J51_2")
public class BMUpdate {

	JWeb jw;

	public BMUpdate(JWeb jw) {
		this.jw = jw;
	}

	@M("/update")
	@Validate(wx.web.base.hm.bm.validate.BMValidate.class)
	public void update() {
		BM obj = jw.getObject(wx.web.base.bean.BM.class);
		if (null == obj.getBm_id() || obj.getBm_id().length() != 24)
			return;
		if (null == obj.getBm_pid() || obj.getBm_pid().isEmpty())
			obj.setBm_pid("0");

		List<BM> list = DBO.service.S.select(BM.class);
		int tkey=TreeService.CHECK.getError_FatherIsSon(list, "bm_id", "bm_pid", obj.getBm_id(),obj.getBm_pid()).key;
		
		if(tkey==IdPidEnum.ERROR_FatherIsYourSelft.key){
			jw.printOne(KeyModel.getJSONModel("-1", "修改失败:自己是自己的上级"));
			return;
		}if(tkey==IdPidEnum.ERROR_FatherIsYourSon.key){
			jw.printOne(KeyModel.getJSONModel("-1", "修改失败:自己的子级是自己的上级!"));
			return;
		}
		DBO.out_update_1_0_f1(jw, DBO.service.U.update_all(obj));
                wx.web.base.BCM.RY_CACHE.reset();
	}

	@M("/update/select")
	public void updateSelect_UseFilter_CheckUpdateSelect() {
		// 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
		String selectUpdateID = jw.getString(ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);

		BM obj = DBO.service.S.selectOneByID(BM.class, selectUpdateID);
		if (null == obj.getBm_id())
			return;
		jw.request.setAttribute("bm", obj);
		jw.request.setAttribute("bm_P",
				DBO.service.S.selectOneByCondition(BM.class, "WHERE bm_id='" + obj.getBm_pid() + "'"));
		jw.forward("/admin/base/bm/bm_U.jsp");
	}
}
