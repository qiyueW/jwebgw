package wx.web.cc.hm.fangan;

import com.alibaba.fastjson.JSON;
import configuration.DBO;
import java.util.List;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import system.web.power.session.Login;
import wx.web.base.bean.RY;
import wx.web.cc.hm.fangan.cache.CCDataCache;
import wx.web.cc.hm.fangan.vo.FanganBeanVo;
import wx.web.cc.service.FanganService;
import wx.web.cc.service.svo.FanganUserData;

@H("cc/fangan/use")
public class UseFangan {

    JWeb jw;

    public UseFangan(JWeb jw) {
        this.jw = jw;
    }

    @system.web.power.ann.SQ("Y101_19_1")
    @M("/create/userdata")
    @Validate(wx.web.cc.hm.fangan.validate.UseFanganValidate.class)
    public void use() {
        FanganBeanVo obj = jw.getObject(FanganBeanVo.class);
        List<FanganUserData> userList = FanganService.fanganVelocityEngine(obj);
        String json = JSON.toJSONString(userList);

        RY ry = Login.getUserInfo(RY.class, jw);
        CCDataCache.put(ry.getRy_account(), json);
        jw.printOne(DBO.getJSONModel("1", "已经推入队列。请在客户端进行获取与生成文件"));
    }
}
