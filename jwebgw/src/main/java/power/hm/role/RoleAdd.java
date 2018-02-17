package power.hm.role;

import configuration.DBO;
import java.util.Date;
import power.bean.AdminUser;
import system.base.annotation.H;
import system.base.annotation.Validate;
import system.web.JWeb;
import system.base.annotation.M;
import system.web.power.PDK;
import system.web.power.session.Login;

@H("/sys/power/role/a")
@system.web.power.ann.SQ(value = "X2_1", scope = system.web.power.PDK.SESSION_ADMIN_KEY)
public class RoleAdd {

    JWeb jw;

    public RoleAdd(JWeb jw) {
        this.jw = jw;
    }

    @M("/add")
    @Validate(power.hm.role.validate.RoleValidate.class)
    public void add() {
        power.bean.Role obj = jw.getObject(power.bean.Role.class);
        obj.setRole_create(new Date());
        if (null != obj.getPower() && obj.getPower().trim().length() > 0) {
            return;
        }
        AdminUser aobj = Login.getUserInfo(AdminUser.class, jw, PDK.SESSION_ADMIN_KEY);
        obj.setUser_id(aobj.getUser_id());
        obj.setUser_name(aobj.getUser_name());
        
        int i = DBO.service.A.addOne(obj, "role_name");
        jw.printOne(i == -1
                ? DBO.getJSONModel("-1", "添加失败：名称或代码重复")
                : (i == 0 ? DBO.getJSONModel("0", "添加失败，未知原因。请通知管理员调试系统")
                        : DBO.getJSONModel("1", "添加成功。"))
        );
    }

}
