/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wx.web.cc.service.svo;

import java.util.List;
import wx.web.cc.bean.BeanField;
import wx.web.cc.bean.BeanField2;

/**
 *
 * @author wo
 */
public class BeanFieldSVO {

    public final BeanField beanField;
    public final List<BeanField2> beanField2List;

    public BeanFieldSVO(BeanField beanField, List<BeanField2> beanField2List) {
        this.beanField = beanField;
        this.beanField2List = beanField2List;
    }
}
