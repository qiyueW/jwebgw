package wx.web.cc.hm.mybean.mybeanfield;

import java.util.List;

//import plugins.ligerui.LigeruiKey;
//import plugins.ligerui.LigeruiService;
//import plugins.ligerui.vo.LigerUIPage;
import configuration.DBO;
import plugins.easyui.EasyuiService;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import wx.web.cc.bean.Mybeanfield;

@H("cc/mybean/field/s")
public class MybeanFieldSelect {

    @M("/selectVast")
    public static void selectGridByCache(JWeb jw) {
        jw.printOne(
                "{\"Rows\":" + wx.web.cc.hm.mybean.cache.MybeanCache.CACHE.getCacheData(wx.web.cc.hm.mybean.cache.MybeanCache.class).getJSON()
                + ",\"" + plugins.ligerui.LigeruiConfig.record + "\":\"0\"}"
        );
    }

    @M("/selectAllByJson")
    public static void selectJSONByCache(JWeb jw) {
        String mybean_zj = jw.getString("mybean_zj");
        if (null == mybean_zj || mybean_zj.isEmpty()) {
            jw.printOne("[]");return;
        }
        List<Mybeanfield> list=DBO.service.S.selectByCondition(Mybeanfield.class, "WHERE mybean_zj='" + mybean_zj + "'");
        jw.printOne(EasyuiService.formatGrid(jw.request, list,list.size()));
    }
}
