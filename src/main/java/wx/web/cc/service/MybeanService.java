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
        ve.evaluate(context, writer, "", modelData.replace("&#39;", "'").replace("&#34;", "\"")); // 关键方法
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
        }
        return false;
    }
//==============================================key-beanfields

    public static Map<String, List<Mybeanfield>> getBeanFields(Map<String, Mybean> mb) {
        Map<String, List<Mybeanfield>> map = new HashMap<>();
        mb.forEach((k, v) -> map.put(k, DBO.service.S.selectByCondition(Mybeanfield.class, "WHERE mybean_zj =" + v.getMybean_zj())));
        return map;
    }

    public static Mybean selectOne(final String zj) {
        return DBO.service.S.selectOneByID(Mybean.class, zj);
    }
}
