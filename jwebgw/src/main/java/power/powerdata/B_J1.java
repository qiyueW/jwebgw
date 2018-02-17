package power.powerdata;

import system.web.power.data.IPowerData;
import system.web.power.data.PD;

/**
 *
 * @author wangchunzi
 */
public class B_J1  implements IPowerData{

    @Override
    public int key() {
        return PDConfig.keyCode.J1.key;
    }

    @Override
    public void doPowerData(PD pdt) {
       pdt
//               .setEmptyNode("0", "J", "基础管理", false)
//                .setEmptyNode("J", "J1", "客户/商家管理", false)
//                .setHMAndViewNode("J1", "J11", "客户/商家添加", "admin/base/khsc/khsc_A.jsp", true)
//                .setViewNode("J1", "J12", "客户/商家清单", "admin/base/khsc/khsc_S.jsp", true)
//                    .setHMNode("J12", "J12_1", "客户/商家查询")
//                    .setHMNode("J12", "J12_2", "客户/商家修改")
//                    .setHMNode("J12", "J12_3", "客户/商家删除")
//                .setHMNode("J1", "J13", "客户/商家模糊查询")
//               
//               
//                .setEmptyNode("J", "J2", "标签管理", false)
//                    .setEmptyNode("J2", "J2_1", "客户商场类别", false)
//                        .setHMAndViewNode("J2_1", "J2_1_1", "客户商场类别添加","admin/base/select/kt/KtSelectKey1_A.jsp", true)
//                        .setViewNode("J2_1", "J2_1_2", "客户商场类别清单",     "admin/base/select/kt/KtSelectKey1_S.jsp", true)
//                            .setHMNode("J2_1_2", "J2_1_2_1", "查询")
//                            .setHMNode("J2_1_2", "J2_1_2_2", "修改")
//                            .setHMNode("J2_1_2", "J2_1_2_3", "删除")
//                    .setEmptyNode("J2", "J2_2", "快寄公司", false)
//                        .setHMAndViewNode("J2_2", "J2_2_1", "快递公司添加","admin/base/select/kt/KtSelectKey2_A.jsp", true)
//                        .setViewNode("J2_2", "J2_2_2", "快递公司清单", "admin/base/select/kt/KtSelectKey2_S.jsp", true)
//                            .setHMNode("J2_2_2", "J2_2_2_1", "查询")
//                            .setHMNode("J2_2_2", "J2_2_2_2", "修改")
//                            .setHMNode("J2_2_2", "J2_2_2_3", "删除")
//                    .setEmptyNode("J2", "J2_3", "付款方式", false)
//                        .setHMAndViewNode("J2_3", "J2_3_1", "付款方式添加","admin/base/select/kt/KtSelectKey3_A.jsp", true)
//                        .setViewNode("J2_3", "J2_3_2", "付款方式清单", "admin/base/select/kt/KtSelectKey3_S.jsp", true)
//                            .setHMNode("J2_3_2", "J2_3_2_1", "查询")
//                            .setHMNode("J2_3_2", "J2_3_2_2", "修改")
//                            .setHMNode("J2_3_2", "J2_3_2_3", "删除")
//                    .setEmptyNode("J2", "J2_4", "运输方式", false)
//                        .setHMAndViewNode("J2_4", "J2_4_1", "运输方式添加","admin/base/select/kt/KtSelectKey4_A.jsp", true)
//                        .setViewNode("J2_4", "J2_4_2", "运输方式清单", "admin/base/select/kt/KtSelectKey4_S.jsp", true)
//                            .setHMNode("J2_4_2", "J2_4_2_1", "查询")
//                            .setHMNode("J2_4_2", "J2_4_2_2", "修改")
//                            .setHMNode("J2_4_2", "J2_4_2_3", "删除")
//                     .setEmptyNode("J2", "J2_5", "发货标签1", false)
//                        .setHMAndViewNode("J2_5", "J2_5_1", "发货标签1添加","admin/base/select/kt/KtSelectKey5_A.jsp", true)
//                        .setViewNode("J2_5", "J2_5_2", "发货标签1清单", "admin/base/select/kt/KtSelectKey5_S.jsp", true)
//                            .setHMNode("J2_5_2", "J2_5_2_1", "查询")
//                            .setHMNode("J2_5_2", "J2_5_2_2", "修改")
//                            .setHMNode("J2_5_2", "J2_5_2_3", "删除")
//               
//                     .setEmptyNode("J2", "J2_6", "品牌", false)
//                        .setHMAndViewNode("J2_6", "J2_6_1", "品牌添加","admin/base/select/kt/KtSelectKey6_A.jsp", true)
//                        .setViewNode("J2_6", "J2_6_2", "品牌清单", "admin/base/select/kt/KtSelectKey6_S.jsp", true)
//                            .setHMNode("J2_6_2", "J2_6_2_1", "查询")
//                            .setHMNode("J2_6_2", "J2_6_2_2", "修改")
//                            .setHMNode("J2_6_2", "J2_6_2_3", "删除")
//                     .setEmptyNode("J2", "J2_7", "收货类型", false)
//                        .setHMAndViewNode("J2_7", "J2_7_1", "收货类型添加","admin/base/select/kt/KtSelectKey7_A.jsp", true)
//                        .setViewNode("J2_7", "J2_7_2", "收货类型清单", "admin/base/select/kt/KtSelectKey7_S.jsp", true)
//                            .setHMNode("J2_7_2", "J2_7_2_1", "查询")
//                            .setHMNode("J2_7_2", "J2_7_2_2", "修改")
//                            .setHMNode("J2_7_2", "J2_7_2_3", "删除")
//               
//                     .setEmptyNode("J2", "J2_8", "体表标签2", false)
//                        .setHMAndViewNode("J2_8", "J2_8_1", "标签2添加","admin/base/select/kt/KtSelectKey8_A.jsp", true)
//                        .setViewNode("J2_8", "J2_8_2", "标签2清单", "admin/base/select/kt/KtSelectKey8_S.jsp", true)
//                            .setHMNode("J2_8_2", "J2_8_2_1", "查询")
//                            .setHMNode("J2_8_2", "J2_8_2_2", "修改")
//                            .setHMNode("J2_8_2", "J2_8_2_3", "删除")
//               
//                     .setEmptyNode("J2", "J2_9", "体表标签3", false)
//                        .setHMAndViewNode("J2_9", "J2_9_1", "标签3添加","admin/base/select/kt/KtSelectKey9_A.jsp", true)
//                        .setViewNode("J2_9", "J2_9_2", "标签3清单", "admin/base/select/kt/KtSelectKey9_S.jsp", true)
//                            .setHMNode("J2_9_2", "J2_9_2_1", "查询")
//                            .setHMNode("J2_9_2", "J2_9_2_2", "修改")
//                            .setHMNode("J2_9_2", "J2_9_2_3", "删除")
//                    
//                    .setEmptyNode("J", "J7_1", "固定资产基础", false)
//                        .setHMAndViewNode("J7_1", "J7_1_1", "添加资产分类","admin/base/tree/gdzcfl/gdzcfl_A.jsp", true)
//                        .setViewNode("J7_1", "J7_1_2", "资产分类中心", "admin/base/tree/gdzcfl/gdzcfl.jsp", true)
//                            .setHMNode("J7_1_2", "J7_1_2_1", "分类查询")
//                            .setHMNode("J7_1_2", "J7_1_2_2", "分类修改")
//                            .setHMNode("J7_1_2", "J7_1_2_3", "分类删除")
               
                    .setEmptyNode("J", "J7_2", "经验库分类", false)
                        .setHMAndViewNode("J7_2", "J7_2_1", "添加经验库分类","admin/base/tree/jingyankufl/jingyankufl_A.jsp", true)
                        .setViewNode("J7_2", "J7_2_2", "经验库分类中心", "admin/base/tree/jingyankufl/jingyankufl.jsp", true)
                            .setHMNode("J7_2_2", "J7_2_2_1", "查询")
                            .setHMNode("J7_2_2", "J7_2_2_2", "修改")
                            .setHMNode("J7_2_2", "J7_2_2_3", "删除")
               
//                    .setEmptyNode("J", "J7_3", "地理区域", false)
//                        .setHMAndViewNode("J7_3", "J7_3_1", "地理区域添加","admin/base/tree/diliquyu/diliquyu_A.jsp", true)
//                        .setViewNode("J7_3", "J7_3_2", "地理区域中心", "admin/base/tree/diliquyu/diliquyu.jsp", true)
//                            .setHMNode("J7_3_2", "J7_3_2_1", "查询")
//                            .setHMNode("J7_3_2", "J7_3_2_2", "修改")
//                            .setHMNode("J7_3_2", "J7_3_2_3", "删除")                           
                ;
    }
}
