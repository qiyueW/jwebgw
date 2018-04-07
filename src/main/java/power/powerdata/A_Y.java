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
                .setEmptyNode("0", "Y101", "代码生成器", true)
//                    
                    .setEmptyNode("Y101", "Y101_12", "引擎数据映射表", false)
                        .setHMAndViewNode("Y101_12", "Y101_12_1", "bean映射","cc/ccmap/Map_Mybean.jsp", true)
                        
                
                    .setHMAndViewNode("Y101", "Y101_11A", "通用模板分类添加","cc/cmodel/cmodelfl/cmodelfl_A.jsp", true)
                    .setViewNode("Y101", "Y101_11_0", "通用模板分类中心", "cc/cmodel/cmodelfl/cmodelfl.jsp", true)
                            .setHMNode("Y101_11_0", "Y101_11S", "查询")
                            .setHMNode("Y101_11_0", "Y101_11U", "修改")
                            .setHMNode("Y101_11_0", "Y101_11D", "删除")
                
                    .setHMAndViewNode("Y101", "Y101_1", "通用模板添加", "cc/cmodel/cModel_A.jsp", true)
                    .setViewNode("Y101", "Y101_2", "通用模板维护", "cc/cmodel/cModel.jsp", true)
                        .setHMNode("Y101_2", "Y101_2_1", "查询")
                        .setHMNode("Y101_2", "Y101_2_2", "修改")
                        .setHMNode("Y101_2", "Y101_2_3", "删除") 
                    //Y1
                    .setHMAndViewNode("Y101", "Y101_3", "包添加", "cc/mypackage/mypackage_A.jsp", true)
                    .setViewNode("Y101", "Y101_4", "包维护", "cc/mypackage/mypackage.jsp", true)
                        .setHMNode("Y101_4", "Y101_4_1", "查询")
                        .setHMNode("Y101_4", "Y101_4_2", "修改")
                        .setHMNode("Y101_4", "Y101_4_3", "删除")
                    //Y2
                    .setHMAndViewNode("Y101", "Y101_5", "bean添加", "cc/mybean/Mybean_A.jsp", true)
                    .setViewNode("Y101", "Y101_6", "bean维护", "cc/mybean/Mybean_S.jsp", true)
                        .setHMNode("Y101_6", "Y101_6_1", "查询")
                        .setHMNode("Y101_6", "Y101_6_2", "修改")
                        .setHMNode("Y101_6", "Y101_6_3", "删除")
                    .setHMAndViewNode("Y101", "Y101_7", "bean属性添加", "cc/mybeanfield/Mybeanfield_A.jsp", true)
                    .setViewNode("Y101", "Y101_8", "bean属性维护", "cc/mybeanfield/Mybeanfield_S.jsp", true)
                        .setHMNode("Y101_8", "Y101_8_1", "查询")
                        .setHMNode("Y101_8", "Y101_8_2", "修改")
                        .setHMNode("Y101_8", "Y101_8_3", "删除")
                    .setHMAndViewNode("Y101", "Y101_9", "bean模板添加", "cc/mymodel/myModel_A.jsp", true)
                    .setViewNode("Y101", "Y101_10", "bean模板维护", "cc/mymodel/myModel.jsp", true)
                        .setHMNode("Y101_10", "Y101_10_1", "查询")
                        .setHMNode("Y101_10", "Y101_10_2", "修改")
                        .setHMNode("Y101_10", "Y101_10_3", "删除")                   
                
                  .setEmptyNode("0", "Y100", "展示区管理", false)
                    .setHMAndViewNode("Y100", "Y100_6", "首页发布", "spage/index/au/select.jw", true)
                        .setHMNode("Y100_6", "Y100_6_2", "维护")
                
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
                ;
    }
}
