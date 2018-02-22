package wx.web.cc.hm.mybean.mybeanfield;

import configuration.DBO;
import configuration.KeyModel;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import wx.web.cc.bean.Mybeanfield;

@H("cc/mybean/field")
public class MybeanFieldAdd {

    JWeb jw;

    public MybeanFieldAdd(JWeb jw) {
        this.jw = jw;
    }

    @M("/a/add")
    public void add() {
        wx.web.cc.bean.Mybeanfield obj = jw.getObject(wx.web.cc.bean.Mybeanfield.class);
        System.out.println(obj.getV_zzbds());
        if (DBO.service.ADUS.executeQueryCount("SELECT COUNT(*) FROM Mybeanfield WHERE mybean_zj='" + obj.getMybean_zj()
                + "' AND c_mc='" + obj.getC_mc() + "'") > 0) {
            jw.printOne(DBO.getJSONModel("0", "同个bean，不能同时存在相关的字段"));
            return;
        }
        int i = DBO.service.A.addOne(obj);
        jw.printOne(i == -1 ? DBO.getJSONModel("-1", "添加出错")
                : (i == 0 ? DBO.getJSONModel("0", "添加失败，未知原因。请通知管理员调试系统") : DBO.getJSONModel("1", "添加成功。")));
    }

    @M("u/update")
    @Validate(wx.web.cc.hm.mybean.validate.MybeanValidate.class)
    public void update() {
        Mybeanfield obj = jw.getObject(Mybeanfield.class);
        if (null == obj.getMybeanfield_zj()|| obj.getMybeanfield_zj().length() != 24) {
            return;
        }
        DBO.out_update_1_0_f1(jw, DBO.service.U.update_all(obj));
    }

    @M("u/update/select")
    public void updateSelect_UseFilter_CheckUpdateSelect() {
        // 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
        String selectUpdateID = jw.getString(KeyModel.ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);

        Mybeanfield obj = DBO.service.S.selectOneByID(Mybeanfield.class, selectUpdateID);
        if (null == obj.getMybean_zj()) {
            return;
        }
        jw.request.setAttribute("obj", obj);
        jw.forward("/cc/mybeanfield/Mybeanfield_U.jsp");
    }
}
