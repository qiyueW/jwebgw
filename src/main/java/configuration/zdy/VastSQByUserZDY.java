package configuration.zdy;

import system.web.JWeb;
import system.web.power.PDK;
import system.web.power.interfaces.IZDY;
import system.web.power.session.Login;
import system.web.power.session.PISD;

/**
 *
 * @author adm.wangchunzi
 */
public class VastSQByUserZDY implements IZDY {

    @Override
    public boolean denyByTrue(JWeb jw, String urlCode) {
        //【针对用户】必须是指定范围，首先检查是否在范围内
        Object obj = jw.session.getAttribute(PDK.SESSION_DEFAULT_USER_KEY);
        if (null == obj) {//未登录
            return true;
        }
        String[] uc = urlCode.split(",");
        for (int i = 0; i < uc.length; i++) {
            if (!Login.isNoThisPower((PISD) obj, uc[i])) {//没有权限-取反 
                return false;//如果有权限，即返回false
            }
        }
        return true;//没有权限。
    }

}
