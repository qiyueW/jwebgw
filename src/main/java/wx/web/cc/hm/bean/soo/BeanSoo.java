package wx.web.cc.hm.bean.soo;

import wx.web.cc.bean.MyPackage;

/**
 *
 * @author adm.wangchunzi
 */
public class BeanSoo {

    /**
     * 修改预设值方案的表头的 分类名称。（一般用于用户修改分类时，方案处也要跟着修改。）
     *
     * @param fl 分类对象。
     * @return String 用于update的sql语句。
     */
    public static String updateYushizhiFLName(MyPackage fl) {
        return "UPDATE Bean SET mypackage_name='" + fl.getMypackage_name()+ "' WHERE mypackage_id IN('" + fl.getMypackage_id() + "')";
    }
}
