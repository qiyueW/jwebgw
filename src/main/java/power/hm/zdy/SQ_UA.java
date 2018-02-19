package power.hm.zdy;

import system.web.JWeb;
import system.web.power.PDK;
import system.web.power.interfaces.IZDY;
import system.web.power.session.Login;
import system.web.power.session.PISD;

/**
 *
 * @author jweb
 */
//@system.web.power.ann.ZDY(zdy = power.hm.zdy.SQ_UA.class, value = "xxxx")
/**
 * 授权用户 或 管理员 都可通过。
 *
 * @author jweb
 */
public class SQ_UA implements IZDY {

    @Override
    public boolean denyByTrue(final JWeb jw, final String urlCode) {
   
        //【针对用户】必须是指定范围，首先检查是否在范围内
        Object obj = jw.session.getAttribute(PDK.SESSION_DEFAULT_USER_KEY);
        if (null != obj) {//首先检查业务员(访问多)，如果有授权，进行授权检验。
            return Login.isNoThisPower((PISD) obj, urlCode);
        }
        //【针对管理员】检查管理员是否有权限。
        obj = jw.session.getAttribute(PDK.SESSION_ADMIN_KEY);
        if (null != obj) {//如果有授权，进行授权检验。
            return Login.isNoThisPower((PISD) obj, urlCode);
        }
        return null == jw.session.getAttribute(PDK.SESSION_SUPER_ADMIN_KEY);
    }

}
