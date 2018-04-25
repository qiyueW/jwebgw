package wx.web.cc.hm.yushizhi.soo;

import wx.web.cc.bean.YushizhiFL;

/**
 *
 * @author adm.wangchunzi
 */
public class YushizhiSoo {

    /**
     * 修改预设值方案的表头的 分类名称。（一般用于用户修改分类时，方案处也要跟着修改。）
     *
     * @param fl 分类对象。
     * @return String 用于update的sql语句。
     */
    public static String updateYushizhiFLName(YushizhiFL fl) {
        return "UPDATE Yushizhi SET yushizhifl_name='" + fl.getYushizhifl_name() + "' WHERE yushizhifl_id IN('" + fl.getYushizhifl_id() + "')";
    }
}
