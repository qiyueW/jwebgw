package power.hm.adminuser;

import configuration.DBO;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.base.date.DateService;
import system.web.JWeb;
import system.web.power.PDK;
@system.web.power.ann.DL(PDK.SESSION_SUPER_ADMIN_KEY) //超级管理员登陆
@H("/sys/power/adminuser/a")
public class AdminUserAdd {

    JWeb jw;

    public AdminUserAdd(JWeb jw) {
        this.jw = jw;
    }
//    @system.web.power.ann.SQ("X3_2")
    @M("/add")
    @Validate(power.hm.adminuser.validate.AdminUserValidate.class)
    public void add() {
        power.bean.AdminUser obj = jw.getObject(power.bean.AdminUser.class);
        obj.setUser_time(DateService.getNowTime());
        obj.setPower_id("");
//            private String user_name;//用户名
//    private String user_account;//账号
        int i = DBO.service.A.addOne(obj,"user_account");
        jw.printOne(i == -1
                ? DBO.getJSONModel("-1", "添加失败：名称或账号重复")
                : (i == 0 ? DBO.getJSONModel("0", "添加失败，未知原因。请通知管理员调试系统")
                        : DBO.getJSONModel("1", "添加成功。"))
        );
    }

}
