package wx.web.cc.service.svo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.velocity.VelocityContext;
import wx.web.cc.hm.fangan.vo.FanganBeanVo;
import wx.web.cc.service.EngineService;

/**
 *
 * @author adm.wangchunzi
 */
public class BeanInfoSVO {

    public final String beanKey;
    public final String fieldsKey;
    public final BeanSVO bean;
    public final List<BeanFieldSVO> fields;
    public final Map<String, String> beanMap;
    public final List<Map<String, String>> fieldsMap;

    /**
     * 针对单一bean的 代码模板翻译 在线看的数据产出。
     *
     * @param bean_zj
     */
    public BeanInfoSVO(final String bean_zj) {
        this.beanKey = "";
        this.fieldsKey = "";// index.length() > 4 ? index.substring(4) : "";
        this.bean = BeanSVO.selectByBeanID(bean_zj);
        this.fields = BeanFieldSVO.getListByBeanID(bean_zj);
        this.beanMap = BeanSVO.getBean_KeyValue(this.bean);
        this.fieldsMap = BeanFieldSVO.getField_KeyValue(this.fields);
    }

    /**
     * 针对单一bean的 代码模板翻译 在线看的数据产出。
     *
     * @param index
     * @param bean_zj
     */
    public BeanInfoSVO(String index, final String bean_zj) {
        this.beanKey = index;
        this.fieldsKey = "fields" + (index.length() > 4 ? index.substring(4) : "");
        this.bean = BeanSVO.selectByBeanID(bean_zj);
        this.fields = BeanFieldSVO.getListByBeanID(bean_zj);
        this.beanMap = BeanSVO.getBean_KeyValue(this.bean);
        this.fieldsMap = BeanFieldSVO.getField_KeyValue(this.fields);
    }

    public String getEngineData_Online(final String modelData, Map<String, String> defaultKV) {
        VelocityContext vc = EngineService.getVelocityContext();
        vc.put("bean", this.beanMap);
        vc.put("fields", this.fieldsMap);
        if (null != defaultKV && defaultKV.size() > 0) {
            for (Map.Entry<String, String> m : defaultKV.entrySet()) {
                vc.put(m.getKey(), m.getValue());
            }
        }
        return EngineService.workByEngine(EngineService.fzFormat(modelData), vc);
    }

    final public static List<BeanInfoSVO> getBeanInfoSVOList(FanganBeanVo obj) {
        List<BeanInfoSVO> list = new ArrayList<>();
        list.add(new BeanInfoSVO("bean", obj.bean));
        if (null != obj.bean1 && obj.bean1.length() == 24) {
            list.add(new BeanInfoSVO("bean1", obj.bean1));
        }
        if (null != obj.bean2 && obj.bean2.length() == 24) {
            list.add(new BeanInfoSVO("bean2", obj.bean2));
        }
        if (null != obj.bean3 && obj.bean3.length() == 24) {
            list.add(new BeanInfoSVO("bean3", obj.bean3));
        }
        if (null != obj.bean4 && obj.bean4.length() == 24) {
            list.add(new BeanInfoSVO("bean4", obj.bean4));
        }
        if (null != obj.bean5 && obj.bean5.length() == 24) {
            list.add(new BeanInfoSVO("bean5", obj.bean5));
        }
        return list;
    }

}
