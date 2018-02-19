package wx.web.spage.hm;

import configuration.DBO;
import system.web.JWeb;
import system.base.annotation.M;
import configuration.KeyModel;
import system.base.annotation.H;
import wx.web.spage.bean.Spage_jingyanku;
@system.web.power.ann.SQ("Y100_3_2")
@H("/spage/jingyanku/u")
final public class JingyankuUpdate {

    JWeb jw;

    public JingyankuUpdate(JWeb jw) {
        this.jw = jw;
    }

    @M("/selectOne")///base/wt/twt/selectOne.jw
    public void selectOne_CheckUpdateSelect() {
        //表示用户修改前的查询id,查询此id的最新值，返回给用户修改
        String selectUpdateID = jw.getString(KeyModel.ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);
        jw.set("obj", DBO.service.S.selectOneByID(Spage_jingyanku.class, selectUpdateID));
        jw.forward("/spage/jingyanku/jingyanku_U.jsp");
    }

    @M("/update")
    @system.base.annotation.Validate(wx.web.spage.hm.validate.Spage_jingyankuValidate.class)
    public void update() {
        Spage_jingyanku obj = jw.getObject(Spage_jingyanku.class);
        if (null == obj.getSpage_jingyanku_zj() || obj.getSpage_jingyanku_zj().length() != 24) {
            return;
        }
        Spage_jingyanku sobj = DBO.service.S.selectOneByID(Spage_jingyanku.class, obj.getSpage_jingyanku_zj());
        if (null == sobj.getSpage_jingyanku_zj()) {//提交的id未有相关记录。可能已经被删除
            DBO.getJSONModel("0", "未找到相关修改的记录，可能已经被删除");
            return;
        }
        int i = DBO.service.U.updateSome_reject(obj,
                "spage_jingyanku_zhidanren,spage_jingyanku_zhidanren_zj,spage_jingyanku_zhidanshijian"
        );
        DBO.out_update_1_0_f1(jw, i);
        if (i == 1) {
            wx.web.spage.cache.JianyankuCache.CACHE.reset();
        }
    }
}
