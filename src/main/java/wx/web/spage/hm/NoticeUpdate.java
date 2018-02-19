package wx.web.spage.hm;

import configuration.DBO;
import system.web.JWeb;
import system.base.annotation.M;
import configuration.KeyModel;
import system.base.annotation.H;
import wx.web.spage.bean.Spage_notice;
//@system.web.power.ann.SQ("Y100_1_2")

@H("/spage/notice/u")
final public class NoticeUpdate {

    JWeb jw;

    public NoticeUpdate(JWeb jw) {
        this.jw = jw;
    }

    @M("/selectOne")///base/wt/twt/selectOne.jw
    public void selectOne_CheckUpdateSelect() {
        //表示用户修改前的查询id,查询此id的最新值，返回给用户修改
        String selectUpdateID = jw.getString(KeyModel.ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);
        jw.set("obj", DBO.service.S.selectOneByID(Spage_notice.class, selectUpdateID));
        jw.forward("/spage/notice/notice_U.jsp");
    }

    @M("/update")
    @system.base.annotation.Validate(wx.web.spage.hm.validate.Spage_noticeValidate.class)
    public void update() {
        Spage_notice obj = jw.getObject(Spage_notice.class);
        if (null == obj.getSpage_notice_zj() || obj.getSpage_notice_zj().length() != 24) {
            return;
        }
        Spage_notice sobj = DBO.service.S.selectOneByID(Spage_notice.class, obj.getSpage_notice_zj());
        if (null == sobj.getSpage_notice_zj()) {//提交的id未有相关记录。可能已经被删除
            DBO.getJSONModel("0", "未找到相关修改的记录，可能已经被删除");
            return;
        }
        DBO.out_update_1_0_f1(jw, DBO.service.U.updateSome_alloy(obj, "spage_notice_biaoti,spage_notice_neirong,spage_notice_fabushijian"));
    }
}
