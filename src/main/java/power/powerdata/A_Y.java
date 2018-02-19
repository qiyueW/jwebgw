package power.powerdata;

import system.web.power.data.IPowerData;
import system.web.power.data.PD;

/**
 * 业务管理
 *
 * @author wangchunzi
 */
public class A_Y implements IPowerData {

    @Override
    public int key() {
        return PDConfig.keyCode.Y.key;
    }

    @Override
    public void doPowerData(PD pdt) {
        pdt
//                .setEmptyNode("0", "Y", "快递管理", true)
//                    //Y1
//                    .setHMAndViewNode("Y", "Y1_0", "发货登记", "admin/services/kt/Fktdj_A.jsp", true)
//                    .setViewNode("Y", "Y1_1", "发货维护", "admin/services/kt/Fktdj_S.jsp", true)
//                        .setHMNode("Y1_1", "Y1_1_1", "查询")
//                        .setHMNode("Y1_1", "Y1_1_2", "修改")
//                        .setHMNode("Y1_1", "Y1_1_3", "删除")
//                    .setHMAndViewNode("Y", "Y1_2", "明细查询", "admin/services/kt/Fktdj_LJS.jsp", true)
//                    //Y2
//                    .setHMAndViewNode("Y", "Y2_0", "收货登记", "admin/services/kt/Sktdj_A.jsp", true)
//                    .setViewNode("Y", "Y2_1", "收货维护", "admin/services/kt/Sktdj_S.jsp", true)
//                        .setHMNode("Y2_1", "Y2_1_1", "查询")
//                        .setHMNode("Y2_1", "Y2_1_2", "修改")
//                        .setHMNode("Y2_1", "Y2_1_3", "删除")
//                    .setHMAndViewNode("Y", "Y2_2", "明细查询", "admin/services/kt/Sktdj_LJS.jsp", true)
//                        .setHMNode("Y2_2", "Y2_2_1", "导出权限")
//                    .setHMAndViewNode("Y", "Y2_3", "报表", "services/kt/s/s/bb/selectVast.jw", true)
                
//                 .setEmptyNode("0", "Y3", "资产管理", true)
//                    //Y3
//                    .setHMAndViewNode("Y3", "Y3_0", "新增盘点方案", "admin/services/gdzc/fangan/gdzcfa_A.jsp", true)
//                    .setViewNode("Y3", "Y3_1", "盘点方案维护", "admin/services/gdzc/fangan/gdzcfa_S.jsp", true)
//                        .setHMNode("Y3_1", "Y3_1_1", "查询")
//                        .setHMNode("Y3_1", "Y3_1_2", "修改")
//                        .setHMNode("Y3_1", "Y3_1_3", "删除")
//                        .setHMNode("Y3_1", "Y3_1_4", "启用")
//                        .setHMNode("Y3_1", "Y3_1_5", "停止")
//                        .setHMNode("Y3_1", "Y3_1_6", "作废")
                        //预留一个Y3_2 Y3_3 Y3_4 Y3_5
//                    .setHMAndViewNode("Y3", "Y3_6", "新增资产", "admin/services/gdzc/gdzc_A.jsp", true)
//                    .setViewNode("Y3", "Y3_7", "资产维护", "admin/services/gdzc/gdzc_S.jsp", true)
//                        .setHMNode("Y3_7", "Y3_7_1", "查询")
//                        .setHMNode("Y3_7", "Y3_7_2", "修改")
//                        .setHMNode("Y3_7", "Y3_7_3", "删除")
//                        .setHMNode("Y3_7", "Y3_7_4", "启用")
//                        .setHMNode("Y3_7", "Y3_7_5", "停止")
//                        .setHMNode("Y3_7", "Y3_7_6", "作废")
                
//                .setHMAndViewNode("Y3", "Y3_10", "盘点", "admin/services/gdzc/pd/pd_A.jsp", true)
//                .setHMAndViewNode("Y3", "Y3_8", "盘点明细", "admin/services/gdzc/_view/viewGdzcPD.jsp", true)
//                .setHMAndViewNode("Y3", "Y3_9", "盘点校对", "admin/services/gdzc/_view/viewGdzcPD_JiaoDui.jsp", true)
                
//                .setEmptyNode("0", "Y4", "信息登记", true)
//                    .setHMAndViewNode("Y4", "Y4_0", "电脑信息登记", "admin/base/ryzy/ryzy_A.jsp", true)
//                    .setViewNode("Y4", "Y4_1", "电脑信息审核", "admin/base/ryzy/ryzyList0.jsp", true)
//                    .setViewNode("Y4", "Y4_2", "电脑信息维护", "admin/base/ryzy/ryzyList1.jsp", true)
//                        .setHMNode("Y4_2", "Y4_2_1", "查询")
//                        .setHMNode("Y4_2", "Y4_2_2", "修改")
//                        .setHMNode("Y4_2", "Y4_2_3", "删除")
                  .setEmptyNode("0", "Y100", "展示区管理", true)
                    .setHMAndViewNode("Y100", "Y100_4", "首页发布", "spage/index/au/select.jw", true)
                        .setHMNode("Y100_4", "Y100_4_1", "查询")
                        .setHMNode("Y100_4", "Y100_4_2", "修改")
                
                    .setHMAndViewNode("Y100", "Y100_0", "发布公告通知", "spage/notice/notice_A.jsp", true)
                    .setViewNode("Y100", "Y100_1", "公告通知维护", "spage/notice/notice_S.jsp", true)
                        .setHMNode("Y100_1", "Y100_1_1", "查询")
                        .setHMNode("Y100_1", "Y100_1_2", "修改")
                        .setHMNode("Y100_1", "Y100_1_3", "删除")
                    .setHMAndViewNode("Y100", "Y100_2", "新增经验", "spage/jingyanku/jingyanku_A.jsp", true)
                    .setViewNode("Y100", "Y100_3", "经验库维护", "spage/jingyanku/jingyanku_S.jsp", true)
                        .setHMNode("Y100_3", "Y100_3_1", "查询")
                        .setHMNode("Y100_3", "Y100_3_2", "修改")
                        .setHMNode("Y100_3", "Y100_3_3", "删除")
//                    .setHMAndViewNode("Y100", "Y100_4", "申请开店", "spage/mendian/mendian_A.jsp", true)
//                    .setViewNode("Y100", "Y100_5", "店维护", "spage/mendian/mendian_S.jsp", true)
//                        .setHMNode("Y100_5", "Y100_5_1", "查询")
//                        .setHMNode("Y100_5", "Y100_5_2", "修改")
//                        .setHMNode("Y100_5", "Y100_5_3", "删除")
//                        .setHMNode("Y100_5", "Y100_5_1_1", "查询-内审")
//                        .setHMNode("Y100_5", "Y100_5_5", "状态-启用")
//                        .setHMNode("Y100_5", "Y100_5_6", "状态-停止")
                ;
    }
}
