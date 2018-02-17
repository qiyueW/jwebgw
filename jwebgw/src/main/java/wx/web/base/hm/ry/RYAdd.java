package wx.web.base.hm.ry;

import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.DBO;
import wx.web.base.bean.RY;

@H("/base/ry/a")
public class RYAdd {

    JWeb jw;

    public RYAdd(JWeb jw) {
        this.jw = jw;
    }

    @M("/add")
    @Validate(wx.web.base.hm.ry.validate.RYValidate.class)
    public void add() {
        RY ry = (RY) jw.request.getAttribute("RY");
        int i = DBO.service.A.addOne(ry, "ry_account");
        String rs = "添加成功。请耐心等系统管理员审核通过后，再使用";
        if (ry.getRy_style() == 1) {
            rs = "您选择的审核状态账号添加成功，可直接使用。";
        } else if (ry.getRy_style() == 2) {
            rs = "您选择的停用状态账号添加成功，但无法使用它登录处理业务";
        }
        jw.printOne(i == -1
                ? DBO.getJSONModel("-1", "添加失败原因：账号重复")
                : (i == 0 ? DBO.getJSONModel("0", "添加失败，未知原因。请通知管理员调试系统")
                        : DBO.getJSONModel("1", rs))
        );
    }

    @M("/zhuce")
    @Validate(wx.web.base.hm.ry.validate.RY_ZhuCeValidate.class)
    public void zhuce() {
        int i = DBO.service.A.addOne(jw.request.getAttribute("RY"), "ry_account");
        jw.printOne(i == -1
                ? DBO.getJSONModel("-1", "添加失败原因：账号重复")
                : (i == 0 ? DBO.getJSONModel("0", "添加失败，未知原因。请通知管理员调试系统")
                        : DBO.getJSONModel("1", "添加成功。请耐心等系统管理员审核通过后，再使用"))
        );
    }

}
