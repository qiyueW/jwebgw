package wx.web.spage.service;

import configuration.DBO;
import java.util.List;
import wx.web.spage.bean.Spage_jingyankuSimple;

/**
 *
 * @author adm.wangchunzi
 */
public class JingyankuService {

    private final static String VIEW
            = "SELECT `spage_jingyanku_zj`,"
            + "`spage_jingyanku_biaoti`,"
            + "`spage_jingyanku_gjc`,"
            + "`spage_jingyanku_fabushijian`,"
            + "`spage_jingyanku_zhidanren`,"
            + "`spage_jingyanku_zhidanren_zj`,"
            + "`jingyankufl_id`,"
            + "`jingyankufl_name`,"
            + "`spage_jingyanku_zhidanshijian`"
            + "FROM `Spage_jingyanku` ";

    /**
     * 分页查询 方案
     * <p>
     * 如果zt为null，默认查询 非作废的方案。</p>
     *
     * @param page
     * @param pageCount
     * @param where
     * @param orderby 排序
     * @return
     */
    public static List<Spage_jingyankuSimple> selectVast(int page, int pageCount,String where, String orderby) {
        if (null == orderby || orderby.isEmpty()) {
            orderby = " order by `spage_jingyanku_zj` desc";
        }
        return DBO.service.ADUS.executeQueryVast(Spage_jingyankuSimple.class, VIEW
                +where
                + " " + orderby
                + " LIMIT " + (page - 1) * pageCount + "," + pageCount);
    }
    
        public static List<Spage_jingyankuSimple> selectVast(String orderby) {
        if (null == orderby || orderby.isEmpty()) {
            orderby = " order by `spage_jingyanku_zj` desc";
        }
        return DBO.service.ADUS.executeQueryVast(Spage_jingyankuSimple.class, VIEW+ " " + orderby);
    }
        
}
