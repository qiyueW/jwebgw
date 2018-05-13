package wx.web.cc.service.svo;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import wx.web.cc.bean.Bean;
import wx.web.cc.bean.Bean2;

/**
 *
 * @author wo
 */
public class BeanSVO {

    public final Bean bean;
    public final List<Bean2> bean2List;
    public final static Field[] BF = Bean.class.getDeclaredFields();

    static {
        for (Field f : BF) {
            f.setAccessible(true);
        }
    }

    /**
     * 将bean的 字段-值 通过 Map联系起来
     *
     * @param obj BeanSVO
     * @return
     */
    public static Map<String, String> getBean_KeyValue(BeanSVO obj) {
        Map<String, String> mapObject = ClassTool.getObject_KeyValue(obj.bean, BF, null);
        return ClassTool.getListKV_KeyValue(obj.bean2List, BF, "getBean2_key", "getBean2_value", mapObject);
    }

    public BeanSVO(Bean bean, List<Bean2> bean2List) {
        this.bean = bean;
        this.bean2List = bean2List;
    }

    public static BeanSVO selectByBeanID(String bean_id) {
        // 找到 Bean
        Bean bean = wx.web.cc.service.BeanService.getBean(bean_id);
        if (null == bean || null == bean.getBean_zj()) {
            return null;
        }
        List<Bean2> bean2List = wx.web.cc.service.BeanService.getBody(bean_id);
        return new BeanSVO(bean, bean2List);
    }
}
