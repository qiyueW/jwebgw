package wx.web.cc.service.svo;

import java.util.List;
import wx.web.cc.bean.Bean;
import wx.web.cc.bean.Bean2;

/**
 *
 * @author wo
 */
public class BeanSVO {

    public final Bean bean;
    public final List<Bean2> bean2List;

    public BeanSVO(Bean bean, List<Bean2> bean2List) {
        this.bean = bean;
        this.bean2List = bean2List;
    }

    public static BeanSVO selectByID(String bean_id) {
        // 找到 Bean
        Bean bean = wx.web.cc.service.BeanService.getBean(bean_id);
        if (null == bean || null == bean.getBean_zj()) {
            return null;
        }
        List<Bean2> bean2List = wx.web.cc.service.BeanService.getBody(bean_id);
        return new BeanSVO(bean, bean2List);
    }
}
