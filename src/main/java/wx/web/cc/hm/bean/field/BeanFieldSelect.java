package wx.web.cc.hm.bean.field;

import configuration.DBO;
import java.util.List;
import plugins.easyui.EasyuiService;
import plugins.easyui.vo.EasyuiPage;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import wx.web.cc.bean.BeanField;
import wx.web.cc.service.BeanFieldService;

@system.web.power.ann.SQ("Y101_8_1")
@H("cc/bean/field/s")
public class BeanFieldSelect {

    @M("/selectOne")
    public static void selectOne(JWeb jw) {
        String beanfield_zj = jw.getString("beanfield_zj");
        if (null == beanfield_zj || beanfield_zj.isEmpty()) {
            return;
        }
        BeanField obj = DBO.service.S.selectOneByID(BeanField.class, beanfield_zj);
        jw.set("obj", obj);
        jw.forward("/cc/bean/beanfield/beanfield_one.jsp");
    }

    @M("/select2OneByJson")//一对多。通过表头主键，查询体表
    public static void selectOne2(JWeb jw) {
        String beanfield_zj = jw.getString("beanfield_zj");
        if (null == beanfield_zj || beanfield_zj.isEmpty()) {
            jw.printOne("{}");
            return;
        }
        jw.printOne(EasyuiService.formatGrid(BeanFieldService.getBody(beanfield_zj)));
    }

    @M("/selectAllByJson")
    public static void selectJSON(JWeb jw) {
        String bean_zj = jw.getString("bean_zj");
        if (null == bean_zj || bean_zj.isEmpty()) {
            jw.printOne("[]");
            return;
        }
        String where = "WHERE bean_zj='" + bean_zj + "'";
        EasyuiPage page = EasyuiService.getPage(jw);

        List<BeanField> list = null == jw.getString("page") 
                ? DBO.service.S.selectByCondition(BeanField.class, where, "ORDER BY beanfield_px  ASC") 
                : DBO.service.S.selectVastByCondition(BeanField.class, page.page, page.rows, where, "ORDER BY beanfield_px ASC");
        
        jw.printOne(EasyuiService.formatGrid(list, DBO.service.S.selectCountByCondition(BeanField.class, where)));
    }

}
