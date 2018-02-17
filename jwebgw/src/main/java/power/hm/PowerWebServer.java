package power.hm;

import power.powerdata.PDConfig;
import system.base.annotation.H;
import system.base.annotation.M;
import system.web.JWeb;
import system.web.power.ann.DL;
import system.web.power.data.PD;
import system.web.power.session.Login;

/**
 *
 * @author wangchunzi
 */
@H("/sys/power/s")
public class PowerWebServer {
    
    @M("p/showMenu")
    public static void select_ListJSON(JWeb jw) {
        jw.request.setAttribute("ListJson", PD.getPowerMenue());
    }

    @DL//默认用户登陆
    @M("v/showMenu")
    public static void selectV_ListJSON(JWeb jw) {
        jw.request.setAttribute("ListJson", PD.getViewMenue());
    }

    @DL//默认用户登陆
    @M("v/showMenu/user")
    public static void selectV_User(JWeb jw) {
        jw.printOne(PD.getViewMenueByJson(Login.getUserPower(jw)));
    }

}
