package wx.web.base.hm.bm.cache;

import java.util.List;
import wx.web.base.bean.BM;
import wx.web.base.dao.BMDao;

/**
 *
 * @author jweb
 */
public class BMCache extends system.base.cache.CacheData {
    private List<BM> list;
    private String json,zdyJson;
    @Override
    public void loadData(system.db.Service db) {
        this.list = BMDao.selectAll();//作用分类
        this.json = system.base.beanjson.JCJSON.toSimpleJSON(list);//作用树
        this.zdyJson = plugins.ligerui.LigeruiService.toJson(list);//作用组件ligerui GRID 数据格式。
        System.out.println("this.json:"+this.json);
    }

    public List getList() {
        return this.list;
    }

    public String getJSON() {
        return this.json;
    }

    public String getLigeruiJSON() {
        return this.zdyJson;
    }
}
