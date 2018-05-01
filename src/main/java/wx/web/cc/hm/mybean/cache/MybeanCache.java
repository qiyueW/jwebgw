package wx.web.cc.hm.mybean.cache;

import static configuration.DBO.service;
import wx.web.cc.bean.Bean;

/**
 *
 * @author jweb
 */
public class MybeanCache extends system.base.cache.CacheData {

    final static public system.base.cache.CacheCenter CACHE = new system.base.cache.CacheCenter(MybeanCache.class);
    private String json;

    @Override
    public void loadData(system.db.Service db) {
        this.json = system.base.beanjson.JCJSON.toSimpleJSON(service.S.select(Bean.class, "order by bean_px ASC"));//作用树
    }

    public String getJSON() {
        return this.json;
    }
}
