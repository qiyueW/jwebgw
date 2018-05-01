package wx.web.cc.service;

import configuration.DBO;
import java.util.List;
import wx.web.cc.bean.Bean;
import wx.web.cc.bean.Bean2;

/**
 *
 * @author adm.wangchunzi
 */
public class BeanService {

    /**
     * 通过分类key（包含式）方式取得相关模板的预设值的表头。
     *
     * @param flkey
     * @return List
     */
    public static List<Bean> getHead(String flkey) {
        return DBO.service.S.selectByCondition(Bean.class, "WHERE mypackage_id IN('" + flkey + "') ORDER BY bean_px ASC");
    }

    /**
     * 通过表头ID,取得表体ID
     *
     * @param bean_zj
     * @return
     */
    public static List<Bean2> getBody(String bean_zj) {
        return DBO.service.S.selectByCondition(Bean2.class, "WHERE bean_zj IN('" + bean_zj + "')");
    }

    public static int[] topx(String[] ids) {
        String[] sqldata = new String[ids.length];
        for (int i = 0; i < ids.length; i++) {
            sqldata[i] = "UPDATE Bean SET bean_px=" + i + " WHERE bean_zj='" + ids[i] + "'";
        }
        return DBO.service.ADUS.executeBatch(sqldata);
    }
}
