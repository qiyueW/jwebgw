package power.hm.jsdj;

import configuration.KeyModel;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import configuration.DBO;
import power.bean.JSDJ;
import power.hm.jsdj.validate.JSDJValidate;

@H("/sys/power/jsdj/u")
@system.web.power.ann.SQ(value="X1_2_2",scope=system.web.power.PDK.SESSION_ADMIN_KEY)
public class JSDJUpdate {

    JWeb jw;

    public JSDJUpdate(JWeb jw) {
        this.jw = jw;
    }

    @M("/update")
    @Validate(JSDJValidate.class)
    public void update() {
        JSDJ obj = jw.getObject(JSDJ.class);
        if (null == obj.getJsdj_zj() || obj.getJsdj_zj().length() != 24) {
            return;
        }
        DBO.out_update_1_0_f1(jw, DBO.service.U.update_all(obj, "jsdj_dm", "jsdj_mc"));
    }

    @M("/update/select")
    public void updateSelect_UseFilter_CheckUpdateSelect() {
        // 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
        String selectUpdateID = jw.getString(KeyModel.ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);
        JSDJ obj = DBO.service.S.selectOneByID(JSDJ.class, selectUpdateID);
        if (null == obj.getJsdj_zj()) {
            return;
        }
        jw.request.setAttribute("obj", obj);
        jw.forward("/sys/role/jsdj/jsdj_U.jsp");
    }
}
