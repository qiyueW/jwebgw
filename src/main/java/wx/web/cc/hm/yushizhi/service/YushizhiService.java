package wx.web.cc.hm.yushizhi.service;

import configuration.DBO;
import java.util.List;
import wx.web.cc.bean.Yushizhi;
import wx.web.cc.bean.Yushizhi2;

/**
 *
 * @author adm.wangchunzi
 */
public class YushizhiService {

    /**
     * 通过分类key（包含式）方式取得相关模板的预设值的表头。
     *
     * @param flkey
     * @return List
     */
    public static List<Yushizhi> getHead(String flkey) {
        return DBO.service.S.selectByCondition(Yushizhi.class, "WHERE yushizhifl_name LIKE '%" + flkey + "%'");
    }

    /**
     * 通过表头ID,取得表体ID
     *
     * @param yushizhi_zj
     * @return
     */
    public static List<Yushizhi2> getBody(String yushizhi_zj) {
        return DBO.service.S.selectByCondition(Yushizhi2.class, "WHERE yushizhi_zj IN('" + yushizhi_zj + "')");
    }
}
