package wx.web.base.hm.bm;


import configuration.KeyModel.ReturnKey;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import configuration.DBO;
import wx.web.base.bean.BM;

@H("/base/bm")
@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "J51_3")
public class BMDell {

    JWeb jw;

    public BMDell(JWeb jw) {
        this.jw = jw;
    }
    @M("/dell")
    public void dellVast() {
        int i = DBO.service.D.deleteVastByID_CheckToDeny(
                BM.class          //关联宿舍表
                , jw.getString("ids")//宿舍ID集合
                ,null                   
//                ,ZSHT.class          //1.如果删除的ID在此表存在，阻止删除 【住宿合同】表
//                ,SDF.class           //2.如果删除的ID在此表存在，阻止删除 【水电费】表
//                ,SDF_QC.class                    // 3.现在，我要拓展一个【水电期初表】 .如果删除的ID在此表存在，阻止删除 
        );
        jw.printOne(i == -1? ReturnKey.DELL_UNIQUE.statusCode
                : (i > 0 ? ReturnKey.DELL_SUCESS.statusCode : ReturnKey.DELL_ERROR.statusCode));
        wx.web.base.BCM.RY_CACHE.reset();
    }
}
