package power.hm.role;

import configuration.DBO;
import configuration.KeyModel;
import power.bean.Role;
import system.base.annotation.H;
import system.web.JWeb;
import system.base.annotation.M;
import system.base.annotation.Validate;

@system.web.power.ann.SQ(value = "X2_2_2", scope = system.web.power.PDK.SESSION_ADMIN_KEY)
@H("/sys/power/role/u")
public class RoleUpdate {

    JWeb jw;

    public RoleUpdate(JWeb jw) {
        this.jw = jw;
    }

    @M("/update")
    @Validate(power.hm.role.validate.RoleValidate.class)
    public void update() {
        Role obj = jw.getObject(Role.class);
        if (null == obj.getRole_id() || obj.getRole_id().length() != 24) {
            return;
        }
        DBO.out_update_1_0_f1(jw, DBO.service.U.updateSome_reject(obj, "role_create,power,user_id,user_name", "role_name"));
    }
    
    @M("/update/select")
    public void updateSelect_UseFilter_CheckUpdateSelect() {
        // 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
        String selectUpdateID = jw.getString(KeyModel.ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);
        Role obj = DBO.service.S.selectOneByID(Role.class, selectUpdateID);
        if (null == obj.getJsdj_zj()) {
            return;
        }
        jw.request.setAttribute("obj", obj);
        jw.forward("/sys/role/role_U.jsp");
    }

}
