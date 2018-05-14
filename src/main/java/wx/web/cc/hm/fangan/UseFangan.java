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
////========================准备数据阶段==================================
//        Set<ABA> aba = ABA.getABA(obj);
//        if (null == aba) {
//            jw.printOne(DBO.getJSONModel("-1", "异常：后台没找到您输入的某个bean名。添加bean，【一定要通过选择的方式】"));
//            return;
//        }
//        //要执行的方案
//        List<Fangan2> falist = FanganService.getBody(obj.fangan1_zj);
//        //数据支持：通过通用模板主键，可取得其的模板内容
//        Map<String, String> cmodelDatas = CModelService.toMapDataZJ_NR(CModelService.selectAll());
//        //数据支持：空的容器。用来放要生成的文件的相关数据
//        List<FanganUserData> userList = new ArrayList<>();
//
//        FanganUserData uobj;
////========================执行替换 ==================================          
//        for (Fangan2 fa : falist) {
//            uobj = new FanganUserData();
//            //赋值文件内容（通过处理模板后的数据）
//            uobj.filecontext = MybeanService.fanganVelocityEngine(cmodelDatas.get(fa.getCmodel_zj()), aba, null);
//            uobj.filename = MybeanService.fanganVelocityEngine(fa.getFangan2_filename(), aba, null);
//            uobj.filepath = MybeanService.fanganVelocityEngine(fa.getFangan2_filepath(), aba, null);
//            userList.add(uobj);
//        }

        List<FanganUserData> userList = FanganService.fanganVelocityEngine(obj);
        String json = JSON.toJSONString(userList);

        RY ry = Login.getUserInfo(RY.class, jw);
        CCDataCache.put(ry.getRy_account(), json);
        jw.printOne(DBO.getJSONModel("1", "已经推入队列。请在客户端进行获取与生成文件"));
    }
}
