package wx.web.base.hm.tree;

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
import wx.web.base.bean.tree.JingyanKuFL;

@H("base/tree/jingyankufl/u")
//@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J61_2")
@system.web.power.ann.SQ("J7_2_2_2")
public class JingyanKuFLUpdate {

	JWeb jw;

	public JingyanKuFLUpdate(JWeb jw) {
		this.jw = jw;
	}

	@M("/update")
	@Validate(wx.web.base.hm.tree.validate.JingyanKuFLValidate.class)
	public void update() {
		JingyanKuFL obj = jw.getObject(JingyanKuFL.class);
		if (null == obj.getJingyankufl_id() || obj.getJingyankufl_id().length() != 24)
			return;
		if (null == obj.getJingyankufl_pid() || obj.getJingyankufl_pid().isEmpty())
			obj.setJingyankufl_pid("0");

		List<JingyanKuFL> list = DBO.service.S.select(JingyanKuFL.class);
		int tkey=TreeService.CHECK.getError_FatherIsSon(list, "jingyankufl_id", "jingyankufl_pid", obj.getJingyankufl_id(),obj.getJingyankufl_pid()).key;
		
		if(tkey==IdPidEnum.ERROR_FatherIsYourSelft.key){
			jw.printOne(KeyModel.getJSONModel("-1", "修改失败:自己是自己的上级"));
			return;
		}if(tkey==IdPidEnum.ERROR_FatherIsYourSon.key){
			jw.printOne(KeyModel.getJSONModel("-1", "修改失败:自己的子级是自己的上级!"));
			return;
		}
		DBO.out_update_1_0_f1(jw, DBO.service.U.update_all(obj));
        wx.web.base.hm.tree.cache.JingyanKuFLCache.CACHE.reset();
	}

	@M("/update/select")
	public void updateSelect_UseFilter_CheckUpdateSelect() {
		// 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
		String selectUpdateID = jw.getString(ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);

		JingyanKuFL obj = DBO.service.S.selectOneByID(JingyanKuFL.class, selectUpdateID);
		if (null == obj.getJingyankufl_id())
			return;
		jw.request.setAttribute("jingyankufl", obj);
		jw.request.setAttribute("fl_P", DBO.service.S.selectOneByCondition(JingyanKuFL.class, "WHERE jingyankufl_id='" + obj.getJingyankufl_pid()+ "'"));
		jw.forward("/admin/base/tree/jingyankufl/jingyankufl_U.jsp");
	}
}
