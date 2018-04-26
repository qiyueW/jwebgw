package wx.web.cc.hm.fangan;

import com.alibaba.fastjson.JSON;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import wx.web.cc.service.FanganService;

/**
 * 公共区，使用预设值
 *
 * @author adm.wangchunzi
 */
@H("cc/fangan/s2")
public class FanganS2 {

    private static final String beanKey = "bean";
    private static final String fieldsKey = "fields";

    @M("/findBody")
    public static void selectBody(JWeb jw) {
        String zj = jw.getString("zj");
        jw.printOne(JSON.toJSONString(FanganService.getBody(zj)));
    }

}
