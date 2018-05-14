package wx.web.cc.service;

import com.alibaba.fastjson.JSON;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import wx.web.cc.bean.Bean;
import wx.web.cc.bean.Bean2;
import wx.web.cc.bean.Mybeanfield;

/**
 *
 * @author adm.wangchunzi
 */
final public class EngineService {

    private final static VelocityEngine ENGINE;

    static {
        ENGINE = new VelocityEngine();
        ENGINE.init();
    }

    public static String workByEngine(String modelData, VelocityContext context) {
        StringWriter writer = new StringWriter();
        ENGINE.evaluate(context, writer, "", modelData); // 关键方法
        return writer.toString().replace("#$#", "$");
    }

    public static String fzFormat(String str) {
        return str.replace("&#39;", "'").replace("&#34;", "\"").replace("&quot;", "\"").replace("&#92;", "\\").replace("&#60;", "<").replace("&#62;", ">");
    }

    /**
     * 为了方便json数据的传递，将"号转化成 &#34;
     *
     * @param jsonData
     * @return String
     */
    public static String toFotmatJSONData(String jsonData) {
        return jsonData.replace("\"", "&#34;");
    }

    public static void main(String args[]) {
        Map<String, String> map = new HashMap();
        map.put("1", "value1");
        map.put("2", "value2");
        String str = "${map.get(\"1\")}";
        VelocityContext v = getVelocityContext();
        v.put("map", map);
        System.err.println(workByEngine(str, v));
    }

    public static VelocityContext getVelocityContext() {
        VelocityContext context = new VelocityContext();
        return context;
    }

    public static Bean toWork(Bean t, VelocityContext context) {
        return JSON.parseObject(workByEngine(JSON.toJSONString(t), context), Bean.class);
    }

    public static Mybeanfield toWork(Mybeanfield t, VelocityContext context) {
        return JSON.parseObject(workByEngine(JSON.toJSONString(t), context), Mybeanfield.class);
    }

    public static List<Bean2> toWork(List<Bean2> t, VelocityContext context) {
        return JSON.parseArray(workByEngine(JSON.toJSONString(t), context), Bean2.class);
    }

    public static <T> List<T> toWorkT(List<T> t, VelocityContext context, Map<String, String> kv) {
        Class c = t.get(0).getClass();
        String str = JSON.toJSONString(t);
        if (null != kv && kv.size() > 0) {
            for (Map.Entry<String, String> entry : kv.entrySet()) {
                str = str.replace(entry.getKey(), entry.getValue());
            }
        }
        return JSON.parseArray(workByEngine(str, context), c);
    }

    public static <T> T toWorkT(T t, VelocityContext context, Map<String, String> kv) {
        String str = JSON.toJSONString(t);
        if (null != kv && kv.size() > 0) {
            for (Map.Entry<String, String> entry : kv.entrySet()) {
                str = str.replace(entry.getKey(), entry.getValue());
            }
        }
        return JSON.parseObject(workByEngine(str, context), (Class<T>) t.getClass());

    }

    public static Map<String, String> getDefaultEngineData() {
        Map<String, String> map = new HashMap();
        map.put("#$#", "$");
        return map;
    }

    /**
     * 拿T对象的值，自己翻译自己
     *
     * @param <T>
     * @param engine
     * @param t
     */
    public static <T> void setMyself(VelocityContext engine, T t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field fieldsobj : fields) {
            fieldsobj.setAccessible(true);
        }
        for (Field f : fields) {
            try {
                engine.put(f.getName(), f.get(t));
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(MybeanService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * 拿T对象的值，自己翻译自己
     *
     * @param <T>
     * @param engine
     * @param list
     * @param methodKey
     * @param methodValue
     */
    public static <T> void setMyself(VelocityContext engine, List<T> list, String methodKey, String methodValue) {
        Class tc = list.get(0).getClass();
        try {
            if (null != list && list.size() > 0) {
                Field[] fields = tc.getDeclaredFields();
                for (Field fieldsobj : fields) {
                    fieldsobj.setAccessible(true);
                }
                for (T t : list) {
                    engine.put(tc.getMethod(methodKey).invoke(t).toString(), tc.getMethod(methodValue).invoke(t).toString());
                }
            }
        } catch (IllegalArgumentException | IllegalAccessException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
            Logger.getLogger(EngineService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
