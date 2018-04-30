package wx.web.cc.service;

import configuration.DBO;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import wx.web.cc.bean.Mybean;
import wx.web.cc.bean.Mybeanfield;
import wx.web.cc.hm.fangan.vo.FanganBeanVo;

/**
 *
 * @author adm.wangchunzi
 */
public class MybeanService {

    public static String myVelocityEngine(String modelData, List<Mybeanfield> fields, Mybean bean) {
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

    public static String fanganVelocityEngine(String modelData, Map<String, Mybean> beanMap, Map<String, List<Mybeanfield>> fields, Map<String, String> otherMap) {
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        VelocityContext context = new VelocityContext();
        beanMap.forEach((k, v) ->context.put(k, v));//替换bean集合的每个元素的值
        fields.forEach((k, v) -> context.put(k, v));//替换bean属性集合的每个元素的值
        if (null != otherMap && otherMap.size() > 0) {
            otherMap.forEach((k, v) -> context.put(k, v));
        }
        StringWriter writer = new StringWriter();
        String str=modelData.replace("&#39;", "'").replace("&#34;", "\"").replace("&#92;", "\\").replace("&#60;", "<").replace("&#62;", ">");
        System.out.println(str);
        ve.evaluate(context, writer, "", str); // 关键方法
        return writer.toString().replace("#$#", "$");
    }

    public static Map<String, Mybean> getBean(FanganBeanVo vo) {
        Map<String, Mybean> map = new HashMap<>();
        if (iniMapData_ErrorByTrue(map, "bean", vo.bean)) {
            return null;
        }
        if (iniMapData_ErrorByTrue(map, "bean1", vo.bean1)) {
            return null;
        }
        if (iniMapData_ErrorByTrue(map, "bean2", vo.bean2)) {
            return null;
        }
        if (iniMapData_ErrorByTrue(map, "bean3", vo.bean3)) {
            return null;
        }
        if (iniMapData_ErrorByTrue(map, "bean4", vo.bean4)) {
            return null;
        }
        if (iniMapData_ErrorByTrue(map, "bean5", vo.bean5)) {
            return null;
        }
        return map;
    }

    //浓缩 方法Map<String, Mybean> getBean(FanganBeanVo vo)的逻辑。方便复用。
    private static boolean iniMapData_ErrorByTrue(final Map<String, Mybean> map, final String key, final String bean_zj) {
        if (null != bean_zj && bean_zj.length() == 24) {
            Mybean obj = selectOne(bean_zj);
            if (null == obj || null == obj.getMybean_zj()) {//bean异常 没找到bean或数据库查询时出了问题
                return true;
            }
            map.put(key, obj);//key-obj关联起来
            System.out.println(key + "//" + obj.getMybean_mc());
        }
        return false;
    }
//==============================================key-beanfields

    public static Map<String, List<Mybeanfield>> getBeanFields(Map<String, Mybean> mb) {
        Map<String, List<Mybeanfield>> map = new HashMap<>();
        mb.forEach((k, v) -> map.put(getFieldsKeyByBeanKey(k), DBO.service.S.selectByCondition(Mybeanfield.class, "WHERE mybean_zj =" + v.getMybean_zj())));
        return map;
    }

    public static Mybean selectOne(final String zj) {
        return DBO.service.S.selectOneByID(Mybean.class, zj);
    }

    public static String getFieldsKeyByBeanKey(final String beanKey) {
        switch (beanKey) {
            case "bean":
                return "fields";
            case "bean1":
                return "fields1";
            case "bean2":
                return "fields2";
            case "bean3":
                return "fields3";
            case "bean4":
                return "fields4";
            case "bean5":
                return "fields5";
        }
        return "fields";
    }
}
