package wx.web.cc.service;

import configuration.DBO;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import wx.web.cc.bean.Bean;
import wx.web.cc.bean.Bean2;
import wx.web.cc.bean.Mybeanfield;
import wx.web.cc.hm.fangan.vo.ABA;

/**
 *
 * @author adm.wangchunzi
 */
public class MybeanService {

    public static String myVelocityEngine(String modelData, List<Mybeanfield> fields, Bean bean) {
        if (null == fields || fields.isEmpty()) {
            return "";
        }
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        VelocityContext context = new VelocityContext();
        context.put("fields", fields);
        context.put("bean", bean);
        StringWriter writer = new StringWriter();
        ve.evaluate(context, writer, "", modelData.replace("&#39;", "'").replace("&#34;", "\"").replace("&#92;", "\\").replace("&#60;", "<").replace("&#62;", ">")); // 关键方法
        return writer.toString().replace("#$#", "$");
    }

    /**
     * 方案执行时，进行翻译
     *
     * @param modelData
     * @param set
     * @param otherMap
     * @return
     */
    public static String fanganVelocityEngine(String modelData, Set<ABA> set, Map<String, String> otherMap) {
        VelocityContext context = EngineService.getVelocityContext();
        if (null != otherMap && otherMap.size() > 0) {
            otherMap.forEach((k, v) -> context.put(k, v));
        }
        for (ABA aba : set) {
            aba.toSetEngineData(context);
        }
        String str = modelData.replace("&#39;", "'").replace("&#34;", "\"").replace("&#92;", "\\").replace("&#60;", "<").replace("&#62;", ">");
        return EngineService.workByEngine(str, context);
    }

    public static String toEngineCommonData(String model, Map<String, String> otherMap) {
        model = model.replace("&#39;", "'").replace("&#92;", "\\").replace("&#60;", "<").replace("&#62;", ">");//.replace("&#34;", "\"")
        if (null == otherMap) {
            return model;
        }
        VelocityContext ctx = EngineService.getVelocityContext();
        otherMap.forEach((k, v) -> ctx.put(k, v));
        return EngineService.workByEngine(model, ctx);
    }

    /**
     * 针对添加/修改时，bean/bean2 的自我翻译
     *
     * @param model json字符化的 bean或bean2
     * @param obj bean对象
     * @param list bean2集合
     * @return String 翻译后的字符串
     */
    public static String toEngineBean(String model, Bean obj, List<Bean2> list) {
        VelocityContext ctx = EngineService.getVelocityContext();
        myself(ctx, obj);//首先是表头的bean的自我翻译。
        for (Bean2 b2 : list) {
            ctx.put(b2.getBean2_key(), b2.getBean2_value());//表体的自我翻译
        }
        return EngineService.workByEngine(model, ctx);
    }

    /**
     * 针对添加/修改时，Mybeanfield 的自我翻译
     *
     * @param model json字符化的 bean或bean2
     * @param obj bean对象
     * @param list bean2集合
     * @param bflist
     * @return String 翻译后的字符串
     */
    public static String toEngineBean(String model, Bean obj, List<Bean2> list, Mybeanfield bflist) {
        VelocityContext ctx = EngineService.getVelocityContext();
        myself(ctx, obj);//首先是表头的bean的自我翻译。
        for (Bean2 b2 : list) {
            ctx.put(b2.getBean2_key(), b2.getBean2_value());//表体的自我翻译
        }
        myself(ctx, bflist);//属性的自我翻译
        return EngineService.workByEngine(model, ctx);
    }

    public static <T> VelocityContext myself(VelocityContext context, T t) {
        Field[] fields = t.getClass().getDeclaredFields();
        for (Field fieldsobj : fields) {
            fieldsobj.setAccessible(true);
        }
        for (Field f : fields) {
            try {
                context.put(f.getName(), f.get(t));
            } catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(MybeanService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return context;
    }

//==============================================key-beanfields
//    public static Map<String, List<Mybeanfield>> getBeanFields(Map<String, Bean> mb) {
//        Map<String, List<Mybeanfield>> map = new HashMap<>();
//        mb.forEach((k, v) -> map.put(getFieldsKeyByBeanKey(k), DBO.service.S.selectByCondition(Mybeanfield.class, "WHERE bean_zj =" + v.getBean_zj())));
//        return map;
//    }
    public static Bean selectOne(final String zj) {
        return DBO.service.S.selectOneByID(Bean.class, zj);
    }

//    public static String getFieldsKeyByBeanKey(final String beanKey) {
//        switch (beanKey) {
//            case "bean":
//                return "fields";
//            case "bean1":
//                return "fields1";
//            case "bean2":
//                return "fields2";
//            case "bean3":
//                return "fields3";
//            case "bean4":
//                return "fields4";
//            case "bean5":
//                return "fields5";
//        }
//        return "fields";
//    }
}
