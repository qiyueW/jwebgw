package wx.web.cc.hm.fanganfl.cache;

import java.util.List;
import wx.web.cc.bean.FanganFL;

/**
 *
 * @author jweb
 */
public class FanganFLCache extends system.base.cache.CacheData {
    final static public system.base.cache.CacheCenter CACHE = new system.base.cache.CacheCenter(FanganFLCache.class);
    private List<FanganFL> list;
    private String json,zdyJson;
    @Override
    public void loadData(system.db.Service db) {
        this.list =configuration.DBO.service.S.select(FanganFL.class);//作用分类
        this.json = system.base.beanjson.JCJSON.toSimpleJSON(list);//作用树
        this.zdyJson = plugins.ligerui.LigeruiService.toJson(list);//作用组件ligerui GRID 数据格式。
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
