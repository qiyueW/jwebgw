package wx.web.base.dao;

import java.util.List;

import system.db.dao.vo.CID;
import configuration.DBO;
import wx.web.base.bean.RY;
import wx.web.base.bean.vo.RYView;

public class RYDao {

    /**
     * 所有的人员
     *
     * @return
     */
    public static final List<RY> selectAll() {
        return DBO.service.S.select(RY.class);
    }

    /*	public static final List<RY> selectRYByIds_0(String ids) {
		return DBO.service.S.selectByCondition(RY.class,"WHERE ry_id IN("+ids+") AND ry_style=0");
	}
     */
    /**
     * 过滤执行的某状态id集合。防止跨状态注入。比如，新增id通过，禁防禁用id出现参与就职审核通过。
     *
     * @param ids
     * @param ry_style
     * @return
     */
    public static final String formatListToIds(final String ids, final int ry_style) {
        List<RY> list = DBO.service.S.selectByCondition(RY.class, "WHERE ry_sort NOT IN(0,1) AND  ry_id IN(" + ids + ") AND ry_style=" + ry_style);
        if (list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (RY ry : list) {
            sb.append(",'").append(ry.getRy_id()).append("'");
        }
        return sb.substring(1);
    }

    /**
     * 过滤执行的某状态id集合。防止跨状态注入。比如，新增id通过，禁防禁用id出现参与就职审核通过。
     *
     * @param ids
     * @return
     */
    public static final List<RY> formatListToIds(final String ids) {
        List<RY> list = DBO.service.S.selectByCondition(RY.class, "WHERE ry_sort NOT IN(0,1) AND ry_id IN(" + ids + ") AND ry_style!=0");
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    public static final int updateStye(final String ids, final int style) {
        return DBO.service.ADUS.executeUpdate("UPDATE RY SET ry_style=" + style + " WHERE ry_id IN(" + ids + ")");
    }

    /**
     * 将状态1改成2，状态2改成1
     *
     * @param list
     * @return
     */
    public static final int updateStye12(final List<RY> list) {
        StringBuilder sb1 = new StringBuilder();//启用
        StringBuilder sb2 = new StringBuilder();//停用

        for (RY ry : list) {
            //状态是1的，放入1的集合;其他放入2的集合
            (ry.getRy_style() == 1 ? sb1 : sb2).append(",'").append(ry.getRy_id()).append("'");
        }
        boolean s1, s2;
        s1 = sb1.length() == 0;
        s2 = sb2.length() == 0;
        if (s1 && s2) {
            return -1;
        }

        if (s1) {
            return DBO.service.ADUS.executeUpdate("UPDATE RY SET ry_style=1 WHERE ry_id IN(" + sb2.substring(1) + ")");
        }
        if (s2) {
            return DBO.service.ADUS.executeUpdate("UPDATE RY SET ry_style=2 WHERE ry_id IN(" + sb1.substring(1) + ")");
        }
        int[] i = DBO.service.ADUS.executeBatch(
                "UPDATE RY SET ry_style=2 WHERE ry_id IN(" + sb1.substring(1) + ")",
                "UPDATE RY SET ry_style=1 WHERE ry_id IN(" + sb2.substring(1) + ")"
        );
        return null == i ? -1 : i[0] + i[1];
    }

    public static final int dellStye(final String ids, final int style) {
        return DBO.service.D.deleteVastByID_CheckToDeny_CID(RY.class,
                ids//将被删除的id集合
                ,
                 "(ry_sort=0 OR ry_sort=1 OR ry_style!=" + style + ")"//如果被删除的是超管员或管理员或不是我们指定的状态，阻止删除
        )//在提问表，资料库检查，人员是否已经使用
                ;
    }

    public static final int dellStye(final String ids) {
        return DBO.service.D.deleteVastByID_CheckToDeny_CID(RY.class,
                ids//将被删除的id集合
                ,
                 "(ry_sort=0 OR ry_sort=1 OR ry_style=0)"//如果被删除的是超管员或管理员或是新建的人员（新建的人员，有新建人员的删除权限，所以分开) 阻止删除
        )//在提问表，资料库检查，人员是否已经使用
                ;
    }

    /**
     * @param ry_account
     * @param ry_password
     * @return RY
     */
    public static final RY selectOneByAccountAndName(String ry_account, String ry_password) {
        return DBO.service.S.selectOneByCondition(RY.class,
                "WHERE ry_account='" + ry_account + "' AND ry_password='" + ry_password + "'");
    }

    /**
     *
     * @param condition
     * @param page	页码
     * @param pageCount	页数
     * @param orderby 正倒序 默认id倒序
     * @return
     */
    public static final List<RY> selectVast(final String condition, final int page, final int pageCount, String orderby) {
        return DBO.service.S.selectVastByCondition(RY.class,
                page, pageCount//分页
                ,
                 condition//条件
                ,
                 orderby.isEmpty() ? "ORDER BY ry_id DESC" : orderby//默认id倒序
        );
    }

    public static final List<RYView> selectVastByBmID(final String bm_ids) {
        String where = null == bm_ids || bm_ids.isEmpty() ? "" : "bm_id IN(" + bm_ids + ")";
        return DBO.service.ADUS.executeQueryVast(RYView.class, "SELECT * FROM RY WHERE ry_sort!=0 AND ry_style=1 AND " + where);
    }

    /**
     * <p>
     * 将参数格式化成合法sql语句条件的部分。同时，锁定一些敏感参数的查询。</p>
     * <p>
     * 1.禁止查询 超级管理员的信息</p>
     * <p>
     * 2.未通过审核的新建人员不参与人名与账号的模糊匹配。</p>
     *
     * @param	bm_ids	部门集合'b1','b2'.........,'bN'这个id集合的格式
     * @param nameOrAccount 配置查询 人员名字或账号
     * @param ry_style 职员范围 1在职，2离职,99表示在职和离职
     * @return
     */
    public static final String formatParam(final String bm_ids, final String nameOrAccount, final int ry_style) {
        return new StringBuilder()
                //不能查超级管理员的信息
                .append("WHERE ry_sort!=0 AND")
                //检出人员信息的范围。99表示除未通过审核的所有人员。1表示在职人员。2表示离职人员
                .append(ry_style == 99 ? " ry_style!=0" : " ry_style=" + ry_style)
                //人名或账号的匹配
                .append(null == nameOrAccount || nameOrAccount.trim().isEmpty() ? "" : " AND (ry_name LIKE '%" + nameOrAccount + "%' OR ry_account LIKE '%" + nameOrAccount + "%' )")
                //在指定部门内检索。当bm_ids为null或空时，检出所以部门的
                .append(null == bm_ids || bm_ids.isEmpty() ? "" : " AND bm_id IN(" + bm_ids + ")").toString();
    }

    /**
     * <p>
     * 将参数格式化成合法sql语句条件的部分。同时，锁定一些敏感参数的查询。</p>
     * <p>
     * 1.禁止查询 超级管理员的信息</p>
     * <p>
     * 2.未通过审核的新建人员不参与人名与账号的模糊匹配。</p>
     *
     * @param	bm_ids	部门集合'b1','b2'.........,'bN'这个id集合的格式
     * @param nameOrAccount 配置查询 人员名字或账号
     * @return
     */
    public static final String formatParam0(final String bm_ids, final String nameOrAccount) {
        return new StringBuilder()
                //不能查超级管理员的信息
                .append("WHERE ry_sort!=0 AND ry_style=0")
                //人名或账号的匹配
                .append(null == nameOrAccount || nameOrAccount.trim().isEmpty() ? "" : " AND (ry_name LIKE '%" + nameOrAccount + "%' OR ry_account LIKE '%" + nameOrAccount + "%' )")
                //在指定部门内检索。当bm_ids为null或空时，检出所以部门的
                .append(null == bm_ids || bm_ids.isEmpty() ? "" : " AND bm_id IN(" + bm_ids + ")").toString();
    }

}
