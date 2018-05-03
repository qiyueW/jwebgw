package wx.web.cc.hm.fangan.vo;

import configuration.DBO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.velocity.VelocityContext;
import wx.web.cc.bean.Bean;
import wx.web.cc.bean.Bean2;
import wx.web.cc.bean.Mybeanfield;
import wx.web.cc.service.EngineService;
import wx.web.cc.service.MybeanService;

/**
 *
 * @author adm.wangchunzi
 */
public class ABA {

    public String index;
    public String key;
    public Bean bean;
    public List<Bean2> bean2;
    public List<Mybeanfield> fields;

    public void iniBean(String index, Bean bean) {
        this.index = index;
        this.key = index.length() > 4 ? index.substring(4) : "";
        this.bean = bean;
        this.bean2 = DBO.service.S.selectByCondition(Bean2.class, "WHERE bean_zj IN('" + bean.getBean_zj() + "')");
        this.fields = DBO.service.S.selectByCondition(Mybeanfield.class, "WHERE bean_zj IN('" + bean.getBean_zj() + "')");
    }

    public void iniEngineData() {
        VelocityContext ctx = EngineService.getVelocityContext();
//1. bean的表头 自我翻译
        ctx.put("bean", this.bean);
        this.bean = EngineService.toWork(this.bean, ctx);
//2. bean的新表头与旧表体 自我翻译。 比如表体的a，引用同个表体的字段 b的值 ，通过${b} 取得。
        ctx.put("bean", this.bean);
        for (Bean2 b2 : bean2) {
            ctx.put(b2.getBean2_key(), b2.getBean2_value());
        }
        this.bean2 = EngineService.toWork(this.bean2, ctx);
//3. bean属性的 自我翻译
        List<Mybeanfield> fields2 = new ArrayList<>(fields.size());//新容器
        for (Bean2 b2 : bean2) {
            ctx.put(b2.getBean2_key(), b2.getBean2_value());
        }
        for (Mybeanfield f : fields) {
            fields2.add(EngineService.toWork(f, MybeanService.myself(ctx, f)));//用自己的数据翻译自己
        }
        this.fields = fields2;//用自己的数据翻译自己 后的新数据;
    }

    /**
     * 外翻译
     *
     * @param ctx
     */
    public void toSetEngineData(VelocityContext ctx) {
        ctx.put(index, this.bean);
        ctx.put("fields" + key, this.fields);
        for (Bean2 b2 : bean2) {
            ctx.put(b2.getBean2_key() + this.key, b2.getBean2_value());
        }
    }

    public static Set<ABA> getABA(FanganBeanVo vo) {
        Set<ABA> set = new HashSet<>();
        if (setABAError(set, "bean", vo.bean)) {
            return null;
        }
        if (setABAError(set, "bean1", vo.bean1)) {
            return null;
        }
        if (setABAError(set, "bean2", vo.bean2)) {
            return null;
        }
        if (setABAError(set, "bean3", vo.bean3)) {
            return null;
        }
        if (setABAError(set, "bean4", vo.bean4)) {
            return null;
        }
        if (setABAError(set, "bean5", vo.bean5)) {
            return null;
        }
        return set;
    }

    private static ABA getABA(String index, String zj) {
        if (null == zj || zj.isEmpty()) {
            return null;
        }
        Bean b = MybeanService.selectOne(zj);
        if (null == b || null == b.getBean_zj()) {
            return null;
        }
        ABA obj = new ABA();
        obj.iniBean(index, b);
        obj.iniEngineData();
        return obj;
    }

    private static boolean setABAError(Set<ABA> set, String index, String zj) {
        if (null == zj || zj.isEmpty()) {
            return false;
        }
        Bean b = MybeanService.selectOne(zj);
        if (null == b || null == b.getBean_zj()) {
            return true;
        }
        ABA obj = new ABA();
        obj.iniBean(index, b);
        obj.iniEngineData();
        set.add(obj);
        return false;
    }
}
