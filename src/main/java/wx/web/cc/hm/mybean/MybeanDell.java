package wx.web.cc.hm.mybean;

import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import configuration.DBO;


@H("cc/mybean/d")
public class MybeanDell {

    JWeb jw;

    public MybeanDell(JWeb jw) {
        this.jw = jw;
    }
    @M("/dell")
    public void dellVast() {
        String ids = jw.getString("ids");
        if(null==ids||ids.length()<24)return;
        String id = "";
        for (String str : ids.split(",")) {
            id = id + ",'" + str + "'";
        }
        id= "WHERE mybean_zj in(" + id.substring(1) + ") ";
        int i=DBO.service.D.deleteVastByCondition_CheckToDeny(wx.web.cc.bean.Mybean.class,id,null);
        wx.web.cc.hm.mybean.cache.MybeanCache.CACHE.resetNow();
        if(i==-1)jw.printOne(DBO.getJSONModel("-1","无法执行删除。已经被使用"));
		jw.printOne(i==0?DBO.getJSONModel("0","删除失败，请通知管理员检查网络或数据库。或稍后再试。")
				:DBO.getJSONModel("1","删除成功"));
    }
    
}
