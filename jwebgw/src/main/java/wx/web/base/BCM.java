package wx.web.base;

import system.base.cache.CacheCenter;
import wx.web.base.hm.bm.cache.BMCache;

/**
 *
 * @author jweb
 */
public class BCM {

    /**
     * 部门缓存操作对象
     */
    final static public CacheCenter RY_CACHE = new CacheCenter(BMCache.class);
    
}
