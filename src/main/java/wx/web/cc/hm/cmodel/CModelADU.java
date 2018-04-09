package wx.web.cc.hm.cmodel;

import configuration.DBO;
import configuration.KeyModel;
import system.base.annotation.H;
import system.base.annotation.M;
import system.base.annotation.Validate;
import system.web.JWeb;
import system.web.power.ann.SQ;
import wx.web.cc.bean.CModel;

@H("cc/cmodel")
public class CModelADU {

    JWeb jw;

    public CModelADU(JWeb jw) {
        this.jw = jw;
    }
    @SQ("Y101_1")
    @Validate(wx.web.cc.hm._validate.CModelValidate.class)
    @M("/a/add")//cc/mymodel/a/add.jw
    public void add() {
        wx.web.cc.bean.CModel obj = jw.getObject(wx.web.cc.bean.CModel.class);
        obj.setCmodel_nr(obj.getCmodel_nr().replace("'", "&#39;"));
        int i = DBO.service.A.addOne(obj,"cmodel_mc");
        jw.printOne(i == -1 ? DBO.getJSONModel("-1", "添加出错，请检查字段是否唯一，或通知管理检测数据库是否断开")
                : (i == 0 ? DBO.getJSONModel("0", "添加失败，未知原因。请通知管理员调试系统") : DBO.getJSONModel("1", "添加成功。")));
    }
    @SQ("Y101_2_3")
    @M("/d/dell")
    public void dellVast() {
        String ids = jw.getString("ids");
        if(null==ids||ids.length()<24)return;
        String id = "";
        for (String str : ids.split(",")) {
            id = id + ",'" + str + "'";
        }
        id= "WHERE cmodel_zj in(" + id.substring(1) + ") ";
        int i=DBO.service.D.deleteVastByCondition_CheckToDeny(wx.web.cc.bean.CModel.class,id,null);
        if(i==-1)jw.printOne(DBO.getJSONModel("-1","无法执行删除。已经被使用"));
		jw.printOne(i==0?DBO.getJSONModel("0","删除失败，请通知管理员检查网络或数据库。或稍后再试。")
				:DBO.getJSONModel("1","删除成功"));
    }
    @SQ("Y101_2_2")    
    @M("/u/update")
    public void update() {
        CModel obj = jw.getObject(CModel.class);
        if (null == obj.getCmodel_zj()|| obj.getCmodel_zj().length() != 24) {
            return;
        }
        DBO.out_update_1_0_f1(jw, DBO.service.U.update_all(obj,"cmodel_mc"));
    }
    @SQ("Y101_2_2")
    @M("/u/update/select")
    public void updateSelect_UseFilter_CheckUpdateSelect() {
        // 表示用户修改前的查询id,查询此id的最新值，返回给用户修改
        String selectUpdateID = jw.getString(KeyModel.ParamKey.UPDATE_SELECT_PARAM_NAME.KEY);

        CModel obj = DBO.service.S.selectOneByID(CModel.class, selectUpdateID);
        if (null == obj.getCmodel_zj()) {
            return;
        }
        jw.request.setAttribute("obj", obj);
        jw.forward("/cc/cmodel/cModel_U.jsp");
    }
}
