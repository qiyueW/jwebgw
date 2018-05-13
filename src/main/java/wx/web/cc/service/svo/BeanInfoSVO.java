package wx.web.cc.service.svo;

import java.util.List;
import java.util.Map;
import org.apache.velocity.VelocityContext;
import wx.web.cc.service.EngineService;

/**
 *
 * @author adm.wangchunzi
 */
public class BeanInfoSVO {

    public final String index;
    public final String key;
    public final BeanSVO bean;
    public final List<BeanFieldSVO> fields;

    /**
     * 针对单一bean的 代码模板翻译 在线看的数据产出。
     *
     * @param bean_zj
     */
    public BeanInfoSVO(final String bean_zj) {
        this.index = "";
        this.key = "";// index.length() > 4 ? index.substring(4) : "";
        this.bean = BeanSVO.selectByBeanID(bean_zj);
        this.fields = BeanFieldSVO.getListByBeanID(bean_zj);
    }
    
    public String getEngineData_Online(final String modelData, Map<String, String> defaultKV) {
        VelocityContext vc = EngineService.getVelocityContext();
        vc.put("bean", BeanSVO.getBean_KeyValue(this.bean));
        vc.put("fields", BeanFieldSVO.getField_KeyValue(this.fields));
        if (null != defaultKV && defaultKV.size() > 0) {
            for (Map.Entry<String, String> m : defaultKV.entrySet()) {
                vc.put(m.getKey(), m.getValue());
            }
        }
        return EngineService.workByEngine(EngineService.fzFormat(modelData), vc);
    }

//
//    /**
//     * 外翻译
//     *
//     * @param ctx
//     */
//    public void toSetEngineData(VelocityContext ctx) {
//        ctx.put(index, this.bean);
//        ctx.put("fields" + key, this.fields);
//        for (Bean2 b2 : bean2) {
//            ctx.put(b2.getBean2_key() + this.key, b2.getBean2_value());
//        }
//    }
//
//    public static Set<BeanInfoSVO> getABA(FanganBeanVo vo) {
//        Set<BeanInfoSVO> set = new HashSet<>();
//        if (setABAError(set, "bean", vo.bean)) {
//            return null;
//        }
//        if (setABAError(set, "bean1", vo.bean1)) {
//            return null;
//        }
//        if (setABAError(set, "bean2", vo.bean2)) {
//            return null;
//        }
//        if (setABAError(set, "bean3", vo.bean3)) {
//            return null;
//        }
//        if (setABAError(set, "bean4", vo.bean4)) {
//            return null;
//        }
//        if (setABAError(set, "bean5", vo.bean5)) {
//            return null;
//        }
//        return set;
//    }
}
