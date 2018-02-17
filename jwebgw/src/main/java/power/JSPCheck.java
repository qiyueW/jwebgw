package power;

import javax.servlet.http.HttpSession;
import system.web.power.PDK;
import system.web.power.session.PISD;

/**
 *
 * @author jweb
 */
public class JSPCheck {

    private final HttpSession session;

    public JSPCheck(HttpSession session) {
        this.session = session;
    }
    public JSPStr getStrTool(){
        return new JSPStr();
    }
    public boolean isNotLoginByUser() {
        return null == session.getAttribute(PDK.SESSION_DEFAULT_USER_KEY);
    }

    public boolean isNotLoginByAdmin() {
        return null == session.getAttribute(PDK.SESSION_ADMIN_KEY);
    }
    
    
    public boolean isNotLoginBySuperAdmin() {
        return null == session.getAttribute(PDK.SESSION_SUPER_ADMIN_KEY);
    }
    
    
    public boolean checkUser(final String key) {
        Object ss = session.getAttribute(PDK.SESSION_DEFAULT_USER_KEY);
        if (null == ss) {
            return false;
        }
        PISD pisd = (PISD) ss;
        String power[] = pisd.power;
        for (int i = 0; i < power.length; i++) {
            if (key.equals(power[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean checkAdmin(final String key) {
        Object ao = session.getAttribute(PDK.SESSION_ADMIN_KEY);//管理员
        if (null == ao) {
            return false;
        }
        PISD pisd;
        String power[];
        pisd = (PISD) ao;
        power = pisd.power;
        for (int i = 0; i < power.length; i++) {
            if (key.equals(power[i])) {
                return true;
            }
        }
        return false;
    }

    public boolean checkUserORAdmin(final String key) {
        Object uo = session.getAttribute(PDK.SESSION_DEFAULT_USER_KEY);//用户
        Object ao = session.getAttribute(PDK.SESSION_ADMIN_KEY);//管理员
        if (null == uo && null == ao) {
            return false;
        }
        PISD pisd;
        String power[];
        if (null != uo) {
            pisd = (PISD) uo;
            power = pisd.power;
            for (int i = 0; i < power.length; i++) {
                if (key.equals(power[i])) {
                    return true;
                }
            }
        }
        if (null != ao) {
            pisd = (PISD) ao;
            power = pisd.power;
            for (int i = 0; i < power.length; i++) {
                if (key.equals(power[i])) {
                    return true;
                }
            }
        }

        return false;
    }

}
