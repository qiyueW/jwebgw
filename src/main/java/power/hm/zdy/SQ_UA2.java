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
public class SQ_UA2 implements IZDY {

    @Override
    public boolean denyByTrue(final JWeb jw, final String urlCode) {

        //【针对用户】必须是指定范围，首先检查是否在范围内
        Object obj = jw.session.getAttribute(PDK.SESSION_DEFAULT_USER_KEY);
        if (null != obj) {//首先检查业务员(访问多)，如果有授权，进行授权检验。

            return checkPower((PISD) obj, urlCode);

        }
        //【针对管理员】检查管理员是否有权限。
        obj = jw.session.getAttribute(PDK.SESSION_ADMIN_KEY);
        if (null != obj) {//如果有授权，进行授权检验。
            return checkPower((PISD) obj, urlCode);
        }
        return null == jw.session.getAttribute(PDK.SESSION_SUPER_ADMIN_KEY);
    }

    //默认返回true,返回不通过
    private boolean checkPower(final PISD obj, final String urlCode) {
        if (urlCode.contains(",")) {
            String[] cs=urlCode.split(",");
            boolean rs;
            for(int i=0;i<cs.length;i++){
                rs=Login.isNoThisPower(obj, cs[i]);
                if(rs){
                    return true;//不通过。不再继续
                }
            }
            return false;//通过
        }
        return Login.isNoThisPower(obj, urlCode);
    }
}
