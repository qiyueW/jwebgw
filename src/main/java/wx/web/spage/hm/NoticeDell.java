package wx.web.spage.hm;

import configuration.KeyModel.ReturnKey;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import configuration.DBO;
import wx.web.spage.bean.Spage_notice;

@system.web.power.ann.SQ("Y100_1_3")// 删除
@H("/spage/notice/d")
public class NoticeDell {

    JWeb jw;

    public NoticeDell(JWeb jw) {
        this.jw = jw;
    }

    @M("/dell")
    public void dellVast() {
        String id=jw.getString("id");
        if(null==id||id.trim().length()!=24){
            return;
        }
        int i = DBO.service.D.dellByID(Spage_notice.class, id);
        jw.printOne(i == -1 ? DBO.getJSONModel("-1", "数据库异常!请通知管理员")
                : (i > 0 ? ReturnKey.DELL_SUCESS.statusCode : ReturnKey.DELL_ERROR.statusCode));
    }
}
