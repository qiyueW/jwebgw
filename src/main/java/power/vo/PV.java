package power.vo;

import java.util.Arrays;
import java.util.List;
import system.web.power.data.Power;

/**
 *
 * @author jweb
 */
final public class PV {

    public final List<Power> pPower;
    public final List<Power> vPower;

    public final String pPowerJson_all;
    public final String vPowerJson_all;

    public PV(List<Power> pPower, List<Power> vPower) {
        this.pPower = pPower;
        this.vPower = vPower;
        this.pPowerJson_all = toJson(this.pPower, true);
        this.vPowerJson_all = toJson(this.vPower, false);
    }
public String getMyPowerByTrue_Or_GetMyViewByFalse(String[] ids, boolean isPP) {
        if (null == ids || ids.length==0) {
            return "[]";
        }
        System.out.println("");
        for(Power spp:pPower){
            System.out.print(spp.getPower_id());
        }
        System.out.println("");
        System.out.println("MyIDs"+Arrays.toString(ids));
        StringBuilder sb = new StringBuilder();
        if (isPP) {//如果是权限集合
            for (Power obj : this.pPower) {
                for (String up : ids) {
                    if (up.equals(obj.getPower_id())) {
                        sb.append(",").append(obj.getShowPVMenuJSON());
                    }
                }
            }
            return sb.length() > 0 ? "[" + sb.substring(1) + "]" : "[]";
        }
        for (Power obj : this.vPower) {
            for (String up : ids) {
                if (up.equals(obj.getPower_id())) {
                    sb.append(",").append(obj.getViewMenuJSON());
                }
            }
        }
        return sb.length() > 0 ? "[" + sb.substring(1) + "]" : "[]";
    }

    public String getMyPowerByTrue_Or_GetMyViewByFalse(String ids, boolean isPP) {
        if (null == ids || ids.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        if (isPP) {//如果是权限集合
            for (Power obj : this.pPower) {
                for (String up : ids.split(",")) {
                    if (up.equals(obj.getPower_id())) {
                        sb.append(",").append(obj.getShowPVMenuJSON());
                    }
                }
            }
            return sb.length() > 0 ? "[" + sb.substring(1) + "]" : "[]";
        }
        for (Power obj : this.vPower) {
            for (String up : ids.split(",")) {
                if (up.equals(obj.getPower_id())) {
                    sb.append(",").append(obj.getViewMenuJSON());
                }
            }
        }
        return sb.length() > 0 ? "[" + sb.substring(1) + "]" : "[]";
    }

    public static String toJson(final List<Power> p, boolean isPP) {
        StringBuilder sb = new StringBuilder();
        if (isPP) {//如果是权限集合
            for (Power obj : p) {
                sb.append(",").append(obj.getShowPVMenuJSON());
            }
            return sb.length() > 0 ? "[" + sb.substring(1) + "]" : "[]";
        }
        for (Power obj : p) {
            sb.append(",").append(obj.getViewMenuJSON());
        }
        return sb.length() > 0 ? "[" + sb.substring(1) + "]" : "[]";
    }
}
