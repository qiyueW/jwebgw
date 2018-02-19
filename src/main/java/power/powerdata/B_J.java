package power.powerdata;

import system.web.power.data.IPowerData;
import system.web.power.data.PD;

/**
 *
 * @author wangchunzi
 */
public class B_J  implements IPowerData{

    @Override
    public int key() {
        return PDConfig.keyCode.J.key;
    }

    @Override
    public void doPowerData(PD pdt) {
       pdt.setEmptyNode("0", "J", "基础管理", false)
               
        .setEmptyNode("J", "J5", "部门管理", false)
            .setHMAndViewNode("J5", "J51", "添加部门","admin/base/bm/bm_A.jsp", true)
            .setViewNode("J5", "J52", "部门中心", "admin/base/bm/bm.jsp", true)
                .setHMNode("J52", "J51_1", "查询")
                .setHMNode("J52", "J51_2", "修改")
                .setHMNode("J52", "J51_3", "删除")
               
        .setEmptyNode("J", "J4", "人员管理", false)
            .setHMAndViewNode("J4", "J41", "添加人员(Root)","admin/base/ry/ry_A.jsp", true)
            .setHMAndViewNode("J4", "J42", "添加人员(开放)","viwe/ryzhuce.jsp", true)
            .setViewNode("J4", "J43", "待审新建人员","admin/base/ry/ryList0.jsp", true)
                .setHMNode("J43", "J43_1", "查询")
                .setHMNode("J43", "J43_2", "审核")
                .setHMNode("J43", "J43_3", "删除")
 
            .setViewNode("J4", "J44", "人员中心", "admin/base/ry/ryList.jsp", true)
                .setHMNode("J44", "J44_1", "查询")
                .setHMNode("J44", "J44_2", "修改")
                .setHMNode("J44", "J44_3", "删除")
                .setHMNode("J44", "J44_4", "停用|启用")
// 
//        .setEmptyNode("J", "J6", "物料管理", false)
//            .setHMAndViewNode("J6", "J61", "添加分类","admin/base/wl/fl/wuliaoFL_A.jsp", true)
//            .setViewNode("J6", "J62", "分类中心", "admin/base/wl/fl/wuliaoFL.jsp", true)
//                .setHMNode("J62", "J61_1", "分类查询")
//                .setHMNode("J62", "J61_2", "分类修改")
//                .setHMNode("J62", "J61_3", "分类删除")
//             .setHMAndViewNode("J6", "J61", "添加分类","admin/wl/lf/bm/bm_A.jsp", true)
//            .setViewNode("J6", "J62", "分类中心", "admin/base/wl/lf/bm.jsp", true)
//                .setHMNode("J62", "J61_1", "分类查询")
//                .setHMNode("J62", "J61_2", "分类修改")
//                .setHMNode("J62", "J61_3", "分类删除")              
               
               
                ;
    }
}
