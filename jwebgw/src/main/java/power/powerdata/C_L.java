package power.powerdata;

import system.web.power.data.IPowerData;
import system.web.power.data.PD;

/**
 *
 * @author wangchunzi
 */
public class C_L implements IPowerData{

    @Override
    public int key() {
         return PDConfig.keyCode.L.key;
    }

    @Override
    public void doPowerData(PD pdt) {
        
    }

}
