package power.hm.jsdj;

import system.base.annotation.Validate;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import configuration.DBO;
import power.bean.JSDJ;
import power.hm.jsdj.validate.JSDJValidate;
@system.web.power.ann.SQ(value="X1_1",scope=system.web.power.PDK.SESSION_ADMIN_KEY)
@H("/sys/power/jsdj/a")
public class JSDJAdd {

    JWeb jw;

    public JSDJAdd(JWeb jw) {
        this.jw = jw;
    }

    @M("/add")
    @Validate(JSDJValidate.class)
    public void add() {
        JSDJ obj = jw.getObject(JSDJ.class);
//        if (null == obj.getJsdj_dm()|| obj.getJsdj_dm().isEmpty()) {
//            obj.setJsdj_dm(null);
//            int i = DBO.service.A.addOne(obj, "Jsdj_mc");
//            jw.printOne(i == -1
//                    ? DBO.getJSONModel("-1", "添加失败：名称重复")
//                    : (i == 0 ? DBO.getJSONModel("0", "添加失败，未知原因。请通知管理员调试系统")
//                            : DBO.getJSONModel("1", "添加成功。"))
//            );
//            return;
//        }
        int i = DBO.service.A.addOne(obj, "jsdj_mc", "jsdj_dm");
        jw.printOne(i == -1
                ? DBO.getJSONModel("-1", "添加失败：名称或代码重复")
                : (i == 0 ? DBO.getJSONModel("0", "添加失败，未知原因。请通知管理员调试系统")
                        : DBO.getJSONModel("1", "添加成功。"))
        );
    }

}
