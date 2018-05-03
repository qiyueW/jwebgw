package wx.web.cc.hm.mybean.mybeanfield;

import com.alibaba.fastjson.JSON;
import configuration.DBO;
import configuration.KeyModel;
import java.util.List;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.ann.SQ;
import wx.web.cc.bean.Bean;
import wx.web.cc.bean.Bean2;
import wx.web.cc.bean.Mybeanfield;
import wx.web.cc.service.MybeanService;

@H("cc/mybean/field")
public class MybeanFieldAdd {

    JWeb jw;

    public MybeanFieldAdd(JWeb jw) {
        this.jw = jw;
    }

    @SQ("Y101_7")
    @M("/a/add")
    public void add() {
        wx.web.cc.bean.Mybeanfield beanfield = jw.getObject(wx.web.cc.bean.Mybeanfield.class);
        Bean bean = DBO.service.S.selectOneByID(Bean.class, beanfield.getBean_zj());
        if (null == bean || null == bean.getBean_zj()) {
            jw.printOne(DBO.getJSONModel("-1", "后台没找到相关的bean.注：选择bean时，一定要选择。不要直接输完"));
            return;
        }
        beanfield.setBean_mc(bean.getBean_mc());
        if (DBO.service.ADUS.executeQueryCount("SELECT COUNT(*) FROM Mybeanfield WHERE bean_zj='" + beanfield.getBean_zj()
                + "' AND c_mc='" + beanfield.getC_mc() + "'") > 0) {
            jw.printOne(DBO.getJSONModel("0", "同个bean，不能同时存在相关的字段"));
            return;
        }
        List<Bean2> listBean2 = DBO.service.S.selectByCondition(Bean2.class, "WHERE bean_zj IN('" + bean.getBean_zj() + "')");
        //通用与强制的翻译
        String jsonData = MybeanService.toEngineCommonData(JSON.toJSONString(beanfield).replace("[?c?]", bean.getBean_mc().toLowerCase()), null);
        //Bean,Bean2,Beanfield 的翻译
        jsonData = MybeanService.toEngineBean(jsonData, bean, listBean2, beanfield);
        beanfield = JSON.parseObject(jsonData, wx.web.cc.bean.Mybeanfield.class);
        
        int i = DBO.service.A.addOne(beanfield);
        jw.printOne(i == -1 ? DBO.getJSONModel("-1", "添加出错")
                : (i == 0 ? DBO.getJSONModel("0", "添加失败，未知原因。请通知管理员调试系统") : DBO.getJSONModel("1", "添加成功。")));
    }

    @SQ("Y101_8_3")
    @M("/d/dell")
    public void dellVast() {
        String ids = jw.getString("ids");
        if (null == ids || ids.length() < 24) {
            return;
        }
        String id = "";
        for (String str : ids.split(",")) {
            id = id + ",'" + str + "'";
        }
        id = "WHERE mybeanfield_zj in(" + id.substring(1) + ") ";
        int i = DBO.service.D.deleteVastByCondition_CheckToDeny(wx.web.cc.bean.Mybeanfield.class, id, null);
        if (i == -1) {
            jw.printOne(DBO.getJSONModel("-1", "无法执行删除。已经被使用"));
        }
        jw.printOne(i == 0 ? DBO.getJSONModel("0", "删除失败，请通知管理员检查网络或数据库。或稍后再试。")
                : DBO.getJSONModel("1", "删除成功"));
    }

    @SQ("Y101_8_2")
    @M("/u/update")
    public void update() {
        Mybeanfield obj = jw.getObject(Mybeanfield.class);
        if (null == obj.getMybeanfield_zj() || obj.getMybeanfield_zj().length() != 24) {
            return;
        }
        DBO.out_update_1_0_f1(jw, DBO.service.U.updateSome_reject(obj, "bean_zj,bean_mc"));
    }

    @SQ("Y101_8_2")
    @M("/u/update/select")
    public void updateSelect_UseFilter_CheckUpdateSelect() {
        // 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
        String selectUpdateID = jw.getString(KeyModel.ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);

        Mybeanfield obj = DBO.service.S.selectOneByID(Mybeanfield.class, selectUpdateID);
        if (null == obj.getBean_zj()) {
            return;
        }
        jw.request.setAttribute("obj", obj);
        jw.forward("/cc/mybeanfield/Mybeanfield_U.jsp");
    }
}
