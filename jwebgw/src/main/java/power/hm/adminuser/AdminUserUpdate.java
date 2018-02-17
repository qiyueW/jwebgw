package power.hm.adminuser;

import configuration.DBO;
import configuration.KeyModel.ParamKey;
import power.bean.AdminUser;
import power.service.AdminService;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;

@H("/sys/power/adminuser/u")
@system.web.power.ann.DL(system.web.power.PDK.SESSION_SUPER_ADMIN_KEY) //超级管理员登陆
public class AdminUserUpdate {

    JWeb jw;

    public AdminUserUpdate(JWeb jw) {
        this.jw = jw;
    }

    @M("/update")
    @Validate(power.hm.adminuser.validate.AdminUserValidate_U.class)    
    public void update() {
        AdminUser obj = jw.getObject(AdminUser.class);
        if (null == obj.getUser_id() || obj.getUser_id().length() != 24) {
            return;
        }
        DBO.out_update_1_0_f1(jw, DBO.service.U.updateSome_alloy(obj, "user_password,user_name,user_email,bm_id,bm_name"));
    }

    @M("/update/select")
    public void updateSelect_UseFilter_CheckUpdateSelect() {
        // 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
        String selectUpdateID = jw.getString(ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);

        AdminUser obj = DBO.service.S.selectOneByID(AdminUser.class, selectUpdateID);
        if (null == obj.getUser_id()) {
            return;
        }
        jw.request.setAttribute("obj", obj);
        jw.forward("/sys/adminuser/adminuser_U.jsp");
    }

    @M("/updateStyle")///base/ry/update0.jw
    public void updateStyle() {
        String ids = jw.getString("ids");
        if (null == ids || ids.length() < 24) {
            return;
        }
        int i = AdminService.updateStyle(ids);
        if (i == -1) {
            DBO.getJSONModel("-1", "执行出错!");
            return;
        }
        jw.printOne(i > 0
                ? DBO.getJSONModel("1", "执行成功" + i + "个")
                : DBO.getJSONModel("0", "没有可执行的数据或执行失败。")
        );
    }

}
