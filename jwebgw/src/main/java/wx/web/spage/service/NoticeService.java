package wx.web.spage.service;

import configuration.DBO;
import java.util.List;
import wx.web.spage.bean.Spage_noticeSimple;

/**
 *
 * @author adm.wangchunzi
 */
public class NoticeService {
    
    private final static String noticeView =
            " SELECT `spage_notice_zj`,"
            + "    `spage_notice_biaoti`,"
            + "    `spage_notice_fabushijian`,"
            + "    `spage_notice_zhidanren`,"
            + "    `spage_notice_zhidanren_zj`,"
            + "    `spage_notice_zhidanshijian`"
            + "   FROM `Spage_notice` " ;
    
    /**
     * 分页查询 方案
     * <p>
     * 如果zt为null，默认查询 非作废的方案。</p>
     *
     * @param page
     * @param pageCount
     * @param orderby 排序
     * @return
     */
    public static List<Spage_noticeSimple> selectVast(int page, int pageCount, String orderby) {
        if (null == orderby || orderby.isEmpty()) {
            orderby = " order by `spage_notice_zj` desc";
        }
        return DBO.service.ADUS.executeQueryVast(Spage_noticeSimple.class, noticeView
                + " " + orderby
                + " LIMIT " + (page - 1) * pageCount + "," + pageCount);
    }

    /**
     * 编码、状态、创建时间、流程外键 不可变更
     *
     * @param obj
     * @return
     */
    public static int update(final Spage_noticeSimple obj) {//编码、状态、创建时间、流程外键 不可变更
        return DBO.service.U.updateSome_reject(obj, "gdzc_bianma,gdzc_zt,gdzc_shijian2,gdzc_liuchen_zj", "gdzc_weimabiaoshi");
    }

}
