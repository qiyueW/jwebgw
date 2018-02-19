package wx.web.spage.doinit;

import configuration.DBO;
import system.web.init.model.InitModel;
import wx.web.spage.bean.Spage_index;

/**
 *
 * @author wangchunzi
 */
public class IndexPageInit implements InitModel {

    @Override
    public void doInit() {

        if (DBO.service.S.selectCount(Spage_index.class) == 0) {
            DBO.service.ADUS.executeUpdate("INSERT INTO Spage_index(spage_indexpage_zj,spage_indexpage_neirong) VALUES('1','<h3>您好。</h3>')");
        }
    }

}
