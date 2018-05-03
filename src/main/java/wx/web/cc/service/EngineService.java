package wx.web.cc.service;

import com.alibaba.fastjson.JSON;
import java.io.StringWriter;
import java.util.List;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import wx.web.cc.bean.Bean;
import wx.web.cc.bean.Bean2;
import wx.web.cc.bean.Mybeanfield;

/**
 *
 * @author adm.wangchunzi
 */
final public class EngineService {

    private final static VelocityEngine ENGINE;

    static {
        ENGINE = new VelocityEngine();
        ENGINE.init();
    }

    public static String workByEngine(String modelData, VelocityContext context) {
        StringWriter writer = new StringWriter();
        ENGINE.evaluate(context, writer, "", modelData); // 关键方法
        return writer.toString().replace("#$#", "$");
    }

    public static VelocityContext getVelocityContext() {
        VelocityContext context = new VelocityContext();
        return context;
    }

    public static Bean toWork(Bean t, VelocityContext context) {
        return JSON.parseObject(workByEngine(JSON.toJSONString(t), context), Bean.class);
    }

    public static Mybeanfield toWork(Mybeanfield t, VelocityContext context) {
        return JSON.parseObject(workByEngine(JSON.toJSONString(t), context), Mybeanfield.class);
    }

    public static List<Bean2> toWork(List<Bean2> t, VelocityContext context) {
        return JSON.parseArray(workByEngine(JSON.toJSONString(t), context), Bean2.class);
    }

}
