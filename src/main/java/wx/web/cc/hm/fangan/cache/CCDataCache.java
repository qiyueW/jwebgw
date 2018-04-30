package wx.web.cc.hm.fangan.cache;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author adm.wangchunzi
 */
public class CCDataCache {

    private static final Map<String, String> UD = new HashMap();

    public static void put(String key, String value) {
        UD.put(key, value);
    }

    public static String getValue(String key) {
        return UD.get(key);
    }
}
