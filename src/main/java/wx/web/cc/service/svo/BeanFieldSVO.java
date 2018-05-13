package wx.web.cc.service.svo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wx.web.cc.bean.BeanField;
import wx.web.cc.bean.BeanField2;
import wx.web.cc.service.BeanFieldService;

/**
 *
 * @author wo
 */
public class BeanFieldSVO {

    public final BeanField beanField;
    public final List<BeanField2> beanField2List;
    public final static Field[] BF = BeanField.class.getDeclaredFields();
    public final static Field[] B2F = BeanField2.class.getDeclaredFields();

    static {
        for (Field f : BF) {
            f.setAccessible(true);
        }
        for (Field f : B2F) {
            f.setAccessible(true);
        }
    }

    public BeanFieldSVO(BeanField beanField, List<BeanField2> beanField2List) {
        this.beanField = beanField;
        this.beanField2List = beanField2List;
    }

    public static List<BeanFieldSVO> getListByBeanID(final String bean_zj) {
        List<BeanFieldSVO> slist = new ArrayList<>();
        List<BeanField> dbBeanFeild = BeanFieldService.getBeanFileHeadByBeanID(bean_zj);
        for (BeanField bf : dbBeanFeild) {
            slist.add(new BeanFieldSVO(bf, BeanFieldService.getBeanFileBodyByBeanfieldID(bf.getBeanfield_zj())));
        }
        return slist;
    }

    /**
     * 将bean的 字段-值 通过 Map联系起来
     *
     * @param list List<BeanFieldSVO>
     * @return Map<String, String>
     */
    public static List<Map<String, String>> getField_KeyValue(List<BeanFieldSVO> list) {
        List<Map<String, String>> rs = new ArrayList<>();
        Map<String, String> map;
        for (BeanFieldSVO vo : list) {
            map = ClassTool.getObject_KeyValue(vo.beanField, BF, null);
            ClassTool.getListKV_KeyValue(vo.beanField2List, B2F, "getBeanfield2_key", "getBeanfield2_value", map);
            rs.add(map);
        }
        return rs;
    }
}
