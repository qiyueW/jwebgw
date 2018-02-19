   package power.powerdata;

import system.web.power.data.IPowerData;
import system.web.power.data.PD;

/**
 *
 * @author wangchunzi
 */
public class D_X  implements IPowerData{

    @Override
    public int key() {
         return PDConfig.keyCode.X.key;
    }
//@system.web.power.ann.SQ(value="XX",scope=system.web.power.PDK.SESSION_ADMIN_KEY)
    @Override
    public void doPowerData(PD pdt) {
        pdt.setEmptyNode("0", "X", "系统管理", true)
                
                .setEmptyNode("X", "X1", "角色等级管理", true)
                .setHMAndViewNode("X1", "X1_1", "角色等级添加","sys/role/jsdj/jsdj_A.jsp", true)
                .setViewNode("X1", "X1_2", "角色等级清单", "sys/role/jsdj/jsdj_S.jsp", true)
                    .setHMNode("X1_2", "X1_2_1", "角色等级查询")
                    .setHMNode("X1_2", "X1_2_2", "角色等级修改")
                    .setHMNode("X1_2", "X1_2_3", "角色等级删除")
                .setHMNode("X1", "X1_3", "角色等级模糊查询")
                
                .setEmptyNode("X", "X2", "角色管理", true)
                .setHMAndViewNode("X2", "X2_1", "角色添加","sys/role/role_A.jsp", true)
                .setViewNode("X2", "X2_2", "角色清单", "sys/role/role_S.jsp", true)
                    .setHMNode("X2_2", "X2_2_1", "角色查询")
                    .setHMNode("X2_2", "X2_2_2", "角色修改")
                    .setHMNode("X2_2", "X2_2_3", "角色删除")
                .setViewNode("X2", "X2_3", "角色权限管理", "sys/role/role_SetPower.jsp", true)
                
                .setEmptyNode("X", "X3", "用户权限管理", true)
                .setViewNode("X3", "X3_2", "用户权限查询", "sys/user/user_S.jsp", true)
                .setViewNode("X3", "X3_3", "用户角色管理", "sys/user/user_SetRole.jsp", true)
                .setViewNode("X3", "X3_4", "用户直接权限管理", "sys/user/user_SetPower.jsp", true)
//               
//                .setEmptyNode("C", "C2", "初始化", true)
//                .setHMAndViewNode("C2", "C2_1", "客户商场初始化",  "admin/inidata/initByExcel.jsp", true)
                ;
    }
}
