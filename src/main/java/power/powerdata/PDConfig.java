package power.powerdata;

import power.vo.PV;
import system.web.power.data.PD;

/**
 *
 * @author jweb
 */
public class PDConfig {

    public enum keyCode {
        Y(1), J(3),J1(5), L(7), X(9), XG(11);
        public final int key;

        private keyCode(int key) {
            this.key = key;
        }
    }

    /**
     * 可分配给【用户】的权限
     */
    final public static PV UP;
    /**
     * 可分配给【管理员】的权限
     */
    final public static PV AP;
    /**
     * 可分配给【超级管理员】权限
     */
    final public static PV SAP;
    static{
        UP =new PV(
                PD.getPowerMenue(keyCode.Y.key,keyCode.J.key,keyCode.J1.key,keyCode.L.key)//作废的模块。普通用户无管理权限
                ,PD.getViewMenue(keyCode.Y.key,keyCode.J.key,keyCode.J1.key,keyCode.L.key)//用户可使用的权限集合
        );
        AP =new PV(
                PD.getPowerMenue(keyCode.Y.key,keyCode.J.key,keyCode.J1.key,keyCode.L.key)//可分配给管理员来分配给用户的管理集合。
                ,PD.getViewMenue(keyCode.X.key,keyCode.J.key)//管理员只有系统管理权限菜单 X
        );
        
        SAP =new PV(
                PD.getPowerMenue(keyCode.Y.key,keyCode.J.key,keyCode.J1.key,keyCode.L.key,keyCode.X.key)//超级管理员只能管理【管理员】这单一模块，默认只要是超级管理员登陆就可以使用
                ,PD.getViewMenue(keyCode.XG.key)//超级管理员只能使用【管理员】模块的菜单
        );
    }
}
