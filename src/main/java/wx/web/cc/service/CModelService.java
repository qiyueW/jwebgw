/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wx.web.cc.service;

import configuration.DBO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import wx.web.cc.bean.CModel;

/**
 *
 * @author adm.wangchunzi
 */
public final class CModelService {

    public static Map<String, String> getCModelAnd_McMapZj() {
        List<CModel> clist = DBO.service.S.select(CModel.class);
        Map<String, String> map = new HashMap();
        for (CModel obj : clist) {
            map.put(obj.getCmodel_mc(), obj.getCmodel_zj());
        }
        return map;
    }
}
