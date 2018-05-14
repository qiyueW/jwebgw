package wx.web.cc.service;

import configuration.DBO;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.velocity.VelocityContext;
import wx.web.cc.bean.Fangan2;
import wx.web.cc.hm.fangan.vo.FanganBeanVo;
import wx.web.cc.service.svo.BeanInfoSVO;
import wx.web.cc.service.svo.FanganUserData;

/**
 *
 * @author adm.wangchunzi
 */
public class FanganService {

    /**
     * 通过表头ID,取得表体ID
     *
     * @param zj
     * @return
     */
    public static List<Fangan2> getBody(String zj) {
        return DBO.service.S.selectByCondition(Fangan2.class, "WHERE fangan1_zj IN('" + zj + "')");
    }

    public static int[] topx(String[] ids) {
        String[] sqldata = new String[ids.length];
        for (int i = 0; i < ids.length; i++) {
            sqldata[i] = "UPDATE Fangan1 SET fangan1_px=" + i + " WHERE fangan1_zj='" + ids[i] + "'";
        }
        return DBO.service.ADUS.executeBatch(sqldata);
    }

    public static List<FanganUserData> fanganVelocityEngine(FanganBeanVo obj) {
        List<FanganUserData> rs = new ArrayList<>();//翻译结果的容器
        List<BeanInfoSVO> bsvo = BeanInfoSVO.getBeanInfoSVOList(obj);//参与翻译工作者
        List<Fangan2> falist = FanganService.getBody(obj.fangan1_zj);//要执行的翻译模型
        VelocityContext vc = EngineService.getVelocityContext();//准备翻译工具

        //数据支持：通过通用模板主键，可取得其的模板内容
        Map<String, String> cmodelDatas = CModelService.toMapDataZJ_NR(CModelService.selectAll());

        for (BeanInfoSVO vo : bsvo) {
            vc.put(vo.beanKey, vo.beanMap);//bean的信息
            vc.put(vo.fieldsKey, vo.fieldsMap);//fields的信息
        }
        FanganUserData rud;
        for (Fangan2 fa : falist) {
            rud = new FanganUserData();
            rud.filecontext = EngineService.toFotmatJSONData(
                    EngineService.workByEngine(
                            EngineService.fzFormat(cmodelDatas.get(fa.getCmodel_zj())),
                            vc)
            );//取出模板并进行翻译
            rud.filename = EngineService.toFotmatJSONData(EngineService.workByEngine(fa.getFangan2_filename(), vc));//取出文件名并进行翻译
            rud.filepath = EngineService.toFotmatJSONData(EngineService.workByEngine(fa.getFangan2_filepath(), vc));//取出路径并进行翻译
            rs.add(rud);
        }
        return rs;
    }
}
