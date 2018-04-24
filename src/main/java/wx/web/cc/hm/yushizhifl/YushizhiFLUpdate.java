package wx.web.cc.hm.yushizhifl;

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
import wx.web.cc.bean.YushizhiFL;
import wx.web.cc.hm.yushizhi.soo.YushizhiSoo;

@H("cc/yushizhi/yushizhifl/u")
@system.web.power.ann.SQ("Y101_16_1U")
public class YushizhiFLUpdate {

    JWeb jw;

    public YushizhiFLUpdate(JWeb jw) {
        this.jw = jw;
    }

    @M("/update")
    @Validate(wx.web.cc.hm.yushizhifl.validate.YushizhiFLValidate.class)
    public void update() {
        YushizhiFL obj = jw.getObject(YushizhiFL.class);
        if (null == obj.getYushizhifl_id() || obj.getYushizhifl_id().length() != 24) {
            return;
        }
        if (null == obj.getYushizhifl_pid() || obj.getYushizhifl_pid().isEmpty()) {
            obj.setYushizhifl_pid("0");
        }

        List<YushizhiFL> list = DBO.service.S.select(YushizhiFL.class);
        int tkey = TreeService.CHECK.getError_FatherIsSon(list, "yushizhifl_id", "yushizhifl_pid", obj.getYushizhifl_id(), obj.getYushizhifl_pid()).key;

        if (tkey == IdPidEnum.ERROR_FatherIsYourSelft.key) {
            jw.printOne(KeyModel.getJSONModel("-1", "修改失败:自己是自己的上级"));
            return;
        }
        if (tkey == IdPidEnum.ERROR_FatherIsYourSon.key) {
            jw.printOne(KeyModel.getJSONModel("-1", "修改失败:自己的子级是自己的上级!"));
            return;
        }
        int[] i = DBO.service.ADUS.executeBatch(
                DBO.service.SQL.update_all(obj),
                 YushizhiSoo.updateYushizhiFLName(obj)
        );
        DBO.out_update_1_0_f1(jw, null == i ? -1 : DBO.service.U.update_all(obj));
        wx.web.cc.hm.yushizhifl.cache.YushizhiFLCache.CACHE.reset();
    }

    @M("/update/select")
    public void updateSelect_UseFilter_CheckUpdateSelect() {
        // 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
        String selectUpdateID = jw.getString(ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);

        YushizhiFL obj = DBO.service.S.selectOneByID(YushizhiFL.class, selectUpdateID);
        if (null == obj.getYushizhifl_id()) {
            return;
        }
        jw.request.setAttribute("yushizhifl", obj);
        jw.request.setAttribute("fl_P", DBO.service.S.selectOneByCondition(YushizhiFL.class, "WHERE yushizhifl_id='" + obj.getYushizhifl_pid() + "'"));
        jw.forward("/cc/yushizhi/yushizhifl/yushizhifl_U.jsp");
    }
}
