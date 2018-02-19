package wx.web.base.hm.ry;

import java.text.SimpleDateFormat;
import java.util.List;

import configuration.KeyModel.ParamKey;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import configuration.DBO;
import system.web.power.PDK;
import wx.web.base.bean.RY;
import wx.web.base.dao.RYDao;

@H("/base/ry")
@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J44_2")
public class RYUpdate {

    JWeb jw;

    public RYUpdate(JWeb jw) {
        this.jw = jw;
    }

    @M("/update")
    @Validate(wx.web.base.hm.ry.validate.RYValidate.class)
    public void update() {

        RY obj = jw.getObject(wx.web.base.bean.RY.class);
        if (null == obj.getRy_id() || obj.getRy_id().length() != 24) {
            return;
        }
        //【针对用户】必须是指定范围，首先检查是否在范围内
        Object ua = jw.session.getAttribute(PDK.SESSION_DEFAULT_USER_KEY);
        
        String rejectField = null != ua 
                ? "ry_style,ry_sort,ry_account,ry_password"//用户不能修改密码
                : "ry_style,ry_sort,ry_account" ; //管理员可以修改密码
        
        
        DBO.out_update_1_0_f1(jw, DBO.service.U.updateSome_reject(
                obj, rejectField));
    }

    @M("/update/select")
    public void updateSelect_UseFilter_CheckUpdateSelect() {
        // 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
        String selectUpdateID = jw.getString(ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);

        RY obj = DBO.service.S.selectOneByID(RY.class, selectUpdateID);
        if (null == obj.getRy_id()) {
            return;
        }
        jw.request.setAttribute("ry_cdate", new SimpleDateFormat("yyyy-MM-dd").format(obj.getRy_cdate()));
        jw.request.setAttribute("obj", obj);
        jw.forward("/admin/base/ry/ry_U.jsp");
    }

    @system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J43_2")//审核
    @M("/update0")///base/ry/update0.jw
    public void update0() {
        String ids = jw.getString("ids");
        if (null == ids || ids.length() < 24) {
            return;
        }
        ids = RYDao.formatListToIds(ids, 0);//取出其中 为新增待审核 的id集合
        if (null == ids) {
            return;//如果没有，直接中止客户请求
        }
        jw.printOne(RYDao.updateStye(ids, 1) == 0 ? DBO.getJSONModel("0", "审核失败，请通知管理员检查网络或数据库。或稍后再试。") : DBO.getJSONModel("1", "审核通过"));
    }

    @system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J44_4")//停用|启用
    @M("/update12")///base/ry/update0.jw停用|启用
    public void update12() {
        String ids = jw.getString("ids");
        if (null == ids || ids.length() < 24) {
            return;
        }
        List<RY> list = RYDao.formatListToIds(ids);//取出其中 为新增待审核 的id集合
        if (list.isEmpty()) {
            return;//如果没有，直接中止客户请求
        }
        jw.printOne(RYDao.updateStye12(list) > 0
                ? DBO.getJSONModel("1", "执行成功!")
                : DBO.getJSONModel("0", "没有可执行的数据或执行失败。备注：如果修改的对象是管理员，请先改成非管理员才方")
        );
    }
//    /base/ry/update/mypssword

//    @DL
//    @M("/update/mypssword")///base/ry/update0.jw
//    public void updateMyPassword() {
//        String pw0 = jw.getString("pw0");
//        String pw1 = jw.getString("pw1");
//
//        if (null == pw0 || pw0.isEmpty() || null == pw1 || pw1.isEmpty()) {
//            return;
//        }
//        
//        RY ry = Login.getUserInfo(RY.class, jw);
//        if (!ry.getRy_password().equals(pw0)) {
//            jw.printOne("修改不成功原因：旧密码不正确");
//            return;
//        }
//        if (pw0.equals(pw1)) {
//            jw.printOne("新旧密码一样，无需修改");
//            return;
//        }
//        
//        ry.setRy_password(pw1);
//        int i = DBO.service.U.updateSome_alloy(ry, "ry_password");
//        if (i == 0) {
//            jw.printOne("修改失败，请通知管理员检查网络或数据库。或稍后再试。");
//            ry.setRy_password(pw0);
//            return;
//        }
//        jw.printOne("修改成功,下次登陆将启用新密码");
//    }
}
