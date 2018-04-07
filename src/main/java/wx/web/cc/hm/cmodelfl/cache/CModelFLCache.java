package wx.web.cc.hm.cmodelfl.cache;

import java.util.List;
import wx.web.cc.bean.CModelFL;

/**
 *
 * @author jweb
 */
public class CModelFLCache extends system.base.cache.CacheData {
    final static public system.base.cache.CacheCenter CACHE = new system.base.cache.CacheCenter(CModelFLCache.class);
    private List<CModelFL> list;
    private String json,zdyJson;
    @Override
    public void loadData(system.db.Service db) {
        this.list =configuration.DBO.service.S.select(CModelFL.class);//作用分类
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
