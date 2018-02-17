package power.hm.role;

import configuration.DBO;
import static configuration.DBO.service;
import plugins.ligerui.LigeruiKey;
import plugins.ligerui.LigeruiService;
import plugins.ligerui.vo.LigerUIPage;
import power.bean.AdminUser;
import power.bean.Role;
import system.base.annotation.H;
import system.web.JWeb;
import system.base.annotation.M;
import system.web.power.PDK;
import system.web.power.session.Login;

@system.web.power.ann.SQ(value = "X2_2_1", scope = system.web.power.PDK.SESSION_ADMIN_KEY)
@H("/sys/power/role/s")
public class RoleSelect {

    @M("/selectVast")
//  @system.web.filter.annotation.JWFilter(封装分页对象。建议逻辑如下：如果没有相关参数，直接中止请求)
    public static void select_UIGridt(JWeb jw) {
        String orderby = LigeruiService.getOrderBy(jw.request);//排序
        LigerUIPage page = LigeruiService.getPage(jw.request);//分页
        String id = jw.getString("jsdj_zj");
        AdminUser aobj = Login.getUserInfo(AdminUser.class, jw, PDK.SESSION_ADMIN_KEY);
        String where;
//        //假设不是全局管理员（即有部门归属的管理员）只能查看自己建的角色
//        if (null != aobj.getBm_id() && aobj.getBm_id().length() >= 24) {
//            where = "WHERE user_id IN('" + aobj.getUser_id() + "') ";
//            where = where + (null == id || id.isEmpty() ? "" : "AND jsdj_zj IN('" + id + "')");//条件
//        } else {//假设是全局管理员，可以查看其他部门管理员的
//            where = null == id || id.isEmpty() ? "" : "WHERE jsdj_zj IN('" + id + "')";//条件
//        }
    
        //  锁定，只能查看自己创建的角色
        where = "WHERE user_id IN('" + aobj.getUser_id() + "') ";
        where = where + (null == id || id.isEmpty() ? "" : "AND jsdj_zj IN('" + id + "')");//条件

        jw.request.setAttribute(LigeruiKey.ligerui_grid.key, service.S.selectVastByCondition(Role.class, page.page, page.pagesize, where, orderby));
        jw.request.setAttribute(LigeruiKey.ligerui_grid_count.key, service.S.selectCountByCondition(Role.class, where));
    }

    @M("/selectVastByJson")
    public static void select_ListJSON(JWeb jw) {
        String id = jw.getString("jsdj_zj");
        AdminUser aobj = Login.getUserInfo(AdminUser.class, jw, PDK.SESSION_ADMIN_KEY);
        String where;
//        //假设不是全局管理员（即有部门归属的管理员）只能查看自己建的角色
//        if (null != aobj.getBm_id() && aobj.getBm_id().length() > 23) {
//            where = "WHERE user_id IN('" + aobj.getUser_id() + "') "
//                    + (null == id || id.isEmpty() ? "" : "AND jsdj_zj IN('" + id + "')");//条件
//        } else {//假设是全局管理员，可以查看其他部门管理员的
//            where = null == id || id.isEmpty() ? "" : "WHERE jsdj_zj IN('" + id + "')";//条件
//        }
        //  锁定，只能查看自己创建的角色
        where = "WHERE user_id IN('" + aobj.getUser_id() + "') ";
        where = where + (null == id || id.isEmpty() ? "" : "AND jsdj_zj IN('" + id + "')");//条件
        jw.request.setAttribute("ListJson", service.S.selectByCondition(Role.class, where));
    }

    @M("/selectOneRolePower")
    public static void selectOne(JWeb jw) {
        String id = jw.getString("role_id");
        if (null == id || id.trim().isEmpty()) {
            return;
        }
        Role obj = DBO.service.S.selectOneByID(Role.class, id);
        if (null == obj || null == obj.getRole_id()) {
            return;
        }

        AdminUser aobj = Login.getUserInfo(AdminUser.class, jw, PDK.SESSION_ADMIN_KEY);
        //角色没有关联的创建人，或且此角色不归属此管理员，中止服务。
        if (null == obj.getUser_id() || !obj.getUser_id().equals(aobj.getUser_id())) {
            return;
        }

        if (null == obj.getPower() || obj.getPower().isEmpty()) {
            jw.printOne("[]");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (String pid : obj.getPower().split(",")) {
            sb.append(",{\"power_id\":\"").append(pid).append("\"}");
        }
        jw.printOne("[" + sb.substring(1) + "]");
    }
}
