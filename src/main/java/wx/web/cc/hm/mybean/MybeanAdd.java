package wx.web.cc.hm.mybean;

import system.base.annotation.Validate;
import system.web.JWeb;
import system.base.annotation.H;
import system.base.annotation.M;
import configuration.DBO;

@H("cc/mybean/a")
public class MybeanAdd {

    JWeb jw;

    public MybeanAdd(JWeb jw) {
        this.jw = jw;
    }

    @M("/add")
    @Validate(wx.web.cc.hm.mybean.validate.MybeanValidate.class)
    public void add() {
        wx.web.cc.bean.Mybean obj = jw.getObject(wx.web.cc.bean.Mybean.class);
        int i = DBO.service.A.addOne(obj);
        wx.web.cc.hm.mybean.cache.MybeanCache.CACHE.resetNow();
        jw.printOne(i == -1
                ? DBO.getJSONModel("-1", "添加出错")
                : (i == 0 ? DBO.getJSONModel("0", "添加失败，未知原因。请通知管理员调试系统")
                        : DBO.getJSONModel("1", "添加成功。"))
        );
    }

}
