package wx.web.base.hm.ry;


import system.base.annotation.M;
import system.web.JWeb;
import configuration.DBO;
import wx.web.base.dao.RYDao;
import system.base.annotation.H;

@H("/base/ry")
//@system.web.filter.annotation.JWFilter(过滤是否有权限的类)
public class RYDell {

    JWeb jw;

    public RYDell(JWeb jw) {
        this.jw = jw;
    }
    
    
    
	@M("/dell")///base/ry/dell0.jw
	public void dell() {
		String ids=jw.getString("ids");
		if (null ==ids||ids.length() <24)
			return;
		int i=RYDao.dellStye(ids);
		if(i==-1)jw.printOne(DBO.getJSONModel("-1","无法执行删除。人员已经被使用"));
		jw.printOne(i==0?DBO.getJSONModel("0","删除失败，请通知管理员检查网络或数据库。或稍后再试。")
				:DBO.getJSONModel("1","已经删除人员"));
	}
    
	@M("/dell0")///base/ry/dell0.jw
	public void dell0() {
		String ids=jw.getString("ids");
		if (null ==ids||ids.length() <24)
			return;
		int i=RYDao.dellStye(ids, 0);
		if(i==-1)jw.printOne(DBO.getJSONModel("-1","无法执行删除。人员已经被使用"));
		jw.printOne(i==0?DBO.getJSONModel("0","删除失败，请通知管理员检查网络或数据库。或稍后再试。")
				:DBO.getJSONModel("1","已经删除人员"));
	}
	
/*	@M("/dell1")///base/ry/dell0.jw
	public void dell1() {
		String ids=jw.getString("ids");
		if (null ==ids||ids.length() <24)
			return;
		int i=RYDao.dellStye(ids, 1);
		if(i==-1)jw.printOne(DBO.getJSONModel("-1","无法执行删除。人员已经被使用"));
		jw.printOne(i==0?DBO.getJSONModel("0","删除失败，请通知管理员检查网络或数据库。或稍后再试。")
				:DBO.getJSONModel("1","已经删除人员"));
	}
	@M("/dell2")///base/ry/dell0.jw
	public void dell2() {
		String ids=jw.getString("ids");
		if (null ==ids||ids.length() <24)
			return;
		int i=RYDao.dellStye(ids, 1);
		if(i==-1)jw.printOne(DBO.getJSONModel("-1","无法执行删除。人员已经被使用"));
		jw.printOne(i==0?DBO.getJSONModel("0","删除失败，请通知管理员检查网络或数据库。或稍后再试。")
				:DBO.getJSONModel("1","已经删除人员"));
	}*/
    

    
}
