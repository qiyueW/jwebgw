package wx.web.cc.hm.model;

import configuration.DBO;
import configuration.KeyModel;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import wx.web.cc.bean.MyModel;
import wx.web.cc.bean.Mybeanfield;

@H("cc/mymodel")
public class MyModelADU {

    JWeb jw;

    public MyModelADU(JWeb jw) {
        this.jw = jw;
    }

    @M("/a/add")//cc/mymodel/a/add.jw
    public void add() {
        wx.web.cc.bean.MyModel obj = jw.getObject(wx.web.cc.bean.MyModel.class);
        if (DBO.service.ADUS.executeQueryCount("SELECT COUNT(*) FROM MyModel WHERE mybean_zj='" + obj.getMybean_zj()
                + "' AND mymodel_mc='" + obj.getMymodel_mc() + "'") > 0) {
            jw.printOne(DBO.getJSONModel("0", "同个bean，不能同时存在相同的模型"));
            return;
        }
        int i = DBO.service.A.addOne(obj);
        jw.printOne(i == -1 ? DBO.getJSONModel("-1", "添加出错")
                : (i == 0 ? DBO.getJSONModel("0", "添加失败，未知原因。请通知管理员调试系统") : DBO.getJSONModel("1", "添加成功。")));
    }

    @M("/d/dell")
    public void dellVast() {
        String ids = jw.getString("ids");
        if(null==ids||ids.length()<24)return;
        String id = "";
        for (String str : ids.split(",")) {
            id = id + ",'" + str + "'";
        }
        id= "WHERE mybeanfield_zj in(" + id.substring(1) + ") ";
        int i=DBO.service.D.deleteVastByCondition_CheckToDeny(wx.web.cc.bean.Mybeanfield.class,id,null);
        if(i==-1)jw.printOne(DBO.getJSONModel("-1","无法执行删除。已经被使用"));
		jw.printOne(i==0?DBO.getJSONModel("0","删除失败，请通知管理员检查网络或数据库。或稍后再试。")
				:DBO.getJSONModel("1","删除成功"));
    }
    
    @M("/u/update")
    public void update() {
        MyModel obj = jw.getObject(MyModel.class);
        if (null == obj.getMymodel_zj()|| obj.getMymodel_zj().length() != 24) {
            return;
        }
        DBO.out_update_1_0_f1(jw, DBO.service.U.updateSome_reject(obj,"mybean_zj,mybean_mc"));
    }

    @M("/u/update/select")
    public void updateSelect_UseFilter_CheckUpdateSelect() {
        // 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
        String selectUpdateID = jw.getString(KeyModel.ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);

        MyModel obj = DBO.service.S.selectOneByID(MyModel.class, selectUpdateID);
        if (null == obj.getMymodel_zj()) {
            return;
        }
        jw.request.setAttribute("obj", obj);
        jw.forward("/cc/mymodel/myModel_U.jsp");
    }
}
