package wx.web.cc.service.svo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wo
 */
public class ClassTool {

    /**
     * 将一个对象，通过Map，将 字段=值 存放起来
     *
     * @param obj 对象
     * @param fields 对象的Field
     * @param mapObject 存放的容器
     * @return Map
     */
    public static Map<String, String> getObject_KeyValue(Object obj, Field[] fields, Map<String, String> mapObject) {
        Map<String, String> map = null == mapObject ? new HashMap() : mapObject;
        for (Field f : fields) {
            try {
                map.put(f.getName(), f.get(obj).toString());
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(BeanSVO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return map;
    }

    /**
     * 将 key-value 属性的对象的集合，通过Map，将 字段=值 存放起来
     *
     * @param <T> 某个 key value 属性的对象
     * @param list 集合
     * @param fields T类的Field
     * @param keyMethod key的方法
     * @param valueMethod value的方法
     * @param mapObject 存放的容器
     * @return Map
     */
    public static <T> Map<String, String> getListKV_KeyValue(List<T> list, Field[] fields, String keyMethod, String valueMethod, Map<String, String> mapObject) {
        Map<String, String> map = null == mapObject ? new HashMap() : mapObject;
        if (null == list || list.isEmpty()) {
            return map;
        }
        Class c = list.get(0).getClass();
        for (T t : list) {
            try {
                map.put(c.getDeclaredMethod(keyMethod).invoke(t).toString(), c.getDeclaredMethod(valueMethod).invoke(t).toString());
            } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(ClassTool.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return map;
    }

}
