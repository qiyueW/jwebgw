/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wx.web.cc.service.svo;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author wo
 */
public class BeanFieldStrngVO {

    public final String key;
    public final String value;
    public final Map<Integer,String>map=new HashMap<>();
    public BeanFieldStrngVO(String str) {
        this.key = str.substring(1, 2);
        this.value = str.substring(2);
    }
}
