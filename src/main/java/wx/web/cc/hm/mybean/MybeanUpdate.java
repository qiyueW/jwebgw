package wx.web.cc.hm.mybean;

import configuration.KeyModel;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import configuration.DBO;
import wx.web.cc.bean.Mybean;

@H("cc/mybean/u")
//@system.web.filter.annotation.JWFilter(过滤是否有权限的类)
public class MybeanUpdate {

    JWeb jw;

    public MybeanUpdate(JWeb jw) {
        this.jw = jw;
    }

    @M("/update")
    @Validate(wx.web.cc.hm.mybean.validate.MybeanValidate.class)
    public void update() {
        Mybean obj = jw.getObject(Mybean.class);
        if (null == obj.getMybean_zj() || obj.getMybean_zj().length() != 24) {
            return;
        }
        DBO.out_update_1_0_f1(jw, DBO.service.U.update_all(obj));
        wx.web.cc.hm.mybean.cache.MybeanCache.CACHE.resetNow();
    }

    @M("/update/select")
    public void updateSelect_UseFilter_CheckUpdateSelect() {
        // 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
        String selectUpdateID = jw.getString(KeyModel.ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);

        Mybean obj = DBO.service.S.selectOneByID(Mybean.class, selectUpdateID);
        if (null == obj.getMybean_zj()) {
            return;
        }
        jw.request.setAttribute("obj", obj);
        jw.forward("/cc/mybean/Mybean_U.jsp");
    }
}