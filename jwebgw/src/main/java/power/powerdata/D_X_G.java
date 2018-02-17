package power.powerdata;

import system.web.power.data.IPowerData;
import system.web.power.data.PD;

/**
 *
 * @author wangchunzi
 */
public class D_X_G implements IPowerData {

    @Override
    public int key() {
        return PDConfig.keyCode.XG.key;
    }

    @Override
    public void doPowerData(PD pdt) {

        pdt.setEmptyNode("X", "XG1", "管理员", true)
                .setViewNode("XG1", "XG1_1", "权限管理", "sys/adminuser/adminuser_SetPower.jsp", true)
                .setViewNode("XG1", "XG1_2", "新建管理员", "sys/adminuser/adminuser_A.jsp", true)
                .setViewNode("XG1", "XG1_3", "管理员中心", "sys/adminuser/adminuser_S.jsp", true)
                .setHMNode("XG1_3", "XG1_4", "管理员查询")
                .setHMNode("XG1_3", "XG1_5", "管理员修改")
                .setHMNode("XG1_3", "XG1_6", "管理员删除");
    }
}
