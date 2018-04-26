package wx.web.cc.service;

import configuration.DBO;
import java.util.List;
import wx.web.cc.bean.Fangan2;

/**
 *
 * @author adm.wangchunzi
 */
public class FanganService {

    /**
     * 通过表头ID,取得表体ID
     *
     * @param zj
     * @return
     */
    public static List<Fangan2> getBody(String zj) {
        return DBO.service.S.selectByCondition(Fangan2.class, "WHERE fangan1_zj IN('" + zj + "')");
    }

    public static int[] topx(String[] ids) {
        String[] sqldata = new String[ids.length];
        for (int i = 0; i < ids.length; i++) {
            sqldata[i] = "UPDATE Fangan1 SET fangan1_px=" + i + " WHERE fangan1_zj='" + ids[i] + "'";
        }
        return DBO.service.ADUS.executeBatch(sqldata);
    }
}
