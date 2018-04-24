package wx.web.cc.hm.yushizhi;

import com.alibaba.fastjson.JSON;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import wx.web.cc.hm.yushizhi.service.YushizhiService;

/**
 * 公共区，使用预设值
 *
 * @author adm.wangchunzi
 */
@H("cc/yushizhi/s2")
public class YushizhiSelect2 {

    private static final String beanKey = "bean";
    private static final String fieldsKey = "fields";

    @M("/findHead")
    public static void selectHeadByFL(JWeb jw) {
        jw.printOne(JSON.toJSONString(YushizhiService.getHead(jw.getString("key"))));
    }

    @M("/findBody")
    public static void selectBody(JWeb jw) {
        String zj = jw.getString("zj");
        jw.printOne(JSON.toJSONString(YushizhiService.getBody(zj)));
    }

}
