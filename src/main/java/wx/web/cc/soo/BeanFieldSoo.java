package wx.web.cc.soo;

import wx.web.cc.bean.Bean;

/**
 *
 * @author adm.wangchunzi
 */
public class BeanFieldSoo {

    /**
     * 修改Bean的名称时，Bean的属性关联的表头值同时亦要修改。因为属性表，直接写入了bean名称
     *
     * @param bean Bean
     * @return String 用于update的sql语句。
     */
    public static String updateYushizhiFLName(Bean bean) {
        return "UPDATE BeanField SET bean_mc='" + bean.getBean_mc() + "' WHERE bean_zj IN('" + bean.getBean_zj() + "')";
    }
}
